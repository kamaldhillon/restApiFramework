package tests;

import api.CreateNewPlaylistObject;
import initializer.TestInit;
import org.testng.annotations.Test;
import propertymanagement.TestCasesProperties;
import reportmanagement.ExtentManager;

public class CreateNewPlaylist extends TestInit {

    @Test
    public void Success() {
        ExtentManager.startTest(TestCasesProperties.getTestCase("TC001"));
        CreateNewPlaylistObject playlistObjects = new CreateNewPlaylistObject();
        playlistObjects.createNewPlaylist();
    }
}
