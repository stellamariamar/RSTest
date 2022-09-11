package com.rstest.bdd;
import com.rstest.pom.BasketPage;
import com.rstest.pom.HomePage;
import com.rstest.pom.SearchResultsPage;
import com.rstest.pom.CheckoutPage;
import static com.rstest.config.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

import com.rstest.pom.TerminalNodePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;


public class basketFromFilterPageTest {


    public HomePage home;
    public SearchResultsPage results;
    public TerminalNodePage terminal;



    @Given("I am viewing the products in {string} under {string} for the search term {string}")
    public void i_am_viewing_the_products_in_under_for_the_search_term(String subCategory, String category, String searchTerm) {
        home = new HomePage(driver);
        results = home.searchForTerm(searchTerm);
        terminal =  results.selectSubCategory(subCategory, category);
    }

    @When("I sort by {string}, {string}")
    public void i_sort_by(String sortBy, String sortType) {
        try{Thread.sleep(5000);}catch(InterruptedException e){}
        terminal.sortBy(sortBy, sortType);
    }

    @Then("I can buy the top product in the sorted results entering my details")
    public void iCanBuyTheTopProductInTheSortedResultsEnteringMyDetails(Map<String, String> details)  {
        terminal.addTopItemToBasket();
        BasketPage basket = new BasketPage(driver);
        driver.navigate().refresh();
        CheckoutPage checkoutPage = basket.checkout();
        // basket.emptyBasket();
        try{Thread.sleep(5000);}catch(InterruptedException e){}
        checkoutPage.enterDeliveryDetails(details);
        try { Thread.sleep(5000);} catch (InterruptedException e) {}
        checkoutPage.submitDeliveryDetails();

    }

    @Given("I have sorted the results by {string}, {string}")
    public void i_have_sorted_the_results_by(String string, String string2) {

    }

    @When("I add the top product to the basket")
    public void i_add_the_top_product_to_the_basket() {
    }

    @Then("I can proceed to checkout and enter my delivery details")
    public void i_can_proceed_to_checkout_and_enter_my_delivery_details(io.cucumber.datatable.DataTable dataTable) {

    }
}
