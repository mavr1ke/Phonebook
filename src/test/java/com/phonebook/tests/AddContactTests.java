package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("okay@gm.com")
                .setPassword("Manuel1234$"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Adam")
                .setLastName("Karl")
                .setPhone("1234567890")
                .setEmail("adam@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        clickOnSaveButton();
        Assert.assertTrue(isContactCreatedByText("Adam"));
    }

    @AfterMethod
    public void postCondition() {
        removeContact();
    }


}
