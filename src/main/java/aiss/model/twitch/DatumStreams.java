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
"user_id",
"user_name",
"game_id",
"type",
"title",
"viewer_count",
"started_at",
"language",
"thumbnail_url"
})
public class DatumStreams {

@JsonProperty("id")
private String id;
@JsonProperty("user_id")
private String userId;
@JsonProperty("user_name")
private String userName;
@JsonProperty("game_id")
private String gameId;
@JsonProperty("type")
private String type;
@JsonProperty("title")
private String title;
@JsonProperty("viewer_count")
private String viewerCount;
@JsonProperty("started_at")
private String startedAt;
@JsonProperty("language")
private String language;
@JsonProperty("thumbnail_url")
private String thumbnailUrl;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public DatumStreams() {
}

/**
* 
* @param id
* @param title
* @param viewerCount
* @param thumbnailUrl
* @param gameId
* @param userId
* @param startedAt
* @param userName
* @param language
* @param type
*/
public DatumStreams(String id, String userId, String userName, String gameId, String type, String title, String viewerCount, String startedAt, String language, String thumbnailUrl) {
super();
this.id = id;
this.userId = userId;
this.userName = userName;
this.gameId = gameId;
this.type = type;
this.title = title;
this.viewerCount = viewerCount;
this.startedAt = startedAt;
this.language = language;
this.thumbnailUrl = thumbnailUrl;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("user_id")
public String getUserId() {
return userId;
}

@JsonProperty("user_id")
public void setUserId(String userId) {
this.userId = userId;
}

@JsonProperty("user_name")
public String getUserName() {
return userName;
}

@JsonProperty("user_name")
public void setUserName(String userName) {
this.userName = userName;
}

@JsonProperty("game_id")
public String getGameId() {
return gameId;
}

@JsonProperty("game_id")
public void setGameId(String gameId) {
this.gameId = gameId;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("viewer_count")
public String getViewerCount() {
return viewerCount;
}

@JsonProperty("viewer_count")
public void setViewerCount(String viewerCount) {
this.viewerCount = viewerCount;
}

@JsonProperty("started_at")
public String getStartedAt() {
return startedAt;
}

@JsonProperty("started_at")
public void setStartedAt(String startedAt) {
this.startedAt = startedAt;
}

@JsonProperty("language")
public String getLanguage() {
return language;
}

@JsonProperty("language")
public void setLanguage(String language) {
this.language = language;
}

@JsonProperty("thumbnail_url")
public String getThumbnailUrl() {
return thumbnailUrl;
}

@JsonProperty("thumbnail_url")
public void setThumbnailUrl(String thumbnailUrl) {
this.thumbnailUrl = thumbnailUrl;
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