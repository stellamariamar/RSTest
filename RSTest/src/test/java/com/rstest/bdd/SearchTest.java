package com.rstest.bdd;


import com.rstest.pom.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.time.Duration;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static com.rstest.bdd.DriverManager.driver;

public class SearchTest {

    public static SearchPage searchPage;
    int numProd = 0;

    @Given("I have entered {string} in the search field")
    public void i_have_entered_in_the_search_field(String searchTerm) {

        /*
        // temporary: remove and uncomment importing the driver
        ChromeOptions chromeoptions = new ChromeOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        chromeoptions.addArguments("start-maximized");
        chromeoptions.addArguments("enable-popup-blocking");
        chromeoptions.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        caps.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
        driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
         */

        searchPage.visitHomePage();
        searchPage = new SearchPage(driver);
        try {
            searchPage.manageCookies();
        } catch(ElementNotInteractableException e){}
        searchPage.enterSearchTerm(searchTerm);
    }

    @And("I have selected the category {string}")
    public void iHaveSelectedTheCategory(String category) {
        try {
            searchPage.manageCookies();
        } catch(ElementNotInteractableException e){}
        searchPage.selectCategory(category);
    }

    @When("I select values for the {string},  {string} and {string}")
    public int i_select_values_for_the_and(String filter, String filterValue1, String filterValue2) {
        try {
            searchPage.manageCookies();
        } catch(ElementNotInteractableException e){}
        numProd = searchPage.selectFilter(filter, filterValue1, filterValue2);
        return numProd;
    }


    @Then("I should see {int} products in the Results")
    public void iShouldSeeProductsInTheResults(int num) {
        assertThat(numProd).isEqualTo(num);
    }


}
