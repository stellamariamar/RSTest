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

    public void activateMPNSearch() {
        // toggle search by MPN on
        WebElement MPNtoggle = driver.findElement(By.xpath("//span[@data-qa='searchMPNToggle_graphic']"));
        if (!MPNtoggle.isSelected()) MPNtoggle.click();
    }

    public void submitSearchTerm(String searchTerm) {
        // find the search field and submit the `searchTerm`
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='searchTerm']"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);
    }

    public SearchResultsPage searchForTerm(String searchTerm) {
        submitSearchTerm(searchTerm);
        // lands on the search results page
        // Todo: In some occasions where the term is very specific (or an MPN), the result will be
        //    a product page, so a more refined test is required here before returning
        return new SearchResultsPage(driver);
    }

    public ProductPage searchForMPN(String MPN) {
        // [NOTE] separate from the `search` method because it lands on a different page but the two could be merged
        activateMPNSearch();
        submitSearchTerm(MPN);
        // lands on the product page
        // Todo: It would appear that dashes are stripped from MPNs when matching, so there are rare occasions where
        //      a search for an MPN will counterintuitively match multiple products and return a search results page,
        //      so a more refined test is required here before returning
        return new ProductPage(driver);
    }
}
