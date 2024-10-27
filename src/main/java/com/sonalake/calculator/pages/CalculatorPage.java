package com.sonalake.calculator.pages;

import com.sonalake.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class CalculatorPage {
    private final WebDriver driver;
    private final WaitHelper waitHelper;

    private final By inputField = By.id("input");
    private final By equalsButton = By.id("BtnCalc");

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(this.driver);
    }

    public WebElement getInputField() {
        return driver.findElement(inputField);
    }

    public void clickEquals() {
        driver.findElement(equalsButton).click();
    }

    public void clear() {
        getInputField().clear();
    }

    public void waitUntilResultMatches(String expectedResult) {
        waitHelper.waitUntilAttributeContains(inputField, "value", expectedResult);

        String newResult = getInputField().getAttribute("value");
        if (!expectedResult.equals(newResult)) {
            throw new AssertionError(
                    String.format("Expression result not expected, expected ( %s ), found( %s )", expectedResult, newResult));
        }
    }

    public void calculateExpression(String expression) {
        getInputField().sendKeys(expression);
        clickEquals();
    }

    public Supplier<String> getResultSupplier(String expectedResult) {
        return () -> {
            waitUntilResultMatches(expectedResult);
            return getInputField().getAttribute("value");
        };
    }
}