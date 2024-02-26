package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }

        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "okay@gm.com");
        type(By.name("password"), "Manuel1234$");
        click(By.name("login"));
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"), "Adam");
        type(By.cssSelector("input:nth-child(2)"), "Karl");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "adam@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        type(By.cssSelector("input:nth-child(6)"), "goalkeeper");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void removeContact() {
        int sizeBefore = sizeOfContacts();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts() {
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
