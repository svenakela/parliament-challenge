package com.parliamentchallenge.merger.speech;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class ParliamentSpeeches {

  SpeechBundle speechesInformation;

  public ParliamentSpeeches(@JsonProperty("anforandelista") SpeechBundle anforandelista) {
    this.speechesInformation = anforandelista;
  }
}
