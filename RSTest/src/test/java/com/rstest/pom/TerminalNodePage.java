package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class TerminalNodePage extends PageSearchObject {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    public TerminalNodePage(WebDriver driver) {
        super(driver);
    }

    public void setFilterValues(String filter, List<String> values) {

        WebElement weFilterTitle  = driver.findElement(
                By.xpath(
                        String.format(
                                "//div[@data-testid='styled-accordion']//span[text()='%s']",
                                filter
                        )
                )
        );
        weFilterTitle.click();
        WebElement weFilter = driver.findElement(
                By.xpath(
                        String.format(
                                "//div[@data-testid='styled-accordion']//span[text()='%s']/ancestor::div[@data-testid='styled-accordion']",
                                filter
                        )
                )
        );

        for (int val = 0; val < values.size(); val++) {
            WebElement weFilterValue = driver.findElement(
                    By.xpath(
                            String.format(
                                    ".//p[contains(text(),'%s')]",
                                    values.get(val)
                            )
                    )
            );

            // If the value is further down the list getting an ElementOutOfBounds exception
           // org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: move target out of bounds
            actions.moveToElement(weFilterValue).build().perform();
            weFilterValue.click();
            try{Thread.sleep(2000);}catch(InterruptedException e){}
        }


    }
    public void applyFilter() {
        WebElement applyFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//button[@data-qa='apply-filters-button']"
                )
        ));
        //applyFilterBtn.click();
        actions.moveToElement(applyFilterBtn).click().build().perform();
    }

    public int getNumberOfResults() {
        String numOfProductsStr = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//div[@data-qa='filter-product-amount']")
                        )
                ).getText();
        return Integer.parseInt(numOfProductsStr.substring(0, numOfProductsStr.indexOf(" ")));
    }

    public void sortBy(String sortOption, String sortType){
        WebElement sortHeadingDiv = driver.findElement(By.xpath(
            "//div[@data-qa='table-container-header']"
            )
        );
        System.out.println("Parent Div Text: "+ sortHeadingDiv.getText());
        String th_selector;
        if (sortOption.equals("Price")) {
            th_selector = "@data-qa='terminal-node-product-price-header'";
        } else {
            th_selector = "@class='attribute-header'";
        }
        WebElement weSortAttr = sortHeadingDiv.findElement(
                By.xpath(
                        String.format(".//div[text()='%s']//ancestor::th[%s]", sortOption, th_selector)
                )
        );
        System.out.println("weSortAttr : "+ weSortAttr.getText());

        WebElement sortBtn = weSortAttr.findElement(
                By.xpath(String.format(
                        ".//../following-sibling::div/div[contains(@data-qa,'_%s')]", sortType.trim()
                ))
        );
        System.out.println("sortBtn : "+ sortBtn.getAttribute("data-qa"));
        sortBtn.click();


        //actions.moveToElement(applyFilterBtn).click().build().perform();
    }

    public void addTopToBasket(){
        WebElement weIncreaseBtn = driver.findElement(By.xpath("//button[@data-testid='increase-button']"));
        WebElement weAddToBasket = driver.findElement(By.xpath("//button[@data-qa='product-tile-addtocart-button']"));
        weIncreaseBtn.click();
        weAddToBasket.click();

    }

}

