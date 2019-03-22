/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.controller;

import com.hanulhan.tpvWebService.model.TvList;
import com.hanulhan.tpvWebService.model.TvType;
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

    private static TvList tvList;

    static {
        tvList.getTvList().put("UniqueID-1", new TvType("UniqueID-1", "2042", "192.168.178.31", "5011"));
        tvList.getTvList().put("UniqueID-2", new TvType("UniqueID-2", "2042", "192.168.178.32", "5011"));
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/tvList"}, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("persons", tvList);

        return "tvList";
    }

}
