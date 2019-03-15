package com.parliamentchallenge.merger.adapters;

import com.parliamentchallenge.merger.politician.Information;
import com.parliamentchallenge.merger.politician.Politician;
import com.parliamentchallenge.merger.politician.PoliticianData;
import com.parliamentchallenge.merger.politician.PoliticianSummary;
import com.parliamentchallenge.merger.speech.CombinedSpeech;
import com.parliamentchallenge.merger.speech.Link;
import com.parliamentchallenge.merger.speech.MergedSpeech;
import com.parliamentchallenge.merger.speech.ParliamentSpeeches;
import com.parliamentchallenge.merger.speech.Speech;
import com.parliamentchallenge.merger.speech.SpeechData;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;
import reactor.util.function.Tuples;

public class SwedishParliament implements Parliament {

  private final RestTemplate restTemplate;
  private final String speechUriTemplate = "http://data.riksdagen.se/anforandelista/?sz=%d&utformat=json";

  public SwedishParliament(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public MergedSpeech latestSpeeches(int numberOfSpeeches) {
    final ParliamentSpeeches parliamentSpeeches = Objects.requireNonNull(restTemplate
        .getForObject(String.format(speechUriTemplate, numberOfSpeeches),
            ParliamentSpeeches.class));

    return mergedSpeechesWithPoliticianInformation(
        parliamentSpeeches.getSpeechesInformation().getSpeeches());
  }

  private MergedSpeech mergedSpeechesWithPoliticianInformation(List<Speech> speeches) {

    final List<CombinedSpeech> combinedSpeeches = speeches.stream()
        .map(speech -> Tuples.of(speech, speechPoliticianInformation(speech.getStakeholderId())))
        .map(tuple -> toCombinedSpeech(tuple.getT1(), tuple.getT2()))
        .collect(Collectors.toList());
    return MergedSpeech.builder().combinedSpeeches(combinedSpeeches).build();
  }

  private PoliticianSummary speechPoliticianInformation(String stakeholderId) {
    return restTemplate
        .getForObject(String
                .format("http://data.riksdagen.se/personlista/?iid=%s&utformat=json", stakeholderId),
            PoliticianSummary.class);
  }

  private CombinedSpeech toCombinedSpeech(Speech speech, PoliticianSummary politicianSummary) {
    final Politician politician = politicianSummary.getPoliticianListing().getPolitician();
    return CombinedSpeech.builder()
        .speech(SpeechData.builder()
            .date(speech.getDateOfSpeech())
            .subject(speech.getDebateSubject())
            .links(link(speech.getLinkToSpeech()))
            .speechId(speech.getSpeechId())
            .build())
        .speaker(PoliticianData.builder()
            .fullName(politician.getName())
            .imageLink(politician.getImage())
            .constituency(politician.getConstituency())
            .eMail(politicianEmail(politician))
            .affiliation(speech.getAffiliatedPoliticalParty())
            .build())
        .build();
  }

  private List<Link> link(String linkToSpeech) {
    return Collections.singletonList(Link.builder().href(linkToSpeech).rel("self").build());
  }

  private String politicianEmail(Politician politician) {
    return politician.getPoliticianInformation()
        .getInformationList()
        .stream()
        .filter(information -> "eadress".equals(information.getType()))
        .findFirst()
        .orElse(new Information(null, List.of(), null, null))
        .getAssignments()
        .stream()
        .map(Object::toString)
        .map(string -> string.replaceAll("\\[på\\]", "@"))
        .collect(Collectors.joining(","));
  }
}
