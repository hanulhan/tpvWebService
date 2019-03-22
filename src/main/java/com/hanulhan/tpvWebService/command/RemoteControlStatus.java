/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.command;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MultiRC",
    "RCBatteryStatus",
    "RCType"
})
/**
 *
 * @author uhansen
 */
public class RemoteControlStatus {

    @JsonProperty("MultiRC")
    private String MultiRC;
    @JsonProperty("RCBatteryStatus")
    private String RCBatteryStatus;
    @JsonProperty("RCType")
    private String RCType;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonGetter("MultiRC")
    public String getMultiRC() {
        return MultiRC;
    }

    @JsonSetter("MultiRC")
    public void setMultiRC(String MultiRC) {
        this.MultiRC = MultiRC;
    }

    @JsonGetter("RCBatteryStatus")
    public String getRCBatteryStatus() {
        return RCBatteryStatus;
    }

    @JsonSetter("RCBatteryStatus")
    public void setRCBatteryStatus(String RCBatteryStatus) {
        this.RCBatteryStatus = RCBatteryStatus;
    }

    @JsonGetter("RCType")
    public String getRCType() {
        return RCType;
    }

    @JsonSetter("RCType")
    public void setRCType(String RCType) {
        this.RCType = RCType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnyGetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        String myValue = "\n";
        myValue = myValue + "\t\tMultiRC        : " + this.MultiRC + "\n";
        myValue = myValue + "\t\tRCBatteryStatus: " + this.RCBatteryStatus + "\n";
        myValue = myValue + "\t\tRCType         : " + this.RCType + "\n";

        return myValue;
    }

}
