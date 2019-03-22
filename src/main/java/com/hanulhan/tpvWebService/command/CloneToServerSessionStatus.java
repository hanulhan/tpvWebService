/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.command;

/**
 *
 * @author uhansen
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CloneItemStatus",
    "SessionEndTime",
    "SessionStartTime",
    "SessionStatus"
})

public class CloneToServerSessionStatus {

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

    @JsonProperty("CloneItemStatus")
    public List<CloneItemStatus> getCloneItemStatus() {
        return cloneItemStatus;
    }

    @JsonProperty("CloneItemStatus")
    public void setCloneItemStatus(List<CloneItemStatus> cloneItemStatus) {
        this.cloneItemStatus = cloneItemStatus;
    }

    @JsonProperty("SessionEndTime")
    public String getSessionEndTime() {
        return sessionEndTime;
    }

    @JsonProperty("SessionEndTime")
    public void setSessionEndTime(String sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    @JsonProperty("SessionStartTime")
    public String getSessionStartTime() {
        return sessionStartTime;
    }

    @JsonProperty("SessionStartTime")
    public void setSessionStartTime(String sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    @JsonProperty("SessionStatus")
    public String getSessionStatus() {
        return sessionStatus;
    }

    @JsonProperty("SessionStatus")
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
        myValue = myValue + "\t\t\tSessionStartTime: " + this.sessionStartTime + "\n";
        myValue = myValue + "\t\t\tSessionEndTime: " + this.sessionEndTime + "\n";
        myValue = myValue + "\t\t\tCloneItemStatus: " + this.cloneItemStatus + "\n";
        return myValue;
    }
}
