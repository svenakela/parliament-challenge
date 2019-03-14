package com.parliamentchallenge.merger.model;

import java.net.URL;

public final class MergedSpeech implements SpeechTemplate {

  private final String speechId;
  private final String responseNo;
  private final String topic;
  private final URL protocol;
  private final String personId;
  private final String firstName;
  private final String lastName;
  private final String affiliation;
  private final String constituency;
  private final URL image;

  public MergedSpeech(final SpeechTemplate speech) {

    speechId = speech.getSpeechId();
    responseNo = speech.getResponseNo();
    topic = speech.getTopic();
    protocol = speech.getProtocol();
    personId = speech.getPersonId();

    firstName = "";
    lastName = "";
    affiliation = "";
    constituency = "";
    image = null;

  }

  public MergedSpeech(final SpeechTemplate speech, final Person person) {

    speechId = speech.getSpeechId();
    responseNo = speech.getResponseNo();
    topic = speech.getTopic();
    protocol = speech.getProtocol();
    personId = speech.getPersonId();
    firstName = person.getFirstName();
    lastName = person.getLastName();
    affiliation = person.getAffiliation();
    constituency = person.getConstituency();
    image = person.getImage();
  }

  @Override
  public String getPersonId() {
    return personId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAffiliation() {
    return affiliation;
  }

  public String getConstituency() {
    return constituency;
  }

  public URL getImage() {
    return image;
  }

  @Override
  public String getSpeechId() {
    return speechId;
  }

  @Override
  public String getResponseNo() {
    return responseNo;
  }

  @Override
  public String getTopic() {
    return topic;
  }

  @Override
  public URL getProtocol() {
    return protocol;
  }

}
