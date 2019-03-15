package com.parliamentchallenge.merger.politician;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Politician {

  String name;
  PoliticianInformation politicianInformation;
  String image;
  String constituency;

  public Politician(
      @JsonProperty("sorteringsnamn") String name,
      @JsonProperty("personuppgift") PoliticianInformation politicianInformation,
      @JsonProperty("bild_url_192") String image,
      @JsonProperty("valkrets") String constituency) {
    this.name = name;
    this.politicianInformation = politicianInformation;
    this.image = image;
    this.constituency = constituency;
  }
}
