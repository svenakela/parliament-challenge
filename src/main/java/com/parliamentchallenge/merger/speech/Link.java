package com.parliamentchallenge.merger.speech;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Link {
  String rel;
  String href;
}
