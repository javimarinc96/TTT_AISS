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
"title",
"description",
"created_at",
"published_at",
"url",
"thumbnail_url",
"viewable",
"view_count",
"language",
"type",
"duration"
})
public class VideoData {

@JsonProperty("id")
private String id;
@JsonProperty("user_id")
private String userId;
@JsonProperty("user_name")
private String userName;
@JsonProperty("title")
private String title;
@JsonProperty("description")
private String description;
@JsonProperty("created_at")
private String createdAt;
@JsonProperty("published_at")
private String publishedAt;
@JsonProperty("url")
private String url;
@JsonProperty("thumbnail_url")
private String thumbnailUrl;
@JsonProperty("viewable")
private String viewable;
@JsonProperty("view_count")
private Integer viewCount;
@JsonProperty("language")
private String language;
@JsonProperty("type")
private String type;
@JsonProperty("duration")
private String duration;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public VideoData() {
}

/**
* 
* @param type
* @param url
* @param id
* @param publishedAt
* @param duration
* @param title
* @param viewable
* @param description
* @param createdAt
* @param userId
* @param thumbnailUrl
* @param userName
* @param language
* @param viewCount
*/
public VideoData(String id, String userId, String userName, String title, String description, String createdAt, String publishedAt, String url, String thumbnailUrl, String viewable, Integer viewCount, String language, String type, String duration) {
super();
this.id = id;
this.userId = userId;
this.userName = userName;
this.title = title;
this.description = description;
this.createdAt = createdAt;
this.publishedAt = publishedAt;
this.url = url;
this.thumbnailUrl = thumbnailUrl;
this.viewable = viewable;
this.viewCount = viewCount;
this.language = language;
this.type = type;
this.duration = duration;
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

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("created_at")
public String getCreatedAt() {
return createdAt;
}

@JsonProperty("created_at")
public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

@JsonProperty("published_at")
public String getPublishedAt() {
return publishedAt;
}

@JsonProperty("published_at")
public void setPublishedAt(String publishedAt) {
this.publishedAt = publishedAt;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonProperty("thumbnail_url")
public String getThumbnailUrl() {
return thumbnailUrl;
}

@JsonProperty("thumbnail_url")
public void setThumbnailUrl(String thumbnailUrl) {
this.thumbnailUrl = thumbnailUrl;
}

@JsonProperty("viewable")
public String getViewable() {
return viewable;
}

@JsonProperty("viewable")
public void setViewable(String viewable) {
this.viewable = viewable;
}

@JsonProperty("view_count")
public Integer getViewCount() {
return viewCount;
}

@JsonProperty("view_count")
public void setViewCount(Integer viewCount) {
this.viewCount = viewCount;
}

@JsonProperty("language")
public String getLanguage() {
return language;
}

@JsonProperty("language")
public void setLanguage(String language) {
this.language = language;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("duration")
public String getDuration() {
return duration;
}

@JsonProperty("duration")
public void setDuration(String duration) {
this.duration = duration;
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