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
    "CloneSessionStatus",
    "CurrentUpgradeStatus"
})
public class IPCloneParameters {

    @JsonProperty("CloneSessionStatus")
    private CloneSessionStatus cloneSessionStatus;
    @JsonProperty("CurrentUpgradeStatus")
    private String currentUpgradeStatus;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CloneSessionStatus")
    public CloneSessionStatus getCloneSessionStatus() {
        return cloneSessionStatus;
    }

    @JsonProperty("CloneSessionStatus")
    public void setCloneSessionStatus(CloneSessionStatus cloneSessionStatus) {
        this.cloneSessionStatus = cloneSessionStatus;
    }

    @JsonProperty("CurrentUpgradeStatus")
    public String getCurrentUpgradeStatus() {
        return currentUpgradeStatus;
    }

    @JsonProperty("CurrentUpgradeStatus")
    public void setCurrentUpgradeStatus(String currentUpgradeStatus) {
        this.currentUpgradeStatus = currentUpgradeStatus;
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
        myValue = myValue + "\t\tcurrentUpgradeStatus: " + this.currentUpgradeStatus + "\n";
        myValue = myValue + "\t\tcloneSessionStatus: " + this.cloneSessionStatus + "\n";

        return myValue;
    }
}
