package com.parliamentchallenge.merger.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Speeches {

  @JsonProperty("@antal")
  private int size;
  @JsonProperty("anforande")
  private List<Speech> speechList;

  public int getSize() {
    return size;
  }

  public void setSize(final int size) {
    this.size = size;
  }

  public List<Speech> getSpeeches() {
    return speechList;
  }

  public void setSpeeches(final List<Speech> speeches) {
    speechList = speeches;
  }

}
