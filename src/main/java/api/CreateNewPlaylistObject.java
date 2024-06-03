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
    public void createNewPlaylist(){
            ExtentTest node = ExtentManager.getTest();
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
                Response response =  baseClass.restAssuredHelper.SpecifyAndSendRequest(RequestType.Post,
                        ApiProperties.getProperty("createNewPlaylist"),
                        requestBody, true);
                if(response.getStatusCode() != 200){
                    System.out.println(response.asString());
                    node.fail("Response Status Code is : "+response.getStatusCode() + "  Reason : " + response.getStatusLine());
                    throw new Exception("HttpResponseException + "+ response.getStatusLine());
                }
                node.info(response.asPrettyString());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
