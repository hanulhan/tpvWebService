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
import org.springframework.stereotype.Service;

/**
 *
 * @author uli
 */
@Component
public class TvList {

    private static Map<String, TvType> tvList = new HashMap<>();

    static {
        tvList.put("UniqueID-1", new TvType("UniqueID-1", "2042", "192.168.178.31", "5011"));
        tvList.put("UniqueID-2", new TvType("UniqueID-2", "2042", "192.168.178.32", "5011"));
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

    public static Map<String, TvType> getTvList() {
        return tvList;
    }

    public static void setTvList(Map<String, TvType> tvList) {
        TvList.tvList = tvList;
    }

    
}
