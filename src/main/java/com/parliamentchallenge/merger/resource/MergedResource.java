package com.parliamentchallenge.merger.resource;

import com.parliamentchallenge.merger.adapters.Parliament;
import com.parliamentchallenge.merger.speech.MergedSpeech;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speeches")
public class MergedResource {

  private static final int DEFAULT_NUMBER_OF_SPEECHES = 10;
  private Parliament parliament;

  public MergedResource(Parliament parliament) {
    this.parliament = parliament;
  }

  @GetMapping("/latest")
  public ResponseEntity<MergedSpeech> latestSpeeches() {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(parliament.latestSpeeches(DEFAULT_NUMBER_OF_SPEECHES));
  }
}
