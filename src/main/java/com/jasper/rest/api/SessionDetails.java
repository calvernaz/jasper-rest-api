package com.jasper.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize
public class SessionDetails {
    private String iccid;
    private Date lastSessionStartTime;
    private Date lastSessionEndTime;
    private String ipAddress;

    @JsonCreator
    public SessionDetails(@JsonProperty("iccid") String iccid, @JsonProperty("lastSessionStartTime") Date lastSessionStartTime,
                          @JsonProperty("lastSessionEndTime") Date lastSessionEndTime, @JsonProperty("ipAddress") String ipAddress) {
        this.iccid = iccid;
        this.lastSessionStartTime = lastSessionStartTime;
        this.lastSessionEndTime = lastSessionEndTime;
        this.ipAddress = ipAddress;
    }

    public String getIccid() {
        return iccid;
    }

    public Date getLastSessionStartTime() {
        return lastSessionStartTime;
    }

    public Date getLastSessionEndTime() {
        return lastSessionEndTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("iccid", iccid)
                .append("lastSessionStartTime", lastSessionStartTime)
                .append("lastSessionEndTime", lastSessionEndTime)
                .append("ipAddress", ipAddress)
                .toString();
    }
}
