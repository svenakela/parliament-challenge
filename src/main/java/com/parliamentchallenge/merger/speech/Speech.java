package com.parliamentchallenge.merger.speech;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class Speech {

  String speechId;
  String dateOfSpeech;
  String stakeholderId;
  String affiliatedPoliticalParty;
  String debateSubject;
  String linkToSpeech;

  public Speech(
      @JsonProperty("anforande_id") String anforande_id,
      @JsonProperty("dok_datum") String dok_datum,
      @JsonProperty("intressent_id") String intressent_id,
      @JsonProperty("parti") String parti,
      @JsonProperty("avsnittsrubrik") String avsnittsrubrik,
      @JsonProperty("protokoll_url_www") String protokoll_url_www) {
    this.speechId = anforande_id;
    this.dateOfSpeech = dok_datum;
    this.stakeholderId = intressent_id;
    this.affiliatedPoliticalParty = parti;
    this.debateSubject = avsnittsrubrik;
    this.linkToSpeech = protokoll_url_www;
  }
}
