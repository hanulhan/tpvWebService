/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.Command;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author uhansen
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CloneItemsAvailableToServer",
    "CloneToServerSessionStatus",
    "CloneToServerStatus"
})
public class CloneToServerParameters {

    @JsonProperty("CloneItemsAvailableToServer")
    private List<CloneItemDetails> cloneItemsAvailableToServer = null;
    @JsonProperty("CloneToServerSessionStatus")
    private CloneToServerSessionStatus cloneToServerSessionStatus;
    @JsonProperty("CloneToServerStatus")
    private String cloneToServerStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CloneItemsAvailableToServer")
    public List<CloneItemDetails> getCloneItemsAvailableToServer() {
        return cloneItemsAvailableToServer;
    }

    @JsonProperty("CloneItemsAvailableToServer")
    public void setCloneItemsAvailableToServer(List<CloneItemDetails> cloneItemsAvailableToServer) {
        this.cloneItemsAvailableToServer = cloneItemsAvailableToServer;
    }

    @JsonProperty("CloneToServerSessionStatus")
    public CloneToServerSessionStatus getCloneToServerSessionStatus() {
        return cloneToServerSessionStatus;
    }

    @JsonProperty("CloneToServerSessionStatus")
    public void setCloneToServerSessionStatus(CloneToServerSessionStatus cloneToServerSessionStatus) {
        this.cloneToServerSessionStatus = cloneToServerSessionStatus;
    }

    @JsonProperty("CloneToServerStatus")
    public String getCloneToServerStatus() {
        return cloneToServerStatus;
    }

    @JsonProperty("CloneToServerStatus")
    public void setCloneToServerStatus(String cloneToServerStatus) {
        this.cloneToServerStatus = cloneToServerStatus;
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
        myValue = myValue + "\t\tcloneToServerStatus: " + this.cloneToServerStatus + "\n";
        myValue = myValue + "\t\tCloneItemsAvailableToServer: " + this.cloneItemsAvailableToServer + "\n";
        myValue = myValue + "\t\tcloneToServerSessionStatus: " + this.cloneToServerSessionStatus + "\n";
        return myValue;
    }
}
