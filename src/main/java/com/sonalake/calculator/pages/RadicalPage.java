package com.sonalake.calculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadicalPage {
    private final WebDriver driver;

    private final By buttonSqrt = By.id("BtnSqrt");

    public RadicalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void calculateRadicalExpression() {
        driver.findElement(buttonSqrt).click();
    }
}
