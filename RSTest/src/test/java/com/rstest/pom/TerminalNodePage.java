package com.rstest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class TerminalNodePage extends PageSearchObject {
    // The "terminal node" page is a low-level page that contains a set of products, grouped together under a
    // sub-category of products with similar features.
    // - The user can further refine the set of products by applying filters, i.e. selecting specific values for
    //   attributes that are specific to the products in this sub-category
    // - The user can sort the set of products, ordering them according to price or other attributes that are
    //   specific to the products in this sub-category
    //
    // This sort of page is (supposedly) called a "terminal node" because this is where the user will eventually
    // land when searching for products, regardless of the journey they have followed (searching, browsing, etc.)

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    public TerminalNodePage(WebDriver driver) {
        super(driver);
    }

    public boolean confirm() {
        // confirm that this is indeed a terminal node page
        try {
            driver.findElement(
                    By.xpath("//div[@data-qa='terminal-node-page']")
            );
            return true;
        } catch(NullPointerException e) {
            return false;
        }
    }

    public void setFilterValues(String filter, List<String> values) {
        // find a specific attribute
        WebElement weFilterTitle  = driver.findElement(
                By.xpath(
                        String.format(
                                "//div[@data-testid='styled-accordion']//span[text()='%s']",
                                filter
                        )
                )
        );
        weFilterTitle.click();
        // find its accordion ancestor, i.e. the filter for that specific attribute
        WebElement weFilter = weFilterTitle.findElement(
                By.xpath("./ancestor::div[@data-testid='styled-accordion']")
        );


        // select the values for the filter attribute
        for (int val = 0; val < values.size(); val++) {
            WebElement weFilterValue = weFilter.findElement(
                    By.xpath(
                            String.format(".//p[contains(text(),'%s')]", values.get(val))
                    )
            );
            // if the value is further down the list getting an ElementOutOfBounds exception
            // org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: move target out of bounds
            actions.moveToElement(weFilterValue).build().perform();
            weFilterValue.click();

        }

    }
    public void applyFilter() {
        WebElement applyFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//button[@data-qa='apply-filters-button']"
                )
        ));
        actions.moveToElement(applyFilterBtn).click().build().perform();
        waitForTableUpdate();
    }

    public int getTotalNumberOfResults() {
        String numOfProductsStr = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//div[@data-qa='filter-product-amount']")
                        )
                ).getText();
        return Integer.parseInt(numOfProductsStr.substring(0, numOfProductsStr.indexOf(" ")));
    }

    public int getNumberOfResultsOnPage() {
        WebElement resultsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//div[@data-testid='results-table']")
                )
        );
        return resultsTable.findElements(By.xpath(".//button[@data-qa='product-tile-addtocart-button']")).size();
    }

    public void sortBy(String sortOption, String sortType){
        WebElement sortHeadingDiv = driver.findElement(By.xpath(
            "//div[@data-qa='table-container-header']"
            )
        );
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

        WebElement sortBtn = weSortAttr.findElement(
                By.xpath(String.format(
                        ".//../following-sibling::div/div[contains(@data-qa,'_%s')]", sortType.trim()
                ))
        );
        sortBtn.click();
        waitForTableUpdate();
    }

    public void addTopItemToBasket(){
        //WebElement weIncreaseBtn = driver.findElement(By.xpath("//div[@data-testid='results-table']//button[@data-testid='increase-button']"));
        //weIncreaseBtn.click();
        WebElement weAddToBasket = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//div[@data-testid='results-table']//tr//button[@data-qa='product-tile-addtocart-button']"
                ))
        );
        weAddToBasket.click();
        driver.navigate().refresh();

    }

    public void setNumOfResultsPerPage(String numStr){
        Select weSelProdPerPage = new Select(driver.findElement(
                By.xpath("//select[@data-qa='rpp1-select']")
        ));
        weSelProdPerPage.selectByVisibleText(numStr);
        waitForTableUpdate();
    }

    public void waitForTableUpdate(){
        // Wait for results table to be updated
        WebElement visibleResults = wait.until(ExpectedConditions.elementToBeClickable(
               By.xpath("//div[@data-testid='results-table']")
        ));
        // try{Thread.sleep(3000);}catch(InterruptedException e){};
    }

}

