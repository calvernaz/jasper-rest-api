package com.jasper.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Sms {
    private final String iccid;
    private final String messageText;
    private final String messageEncoding;
    private final Integer dataCoding;
    private final Integer tpvp;

    @JsonCreator
    public Sms(@JsonProperty("iccid") String iccid, @JsonProperty("messageText") String messageText,
               @JsonProperty("messageEncoding") String messageEncoding, @JsonProperty("dataCoding") Integer dataCoding,
               @JsonProperty("tpvp") Integer tpvp) {
        this.iccid = iccid;
        this.messageText = messageText;
        this.messageEncoding = messageEncoding;
        this.dataCoding = dataCoding;
        this.tpvp = tpvp;
    }

    public String getIccid() {
        return iccid;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageEncoding() {
        return messageEncoding;
    }

    public Integer getDataCoding() {
        return dataCoding;
    }

    public Integer getTpvp() {
        return tpvp;
    }
}
