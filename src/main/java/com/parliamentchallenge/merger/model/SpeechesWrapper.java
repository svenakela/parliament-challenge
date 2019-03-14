package com.parliamentchallenge.merger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpeechesWrapper {

  @JsonProperty("anforandelista")
  private Speeches speeches;

  public Speeches unwrap() {
    return speeches;
  }

  public void wrap(final Speeches speeches) {
    this.speeches = speeches;
  }

}
