package com.parliamentchallenge.merger.model;

import java.net.URL;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Person {

  @JsonProperty("intressent_id")
  private String personId;
  @JsonProperty("tilltalsnamn")
  private String firstName;
  @JsonProperty("efternamn")
  private String lastName;
  @JsonProperty("parti")
  private String affiliation;
  @JsonProperty("valkrets")
  private String constituency;
  @JsonProperty("bild_url_192")
  private URL image;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getAffiliation() {
    return affiliation;
  }

  public void setAffiliation(final String affiliation) {
    this.affiliation = affiliation;
  }

  public String getConstituency() {
    return constituency;
  }

  public void setConstituency(final String constituency) {
    this.constituency = constituency;
  }

  public URL getImage() {
    return image;
  }

  public void setImage(final URL image) {
    this.image = image;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(final String personId) {
    this.personId = personId;
  }
}
