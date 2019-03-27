/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.model;

import org.springframework.stereotype.Service;

/**
 *
 * @author uhansen
 */
public class TvAction {
    private String tvUniqueId;
    private String function;
    private String CmdType;

    public TvAction(String tvUniqueId, String function, String CmdType) {
        this.tvUniqueId = tvUniqueId;
        this.function = function;
        this.CmdType = CmdType;
    }

    public String getTvUniqueId() {
        return tvUniqueId;
    }

    public void setTvUniqueId(String tvUniqueId) {
        this.tvUniqueId = tvUniqueId;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getCmdType() {
        return CmdType;
    }

    public void setCmdType(String CmdType) {
        this.CmdType = CmdType;
    }
    
    
    
}
