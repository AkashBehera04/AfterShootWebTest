package com.aftershoot.AftershootAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AftershootLandingPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(css = "img[alt*='aftershoot'], svg, .logo")
    private WebElement logo;

    @FindBy(css = "input[type='email'], input[placeholder*='Enter your email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Start Free Trial')]")
    private WebElement startFreeTrialBtn;

    // Updated XPath for Mac and Windows labels/icons on the landing page
    @FindBy(xpath = "//*[contains(text(),'Mac') or contains(text(),'Windows')]")
    private WebElement platformText;

    public AftershootLandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        js.executeScript("arguments[0].style.border='3px solid red'", logo); // Highlighter for visual proof
        return logo.isDisplayed();
    }

    public void enterEmailAndSubmit(String email) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", emailField);
        Thread.sleep(1000);
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(1000);
        
        js.executeScript("arguments[0].style.border='3px solid green'", startFreeTrialBtn);
        startFreeTrialBtn.click();
        Thread.sleep(2000); // Pause to show submission
    }

    public boolean arePlatformIconsVisible() {
        wait.until(ExpectedConditions.visibilityOf(platformText));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", platformText);
        return platformText.isDisplayed();
    }

    public void clickFilterByText(String filterName) throws InterruptedException {
        WebElement filterTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), '" + filterName + "')]")));
        
        // Smooth scroll to filter tab so interviewer can see it on screen
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", filterTab);
        Thread.sleep(1000);
        
        // Highlight element before clicking
        js.executeScript("arguments[0].style.border='3px solid orange'", filterTab);
        js.executeScript("arguments[0].click();", filterTab);
        Thread.sleep(1500); // Real delay to show content change
    }

    public boolean isPhotographerSectionVisible(String photographerName) throws InterruptedException {
        WebElement photographer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), '" + photographerName + "')]")));
        
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", photographer);
        Thread.sleep(1000);
        js.executeScript("arguments[0].style.border='3px solid purple'", photographer);
        return photographer.isDisplayed();
    }
}