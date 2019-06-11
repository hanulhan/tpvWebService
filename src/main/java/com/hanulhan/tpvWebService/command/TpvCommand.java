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
    private String CmdType;
    @JsonProperty("Cookie")
    private Integer Cookie;
    @JsonProperty("Fun")
    private String Fun;
    @JsonProperty("Svc")
    private String Svc;
    @JsonProperty("SvcVer")
    private String SvcVer;
    @JsonProperty("CommandDetails")
    private CommandDetails CommandDetails;

    public TpvCommand(String cmdType, Integer cookie, String fun, String svc, String svcVer) {
        super();
        this.CmdType = cmdType;
        this.Cookie = cookie;
        this.Fun = fun;
        this.Svc = svc;
        this.SvcVer = svcVer;
    }

    public TpvCommand() {
        super();
    }

    
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
   
    @JsonGetter("CmdType")
    public String getCmdType() {
        return CmdType;
    }

    @JsonSetter("CmdType")
    public void setCmdType(String cmdType) {
        this.CmdType = cmdType;
    }

    @JsonGetter("Cookie")
    public Integer getCookie() {
        return Cookie;
    }

    @JsonSetter("Cookie")
    public void setCookie(Integer cookie) {
        this.Cookie = cookie;
    }

    @JsonGetter("Fun")
    public String getFun() {
        return Fun;
    }

    @JsonSetter("Fun")
    public void setFun(String fun) {
        this.Fun = fun;
    }

    @JsonGetter("Svc")
    public String getSvc() {
        return Svc;
    }

    @JsonSetter("Svc")
    public void setSvc(String svc) {
        this.Svc = svc;
    }

    @JsonGetter("SvcVer")
    public String getSvcVer() {
        return SvcVer;
    }

    @JsonSetter("SvcVer")
    public void setSvcVer(String svcVer) {
        this.SvcVer = svcVer;
    }

    @JsonGetter("CommandDetails")
    public CommandDetails getCommandDetails() {
        return CommandDetails;
    }

    @JsonSetter("CommandDetails")
    public void setCommandDetails(CommandDetails commandDetails) {
        this.CommandDetails = commandDetails;
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

        if (this.CommandDetails.getWebServiceParameters() != null) {
            myValue = " ####### TVUniqueID: " + this.CommandDetails.getWebServiceParameters().getTVUniqueID() + "#######\n";
        } else if (this.CommandDetails.getWebListeningServiceParameters() != null) {
            myValue = " ####### TVUniqueID: " + this.CommandDetails.getWebListeningServiceParameters().getTVUniqueID() + "#######\n";
        }
        myValue = myValue + "\tSvc   : " + this.Svc + "\n";
        myValue = myValue + "\tCookie: " + this.Cookie + "\n";

        myValue += this.CommandDetails;

        return myValue;
    }

}
