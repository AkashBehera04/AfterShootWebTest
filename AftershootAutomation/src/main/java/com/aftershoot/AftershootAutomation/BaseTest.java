package com.aftershoot.AftershootAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    // Target Aftershoot landing page URL
    protected String url = "https://aftershoot.com/start-now/?utm_source=google_ads&utm_medium=cpc&utm_campaign=branded_keyword_gad&utm_term=aftershoot";

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        // Maximize browser window for full UI visibility
        driver.manage().window().maximize();
        // Set implicit wait for element loading sync
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to the target web application URL
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        // Quit browser and close session after test completion
        if (driver != null) {
            driver.quit();
        }
    }
}