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
import java.util.List;
import java.util.Map;

/**
 *
 * @author UHansen
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ActiveApplications",
    "WebServiceParameters",
    "WebListeningServiceParameters",
    "TVDiscoveryParameters",
    "CloneToServerParameters",
    "IPCloneParameters",
    "ProfessionalSettingsParameters"})
public class CommandDetails {

    @JsonProperty("WebServiceParameters")
    private WebServiceParameters webServiceParameters;

    @JsonProperty("ProfessionalSettingsParameters")
    private ProfessionalSettingsParameters professionalSettingsParameters;

    @JsonProperty("WebListeningServiceParameters")
    private WebListeningServiceParameters webListeningServiceParameters;

    @JsonProperty("ActiveApplications")
    private List<ActiveApplications> activeApplications = null;

    @JsonProperty("TVDiscoveryParameters")
    private TVDiscoveryParameters tVDiscoveryParameters;

    @JsonProperty("SystemStatusParameters")
    SystemStatusParameters systemStatusParameters;

    @JsonProperty("CloneToServerParameters")
    private CloneToServerParameters cloneToServerParameters;

    @JsonProperty("IPCloneParameters")
    private IPCloneParameters iPCloneParameters;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ProfessionalSettingsParameters")
    public ProfessionalSettingsParameters getProfessionalSettingsParameters() {
        return professionalSettingsParameters;
    }

    @JsonProperty("ProfessionalSettingsParameters")
    public void setProfessionalSettingsParameters(ProfessionalSettingsParameters professionalSettingsParameters) {
        this.professionalSettingsParameters = professionalSettingsParameters;
    }

    @JsonGetter("ActiveApplications")
    public List<ActiveApplications> getActiveApplications() {
        return activeApplications;
    }

    @JsonSetter("ActiveApplications")
    public void setActiveApplications(List<ActiveApplications> activeApplications) {
        this.activeApplications = activeApplications;
    }

    @JsonGetter("WebServiceParameters")
    public WebServiceParameters getWebServiceParameters() {
        return webServiceParameters;
    }

    @JsonSetter("WebServiceParameters")
    public void setWebServiceParameters(WebServiceParameters webServiceParameters) {
        this.webServiceParameters = webServiceParameters;
    }

    @JsonGetter("TVDiscoveryParameters")
    public TVDiscoveryParameters gettVDiscoveryParameters() {
        return tVDiscoveryParameters;
    }

    @JsonSetter("TVDiscoveryParameters")
    public void settVDiscoveryParameters(TVDiscoveryParameters tVDiscoveryParameters) {
        this.tVDiscoveryParameters = tVDiscoveryParameters;
    }

    @JsonGetter("SystemStatusParameters")
    public SystemStatusParameters getSystemStatusParameters() {
        return systemStatusParameters;
    }

    @JsonSetter("SystemStatusParameters")
    public void setSystemStatusParameters(SystemStatusParameters systemStatusParameters) {
        this.systemStatusParameters = systemStatusParameters;
    }

    @JsonGetter("CloneToServerParameters")
    public CloneToServerParameters getCloneToServerParameters() {
        return cloneToServerParameters;
    }

    @JsonSetter("CloneToServerParameters")
    public void setCloneToServerParameters(CloneToServerParameters cloneToServerParameters) {
        this.cloneToServerParameters = cloneToServerParameters;
    }

    @JsonGetter("getiPCloneParameters")
    public IPCloneParameters getiPCloneParameters() {
        return iPCloneParameters;
    }

    @JsonSetter("getiPCloneParameters")
    public void setiPCloneParameters(IPCloneParameters iPCloneParameters) {
        this.iPCloneParameters = iPCloneParameters;
    }

    @JsonProperty("WebListeningServiceParameters")
    public WebListeningServiceParameters getWebListeningServiceParameters() {
        return webListeningServiceParameters;
    }

    @JsonProperty("WebListeningServiceParameters")
    public void setWebListeningServiceParameters(WebListeningServiceParameters webListeningServiceParameters) {
        this.webListeningServiceParameters = webListeningServiceParameters;
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
        String myValue = "";
        Boolean fData = false;

        if (this.activeApplications != null) {
            myValue = myValue + "\tFun: ActiveApplications: " + this.activeApplications + "\n";
            fData = true;
        }

        if (this.tVDiscoveryParameters != null) {
            myValue = myValue + "\tFun: TVDiscoveryParameters: " + this.tVDiscoveryParameters + "\n";
            fData = true;
        }

        if (this.systemStatusParameters != null) {
            myValue = myValue + "\tFun: SystemStatusParameters: " + this.systemStatusParameters + "\n";
            fData = true;
        }
        if (this.iPCloneParameters != null) {
            myValue = myValue + "\tFun: IPCloneParameters: " + this.iPCloneParameters + "\n";
            fData = true;
        }

        if (this.cloneToServerParameters != null) {
            myValue = myValue + "\tFun: CloneToServerParameters: " + this.cloneToServerParameters + "\n";
            fData = true;
        }
        if (fData == false) {
            myValue = myValue + "\tUnknown Command";
        }

        return myValue;
    }

}
