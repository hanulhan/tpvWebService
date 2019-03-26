/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.controller;

import com.hanulhan.tpvWebService.model.TvList;
import com.hanulhan.tpvWebService.model.TvType;
import com.hanulhan.tpvWebService.response.MultipartResponseList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.addObject("tvList", tvList.getTvList());
        model.addObject("message", message);
        return model;

        //      return "index";
    }

    @RequestMapping(value = {"/tvList"}, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("tvList", tvList.getTvList());

        return "tvList";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String handlePost(@RequestParam String action, Model m) {
        if (action.equals("save")) {
            LOGGER.debug("save action");
        } else if (action.equals("renew")) {
            LOGGER.debug("renew action");
        }
        //m.addAttribute("name", "change");
        return "redirect:/index";
    }
    
    @RequestMapping(value = "/getTvList", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<TvType>> getTvList() {
        return new ResponseEntity<>(tvList.getTvList(), HttpStatus.OK);
    }
}
