package com.rstest.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultsPage extends PageObject {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    //[contains(text(),'"+searchTerm+"')]
    public int getNumMatchingProducts(String searchTerm) {
        int numMatchingProducts = driver.findElements(By.xpath("//div[@data-qa='product-tile-title']")).size();
        System.out.println(numMatchingProducts);
        return numMatchingProducts;
    }

    public int getNumOfSearchResults() {
        String numOfSearchResultsStr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-qa='filter-product-amount']"))).getText();
        int numOfSearchResults = Integer.parseInt(numOfSearchResultsStr.substring(0, numOfSearchResultsStr.indexOf(" ")));
        System.out.println(numOfSearchResults);
        return numOfSearchResults;
    }
/*
    puclic boolean inCategoryPage(){
        try {
            WebElement resultsTable = driver.findElement(By.xpath("//div[@data-testid='results-table']"));
            return false;
        } catch(NullPointerException){
            return true;
        }
    }

 */
    //  public String addToCart(){
/*
        if (inCategoryPage()){

            // If we the search results are presented in a Table we can catch the first row and get an element
            WebElement resultsTable = driver.findElement(By.xpath("//div[@data-testid='results-table']"));
            WebElement productRow = resultsTable.findElements(By.tagName("tr")).get(0);

            // Sort results by price Asc
            productRow.findElement(By.xpath("//div[@data-qa='P_breakPrice1_ASC']")).click();
            // Decrease button
            WebElement decreaseBtn = productRow.findElement(By.xpath("//button[@data-testid='decrease-button']"));
            // Increase button
            WebElement increaseBtn = productRow.findElement(By.xpath("//button[@data-testid='increase-button']"));
            increaseBtn.click();
            // Add tp basket
            WebElement addBasketBtn = productRow.findElement(By.xpath("//button[@data-qa='product-tile-addtocart-button']"));
            addBasketBtn.click();

            WebElement viewBasketBtn = productRow.findElement(By.xpath("//a[@data-qa='header-running-total-basket']"));
            String stockNo = (productRow.findElement(By.xpath("//div[@data-qa='product-tile-partno-value']"))).getText();
            System.out.println("Stock Number for added item is " + stockNo);
            viewBasketBtn.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return stockNo;

        } catch (NoSuchElementException e) {

            //The search results are shown in a grid
            WebElement results1Grid = driver.findElement(By.xpath("//div[@data-qa='product-tile']"));
            WebElement addBasketBtn = results1Grid.findElement(By.xpath("//button[@data-qa='add-to-basket-btn']"));
            addBasketBtn.click();
            return "";
        }*/
    // WebElement productLink = productRow.findElement(By.xpath("//a[@data-qa='product-tile-container']"));
    // productLink.click();

    // ProductPage
    // WebElement decreaseBtn = driver.findElement(By.xpath("//button[@data-testid='decrease-button']/ancestor::div[@data-testid='desktop']"));
    // WebElement increaseBtn = driver.findElement(By.xpath("//button[@data-testid='increase-button']/ancestor::div[@data-testid='desktop']"));
    //WebElement addBasketBtn = driver.findElement(By.xpath("//button[@data-testid='add-to-basket-button']/ancestor::div[@data-testid='desktop']"));


}