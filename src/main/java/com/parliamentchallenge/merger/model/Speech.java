package com.parliamentchallenge.merger.model;

import java.net.URL;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Speech implements SpeechTemplate {

  @JsonProperty("anforande_id")
  private String speechId;
  @JsonProperty("anforande_nummer")
  private String responseNo;
  @JsonProperty("avsnittsrubrik")
  private String topic;
  @JsonProperty("protokoll_url_www")
  private URL protocol;
  @JsonProperty("intressent_id")
  private String personId;

  /* (non-Javadoc)
   * @see com.parliamentchallenge.merger.model.SpeechTemplate#getSpeechId()
   */
  @Override
  public String getSpeechId() {
    return speechId;
  }

  public void setSpeechId(final String speechId) {
    this.speechId = speechId;
  }

  /* (non-Javadoc)
   * @see com.parliamentchallenge.merger.model.SpeechTemplate#getResponseNo()
   */
  @Override
  public String getResponseNo() {
    return responseNo;
  }

  public void setResponseNo(final String responseNo) {
    this.responseNo = responseNo;
  }

  /* (non-Javadoc)
   * @see com.parliamentchallenge.merger.model.SpeechTemplate#getTopic()
   */
  @Override
  public String getTopic() {
    return topic;
  }

  public void setTopic(final String topic) {
    this.topic = topic;
  }

  /* (non-Javadoc)
   * @see com.parliamentchallenge.merger.model.SpeechTemplate#getProtocol()
   */
  @Override
  public URL getProtocol() {
    return protocol;
  }

  public void setProtocol(final URL protocol) {
    this.protocol = protocol;
  }

  /* (non-Javadoc)
   * @see com.parliamentchallenge.merger.model.SpeechTemplate#getPersonId()
   */
  @Override
  public String getPersonId() {
    return personId;
  }

  public void setPersonId(final String personId) {
    this.personId = personId;
  }

}
