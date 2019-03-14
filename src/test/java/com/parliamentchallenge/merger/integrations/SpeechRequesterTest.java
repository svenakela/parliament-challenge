package com.parliamentchallenge.merger.integrations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpeechRequesterTest {

  @Test
  public void speechesExpectsResponseSize() {

    final var speechesWrapper = new ApiRequester().getSpeeches().block();
    Assertions.assertEquals(10, speechesWrapper.unwrap().getSize());
    Assertions.assertEquals(10, speechesWrapper.unwrap().getSpeeches().size());
  }

  @Test
  public void membersExpectsResponse() {

    final var personWrapper = new ApiRequester().getMember("0473783431010").block();
    Assertions.assertEquals("Johansson", personWrapper.getPersonList().getPerson().getLastName());
  }
}
