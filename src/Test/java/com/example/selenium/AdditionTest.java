package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdditionTest {

    @Test
    public void testAddition() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("file:///S:/webapp/src/main/webapp/index.html");

        driver.findElement(By.id("num1")).sendKeys("5");
        driver.findElement(By.id("num2")).sendKeys("7");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        WebElement result = driver.findElement(By.id("result"));
        String text = result.getText();

        assertEquals("Result: 12", text);

        driver.quit();
    }
}