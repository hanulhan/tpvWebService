/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.Command;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CloneItemStatus",
    "SessionEndTime",
    "SessionStartTime",
    "SessionStatus"
})

/**
 *
 * @author uhansen
 */
public class CloneSessionStatus {

    @JsonProperty("CloneItemStatus")
    private List<CloneItemStatus> cloneItemStatus = null;
    @JsonProperty("SessionEndTime")
    private String sessionEndTime;
    @JsonProperty("SessionStartTime")
    private String sessionStartTime;
    @JsonProperty("SessionStatus")
    private String sessionStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonGetter("CloneItemStatus")
    public List<CloneItemStatus> getCloneItemStatus() {
        return cloneItemStatus;
    }

    @JsonSetter("CloneItemStatus")
    public void setCloneItemStatus(List<CloneItemStatus> cloneItemStatus) {
        this.cloneItemStatus = cloneItemStatus;
    }

    @JsonGetter("SessionEndTime")
    public String getSessionEndTime() {
        return sessionEndTime;
    }

    @JsonSetter("SessionEndTime")
    public void setSessionEndTime(String sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    @JsonGetter("SessionStartTime")
    public String getSessionStartTime() {
        return sessionStartTime;
    }

    @JsonSetter("SessionStartTime")
    public void setSessionStartTime(String sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    @JsonGetter("SessionStatus")
    public String getSessionStatus() {
        return sessionStatus;
    }

    @JsonSetter("SessionStatus")
    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
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
        myValue = myValue + "\t\t\tsessionStatus: " + this.sessionStatus + "\n";
        myValue = myValue + "\t\t\tsessionStartTime: " + this.sessionStartTime + "\n";
        myValue = myValue + "\t\t\tsessionEndTime: " + this.sessionEndTime + "\n";
        myValue = myValue + "\t\t\tcloneItemStatus: " + this.cloneItemStatus + "\n";
        
        return myValue;
    }
    
    
}
