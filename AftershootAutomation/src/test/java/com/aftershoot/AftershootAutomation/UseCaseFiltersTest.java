package com.aftershoot.AftershootAutomation;


import com.aftershoot.AftershootAutomation.BaseTest;
import com.aftershoot.AftershootAutomation.AftershootLandingPage;
import org.testng.annotations.Test;

public class UseCaseFiltersTest extends BaseTest {

    @Test
    public void testCategoryFilters() throws InterruptedException {
        AftershootLandingPage page = new AftershootLandingPage(driver);

        String[] filters = {"Wedding", "Portrait", "Events", "Headshots", "Lifestyle", "Newborns"};

        // Iterate and click each filter category sequentially
        for (String filter : filters) {
            System.out.println("Clicking filter category: " + filter);
            page.clickFilterByText(filter);
            Thread.sleep(1500); // Visual pause for observation
        }

        System.out.println("Test 4 Passed: All use-case category filters clicked successfully.");
    }
}