package com.parliamentchallenge.merger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class PersonList {

  @JsonProperty("person")
  private Person person;

  public Person getPerson() {
    return person;
  }

  public void setPerson(final Person person) {
    this.person = person;
  }

}
