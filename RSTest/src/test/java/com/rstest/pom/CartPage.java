package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.rstest.bdd.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;
    public class CartPage extends PageObject {


        public CartPage(WebDriver driver) {

            super(driver);
        }

        public void viewBasket() {
            driver.get("https://uk.rs-online.com/basket");
        }

        public void setQuantity(String productStockNo, int quantity) {

            WebElement resultsTable = driver.findElement(By.xpath("//div[@data-testid='results-table']"));
            WebElement productRow = resultsTable.findElements(By.tagName("tr")).get(0);

        }

        public void quantityIncrease(String productStockNo) {

            String productStockNoTrimmed = productStockNo.substring(0, 3) + productStockNo.substring(4, productStockNo.length());
            System.out.println(productStockNoTrimmed);
            WebElement increaseBtn = driver.findElement(By.xpath("//button[@data-testid='quantityIncrease']/ancestor::div[@data-testid='Product--" + productStockNoTrimmed + "']"));
            driver.findElement(By.xpath("//div[@data-testid='Product--" + productStockNoTrimmed + "']")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println(increaseBtn.getAttribute("data-testid"));

            System.out.println(increaseBtn.isEnabled());
            increaseBtn.click();
            Actions builder = new Actions(driver);
            builder.moveToElement(increaseBtn).click(increaseBtn);
            builder.perform();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

        }

        public void removeItemsFromCart(String product) {
            //  WebElement resultsTable = driver.findElement(By.xpath("//div[@data-testid='results-table']"));
            // WebElement productRow = resultsTable.findElements(By.tagName("tr")).get(0);

            //Sort results by price Asc
            //  productRow.findElement(By.xpath("//div[@data-qa='P_breakPrice1_ASC']")).click();

            // WebElement decreaseBtn = productRow.findElement(By.xpath("//button[@data-testid='decrease-button']"));
            // WebElement increaseBtn = productRow.findElement(By.xpath("//button[@data-testid='increase-button']"));
            // WebElement addBasketBtn = productRow.findElement(By.xpath("//button[@data-qa='product-tile-addtocart-button']"));
        }

        public CheckoutPage checkout() {
            WebElement guestCheckoutBtn = driver.findElement(By.xpath("//button[@data-testid='checkoutButton']"));
            guestCheckoutBtn.click();
            return new CheckoutPage(driver);

        }
    }
