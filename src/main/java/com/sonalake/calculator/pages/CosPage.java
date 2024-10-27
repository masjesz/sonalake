package com.sonalake.calculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CosPage {
    private final WebDriver driver;

    private final By cosButton = By.id("BtnCos");
    private final By radRadioButton = By.id("trigorad");

    public CosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void calculateCosExpression() {
        driver.findElement(radRadioButton).click();
    }

    public void clickCosButton() {
        driver.findElement(cosButton).click();
    }
}