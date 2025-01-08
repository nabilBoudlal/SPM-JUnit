package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ChromeTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Disabled
    @Test
    void test() throws InterruptedException {
        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();
         Thread.sleep(3000);
        // Verify
        assertTrue(title.contains("Selenium WebDriver"), "The string does contain the expected substring");
    }

    @Disabled
    @Test
    void testApp(){
        driver.get("http://localhost:8080/MavenTest2/");
        String title = driver.getTitle();
        // Verify
        assertTrue(title.contains("SPM 2025"), "The string does contain the expected substring");
    }

}