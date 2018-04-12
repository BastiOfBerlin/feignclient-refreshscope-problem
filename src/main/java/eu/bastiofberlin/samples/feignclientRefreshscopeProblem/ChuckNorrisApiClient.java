package eu.bastiofberlin.samples.feignclientRefreshscopeProblem;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;

@RefreshScope
@FeignClient(name = "chuck-norris-client",
    url = "${client.api-url}",
    configuration = { FeignClientConfiguration.class })
public interface ChuckNorrisApiClient extends ChuckNorrisApi {
}
