package com.rstest.pom;


import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends PageObject{

    public SearchPage(WebDriver driver){
        super(driver);
    }

    public void enterSearchTerm(String searchTerm) {
        // Search page
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='searchTerm']"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void selectCategory(String category){
        // Category page
        System.out.println(category);
        WebElement weCategory  = driver.findElement(By.xpath("//*[@data-qa='primary'][contains(text(),'"+category+"')]//ancestor::a"));
        weCategory.click();

    }
    public int selectFilter(String filter, String filterValue1, String filterValue2){
        // Filter page

          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
          WebElement weAccordion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+filter+"')]/ancestor::div[@role='button']")));
          weAccordion.click();

        try{Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Alert alertCancel = driver.switchTo().alert();
            alertCancel.dismiss();
        }
        String weRange1Value = driver.findElement(By.xpath("//select[@data-qa='range-to']/option[text()='"+filterValue1.trim()+"']")).getAttribute("Value");;
        WebElement weFilterValue1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa='fa_"+weRange1Value.trim()+"']")));
        System.out.println(weRange1Value.trim()+ " against "+ weFilterValue1.getText());
        weFilterValue1.click();


        try{Thread.sleep(4000);
        }
        catch(InterruptedException e){
            Alert alertCancel = driver.switchTo().alert();
            alertCancel.dismiss();
        }
          String weRange2Value = driver.findElement(By.xpath("//select[@data-qa='range-to']/option[text()='"+filterValue2+"']")).getAttribute("Value");;
        try{Thread.sleep(3000);
        }
        catch(InterruptedException e){
            Alert alertCancel = driver.switchTo().alert();
            alertCancel.dismiss();
        }
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-qa='fa_"+weRange2Value+"']"))).click();

          WebElement applyFilterBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='apply-filters-button']")));
          applyFilterBtn.click();
         try{Thread.sleep(4000);
        }
        catch(InterruptedException e){
            Alert alertCancel = driver.switchTo().alert();
            alertCancel.dismiss();
        }
          String numOfProductsStr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa='filter-product-amount']"))).getText();
          int numOfProducts = Integer.parseInt(numOfProductsStr.substring(0, numOfProductsStr.indexOf(" ")));
          return numOfProducts;


    }



}
