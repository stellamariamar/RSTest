package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageSearchObject {

    public HomePage(WebDriver driver) {
        super(driver);
        deleteStorage();
        driver.get("https://uk.rs-online.com/web/");
        manageCookies();
    }

    public void clickBrowse() {
        driver.findElement(By.xpath("//div[@data-qa='browse']")).click();
    }

    public void selectCategory(String category, int level) {
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
        clickBrowse();
        selectCategory(l0Category, 0);
        selectCategory(l1Category, 1);
        selectCategory(l2Category, 2);

        return new L2CategoryPage(driver);
    }
}
