package com.sonalake.calculator;

import com.sonalake.BaseTest;
import com.sonalake.calculator.pages.CalculatorPage;
import com.sonalake.calculator.pages.CosPage;
import com.sonalake.calculator.pages.PiPage;
import com.sonalake.utilities.WebPageUtils;
import org.junit.jupiter.api.*;

import java.util.function.Supplier;

public class CosCalculationTest extends BaseTest {

    private CalculatorPage calculatorPage;
    private CosPage cosPage;
    private PiPage piPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        calculatorPage = new CalculatorPage(driver);
        cosPage = new CosPage(driver);
        piPage = new PiPage(driver);
    }

    @AfterEach
    public void tearDown() {
        calculatorPage.clear();
        driver.quit();
    }

    @Test
    @DisplayName("Calculate cosine")
    public void testCosCalculation() {
        String expectedCosResult = "-1";

        WebPageUtils.acceptConsentOnWebPage(driver);
        cosPage.clickCosButton();
        piPage.clickPiButton();
        cosPage.calculateCosExpression();
        calculatorPage.clickEquals();

        Supplier<String> actualCosResultSupplier = calculatorPage.getResultSupplier(expectedCosResult);

        Assertions.assertEquals(expectedCosResult, actualCosResultSupplier.get());
    }
}