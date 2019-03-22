/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.model;

/**
 *
 * @author uli
 */
public class TvType {
    private String tvUniqueID;
    private String tvRoomID;
    private String tvIpAddress;
    private String powerStatus;
    private String tvModel;

    public TvType(String tvUniqueID, String tvRoomID, String tvIpAddress, String tvModel) {
        this.tvUniqueID = tvUniqueID;
        this.tvRoomID = tvRoomID;
        this.tvIpAddress = tvIpAddress;
        this.tvModel = tvModel;
    }

    
    public String getTvUniqueID() {
        return tvUniqueID;
    }

    public void setTvUniqueID(String tvUniqueID) {
        this.tvUniqueID = tvUniqueID;
    }

    public String getTvRoomID() {
        return tvRoomID;
    }

    public void setTvRoomID(String tvRoomID) {
        this.tvRoomID = tvRoomID;
    }

    public String getTvIpAddress() {
        return tvIpAddress;
    }

    public void setTvIpAddress(String tvIpAddress) {
        this.tvIpAddress = tvIpAddress;
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus;
    }

    public String getTvModel() {
        return tvModel;
    }

    public void setTvModel(String tvModel) {
        this.tvModel = tvModel;
    }
    
}
