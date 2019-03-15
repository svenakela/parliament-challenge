package com.parliamentchallenge.merger.politician;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PoliticianListing {

  Politician politician;

  public PoliticianListing(@JsonProperty("person") Politician politician) {
    this.politician = politician;
  }
}
