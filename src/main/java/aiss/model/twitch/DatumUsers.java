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
"login",
"display_name",
"type",
"broadcaster_type",
"description",
"profile_image_url",
"offline_image_url",
"view_count",
"email"
})
public class DatumUsers {

@JsonProperty("id")
private String id;
@JsonProperty("login")
private String login;
@JsonProperty("display_name")
private String displayName;
@JsonProperty("type")
private String type;
@JsonProperty("broadcaster_type")
private String broadcasterType;
@JsonProperty("description")
private String description;
@JsonProperty("profile_image_url")
private String profileImageUrl;
@JsonProperty("offline_image_url")
private String offlineImageUrl;
@JsonProperty("view_count")
private String viewCount;
@JsonProperty("email")
private String email;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public DatumUsers() {
}

/**
* 
* @param id
* @param broadcasterType
* @param email
* @param description
* @param offlineImageUrl
* @param profileImageUrl
* @param login
* @param type
* @param displayName
* @param viewCount
*/
public DatumUsers(String id, String login, String displayName, String type, String broadcasterType, String description, String profileImageUrl, String offlineImageUrl, String viewCount, String email) {
super();
this.id = id;
this.login = login;
this.displayName = displayName;
this.type = type;
this.broadcasterType = broadcasterType;
this.description = description;
this.profileImageUrl = profileImageUrl;
this.offlineImageUrl = offlineImageUrl;
this.viewCount = viewCount;
this.email = email;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("login")
public String getLogin() {
return login;
}

@JsonProperty("login")
public void setLogin(String login) {
this.login = login;
}

@JsonProperty("display_name")
public String getDisplayName() {
return displayName;
}

@JsonProperty("display_name")
public void setDisplayName(String displayName) {
this.displayName = displayName;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("broadcaster_type")
public String getBroadcasterType() {
return broadcasterType;
}

@JsonProperty("broadcaster_type")
public void setBroadcasterType(String broadcasterType) {
this.broadcasterType = broadcasterType;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("profile_image_url")
public String getProfileImageUrl() {
return profileImageUrl;
}

@JsonProperty("profile_image_url")
public void setProfileImageUrl(String profileImageUrl) {
this.profileImageUrl = profileImageUrl;
}

@JsonProperty("offline_image_url")
public String getOfflineImageUrl() {
return offlineImageUrl;
}

@JsonProperty("offline_image_url")
public void setOfflineImageUrl(String offlineImageUrl) {
this.offlineImageUrl = offlineImageUrl;
}

@JsonProperty("view_count")
public String getViewCount() {
return viewCount;
}

@JsonProperty("view_count")
public void setViewCount(String viewCount) {
this.viewCount = viewCount;
}

@JsonProperty("email")
public String getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(String email) {
this.email = email;
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