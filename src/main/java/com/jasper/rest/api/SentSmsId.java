package com.jasper.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class SentSmsId {
    private final String smsMsgId;

    @JsonCreator
    public SentSmsId(@JsonProperty("smsMsgId") String smsMsgId) {
        this.smsMsgId = smsMsgId;
    }

    public String getSmsMsgId() {
        return smsMsgId;
    }
}
