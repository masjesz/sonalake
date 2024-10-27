package com.sonalake;

import com.sonalake.calculator.pages.CalculatorPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    protected CalculatorPage calculatorPage;

    @BeforeEach
    public void setUp() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize pages
        calculatorPage = new CalculatorPage(driver);

        // Navigate to calculator website
        driver.get("https://web2.0calc.com/");
    }

    @AfterEach
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }
}