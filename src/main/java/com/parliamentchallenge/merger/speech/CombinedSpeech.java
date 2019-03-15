package com.parliamentchallenge.merger.speech;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parliamentchallenge.merger.politician.PoliticianData;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CombinedSpeech {
  SpeechData speech;
  PoliticianData speaker;
}
