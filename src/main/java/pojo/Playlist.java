package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {
    private String name;
    private String decription;

    @JsonProperty("public")
    private boolean _public;
}
