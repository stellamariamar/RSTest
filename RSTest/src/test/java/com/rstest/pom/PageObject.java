package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.rstest.bdd.DriverManager.driver;

public class PageObject {

    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public void manageCookies() {
        try {
            WebElement cookies = driver.findElement(By.id("ensModalBanner"));
            cookies.click();
            WebElement cookiesMin = driver.findElement(By.id("ensSave"));
            cookiesMin.click();
        } catch(Exception e){}

        /* Survey popup
        dialog popup id ='fsrInvite'
        X Button to close id = 'fsrFocusFirst'
         */
    }

    public void visitHomePage() {
        driver.get("https://uk.rs-online.com/web/");
        System.out.println(driver.getCurrentUrl());
    }
}

