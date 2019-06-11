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
    private String tvIPAddress;
    private String powerStatus;
    private String tvModel;
    private String cloneToServerStatus;
    private String cloneToServerSessionStatus;

    private String upgradeStatus;
    private String upgradeSessionStatus;

    public TvType(String tvUniqueID) {
        this.tvUniqueID = tvUniqueID;
    }

    public TvType(String tvUniqueID, String tvRoomID, String tvIpAddress, String tvModel) {
        this.tvUniqueID = tvUniqueID;
        this.tvRoomID = tvRoomID;
        this.tvIPAddress = tvIpAddress;
        this.tvModel = tvModel;
    }

    public void update(TvType aTv) {
        if (aTv.powerStatus != null) {
            this.powerStatus = aTv.getPowerStatus();
        }
        if (aTv.tvIPAddress != null) {
            this.tvIPAddress = aTv.getTvIPAddress();
        }
        if (aTv.tvModel != null) {
            this.tvModel = aTv.getTvModel();
        }
        if (aTv.tvRoomID != null) {
            this.tvRoomID = aTv.getTvRoomID();
        }
        if (aTv.cloneToServerStatus != null) {
            this.cloneToServerStatus = aTv.getCloneToServerStatus();
        }
        if (aTv.cloneToServerSessionStatus != null) {
            this.cloneToServerSessionStatus = aTv.getCloneToServerSessionStatus();
        }
        if (aTv.upgradeStatus != null) {
            this.upgradeStatus= aTv.getUpgradeStatus();
        }
        if (aTv.upgradeSessionStatus != null) {
            this.upgradeSessionStatus= aTv.getUpgradeSessionStatus();
        }
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

    public String getTvIPAddress() {
        return tvIPAddress;
    }

    public void setTvIPAddress(String tvIPAddress) {
        this.tvIPAddress = tvIPAddress;
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

    public String getCloneToServerStatus() {
        return cloneToServerStatus;
    }

    public void setCloneToServerStatus(String cloneToServerStatus) {
        this.cloneToServerStatus = cloneToServerStatus;
    }

    public String getCloneToServerSessionStatus() {
        return cloneToServerSessionStatus;
    }

    public void setCloneToServerSessionStatus(String cloneToServerSessionStatus) {
        this.cloneToServerSessionStatus = cloneToServerSessionStatus;
    }

    public String getUpgradeStatus() {
        return upgradeStatus;
    }

    public void setUpgradeStatus(String upgradeStatus) {
        this.upgradeStatus = upgradeStatus;
    }

    public String getUpgradeSessionStatus() {
        return upgradeSessionStatus;
    }

    public void setUpgradeSessionStatus(String upgradeSessionStatus) {
        this.upgradeSessionStatus = upgradeSessionStatus;
    }

}
