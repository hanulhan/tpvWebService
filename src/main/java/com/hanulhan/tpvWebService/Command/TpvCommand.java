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
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CmdType",
    "Cookie",
    "Fun",
    "Svc",
    "SvcVer",
    "CommandDetails"
})

/**
 *
 * @author UHansen
 */
public class TpvCommand {

    @JsonProperty("CmdType")
    private String cmdType;
    @JsonProperty("Cookie")
    private Integer cookie;
    @JsonProperty("Fun")
    private String fun;
    @JsonProperty("Svc")
    private String svc;
    @JsonProperty("SvcVer")
    private String svcVer;
    @JsonProperty("CommandDetails")
    private CommandDetails commandDetails;

    @JsonProperty("Test")
    private String Test;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    //@JsonProperty("CmdType")
    @JsonGetter("CmdType")
    public String getCmdType() {
        return cmdType;
    }

    //@JsonProperty("CmdType")
    @JsonSetter("CmdType")
    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }

    //@JsonProperty("Cookie")
    @JsonGetter("Cookie")
    public Integer getCookie() {
        return cookie;
    }

    //@JsonProperty("Cookie")
    @JsonSetter("Cookie")
    public void setCookie(Integer cookie) {
        this.cookie = cookie;
    }

    //@JsonProperty("Fun")
    @JsonGetter("Fun")
    public String getFun() {
        return fun;
    }

    //@JsonProperty("Fun")
    @JsonSetter("Fun")
    public void setFun(String fun) {
        this.fun = fun;
    }

    //@JsonProperty("Svc")
    @JsonGetter("Svc")
    public String getSvc() {
        return svc;
    }

    //@JsonProperty("Svc")
    @JsonSetter("Svc")
    public void setSvc(String svc) {
        this.svc = svc;
    }

    //@JsonProperty("SvcVer")
    @JsonGetter("SvcVer")
    public String getSvcVer() {
        return svcVer;
    }

    //@JsonProperty("SvcVer")
    @JsonSetter("SvcVer")
    public void setSvcVer(String svcVer) {
        this.svcVer = svcVer;
    }

    //@JsonProperty("CommandDetails")
    @JsonGetter("CommandDetails")
    public CommandDetails getCommandDetails() {
        return commandDetails;
    }

    //@JsonProperty("CommandDetails")
    @JsonSetter("CommandDetails")
    public void setCommandDetails(CommandDetails commandDetails) {
        this.commandDetails = commandDetails;
    }

    @JsonGetter("Test")
    public String getTest() {
        return Test;
    }

    @JsonSetter("Test")
    public void setTest(String Test) {
        this.Test = Test;
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
        String myValue = "";;

        if (this.commandDetails.getWebServiceParameters() != null) {
            myValue = " ####### TVUniqueID: " + this.commandDetails.getWebServiceParameters().getTVUniqueID() + "#######\n";
        } else if (this.commandDetails.getWebListeningServiceParameters() != null) {
            myValue = " ####### TVUniqueID: " + this.commandDetails.getWebListeningServiceParameters().getTVUniqueID() + "#######\n";
        }
        myValue = myValue + "\tSvc   : " + this.svc + "\n";
        myValue = myValue + "\tCookie: " + this.cookie + "\n";

        myValue += this.commandDetails;

        return myValue;
    }

}
