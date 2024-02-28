package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("okay@gm.com")
                .setPassword("Manuel1234$"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeTestWithoutEmail() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword("Manuel1234$"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertAppears());
    }

}
