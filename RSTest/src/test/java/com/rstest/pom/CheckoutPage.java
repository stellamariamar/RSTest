package com.rstest.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class CheckoutPage extends PageObject {


    public CheckoutPage(WebDriver driver) {

        super(driver);
    }

    public void enterDeliveryDetails(Map<String, String> details) {

       Select title = new Select(driver.findElement(By.xpath("//select[@data-testid='input-title']")));
       title.selectByVisibleText(details.get("Title"));
       driver.findElement(By.xpath("//input[@data-testid='input-firstName']")).sendKeys(details.get("Name"));
       driver.findElement(By.xpath("//input[@data-testid='input-lastName']")).sendKeys(details.get("Surname"));
       driver.findElement(By.xpath("//input[@data-testid='input-emailAddress']")).sendKeys(details.get("Email"));
       driver.findElement(By.xpath("//input[@data-testid='input-companyName']")).sendKeys(details.get("Surname"));
       driver.findElement(By.xpath("//input[@data-testid='input-addressLine1']")).sendKeys(details.get("Address"));
       driver.findElement(By.xpath("//input[@data-testid='input-addressLine3']")).sendKeys(details.get("Town"));
       driver.findElement(By.xpath("//input[@data-testid='input-postalCode']")).sendKeys(details.get("Postcode"));

    }

    public void submit(){
        driver.findElement(By.xpath("//form[@data-testid='delivery-details-form']")).submit();
    }

    public boolean confirmPaymentIsEnabled(){
        try {
            driver.findElement(By.xpath("//div[@data-testid='address-summary-delivery']"));
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}