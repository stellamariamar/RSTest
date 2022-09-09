package com.rstest.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends PageObject {


    public CheckoutPage(WebDriver driver) {

        super(driver);
    }

    public void enterDeliveryDetails(String name, String surname, String email, String address, String town, String postcode) {

       Select title = new Select(driver.findElement(By.xpath("//select[@data-testid='input-title']")));
       title.selectByIndex(1);
       driver.findElement(By.xpath("//input[@data-testid='input-firstName']")).sendKeys(name);
       driver.findElement(By.xpath("//input[@data-testid='input-lastName']")).sendKeys(surname);
       driver.findElement(By.xpath("//input[@data-testid='input-emailAddress']")).sendKeys(email);
       driver.findElement(By.xpath("//input[@data-testid='input-companyName']")).sendKeys(name +" " +surname);
       driver.findElement(By.xpath("//input[@data-testid='input-addressLine1']")).sendKeys(address);
       driver.findElement(By.xpath("//input[@data-testid='input-addressLine3']")).sendKeys(town);
       driver.findElement(By.xpath("//input[@data-testid='input-postalCode']")).sendKeys(postcode);

       driver.findElement(By.xpath("//form[@data-testid='delivery-details-form']")).submit();
    }
}