
package com.spotify.oauth2.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {

    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("description")
    private String description;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Object> images;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("primary_color")
    private Object primaryColor;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("snapshot_id")
    private String snapshotId;
    @JsonProperty("tracks")
    private Tracks tracks;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    
    public Playlist() {
    	
    }
    
    public Boolean getCollaborative() {
		return collaborative;
	}
	public void setCollaborative(Boolean collaborative) {
		this.collaborative = collaborative;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ExternalUrls getExternalUrls() {
		return externalUrls;
	}
	public void setExternalUrls(ExternalUrls externalUrls) {
		this.externalUrls = externalUrls;
	}
	public Followers getFollowers() {
		return followers;
	}
	public void setFollowers(Followers followers) {
		this.followers = followers;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Object> getImages() {
		return images;
	}
	public void setImages(List<Object> images) {
		this.images = images;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Object getPrimaryColor() {
		return primaryColor;
	}
	public void setPrimaryColor(Object primaryColor) {
		this.primaryColor = primaryColor;
	}
	public Boolean get_public() {
		return _public;
	}
	public void set_public(Boolean _public) {
		this._public = _public;
	}
	public String getSnapshotId() {
		return snapshotId;
	}
	public void setSnapshotId(String snapshotId) {
		this.snapshotId = snapshotId;
	}
	public Tracks getTracks() {
		return tracks;
	}
	public void setTracks(Tracks tracks) {
		this.tracks = tracks;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	

}
