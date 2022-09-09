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
    public static FilterMenu filterMenu;
    int numProd = 0;


    @Given("The user enters a {string} in the search field")
    public void the_user_enters_a_in_the_search_field(String searchTerm) {

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
        searchPage = new SearchPage(driver);
        searchPage.visitHomePage();

        try {
            searchPage.manageCookies();
        } catch(ElementNotInteractableException e){}
        searchPage.enterSearchTerm(searchTerm);
    }


    @Given("The user selects the category {string}")
    public void the_user_selects_the_category(String category) {
        try {
            searchPage.manageCookies();
        } catch(ElementNotInteractableException e){}
        searchPage.selectCategory(category);
    }

    @When("The user selects {string} and {string} for the filter {string}")
    public int the_user_selects_and_for_the_filter(String filterValue1, String filterValue2, String filter) {
        try {
            searchPage.manageCookies();
        } catch(ElementNotInteractableException e){}
        filterMenu = new FilterMenu(driver);
        numProd = filterMenu.selectFilter(filter, filterValue1, filterValue2);
        return numProd;
    }


    @Then("The user should see {int} products in the Results")
    public void the_user_should_see_products_in_the_results(Integer num) {
       // assertThat(numProd).isEqualTo(num);
    }


}
