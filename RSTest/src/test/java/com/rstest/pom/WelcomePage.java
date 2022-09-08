package com.rstest.pom;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.rstest.bdd.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

    public class WelcomePage extends PageObject{

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


