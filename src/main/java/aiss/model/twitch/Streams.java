package aiss.model.twitch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data",
"pagination"
})
public class Streams {

@JsonProperty("data")
private List<DatumStreams> data = null;
@JsonProperty("pagination")
private Pagination pagination;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Streams() {
}

/**
* 
* @param data
* @param pagination
*/
public Streams(List<DatumStreams> data, Pagination pagination) {
super();
this.data = data;
this.pagination = pagination;
}

@JsonProperty("data")
public List<DatumStreams> getData() {
return data;
}

@JsonProperty("data")
public void setData(List<DatumStreams> data) {
this.data = data;
}

@JsonProperty("pagination")
public Pagination getPagination() {
return pagination;
}

@JsonProperty("pagination")
public void setPagination(Pagination pagination) {
this.pagination = pagination;
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