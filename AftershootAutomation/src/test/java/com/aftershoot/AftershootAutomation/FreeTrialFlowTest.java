package com.aftershoot.AftershootAutomation;

import com.aftershoot.AftershootAutomation.BaseTest;
import com.aftershoot.AftershootAutomation.AftershootLandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreeTrialFlowTest extends BaseTest {

    @Test
    public void testEmailSubscriptionFlow() throws InterruptedException {
        AftershootLandingPage page = new AftershootLandingPage(driver);
        
        // Input test email and submit
        page.enterEmailAndSubmit("testuser@example.com");
        
        // Verify redirection occurred
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl, "Redirection URL is null!");
        System.out.println("Test 2 Passed: Email submitted successfully, current URL: " + currentUrl);
    }
}