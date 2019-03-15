/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanulhan.tpvWebService.Command.TpvCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author UHansen
 */
@RestController
public class TpvController {
    @RequestMapping("/")
    public String index() {
        return "Congratulations from BlogController.java";
    }
    
    @RequestMapping("/test")
    public String index2() {
        return "Congratulations test.java";
    }
    
    @RequestMapping(value="/service", method=RequestMethod.POST, consumes="text/plain")
    public void process(@RequestBody String payload) throws Exception{
        System.out.println(payload);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/register", consumes = "application/json")
    public void register(@RequestBody String json) {
    
        TpvCommand aCommand= new TpvCommand();
        ObjectMapper mapper= new ObjectMapper();
        try {
            aCommand= mapper.readValue(json, TpvCommand.class);
        } catch (IOException ex) {
            Logger.getLogger(TpvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(aCommand.toString());
    
  }
 
  @ExceptionHandler
  void handleIllegalArgumentException(
    IllegalArgumentException e, HttpServletResponse response) throws IOException {
 
    response.sendError(HttpStatus.BAD_REQUEST.value());
 
  }    
}
