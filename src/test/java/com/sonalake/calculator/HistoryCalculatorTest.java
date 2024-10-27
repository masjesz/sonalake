package com.sonalake.calculator;

import com.sonalake.BaseTest;
import com.sonalake.calculator.pages.*;
import com.sonalake.utilities.WebPageUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryCalculatorTest extends BaseTest {

    private CalculatorPage calculatorPage;
    private RadicalPage radicalPage;
    private PiPage piPage;
    private CosPage cosPage;
    private HistoryDropdownPage historyDropdownPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        calculatorPage = new CalculatorPage(driver);
        radicalPage = new RadicalPage(driver);
        piPage = new PiPage(driver);
        cosPage = new CosPage(driver);
        historyDropdownPage = new HistoryDropdownPage(driver);
    }

    @AfterEach
    public void tearDown() {
        calculatorPage.clear();
        driver.quit();
    }

    @Test
    @DisplayName("Test calculator")
    public void testCalculator() {
        String expression = "35*999+(100/4)";
        String expectedResult = "34990";
        String expectedCosResult = "-1";
        int numberToFindSquareRoot = 81;
        String expectedRadicalResult = "9";

        WebPageUtils.acceptConsentOnWebPage(driver);

        // Test expression calculation
        Supplier<String> resultSupplier = calculatorPage.getResultSupplier(expectedResult);
        calculatorPage.calculateExpression(expression);
        assertEquals(expectedResult, resultSupplier.get());

        calculatorPage.clear();

        // Test cosine calculation
        Supplier<String> cosResultSupplier = calculatorPage.getResultSupplier(expectedCosResult);
        cosPage.clickCosButton();
        piPage.clickPiButton();
        cosPage.calculateCosExpression();
        calculatorPage.clickEquals();
        assertEquals(expectedCosResult, cosResultSupplier.get());

        calculatorPage.clear();

        // Test square root calculation
        Supplier<String> radicalResultSupplier = () -> {
            calculatorPage.getInputField().sendKeys(String.valueOf(numberToFindSquareRoot));
            radicalPage.calculateRadicalExpression();
            calculatorPage.clickEquals();
            calculatorPage.waitUntilResultMatches(expectedRadicalResult);
            return calculatorPage.getInputField().getAttribute("value");
        };
        assertEquals(expectedRadicalResult, radicalResultSupplier.get());

        calculatorPage.clear();

        // Test history dropdown
        historyDropdownPage.clickOnHistoryDropdown();
        WebElement historyList = historyDropdownPage.getHistoryList();

        WebPageUtils.waitForElementText(driver, historyList, expression);
        WebPageUtils.waitForElementText(driver, historyList, "cos(pi");
        WebPageUtils.waitForElementText(driver, historyList, "sqrt(81)");
    }
}
