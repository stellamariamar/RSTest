package com.rstest.pom;


import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.rstest.bdd.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class BrowseCategoriesPage extends PageObject{

    public BrowseCategoriesPage(WebDriver driver){
        super(driver);
    }

    public void selectBrowse(){
       // Browse
        WebElement weBrowse  = driver.findElement(By.id("desktop-browse-icon"));
        weBrowse.click();

    }

    public void selectCategory(String category){
        // Category page
        WebElement weCategory  = driver.findElement(By.xpath("//span[contains(text(),'"+category+"')]"));
        weCategory.click();

    }
    public void selectEndCategory(String category){
        // Category page
        WebElement weCategory  = driver.findElement(By.xpath("//a[contains(text(),'"+category+"')]"));
        weCategory.click();

    }

}