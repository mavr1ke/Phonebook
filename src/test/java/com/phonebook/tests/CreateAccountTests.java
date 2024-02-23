package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase{

    @Test
    public void createNewAccountPositiveTest() {
        driver.findElement(By.cssSelector("[href='/login']")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("okay@gm.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Manuel1234$");
        driver.findElement(By.name("registration")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test
    public void createExistedAccountNegativeTest() {
        driver.findElement(By.cssSelector("[href='/login']")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("okay@gm.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Manuel1234$");
        driver.findElement(By.name("registration")).click();
        Assert.assertTrue(isAlertAppears());
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }

}
