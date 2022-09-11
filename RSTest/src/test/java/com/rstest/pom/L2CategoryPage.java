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

    /*
    A more complete POM would include a method for selecting one of the sub-categories in the grid,
    but our current tests don't require this functionality. It looks like most user journeys aim to
    take the user to terminal node pages as quickly as possible, so the user would most likely have
    to use the breadcrumbs to navigate to a level-2 category page.
    */
}
