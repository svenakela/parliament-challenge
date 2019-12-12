package com.parliamentchallenge.merger.logic;

import com.parliamentchallenge.merger.integrations.ApiRequester;
import com.parliamentchallenge.merger.model.MergedSpeech;
import reactor.core.publisher.Flux;

public final class DataProvider {

  private final ApiRequester requester;

  public DataProvider(final ApiRequester apiRequester) {
    requester = apiRequester;
  }

  public Flux<MergedSpeech> getLatest() {

    // TODO: SOLVE!
    return Flux.empty();

  }

}
