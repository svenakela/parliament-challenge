package com.parliamentchallenge.merger.integrations;

import org.springframework.web.reactive.function.client.WebClient;
import com.parliamentchallenge.merger.model.PersonWrapper;
import com.parliamentchallenge.merger.model.SpeechesWrapper;
import reactor.core.publisher.Mono;

public final class ApiRequester {

  private static final String SPEECH_URI = "/anforandelista/?anftyp=Nej&sz=10&utformat=json";

  private static final String MEMBER_URI = "/personlista/?&utformat=json&iid=";

  private final WebClient webClient = WebClient.create("http://data.riksdagen.se");

  public Mono<SpeechesWrapper> getSpeeches() {
    // TODO: SOLVE!
    return Mono.empty();
  }

  public Mono<PersonWrapper> getMember(final String id) {

    // TODO: SOLVE!
    return Mono.empty();
  }

}
