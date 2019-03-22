/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.model;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author uli
 */
@Component
@Scope("singleton")
public class TvList {
    private final Map<String, TvType> tvList= new HashMap<>();

    public Map<String, TvType> getTvList() {
        return tvList;
    }
    
    
    
}
