package eu.bastiofberlin.samples.feignclientRefreshscopeProblem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

@Configuration
public class DynamicUrlConfiguration
    implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

  private static final Logger LOGGER = LoggerFactory.getLogger(DynamicUrlConfiguration.class);

  @Autowired
  private ConfigurableEnvironment configurableEnvironment;

  @Autowired
  private RefreshScope refreshScope;

  public void onApplicationEvent(
      EmbeddedServletContainerInitializedEvent event) {
    if ("default".equals(getApiUrl())) {
      int localServerPort = event.getEmbeddedServletContainer().getPort();
      LOGGER.info("Discovered Server Port: {}", localServerPort);
      Properties props = new Properties();
      // I need to use the Port number here, but for the demo use a public API
      props.setProperty("client.api-url", "https://api.chucknorris.io/jokes");
      configurableEnvironment.getPropertySources().addFirst(
          new PropertiesPropertySource("DynamicUrlConfiguration", props)
      );
      LOGGER.info("Property client.api-url: '{}'", getApiUrl());
      refreshScope.refreshAll();
    }
  }

  private String getApiUrl() {
    return configurableEnvironment.getProperty("client.api-url");
  }
}
