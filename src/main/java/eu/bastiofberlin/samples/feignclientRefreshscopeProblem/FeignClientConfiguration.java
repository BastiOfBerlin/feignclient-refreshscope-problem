package eu.bastiofberlin.samples.feignclientRefreshscopeProblem;

import feign.Logger;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfiguration {
  @Bean
  public Logger logger() {
    return new Slf4jLogger(ChuckNorrisApiClient.class);
  }

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.BASIC;
  }
}
