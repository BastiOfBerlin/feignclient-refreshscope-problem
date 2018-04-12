package eu.bastiofberlin.samples.feignclientRefreshscopeProblem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ChuckNorrisApi {

  @RequestMapping(value = "/random", method = RequestMethod.GET)
  ChuckNorrisJoke getRandomJoke();
}
