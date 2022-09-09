package com.rstest.pom;


import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends PageObject{

    public SearchPage(WebDriver driver){
        super(driver);
    }

    public void enterSearchTerm(String searchTerm) {
        // Search page
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='searchTerm']"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void selectCategory(String category){
        // Category page
        System.out.println(category);
        try {
            WebElement weCategory = driver.findElement(By.xpath("//*[@data-qa='primary'][contains(text(),'" + category + "')]//ancestor::a"));
            weCategory.click();
        } catch (NoSuchElementException e) {
            System.out.println("Could not find Category in Left side Menu, trying top Popular Categories");
            WebElement weCategory = driver.findElement(By.xpath("//div[@data-testid='subcategory-title'][contains(text(),'" + category + "')]"));
            weCategory.click();
        }


    }




}
