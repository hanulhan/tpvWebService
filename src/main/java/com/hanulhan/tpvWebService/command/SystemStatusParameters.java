/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.command;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
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
    "RemoteControlStatus"
})

/**
 *
 * @author uhansen
 */
public class SystemStatusParameters {

    @JsonProperty("RemoteControlStatus")
    RemoteControlStatus remoteControlStatus;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonGetter("RemoteControlStatus")
    public RemoteControlStatus getRemoteControlStatus() {
        return remoteControlStatus;
    }

    @JsonSetter("RemoteControlStatus")
    public void setRemoteControlStatus(RemoteControlStatus remoteControlStatus) {
        this.remoteControlStatus = remoteControlStatus;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnyGetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "\n\t\tRemoteControlStatus: " + this.remoteControlStatus + "\n";
    }

}
