package tests;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.Playlist;
import pojo.ResponseGetPlaylist;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetPlaylist {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Authorization","Bearer BQD77Nq8Kkc2j4nsFoQsotCoMuK8oNFSrFL3iWXtUJAxiK7ZLMifYg50haMuWFNtMcBiLhImcwgfog2E2mUWbIhZxWR_KCImI5GF-Ss9vTn8WCl9U_tqdm3R2Pblfe1XJrLMZSSm5rSjzVqGcbwAiCWGxCZAuqvAsN8peBueh-KSqzco2nvrmin2uCHYDRaUL617y2kJnecLRyPndxHWnzVeWuM9J0NJuumPw3VcoVbBQxiIKCszvXR-dDERyqm69zA7CSsCodowMzsk")                .setContentType("application/json")
                .log(LogDetail.ALL);

        requestSpecification=requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200).log(LogDetail.ALL);

        responseSpecification=responseSpecBuilder.build();
    }

    @Test
    public void createPlaylistSuccess(){

//        JSONObject object = new JSONObject();
//        object.put("name","New Test Playlist");
//        object.put("description","New playlist description");
//        object.put("public",false);
        Playlist list = new Playlist();
        list.setName("New Test Playlist1");
        list.setDecription("New Test Playlist1");
        list.set_public(false);
//        given().spec(requestSpecification).log().all().body(list).
//        when().post("/users/31viksw235sx2g3ufcnad5m3xife/playlists").then()
//                .assertThat().statusCode(201)
//                .body("name",equalTo("New Test Playlist"));

        ResponseGetPlaylist response=given().spec(requestSpecification).log().all().body(list).
                when().post("/users/31viksw235sx2g3ufcnad5m3xife/playlists").then().log().all().extract()
                .response().as(ResponseGetPlaylist.class);
               assertThat(response.getName(),equalTo(list.getName()));
        assertThat(response.is_public(),equalTo(list.is_public()));
    }

    @Test
    public void getPlaylistSuccess(){


        given().spec(requestSpecification).log().all().
                when().get("/playlists/70J7dHWh2YnYUzMVImiRBD").then().spec(responseSpecification)
                .body("name",equalTo("New Test Playlist"));
    }

    @Test
    public void updatePlaylistSuccess(){

        JSONObject object = new JSONObject();
        object.put("name","Updated Test Playlist");
        object.put("description","Updated playlist description");
        object.put("public",false);
        given().spec(requestSpecification).log().all().body(object.toString()).
                when().put("playlists/5Jfhv9SXaoX06nNe3I0zo9").then().spec(responseSpecification);
    }
}
