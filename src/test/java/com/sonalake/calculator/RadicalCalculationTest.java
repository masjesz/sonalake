package com.sonalake.calculator;

import com.sonalake.BaseTest;
import com.sonalake.calculator.pages.CalculatorPage;
import com.sonalake.calculator.pages.RadicalPage;
import com.sonalake.utilities.WebPageUtils;
import org.junit.jupiter.api.*;

import java.util.function.Supplier;

public class RadicalCalculationTest extends BaseTest {

    private CalculatorPage calculatorPage;
    private RadicalPage radicalPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        calculatorPage = new CalculatorPage(driver);
        radicalPage = new RadicalPage(driver);
    }

    @AfterEach
    public void tearDown() {
        calculatorPage.clear();
        driver.quit();
    }

    @Test
    @DisplayName("Calculate radical")
    public void testRadicalCalculation() {
        int numberToCalculateRadical = 81;
        String expectedRadicalResult = "9";

        WebPageUtils.acceptConsentOnWebPage(driver);

        Supplier<String> actualRadicalResultSupplier = () -> {
            calculatorPage.getInputField().sendKeys(String.valueOf(numberToCalculateRadical));
            radicalPage.calculateRadicalExpression();
            calculatorPage.clickEquals();
            calculatorPage.waitUntilResultMatches(expectedRadicalResult);
            return calculatorPage.getInputField().getAttribute("value");
        };

        Assertions.assertEquals(expectedRadicalResult, actualRadicalResultSupplier.get());
        calculatorPage.clear();
    }
}