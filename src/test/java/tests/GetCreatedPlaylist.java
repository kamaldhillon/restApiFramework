package tests;

import api.CreateNewPlaylistObject;
import api.GetNewPlaylistObject;
import helper.CustomAssert;
import initializer.TestInit;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.ResponseGetPlaylist;
import propertymanagement.TestCasesProperties;
import reportmanagement.ExtentManager;

public class GetCreatedPlaylist extends TestInit {

    @Test
    public void Success() {
        ExtentManager.startTest(TestCasesProperties.getTestCase("TC002"));
        GetNewPlaylistObject getNewPlaylistObject = new GetNewPlaylistObject();
        Response response=getNewPlaylistObject.getPlaylist();
        CustomAssert.assertEquals(response.getStatusCode(),201,"Status code is incorrect");
        ResponseGetPlaylist pojoResponse=response.as(ResponseGetPlaylist.class);
        String name =pojoResponse.getOwner().getDisplay_name();
        CustomAssert.assertEquals("Kamal",name,"Name is incorrect");
        CustomAssert.assertAll();
    }
}
