package com.parliamentchallenge.merger.politician;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PoliticianSummary {

  PoliticianListing politicianListing;

  public PoliticianSummary(
      @JsonProperty("personlista") PoliticianListing politicianListing) {
    this.politicianListing = politicianListing;
  }
}
