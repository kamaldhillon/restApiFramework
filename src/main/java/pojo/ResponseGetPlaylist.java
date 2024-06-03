package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseGetPlaylist {
    private boolean collaborative;
    private String description;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    private Followers followers;
    private String href;
    private String id;
    private String[] images;
    private String primary_color;
    private String name;
    private String type;
    private String uri;
    private Owner owner;
    @JsonProperty("public")
    private boolean _public;
    private String snapshot_id;
    private Tracks tracks;

}
