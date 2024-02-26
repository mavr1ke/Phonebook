package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }
    }

    public void createNewAccountPositiveTest() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "okay@gm.com");
        type(By.name("password"), "Manuel1234$");
        click(By.name("registration"));
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test
    public void createExistedAccountNegativeTest() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "okay@gm.com");
        type(By.name("password"), "Manuel1234$");
        click(By.name("registration"));
        Assert.assertTrue(isAlertAppears());
    }

}
