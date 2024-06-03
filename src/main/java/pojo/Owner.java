package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Owner {
    private String href;
    private String id;
    private String type;
    private String uri;
    private String display_name;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

}
