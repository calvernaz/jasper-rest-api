package com.jasper.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class SentSmsId {
  private final String smsMessageId;

  @JsonCreator
  public SentSmsId(@JsonProperty("smsMessageId") String smsMsgId) {
    this.smsMessageId = smsMsgId;
  }

  public String getSmsMessageId() {
    return smsMessageId;
  }

}
