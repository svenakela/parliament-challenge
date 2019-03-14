package com.parliamentchallenge.merger.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.parliamentchallenge.merger.logic.DataProvider;
import com.parliamentchallenge.merger.model.MergedSpeech;
import reactor.core.publisher.Flux;

@ResponseBody
@RequestMapping("/speeches")
public class MergedResource {

  private final DataProvider provider;

  public MergedResource(final DataProvider dataProvider) {
    provider = dataProvider;
  }

  @GetMapping("/hello")
  public String hello() {
    return "world!";
  }

  @GetMapping()
  public Flux<MergedSpeech> getSpeeches() {
    return provider.getLatest();
  }

}
