package com.rstest.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultsPage extends PageObject{

    public ResultsPage(WebDriver driver){
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //[contains(text(),'"+searchTerm+"')]
    public int getNumMatchingProducts(String searchTerm) {
        int numMatchingProducts  = driver.findElements(By.xpath("//div[@data-qa='product-tile-title']")).size();
        System.out.println(numMatchingProducts);
        return numMatchingProducts;
    }

    public int getNumOfSearchResults() {
        String numOfSearchResultsStr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-qa='filter-product-amount']"))).getText();
        int  numOfSearchResults = Integer.parseInt(numOfSearchResultsStr.substring(0, numOfSearchResultsStr.indexOf(" ")));
        System.out.println(numOfSearchResults);
        return numOfSearchResults;
    }

    public void addToCart(){
        WebElement resultsTable = driver.findElement(By.xpath("//div[@data-testid='results-table']"));
        WebElement productRow = resultsTable.findElements(By.tagName("tr")).get(0);

        // WebElement decreaseBtn = productRow.findElement(By.xpath("//button[@data-testid='decrease-button']"));
        // WebElement increaseBtn = productRow.findElement(By.xpath("//button[@data-testid='increase-button']"));
        // WebElement addBasketBtn = productRow.findElement(By.xpath("//button[@data-qa='product-tile-addtocart-button']"));

        WebElement productLink = productRow.findElement(By.xpath("//a[@data-qa='product-tile-container']"));
        productLink.click();

        // ProductPage
        WebElement decreaseBtn = driver.findElement(By.xpath("//button[@data-testid='decrease-button']/ancestor::div[@data-testid='desktop']"));
        WebElement increaseBtn = driver.findElement(By.xpath("//button[@data-testid='increase-button']/ancestor::div[@data-testid='desktop']"));
        WebElement addBasketBtn = driver.findElement(By.xpath("//button[@data-testid='add-to-basket-button']/ancestor::div[@data-testid='desktop']"));

        System.out.println("posa koumpia exw "+ driver.findElements(By.xpath("//button[@data-testid='increase-button']/ancestor::div[@data-testid='desktop']")).size());

        decreaseBtn.click();
        increaseBtn.click();
        increaseBtn.click();
        increaseBtn.click();
        addBasketBtn.click();
        try{Thread.sleep(4000);
        }
        catch(InterruptedException e){
            Alert alertCancel = driver.switchTo().alert();
            alertCancel.dismiss();
        }
        decreaseBtn.click();

    }
}

