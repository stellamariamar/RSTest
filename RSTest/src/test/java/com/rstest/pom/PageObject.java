package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.rstest.bdd.DriverManager.driver;

public class PageObject {

    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public void manageCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement cookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("ensModalBanner")));
            cookies.click();
            WebElement cookiesMin = driver.findElement(By.id("ensSave"));
            cookiesMin.click();
        } catch(Exception e){}


        /* Survey popup
        dialog popup id ='fsrInvite'
        X Button to close id = 'fsrFocusFirst'
         */
    }

    public void deleteStorage(){
        driver.manage().deleteAllCookies();
        WebStorage storage = (WebStorage) driver;
        storage.getLocalStorage().clear();
        //((JavascriptExecutor)(driver)).executeScript(
        //        "window.localStorage.clear();"
        //);
    }

    public void visitHomePage() {
        driver.get("https://uk.rs-online.com/web/");
        System.out.println(driver.getCurrentUrl());
    }
}

