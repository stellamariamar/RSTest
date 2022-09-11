package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


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

    public void addToCart(int quantity) {
        System.out.println(quantity);

        WebElement weAddToBasket = driver.findElement(By.xpath("//div[@data-testid='desktop']//button[@data-testid='add-to-basket-button']/span"));
        WebElement weIncreaseBtn = driver.findElement(By.xpath("//div[@data-testid='desktop']//button[@data-testid='increase-button']"));
        WebElement weQuanInput = driver.findElement(By.xpath("//div[@data-testid='desktop']//input[@id='quantity-input']"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript(String.format("arguments[0].setAttribute('value', '%d');", quantity), weQuanInput);
        executor.executeScript("arguments[0].setAttribute('value', '3');", weQuanInput);
       // weIncreaseBtn.click();
       // weIncreaseBtn.click();
       //
        weAddToBasket.click();


        try { Thread.sleep(5000);} catch (InterruptedException e) {}

        //executor.executeScript("arguments[0].click()", weAddToBasket);
    }
}