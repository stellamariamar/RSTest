package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage extends PageObject{
    // The page that the user sees after successfully logging in
    // Note: This page object hasn't been used in the tests; all checkouts are to be performed as guest.

    public WelcomePage(WebDriver driver){
        super(driver);
    }

    public String getWelcomeMsg(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-welcome")));
        return welcome.getText();

    }
    public void logout (){
        WebElement logoutBtn = driver.findElement(By.id("js-logInOut"));
        logoutBtn.click();
    }
}


