package com.rstest.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterMenu extends PageObject{

    public FilterMenu(WebDriver driver){
        super(driver);
    }
    public int selectFilter(String filter, String filterValue1, String filterValue2){
        // Filter Menu

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement weAccordion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+filter+"')]/ancestor::div[@role='button']")));
        weAccordion.click();

        try{Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Alert alertCancel = driver.switchTo().alert();
            alertCancel.dismiss();
        }
        // WebElement weRange1Valuetest = driver.findElement(By.xpath("//select[@data-qa='range-from']"));
        //System.out.println(weRange1Valuetest);
        //WebElement optionTest = weRange1Valuetest.findElement(By.xpath("/option[contains(@value, '4294749301')]"));

        //  System.out.println(optionTest.getAttribute("Value"));

        String weRange1Value = driver.findElement(By.xpath("//select[@data-qa='range-to']/option[text()='"+filterValue1.trim()+"']")).getAttribute("Value");;
        WebElement weFilterValue1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa='fa_"+weRange1Value.trim()+"']")));
        weFilterValue1.click();

        String weRange2Value = driver.findElement(By.xpath("//select[@data-qa='range-to']/option[text()='"+filterValue2+"']")).getAttribute("Value");;

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-qa='fa_"+weRange2Value+"']"))).click();

        WebElement applyFilterBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='apply-filters-button']")));
        applyFilterBtn.click();

        String numOfProductsStr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa='filter-product-amount']"))).getText();
        int numOfProducts = Integer.parseInt(numOfProductsStr.substring(0, numOfProductsStr.indexOf(" ")));
        System.out.println("I parsed "+ numOfProducts);
        return numOfProducts;


    }



}
