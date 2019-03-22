/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.command;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PowerStatus",
    "TVIPAddress",
    "TVMACAddress",
    "TVModelNumber",
    "TVRoomID",
    "TVSerialNumber",
    "VSecureTVID"
})

/**
 *
 * @author uhansen
 */
public class TVDiscoveryParameters {

    @JsonProperty("PowerStatus")
    private String powerStatus;
    @JsonProperty("TVIPAddress")
    private String tVIPAddress;
    @JsonProperty("TVMACAddress")
    private String tVMACAddress;
    @JsonProperty("TVModelNumber")
    private String tVModelNumber;
    @JsonProperty("TVRoomID")
    private String tVRoomID;
    @JsonProperty("TVSerialNumber")
    private String tVSerialNumber;
    @JsonProperty("VSecureTVID")
    private String vSecureTVID;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonGetter("PowerStatus")
    public String getPowerStatus() {
        return powerStatus;
    }

    @JsonSetter("PowerStatus")
    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus;
    }

    @JsonGetter("TVIPAddress")
    public String getTVIPAddress() {
        return tVIPAddress;
    }

    @JsonSetter("TVIPAddress")
    public void setTVIPAddress(String tVIPAddress) {
        this.tVIPAddress = tVIPAddress;
    }

    @JsonGetter("TVMACAddress")
    public String getTVMACAddress() {
        return tVMACAddress;
    }

    @JsonSetter("TVMACAddress")
    public void setTVMACAddress(String tVMACAddress) {
        this.tVMACAddress = tVMACAddress;
    }

    @JsonGetter("TVModelNumber")
    public String getTVModelNumber() {
        return tVModelNumber;
    }

    @JsonSetter("TVModelNumber")
    public void setTVModelNumber(String tVModelNumber) {
        this.tVModelNumber = tVModelNumber;
    }

    @JsonGetter("TVRoomID")
    public String getTVRoomID() {
        return tVRoomID;
    }

    @JsonSetter("TVRoomID")
    public void setTVRoomID(String tVRoomID) {
        this.tVRoomID = tVRoomID;
    }

    @JsonGetter("TVSerialNumber")
    public String getTVSerialNumber() {
        return tVSerialNumber;
    }

    @JsonSetter("TVSerialNumber")
    public void setTVSerialNumber(String tVSerialNumber) {
        this.tVSerialNumber = tVSerialNumber;
    }

    @JsonGetter("VSecureTVID")
    public String getVSecureTVID() {
        return vSecureTVID;
    }

    @JsonSetter("VSecureTVID")
    public void setVSecureTVID(String vSecureTVID) {
        this.vSecureTVID = vSecureTVID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        String myValue = "\n";
        myValue = myValue + "\t\tPowerStatus   : " + this.getPowerStatus() + "\n";
        myValue = myValue + "\t\tTVIPAddress   : " + this.getTVIPAddress() + "\n";
        myValue = myValue + "\t\tTVMACAddress  : " + this.getTVMACAddress() + "\n";
        myValue = myValue + "\t\tTVModelNumber : " + this.getTVModelNumber() + "\n";
        myValue = myValue + "\t\tTVRoomID      : " + this.getTVRoomID() + "\n";
        myValue = myValue + "\t\tTVSerialNumber: " + this.getTVSerialNumber() + "\n";
        myValue = myValue + "\t\tVescureTVID   : " + this.getVSecureTVID() + "\n";
        return myValue;
    }

}
