package tests;

import api.CreateNewPlaylistObject;
import initializer.TestInit;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import propertymanagement.TestCasesProperties;
import reportmanagement.ExtentManager;

public class CreateNewPlaylist extends TestInit {

    @Test
    public void Success() {
        ExtentManager.startTest(TestCasesProperties.getTestCase("TC001"));
        CreateNewPlaylistObject playlistObjects = new CreateNewPlaylistObject();
        Response response=playlistObjects.createNewPlaylist();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
