package eu.bastiofberlin.samples.feignclientRefreshscopeProblem;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ChuckNorrisJoke {

  @JsonProperty("icon_url")
  private String iconUrl;

  @JsonProperty("id")
  private String id;

  @JsonProperty("url")
  private String url;

  @JsonProperty("value")
  private String value;

  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ChuckNorrisJoke that = (ChuckNorrisJoke) o;
    return Objects.equals(iconUrl, that.iconUrl) && Objects.equals(id, that.id) && Objects
        .equals(url, that.url) && Objects.equals(value, that.value);
  }

  @Override public int hashCode() {

    return Objects.hash(iconUrl, id, url, value);
  }

  @Override public String toString() {
    return "ChuckNorrisJoke{" + "iconUrl='" + iconUrl + '\'' + ", id='" + id + '\'' + ", url='"
        + url + '\'' + ", value='" + value + '\'' + '}';
  }
}
