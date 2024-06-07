package api;

import globalconstants.RequestType;
import io.restassured.response.Response;
import pojo.Playlist;
import propertymanagement.ApiProperties;
import utils.BaseClass;

public class GetNewPlaylistObject {
    public Response getPlaylist(){
        Response response = null;
            BaseClass baseClass= new BaseClass();
            try {

                 response=  baseClass.restAssuredHelper.SpecifyAndSendRequest(RequestType.Get,
                        ApiProperties.getProperty("getNewPlaylist"),
                        "", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
    }
}
