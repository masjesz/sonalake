package com.sonalake.calculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HistoryDropdownPage {

    private final WebDriver driver;

    private final By historyDropdown = By.cssSelector(".history button.dropdown-toggle");

    public HistoryDropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHistoryDropdown() {
        driver.findElement(historyDropdown).click();
    }

    public WebElement getHistoryList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='histframe']//ul")));
    }
}