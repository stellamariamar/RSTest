package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage extends PageSearchObject {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean confirm() {
        try {
            driver.findElement(By.xpath("//h1[@data-testid='long-description']"));
            return true;
        } catch(NullPointerException e) {
            return false;
        }
    }

    public void setQuantity(Integer quantity) {
        // locate quantity field
        WebElement weQuanInput = driver.findElement(By.xpath("//div[@data-testid='desktop']//input[@id='quantity-input']"));
        // enter quantity
        weQuanInput.click();
        weQuanInput.clear();
        weQuanInput.sendKeys(quantity.toString());
    }

    public void addToBasket() {
        // locate button
        WebElement weAddToBasket = driver.findElement(
                By.xpath("//div[@data-testid='desktop']//button[@data-testid='add-to-basket-button']/span")
        );
        // add to basket
        weAddToBasket.click();
    }
}