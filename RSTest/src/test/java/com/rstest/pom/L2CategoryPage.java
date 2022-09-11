package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class L2CategoryPage extends PageSearchObject {

    public L2CategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean confirm() {
        try {
            driver.findElement(By.xpath("//div[@test-datalevel='level-2'][@data-testid='category-page']"));
            return true;
        } catch(NullPointerException e) {
            return false;
        }
    }
}
