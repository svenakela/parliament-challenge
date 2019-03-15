package com.parliamentchallenge.merger.politician;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Information {

  String description;
  List<Object> assignments;
  String type;
  String stakeholderId;

  public Information(
      @JsonProperty("kod") String description,
      @JsonProperty("uppgift") List<Object> assignments,
      @JsonProperty("typ") String type,
      @JsonProperty("intressent_id") String stakeholderId) {
    this.description = description;
    this.assignments = assignments;
    this.type = type;
    this.stakeholderId = stakeholderId;
  }
}
