package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageSearchObject {

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://uk.rs-online.com/web/");
        //deleteStorage();  // unsure if this is effective
        manageCookies();
    }

    public void clickBrowse() {
        driver.findElement(By.xpath("//div[@data-qa='browse']")).click();
    }

    public void selectBrowseCategory(String category, int level) {
        // in the browse menu, select a specific `category`, in a specific `level`
        // (categories are in layered in levels 0, 1 and 2, from more general to more specific)
        WebElement weCategory  = driver.findElement(
            By.xpath(
                String.format(
                    "//li[contains(@data-qa,'l%d')]//*[text()='%s']",
                    level, category
                )
            )
        );
        weCategory.click();
    }

    public L2CategoryPage browse(String l0Category, String l1Category, String l2Category) {
        // browse to a specific `l2Category` page, going through its `l0Category` and `l1Category` ancestors
        clickBrowse();
        selectBrowseCategory(l0Category, 0);
        selectBrowseCategory(l1Category, 1);
        selectBrowseCategory(l2Category, 2);
        // lands on the requested level-2 category page
        return new L2CategoryPage(driver);
    }
}
