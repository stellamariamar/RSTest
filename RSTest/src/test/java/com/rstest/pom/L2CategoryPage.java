package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public TerminalNodePage selectSubCategory(String subCategory){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement weSubCategory = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format(
                        "//div[@data-testid='category-grid-section']//div[@data-testid='subcategory-title'][text()='%s']", subCategory
                ))
        ));
        weSubCategory.click();
        return new TerminalNodePage(driver);
    }

}
