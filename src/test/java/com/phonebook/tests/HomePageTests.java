package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest() {
//        System.out.println("Home Component is " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }

}
