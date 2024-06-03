package tests;

import org.testng.annotations.Test;
import pojo.Playlist;
import pojo.ResponseGetPlaylist;

import static helper.SpecBuilder.getRequestSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreatePlaylist {


    @Test
    public void createPlaylistSuccess(){

        Playlist list = new Playlist();
        list.setName("New Test Playlist1");
        list.setDecription("New Test Playlist1");
        list.set_public(false);

        ResponseGetPlaylist response=given(getRequestSpec()).log().all().body(list).
                when().post("/users/31viksw235sx2g3ufcnad5m3xife/playlists").then().log().all().extract()
                .response().as(ResponseGetPlaylist.class);

        assertThat(response.getName(),equalTo(list.getName()));
        assertThat(response.is_public(),equalTo(list.is_public()));
    }

    @Test
    public void tokenExpired(){

    }
}
