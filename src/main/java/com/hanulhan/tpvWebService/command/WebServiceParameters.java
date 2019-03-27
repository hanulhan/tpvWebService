/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.command;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hanulhan.tpvWebService.model.TvList;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PollingFrequency",
    "TVUniqueID"
})

/**
 *
 * @author UHansen
 */
public class WebServiceParameters {

    @JsonProperty("PollingFrequency")
    private Integer pollingFrequency;
    @JsonProperty("TVUniqueID")
    private String tVUniqueID;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PollingFrequency")
    public Integer getPollingFrequency() {
        return pollingFrequency;
    }

    @JsonProperty("PollingFrequency")
    public void setPollingFrequency(Integer pollingFrequency) {
        this.pollingFrequency = pollingFrequency;
    }

    @JsonProperty("TVUniqueID")
    public String getTVUniqueID() {
        return tVUniqueID;
    }

    @JsonProperty("TVUniqueID")
    public void setTVUniqueID(String tVUniqueID) {
        this.tVUniqueID = tVUniqueID;
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
        return "WebServiceParameters{" + "pollingFrequency=" + pollingFrequency + ", tVUniqueID=" + tVUniqueID + '}';
    }


}
