
package aiss.model.youtube;

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
    "authorDisplayName",
    "authorProfileImageUrl",
    "authorChannelUrl",
    "authorChannelId",
    "channelId",
    "videoId",
    "textDisplay",
    "textOriginal",
    "canRate",
    "viewerRating",
    "likeCount",
    "publishedAt",
    "updatedAt"
})
public class SnippetTopLevelComment {

    @JsonProperty("authorDisplayName")
    private String authorDisplayName;
    @JsonProperty("authorProfileImageUrl")
    private String authorProfileImageUrl;
    @JsonProperty("authorChannelUrl")
    private String authorChannelUrl;
    @JsonProperty("authorChannelId")
    private AuthorChannelId authorChannelId;
    @JsonProperty("channelId")
    private String channelId;
    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("textDisplay")
    private String textDisplay;
    @JsonProperty("textOriginal")
    private String textOriginal;
    @JsonProperty("canRate")
    private Boolean canRate;
    @JsonProperty("viewerRating")
    private String viewerRating;
    @JsonProperty("likeCount")
    private Integer likeCount;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SnippetTopLevelComment() {
    }

    /**
     * 
     * @param viewerRating
     * @param canRate
     * @param authorChannelId
     * @param likeCount
     * @param channelId
     * @param textDisplay
     * @param authorChannelUrl
     * @param updatedAt
     * @param publishedAt
     * @param textOriginal
     * @param authorProfileImageUrl
     * @param videoId
     * @param authorDisplayName
     */
    public SnippetTopLevelComment(String authorDisplayName, String authorProfileImageUrl, String authorChannelUrl, AuthorChannelId authorChannelId, String channelId, String videoId, String textDisplay, String textOriginal, Boolean canRate, String viewerRating, Integer likeCount, String publishedAt, String updatedAt) {
        super();
        this.authorDisplayName = authorDisplayName;
        this.authorProfileImageUrl = authorProfileImageUrl;
        this.authorChannelUrl = authorChannelUrl;
        this.authorChannelId = authorChannelId;
        this.channelId = channelId;
        this.videoId = videoId;
        this.textDisplay = textDisplay;
        this.textOriginal = textOriginal;
        this.canRate = canRate;
        this.viewerRating = viewerRating;
        this.likeCount = likeCount;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
    }

    @JsonProperty("authorDisplayName")
    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    @JsonProperty("authorDisplayName")
    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    @JsonProperty("authorProfileImageUrl")
    public String getAuthorProfileImageUrl() {
        return authorProfileImageUrl;
    }

    @JsonProperty("authorProfileImageUrl")
    public void setAuthorProfileImageUrl(String authorProfileImageUrl) {
        this.authorProfileImageUrl = authorProfileImageUrl;
    }

    @JsonProperty("authorChannelUrl")
    public String getAuthorChannelUrl() {
        return authorChannelUrl;
    }

    @JsonProperty("authorChannelUrl")
    public void setAuthorChannelUrl(String authorChannelUrl) {
        this.authorChannelUrl = authorChannelUrl;
    }

    @JsonProperty("authorChannelId")
    public AuthorChannelId getAuthorChannelId() {
        return authorChannelId;
    }

    @JsonProperty("authorChannelId")
    public void setAuthorChannelId(AuthorChannelId authorChannelId) {
        this.authorChannelId = authorChannelId;
    }

    @JsonProperty("channelId")
    public String getChannelId() {
        return channelId;
    }

    @JsonProperty("channelId")
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("textDisplay")
    public String getTextDisplay() {
        return textDisplay;
    }

    @JsonProperty("textDisplay")
    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    @JsonProperty("textOriginal")
    public String getTextOriginal() {
        return textOriginal;
    }

    @JsonProperty("textOriginal")
    public void setTextOriginal(String textOriginal) {
        this.textOriginal = textOriginal;
    }

    @JsonProperty("canRate")
    public Boolean getCanRate() {
        return canRate;
    }

    @JsonProperty("canRate")
    public void setCanRate(Boolean canRate) {
        this.canRate = canRate;
    }

    @JsonProperty("viewerRating")
    public String getViewerRating() {
        return viewerRating;
    }

    @JsonProperty("viewerRating")
    public void setViewerRating(String viewerRating) {
        this.viewerRating = viewerRating;
    }

    @JsonProperty("likeCount")
    public Integer getLikeCount() {
        return likeCount;
    }

    @JsonProperty("likeCount")
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
