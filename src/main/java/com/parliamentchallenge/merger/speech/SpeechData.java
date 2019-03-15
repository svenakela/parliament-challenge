package com.parliamentchallenge.merger.speech;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SpeechData {
  String speechId;
  String date;
  String subject;
  List<Link> links;
}
