/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author uli
 */
@Service
public class TvList {

    private static List<TvType> tvList = new ArrayList<>();

    static {
        tvList.add(new TvType("UniqueID-1", "2042", "192.168.178.31", "5011"));
        tvList.add(new TvType("UniqueID-2", "2042", "192.168.178.32", "5011"));
    }

    public List<TvType> getTvList() {
        return tvList;
    }

}
