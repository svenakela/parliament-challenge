package com.parliamentchallenge.merger.politician;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PoliticianInformation {

  List<Information> informationList;

  public PoliticianInformation(
      @JsonProperty("uppgift") List<Information> informationList) {
    this.informationList = informationList;
  }
}
