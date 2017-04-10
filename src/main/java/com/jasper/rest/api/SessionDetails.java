package com.jasper.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties
public class SessionDetails {
    private String iccid;
    private String dateSessionStarted;
    private String dateSessionEnded;
    private String ipAddress;

    @JsonCreator
    public SessionDetails(@JsonProperty("iccid") String iccid, @JsonProperty("dateSessionStarted") String dateSessionStarted,
                          @JsonProperty("dateSessionEnded") String dateSessionEnded, @JsonProperty("ipAddress") String ipAddress) {
        this.iccid = iccid;
        this.dateSessionStarted = dateSessionStarted;
        this.dateSessionEnded = dateSessionEnded;
        this.ipAddress = ipAddress;
    }

    public String getIccid() {
        return iccid;
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public String getDateSessionStarted() {
        return dateSessionStarted;
    }

    public String getDateSessionEnded() {
        return dateSessionEnded;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("iccid", iccid)
                .append("dateSessionStarted", dateSessionStarted)
                .append("dateSessionEnded", dateSessionEnded)
                .append("ipAddress", ipAddress)
                .toString();
    }
}
