/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.Command;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author UHansen
 */
@RestController()
public class TpvController {
    
    @RequestMapping(value="/register", method=RequestMethod.POST, consumes="application/json")
    public void register(@RequestBody TpvCommand aCommand) {
    
        System.out.println(aCommand);
        //System.out.println(aCommand.toString());
    
  }
 
}
