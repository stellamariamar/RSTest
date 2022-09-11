package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageObject {
    // the login page
    // Note: This page object hasn't been used in the tests; all checkouts are to be performed as guest.

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        WebElement weUsername = driver.findElement(
                By.xpath("//input[@data-automation-id='login-username-field']")
        );
        weUsername.clear();
        weUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement wePassword = driver.findElement(
                By.xpath("//input[@data-automation-id='login-password-field']")
        );
        wePassword.clear();
        wePassword.sendKeys(password);
    }

    public void submit() {
        WebElement loginBtn = driver.findElement(
                By.xpath("//button[@data-automation-id='login-submit-button']")
        );
        loginBtn.submit();
    }

    public boolean failedLogin() {
        // check whether or not the login has been successful
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[@data-automation-id='login-message-bad-credentials']")
                    )
            );
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}