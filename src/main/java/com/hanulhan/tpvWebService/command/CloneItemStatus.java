/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.command;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
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
    "CloneItemDetails",
    "CloneStatus"
})
/**
 *
 * @author uhansen
 */
public class CloneItemStatus {

    @JsonProperty("CloneItemDetails")
    private CloneItemDetails cloneItemDetails;
    @JsonProperty("CloneStatus")
    private String cloneStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonGetter("CloneItemDetails")
    public CloneItemDetails getCloneItemDetails() {
        return cloneItemDetails;
    }

    @JsonSetter("CloneItemDetails")
    public void setCloneItemDetails(CloneItemDetails cloneItemDetails) {
        this.cloneItemDetails = cloneItemDetails;
    }

    @JsonGetter("CloneStatus")
    public String getCloneStatus() {
        return cloneStatus;
    }

    @JsonSetter("CloneStatus")
    public void setCloneStatus(String cloneStatus) {
        this.cloneStatus = cloneStatus;
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
        myValue = myValue + "\t\t\t\tCloneItemDetails: " + this.cloneItemDetails;
        myValue = myValue + "\t\t\t\tCloneStatus     : " + this.cloneStatus + "\n";
        return myValue;
    }
}
