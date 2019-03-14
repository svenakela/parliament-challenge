package com.parliamentchallenge.merger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.parliamentchallenge.merger.integrations.ApiRequester;
import com.parliamentchallenge.merger.logic.DataProvider;
import com.parliamentchallenge.merger.resource.MergedResource;

@Configuration
public class MergerConfig {

  @Bean
  public MergedResource mergeEndpoint(final DataProvider dataProvider) {
    return new MergedResource(dataProvider);
  }

  @Bean
  public ApiRequester requester() {
    return new ApiRequester();
  }

  @Bean
  public DataProvider provider(final ApiRequester apiRequester) {
    return new DataProvider(apiRequester);
  }

}
