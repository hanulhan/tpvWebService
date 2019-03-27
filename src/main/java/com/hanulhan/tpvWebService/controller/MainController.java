/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.controller;

import com.hanulhan.tpvWebService.command.TpvCommand;
import com.hanulhan.tpvWebService.model.TvAction;
import com.hanulhan.tpvWebService.model.TvList;
import com.hanulhan.tpvWebService.model.TvType;
import com.hanulhan.tpvWebService.response.MultipartResponseList;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author uli
 */
@Controller
public class MainController {

    @Autowired
    TvList tvList;
    private static final Logger LOGGER = LogManager.getLogger(MainController.class);

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        String message = "Hello Spring Boot + JSP";
        ModelAndView model = new ModelAndView("index");
        //model.addAttribute("tvList", tvList.getTvList());
        //model.addAttribute("message", message);
        model.addObject("tvList", tvList.getTvsAsList());
        model.addObject("message", message);
        return model;

        //      return "index";
    }

    @RequestMapping(value = {"/tvList"}, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("tvList", tvList.getTvsAsList());

        return "tvList";
    }

    //@RequestMapping(value = "/requestIpUpgrade", method = RequestMethod.POST)
//    public String handlePost(@RequestParam String selectedTv, Model m) {
//        if (selectedTv.equals("save")) {
//            LOGGER.debug("save action");
//        } else if (selectedTv.equals("renew")) {
//            LOGGER.debug("renew action");
//        }
//        //m.addAttribute("name", "change");
//        return "redirect:/index";
//    }
    @RequestMapping(value = "/requestIpUpgrade", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> requestIpUpgrade(@RequestBody TvAction tvAction, Model m) throws UnsupportedEncodingException, IOException {
        LOGGER.debug("request IP Upgrade for " + tvAction.getTvUniqueId());

        TpvCommand myCommand = new TpvCommand("Request", 7, "IPCloneService", "WebListeningServices", "3.0");
        String myIp = TvList.getTvList().get(tvAction.getTvUniqueId()).getTvIPAddress();

        StringWriter writer = new StringWriter();
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TpvCommand.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.marshal(myCommand, writer);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }

        //Define a postRequest request
        HttpPost postRequest = new HttpPost("http://" + myIp + ":9080/WIXP");

        //Set the API media type in http content-type header
        postRequest.addHeader("content-type", "application/json");

        //Set the request post body
        StringEntity commandEntity = new StringEntity(writer.getBuffer().toString());
        postRequest.setEntity(commandEntity);
        CloseableHttpResponse response2 = null;
        HttpEntity entity1;

        try {
            response2 = httpClient.execute(postRequest);
            entity1 = response2.getEntity();
            EntityUtils.consume(entity1);

        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            //Important: Close the connect
            if (response2 != null)  {
                response2.close();
            }
        }

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/getTvList", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<TvType>> getTvList() {
        return new ResponseEntity<>(tvList.getTvsAsList(), HttpStatus.OK);
    }
}
