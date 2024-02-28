package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if(!isHomeComponentPresent()) {
            clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest() {
//        System.out.println("Home Component is " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

}
