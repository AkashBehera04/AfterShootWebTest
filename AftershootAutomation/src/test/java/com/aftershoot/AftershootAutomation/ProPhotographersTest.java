package com.aftershoot.AftershootAutomation;



import com.aftershoot.AftershootAutomation.BaseTest;
import com.aftershoot.AftershootAutomation.AftershootLandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProPhotographersTest extends BaseTest {

    @Test
    public void testProPhotographers() throws InterruptedException {
        AftershootLandingPage page = new AftershootLandingPage(driver);

        // Verify featured photographers are visible on page
        boolean victorLax = page.isPhotographerSectionVisible("VICTOR LAX");
        boolean lillyRed = page.isPhotographerSectionVisible("LILLY RED");

        Assert.assertTrue(victorLax, "Victor Lax name missing!");
        Assert.assertTrue(lillyRed, "Lilly Red name missing!");

        System.out.println("Test 5 Passed: Pro Photographers section validated successfully.");
    }
}