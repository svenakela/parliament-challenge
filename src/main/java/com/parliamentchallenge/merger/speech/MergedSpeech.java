package com.parliamentchallenge.merger.speech;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MergedSpeech {

  @JsonProperty("speeches")
  List<CombinedSpeech> combinedSpeeches;
}
