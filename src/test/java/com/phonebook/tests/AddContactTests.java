package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }

        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "okay@gm.com");
        type(By.name("password"), "Manuel1234$");
        click(By.name("login"));
    }

    @Test
    public void addContactPositiveTest() {
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"), "Adam");
        type(By.cssSelector("input:nth-child(2)"), "Karl");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "adam@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        type(By.cssSelector("input:nth-child(6)"), "goalkeeper");
        click(By.cssSelector(".add_form__2rsm2 button"));
        Assert.assertTrue(isContactCreatedByText("Adam"));
    }

    @AfterMethod
    public void postCondition() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactCreatedByText(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }


}
