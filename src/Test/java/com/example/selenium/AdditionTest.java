package com.example;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdditionTest {

    @Test
    public void testAddition() throws InterruptedException {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Get the Jenkins workspace path dynamically
            String workspace = System.getProperty("user.dir"); 
            // Build the file path to index.html
            File htmlFile = new File(workspace + "/src/main/webapp/index.html");

            // Open the HTML file
            driver.get("file:///" + htmlFile.getAbsolutePath().replace("\\", "/"));

            // Fill in the numbers
            driver.findElement(By.id("num1")).sendKeys("5");
            driver.findElement(By.id("num2")).sendKeys("7");

            // Click the Add button
            driver.findElement(By.tagName("button")).click();

            // Wait a moment for the result
            Thread.sleep(1000);

            // Get the result text
            WebElement result = driver.findElement(By.id("result"));
            String text = result.getText();

            // Check the result
            assertEquals("Result: 12", text);

        } finally {
            // Quit driver in all cases
            driver.quit();
        }
    }
}