package com.aftershoot.AftershootAutomation;



import com.aftershoot.AftershootAutomation.BaseTest;
import com.aftershoot.AftershootAutomation.AftershootLandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlatformCompatibilityTest extends BaseTest {

    @Test
    public void testPlatformIcons() {
        AftershootLandingPage page = new AftershootLandingPage(driver);
        boolean iconsVisible = page.arePlatformIconsVisible();
        
        // Assert platform compatibility visibility
        Assert.assertTrue(iconsVisible, "Mac and Windows compatibility text not found!");
        System.out.println("Test 3 Passed: Mac & Windows compatibility indicators verified.");
    }
}