package com.sonalake.calculator;

import com.sonalake.BaseTest;
import com.sonalake.calculator.pages.CalculatorPage;
import com.sonalake.utilities.WebPageUtils;
import org.junit.jupiter.api.*;

import java.util.function.Supplier;

public class ExpressionCalculationTest extends BaseTest {

    private CalculatorPage calculatorPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        calculatorPage = new CalculatorPage(driver);
    }

    @AfterEach
    public void tearDown() {
        calculatorPage.clear();
        driver.quit();
    }

    @Test
    @DisplayName("Calculate expression")
    public void testExpressionCalculation() {
        String expression = "35*999+(100/4)";
        String expectedResult = "34990";

        WebPageUtils.acceptConsentOnWebPage(driver);
        calculatorPage.calculateExpression(expression);

        Supplier<String> actualResultSupplier = calculatorPage.getResultSupplier(expectedResult);

        Assertions.assertEquals(expectedResult, actualResultSupplier.get());
    }
}