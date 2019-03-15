package com.parliamentchallenge.merger.speech;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class SpeechBundle {

  String numberOfSpeeches;
  List<Speech> speeches;

  public SpeechBundle(@JsonProperty("@antal") String antal,
      @JsonProperty("anforande") List<Speech> anforande) {
    this.numberOfSpeeches = antal;
    this.speeches = anforande;
  }
}



