package com.aftershoot.AftershootAutomation ;

import com.aftershoot.AftershootAutomation.BaseTest;
import com.aftershoot.AftershootAutomation.AftershootLandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoAndHeaderTest extends BaseTest {

    @Test
    public void testLogoVisibility() {
        AftershootLandingPage page = new AftershootLandingPage(driver);
        boolean isLogoPresent = page.isLogoDisplayed();
        
        // Assert to verify logo is displayed
        Assert.assertTrue(isLogoPresent, "Logo verification failed!");
        System.out.println("Test 1 Passed: Logo is successfully displayed.");
    }
}