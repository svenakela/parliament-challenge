package com.parliamentchallenge.merger.politician;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PoliticianData {
  String fullName;
  String constituency;
  String affiliation;
  String eMail;
  String imageLink;
}
