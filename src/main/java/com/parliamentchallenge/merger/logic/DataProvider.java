package com.parliamentchallenge.merger.logic;

import com.parliamentchallenge.merger.integrations.ApiRequester;
import com.parliamentchallenge.merger.model.MergedSpeech;
import com.parliamentchallenge.merger.model.PersonWrapper;
import com.parliamentchallenge.merger.model.SpeechTemplate;
import com.parliamentchallenge.merger.model.Speeches;
import com.parliamentchallenge.merger.model.SpeechesWrapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public final class DataProvider {

  private final ApiRequester requester;

  public DataProvider(final ApiRequester apiRequester) {
    requester = apiRequester;
  }

  public Flux<MergedSpeech> getLatest() {

    return requester
        .getSpeeches()
        .map(SpeechesWrapper::unwrap)
        .map(Speeches::getSpeeches)
        .flatMapMany(Flux::fromIterable)
        .parallel()
        .runOn(Schedulers.parallel())
        .flatMap(this::mergeSpeech)
        .log()
        .sequential();
  }

  private Mono<PersonWrapper> getPersonWhoSpoke(final SpeechTemplate speech) {
    return requester.getMember(speech.getPersonId());
  }

  private Mono<MergedSpeech> mergeSpeech(final SpeechTemplate speech) {

    return getPersonWhoSpoke(speech)
        .map(p -> new MergedSpeech(speech, p.getPersonList().getPerson()));
  }

}
