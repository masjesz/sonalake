package com.sonalake.calculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PiPage {
    private final WebDriver driver;

    private final By piButton = By.id("BtnPi");

    public PiPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPiButton() {
        driver.findElement(piButton).click();
    }
}