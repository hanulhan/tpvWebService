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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CloneItemName",
    "CloneItemVersionNo"
})
public class CloneItemsAvailableToServer {

    @JsonProperty("CloneItemName")
    private String cloneItemName;
    @JsonProperty("CloneItemVersionNo")
    private String cloneItemVersionNo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CloneItemName")
    public String getCloneItemName() {
        return cloneItemName;
    }

    @JsonProperty("CloneItemName")
    public void setCloneItemName(String cloneItemName) {
        this.cloneItemName = cloneItemName;
    }

    @JsonProperty("CloneItemVersionNo")
    public String getCloneItemVersionNo() {
        return cloneItemVersionNo;
    }

    @JsonProperty("CloneItemVersionNo")
    public void setCloneItemVersionNo(String cloneItemVersionNo) {
        this.cloneItemVersionNo = cloneItemVersionNo;
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
        String myValue = "\n\t\t\t{CloneItemName: " + this.cloneItemName + ", CloneItemVersionNo: " + this.cloneItemVersionNo + "}\n";
        return myValue;
    }
}
