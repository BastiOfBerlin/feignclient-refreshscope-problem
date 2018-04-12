package eu.bastiofberlin.samples.feignclientRefreshscopeProblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController implements ChuckNorrisApi {

  private final ChuckNorrisApiClient chuckNorrisApiClient;

  @Autowired
  public RestController(ChuckNorrisApiClient chuckNorrisApiClient) {
    this.chuckNorrisApiClient = chuckNorrisApiClient;
  }

  @RequestMapping(
      value = {"/hello"},
      produces = {"application/json"},
      method = {RequestMethod.GET}
  )
  public String hello(){
    return "Hello World!";
  }

  @Override
  public ChuckNorrisJoke getRandomJoke() {
    return this.chuckNorrisApiClient.getRandomJoke();
  }
}
