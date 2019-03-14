package com.parliamentchallenge.merger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class PersonWrapper {

  @JsonProperty("personlista")
  private PersonList personList;

  public PersonList getPersonList() {
    return personList;
  }

  public void setPersonList(final PersonList personList) {
    this.personList = personList;
  }

}
