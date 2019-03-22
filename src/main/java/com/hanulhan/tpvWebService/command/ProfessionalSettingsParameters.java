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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author uhansen
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CustomDashboardServerURL"
})
public class ProfessionalSettingsParameters {

    @JsonProperty("CustomDashboardServerURL")
    private String customDashboardServerURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CustomDashboardServerURL")
    public String getCustomDashboardServerURL() {
        return customDashboardServerURL;
    }

    @JsonProperty("CustomDashboardServerURL")
    public void setCustomDashboardServerURL(String customDashboardServerURL) {
        this.customDashboardServerURL = customDashboardServerURL;
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
        myValue = myValue + "\t\tcustomDashboardServerURL: " + this.customDashboardServerURL + "\n";
        return myValue;
    }
}
