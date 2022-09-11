package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchResultsPage extends PageSearchObject {
    // The page the user sees after performing a search for a specific term

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean confirm() {
        try {
            driver.findElement(By.id("search-results"));
            return true;
        } catch(NullPointerException e) {
            return false;
        }
    }

    public TerminalNodePage selectSubCategory(String subCategory, String category) {
        // Find the Category
        WebElement weCategory = driver.findElement(
                By.xpath(
                        String.format(
                                "//span[@data-qa='primary' and text()='%s']/ancestor::div[@data-qa='level-two-category']",
                                category
                        )
                )
        );

        try {
            // Find the sub-Category within the Category
            WebElement weSubCategory = weCategory.findElement(
                    By.xpath(
                            String.format(
                                    ".//li//span[@data-qa='primary' and text()='%s']",
                                    subCategory
                            )
                    )
            );
            weSubCategory.click();

        } catch(NoSuchElementException e) {
            // If the sub Category is not present, click on 'See more' and try again
            WebElement weSeeMore = weCategory.findElement(
                    By.xpath(".//a[text()='See more']")
            );
            weSeeMore.click();
            WebElement weSubCategory = weCategory.findElement(
                    By.xpath(
                            String.format(
                                    ".//li//span[@data-qa='primary' and text()='%s']",
                                    subCategory
                            )
                    )
            );
            weSubCategory.click();
        }
        return new TerminalNodePage(driver);
    }

    public TerminalNodePage selectPopCategory(String popCategory) {
        // Find the Popular Category
        WebElement wePopCategory = driver.findElement(
                By.xpath(
                        String.format(
                              "//div[contains(@class,'top-categories-container')]//a[@data-qa='top-category']//span[text()='%s']",
                                popCategory
                        )
                )
        );
        wePopCategory.click();
        return new TerminalNodePage(driver);
    }

}
