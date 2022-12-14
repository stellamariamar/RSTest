package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CheckoutPage extends PageObject {
    // the page where the user enters their delivery and payment details, in order to check out

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterDeliveryDetails(Map<String, String> details) {
        // TODO: Probably best to break these down per field in a "real" POM
        WebElement wel = driver.findElement(By.xpath("//input[@data-testid='input-firstName']"));
        System.out.println(wel.getText());
        Select title = new Select(driver.findElement(
               By.xpath("//select[@data-testid='input-title']")
        ));
        title.selectByVisibleText(details.get("Title"));
        driver.findElement(By.xpath("//input[@data-testid='input-firstName']"))
                .sendKeys(details.get("Name"));
        driver.findElement(By.xpath("//input[@data-testid='input-lastName']"))
                .sendKeys(details.get("Surname"));
        driver.findElement(By.xpath("//input[@data-testid='input-emailAddress']"))
                .sendKeys(details.get("Email"));
        driver.findElement(By.xpath("//input[@data-testid='input-companyName']"))
                .sendKeys(details.get("Surname"));
        driver.findElement(By.xpath("//input[@data-testid='input-addressLine1']"))
                .sendKeys(details.get("Address"));
        driver.findElement(By.xpath("//input[@data-testid='input-addressLine3']"))
                .sendKeys(details.get("Town"));
        driver.findElement(By.xpath("//input[@data-testid='input-postalCode']"))
                .sendKeys(details.get("Postcode"));
    }

    public void submitDeliveryDetails(){
        driver.findElement(
                By.xpath("//form[@data-testid='delivery-details-form']")
        ).submit();
    }

    public boolean confirmPaymentIsEnabled() {
        // check if the page is in a state where payment details are required
        try {
            // an address summary only appears after the delivery details have successfully been entered
            // and payment details are required
            driver.findElement(By.xpath("//div[@data-testid='address-summary-delivery']"));
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }

}