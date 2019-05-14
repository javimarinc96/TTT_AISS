
package aiss.model.twitch;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"name",
"box_art_url"
})
public class DatumGames {

@JsonProperty("id")
private String id;
@JsonProperty("name")
private String name;
@JsonProperty("box_art_url")
private String boxArtUrl;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public DatumGames() {
}

/**
* 
* @param id
* @param name
* @param boxArtUrl
*/
public DatumGames(String id, String name, String boxArtUrl) {
super();
this.id = id;
this.name = name;
this.boxArtUrl = boxArtUrl;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("box_art_url")
public String getBoxArtUrl() {
return boxArtUrl;
}

@JsonProperty("box_art_url")
public void setBoxArtUrl(String boxArtUrl) {
this.boxArtUrl = boxArtUrl;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}