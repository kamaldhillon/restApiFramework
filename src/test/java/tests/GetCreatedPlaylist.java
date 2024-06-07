package tests;

import api.CreateNewPlaylistObject;
import api.GetNewPlaylistObject;
import initializer.TestInit;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ResponseGetPlaylist;
import propertymanagement.TestCasesProperties;
import reportmanagement.ExtentManager;

public class GetCreatedPlaylist extends TestInit {

    @Test
    public void Success() {
        ExtentManager.startTest(TestCasesProperties.getTestCase("TC002"));
        GetNewPlaylistObject getNewPlaylistObject = new GetNewPlaylistObject();
        ResponseGetPlaylist response=getNewPlaylistObject.getPlaylist().as(ResponseGetPlaylist.class);
        String name =response.getOwner().getDisplay_name();
        Assert.assertEquals("Kamal",name,"Name is incorrect");

    }
}
