package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageSearchObject extends PageObject {

    public PageSearchObject(WebDriver driver){
        super(driver);
    }

    public SearchResultsPage search(String searchTerm) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='searchTerm']"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);

        return new SearchResultsPage(driver);
    }

    public ProductPage searchMPN(String searchTerm) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='searchTerm']"));
        WebElement MPNtoggle = driver.findElement(By.xpath("//span[@data-qa='searchMPNToggle_graphic']"));
        MPNtoggle.click();
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);

        return new ProductPage(driver);
    }


}
