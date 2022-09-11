package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasketPage extends PageSearchObject {

    public BasketPage(WebDriver driver) {
        super(driver);
        driver.get("https://uk.rs-online.com/basket");
    }

    public CheckoutPage checkout() {
        WebElement guestCheckoutBtn = driver.findElement(
                By.xpath("//button[@data-testid='checkoutButton']")
        );
        guestCheckoutBtn.click();
        // lands on the checkout page
        return new CheckoutPage(driver);
    }

    public void emptyBasket() {
        int numBtns = driver.findElements(By.xpath("//button[@data-testid='removeProduct']")).size();
        for (int i = 0; i < numBtns; i++) {
            WebElement removeProductBtn = driver.findElement(
                    By.xpath("//button[@data-testid='removeProduct']")
            );
            removeProductBtn.isDisplayed();
            removeProductBtn.click();
        }
    }
}
