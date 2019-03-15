package com.parliamentchallenge.merger;

import com.parliamentchallenge.merger.adapters.Parliament;
import com.parliamentchallenge.merger.adapters.SwedishParliament;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.parliamentchallenge.merger.resource.MergedResource;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MergerConfig {

  @Bean
  public Parliament parliament() {
    return new SwedishParliament(new RestTemplate());
  }
}
