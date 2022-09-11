package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject {
    // Base class for all page objects

    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public void manageCookies() {
        // wait for the cookies pop-up and handle it, if it appears
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement cookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("ensModalBanner")));
            cookies.click();
            WebElement cookiesMin = driver.findElement(By.id("ensSave"));
            cookiesMin.click();
        } catch(Exception e) {}
    }

    public void deleteStorage(){
        driver.manage().deleteAllCookies();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.localStorage.clear();");
    }

}

/* Notes for Survey pop-up
dialog popup id ='fsrInvite'
X Button to close id = 'fsrFocusFirst'
*/
