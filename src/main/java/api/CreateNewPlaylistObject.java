package api;

import com.aventstack.extentreports.ExtentTest;
import globalconstants.RequestType;
import io.restassured.response.Response;
import org.jsoup.Connection;
import pojo.Playlist;
import propertymanagement.ApiProperties;
import reportmanagement.ExtentManager;
import utils.BaseClass;

public class CreateNewPlaylistObject {
    public Response createNewPlaylist(){
        Response response = null;
            BaseClass baseClass= new BaseClass();
            try {

                Playlist list = new Playlist();
                list.setName("New Test Playlist1");
                list.setDecription("New Test Playlist1");
                list.set_public(false);
                String requestBody="{\n" +
                        "    \"name\": \"New Playlist\",\n" +
                        "    \"description\": \"New playlist description\",\n" +
                        "    \"public\": false\n" +
                        "}";
                 response=  baseClass.restAssuredHelper.SpecifyAndSendRequest(RequestType.Post,
                        ApiProperties.getProperty("createNewPlaylist"),
                        requestBody, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
    }
}
