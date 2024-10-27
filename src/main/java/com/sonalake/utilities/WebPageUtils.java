package com.sonalake.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebPageUtils {

    public static void acceptConsentOnWebPage(WebDriver driver) {
        By consentButtonLocator = By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']");

        try {
            WebDriverWait wait = getWebDriverWait(driver);
            WebElement consentAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(consentButtonLocator));
            consentAcceptButton.click();
        } catch (Exception e) {
            // If the consent accept button is not displayed, ignore the exception
        }
    }

    public static void waitForElementText(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = getWebDriverWait(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    private static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
