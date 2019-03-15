/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.Command;

/**
 *
 * @author UHansen
 */
public class WebServiceParameters {
    private float PollingFrequency;
    private String TVUniqueID;

    public float getPollingFrequency() {
        return PollingFrequency;
    }

    public void setPollingFrequency(float PollingFrequency) {
        this.PollingFrequency = PollingFrequency;
    }

    public String getTVUniqueID() {
        return TVUniqueID;
    }

    public void setTVUniqueID(String TVUniqueID) {
        this.TVUniqueID = TVUniqueID;
    }

    @Override
    public String toString() {
        return "WebServiceParameters{" + "PollingFrequency=" + PollingFrequency + ", TVUniqueID=" + TVUniqueID + '}';
    }

    
}
