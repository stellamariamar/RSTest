package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class L2CategoryPage extends PageSearchObject {
    // a level-2 category page is just above the final "sub-category" or "terminal node" page
    // fundamentally, it contains a grid of sub-categories

    public L2CategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean confirm() {
        // confirm that this is indeed a level-2 category page
        try {
            driver.findElement(
                    By.xpath("//div[@test-datalevel='level-2'][@data-testid='category-page']")
            );
            return true;
        } catch(NullPointerException e) {
            return false;
        }
    }
}
