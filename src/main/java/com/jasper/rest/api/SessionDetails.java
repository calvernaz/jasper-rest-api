package com.jasper.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@JsonSerialize
public class SessionDetails {
    private String iccid;
    private Date dateSessionStarted;
    private Date dateSessionEnded;
    private String ipAddress;

    @JsonCreator
    public SessionDetails(@JsonProperty("iccid") String iccid, @JsonProperty("dateSessionStarted") Date dateSessionStarted,
                          @JsonProperty("dateSessionEnded") Date dateSessionEnded, @JsonProperty("ipAddress") String ipAddress) {
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

    public Date getDateSessionStarted() {
        return dateSessionStarted;
    }

    public Date getDateSessionEnded() {
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
