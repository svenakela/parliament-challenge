package com.parliamentchallenge.merger.integrations;

import java.util.StringJoiner;
import org.springframework.web.reactive.function.client.WebClient;
import com.parliamentchallenge.merger.model.PersonWrapper;
import com.parliamentchallenge.merger.model.SpeechesWrapper;
import reactor.core.publisher.Mono;

public final class ApiRequester {

  private static final String SPEECH_URI = "/anforandelista/?anftyp=Nej&sz=10&utformat=json";

  private static final String MEMBER_URI = "/personlista/?&utformat=json&iid=";

  // Causing an ugly warning with a stack trace at boot but only a warning
  private final WebClient webClient = WebClient.create("http://data.riksdagen.se");

  public Mono<SpeechesWrapper> getSpeeches() {
    return webClient.get()
        .uri(SPEECH_URI)
        .retrieve()
        .bodyToMono(SpeechesWrapper.class);
  }

  public Mono<PersonWrapper> getMember(final String id) {

    final String callUri = new StringJoiner("").add(MEMBER_URI).add(id).toString();
    return webClient.get()
        .uri(callUri)
        .retrieve()
        .bodyToMono(PersonWrapper.class);
  }

}
