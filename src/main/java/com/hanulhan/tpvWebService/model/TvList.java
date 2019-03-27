/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author uli
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TvList {

    private Map<String, TvType> tvList = new HashMap<>();
    private static int instances= 0;

    public TvList() {
        TvList.instances++;
    }

    

    public List<TvType> getTvsAsList() {
        List<TvType> myList = new ArrayList<>();
        Iterator myEntries;
        
        if (!tvList.isEmpty()) {
            myEntries = tvList.entrySet().iterator();
            while (myEntries.hasNext()) {
                Entry thisEntry = (Entry) myEntries.next();
                myList.add((TvType)thisEntry.getValue());
            }
        }

        return myList;
    }

    public Map<String, TvType> getTvList() {
        return tvList;
    }

    public void setTvList(Map<String, TvType> tvList) {
        this.tvList = tvList;
    }


    
}
