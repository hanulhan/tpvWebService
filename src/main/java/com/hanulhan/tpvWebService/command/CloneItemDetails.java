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
    "CloneItemName",
    "CloneItemVersionNo"
})

/**
 *
 * @author uhansen
 */
public class CloneItemDetails {

    @JsonProperty("CloneItemName")
    private String cloneItemName;
    @JsonProperty("CloneItemVersionNo")
    private String cloneItemVersionNo;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonGetter("CloneItemName")
    public String getCloneItemName() {
        return cloneItemName;
    }

    @JsonSetter("CloneItemName")
    public void setCloneItemName(String cloneItemName) {
        this.cloneItemName = cloneItemName;
    }

    @JsonGetter("CloneItemVersionNo")
    public String getCloneItemVersionNo() {
        return cloneItemVersionNo;
    }

    @JsonSetter("CloneItemVersionNo")
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
        String myValue = "{CloneItemName: " + this.cloneItemName + ", CloneItemVersionNo: " + this.cloneItemVersionNo + "}\n";
        return myValue;
    }
}
