package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageSearchObject extends PageObject {
    // Base class for page objects with a search field

    public PageSearchObject(WebDriver driver){
        super(driver);
    }

    public SearchResultsPage search(String searchTerm) {
        // find the search field and search for `searchTerm`
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='searchTerm']"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);
        // lands on the search results page
        return new SearchResultsPage(driver);
    }

    public void selectMPNSearch() {
        WebElement MPNtoggle = driver.findElement(By.xpath("//span[@data-qa='searchMPNToggle_graphic']"));
        System.out.println(MPNtoggle.isSelected());
        if (!MPNtoggle.isSelected()) MPNtoggle.click();
        System.out.println(MPNtoggle.isSelected());
    }

    public ProductPage searchMPN(String MPN) {
        // [NOTE] lands on a different page than the `search` method but the two could be merged
        // switch on MPN search
        selectMPNSearch();
        // find the search field and search for the specific `MPN`
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='searchTerm']"));
        searchBox.sendKeys(MPN);
        searchBox.sendKeys(Keys.RETURN);
        // lands on the product page
        return new ProductPage(driver);
    }
}
