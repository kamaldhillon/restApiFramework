package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tracks {
    private String limit;
    private String next;
    private String offset;
    private String previous;
    private String href;
    private String total;
    private String[] items;

}
