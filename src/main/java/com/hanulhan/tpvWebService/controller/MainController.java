/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.controller;

import com.hanulhan.tpvWebService.model.TvList;
import com.hanulhan.tpvWebService.model.TvType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author uli
 */
@Controller
public class MainController {

    @Autowired
    TvList tvList;

 
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/tvList"}, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("tvList", tvList.getTvList());

        return "tvList";
    }

}
