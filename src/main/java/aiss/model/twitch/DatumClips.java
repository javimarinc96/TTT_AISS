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
"url",
"embed_url",
"broadcaster_id",
"broadcaster_name",
"creator_id",
"creator_name",
"video_id",
"game_id",
"language",
"title",
"view_count",
"created_at",
"thumbnail_url"
})
public class DatumClips {

@JsonProperty("id")
private String id;
@JsonProperty("url")
private String url;
@JsonProperty("embed_url")
private String embedUrl;
@JsonProperty("broadcaster_id")
private String broadcasterId;
@JsonProperty("broadcaster_name")
private String broadcasterName;
@JsonProperty("creator_id")
private String creatorId;
@JsonProperty("creator_name")
private String creatorName;
@JsonProperty("video_id")
private String videoId;
@JsonProperty("game_id")
private String gameId;
@JsonProperty("language")
private String language;
@JsonProperty("title")
private String title;
@JsonProperty("view_count")
private String viewCount;
@JsonProperty("created_at")
private String createdAt;
@JsonProperty("thumbnail_url")
private String thumbnailUrl;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public DatumClips() {
}

/**
* 
* @param broadcasterName
* @param gameId
* @param embedUrl
* @param creatorId
* @param url
* @param id
* @param title
* @param creatorName
* @param createdAt
* @param thumbnailUrl
* @param videoId
* @param broadcasterId
* @param language
* @param viewCount
*/
public DatumClips(String id, String url, String embedUrl, String broadcasterId, String broadcasterName, String creatorId, String creatorName, String videoId, String gameId, String language, String title, String viewCount, String createdAt, String thumbnailUrl) {
super();
this.id = id;
this.url = url;
this.embedUrl = embedUrl;
this.broadcasterId = broadcasterId;
this.broadcasterName = broadcasterName;
this.creatorId = creatorId;
this.creatorName = creatorName;
this.videoId = videoId;
this.gameId = gameId;
this.language = language;
this.title = title;
this.viewCount = viewCount;
this.createdAt = createdAt;
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

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonProperty("embed_url")
public String getEmbedUrl() {
return embedUrl;
}

@JsonProperty("embed_url")
public void setEmbedUrl(String embedUrl) {
this.embedUrl = embedUrl;
}

@JsonProperty("broadcaster_id")
public String getBroadcasterId() {
return broadcasterId;
}

@JsonProperty("broadcaster_id")
public void setBroadcasterId(String broadcasterId) {
this.broadcasterId = broadcasterId;
}

@JsonProperty("broadcaster_name")
public String getBroadcasterName() {
return broadcasterName;
}

@JsonProperty("broadcaster_name")
public void setBroadcasterName(String broadcasterName) {
this.broadcasterName = broadcasterName;
}

@JsonProperty("creator_id")
public String getCreatorId() {
return creatorId;
}

@JsonProperty("creator_id")
public void setCreatorId(String creatorId) {
this.creatorId = creatorId;
}

@JsonProperty("creator_name")
public String getCreatorName() {
return creatorName;
}

@JsonProperty("creator_name")
public void setCreatorName(String creatorName) {
this.creatorName = creatorName;
}

@JsonProperty("video_id")
public String getVideoId() {
return videoId;
}

@JsonProperty("video_id")
public void setVideoId(String videoId) {
this.videoId = videoId;
}

@JsonProperty("game_id")
public String getGameId() {
return gameId;
}

@JsonProperty("game_id")
public void setGameId(String gameId) {
this.gameId = gameId;
}

@JsonProperty("language")
public String getLanguage() {
return language;
}

@JsonProperty("language")
public void setLanguage(String language) {
this.language = language;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("view_count")
public String getViewCount() {
return viewCount;
}

@JsonProperty("view_count")
public void setViewCount(String viewCount) {
this.viewCount = viewCount;
}

@JsonProperty("created_at")
public String getCreatedAt() {
return createdAt;
}

@JsonProperty("created_at")
public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
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