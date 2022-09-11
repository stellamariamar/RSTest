package com.rstest.bdd;
import com.rstest.pom.BasketPage;
import com.rstest.pom.HomePage;
import com.rstest.pom.SearchResultsPage;
import static com.rstest.bdd.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

import com.rstest.pom.TerminalNodePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class basketFromFilterPageTest {


    public HomePage home;
    public SearchResultsPage results;
    public TerminalNodePage terminal;


    @Given("I am viewing the products in {string} under {string} for the search term {string}")
    public void i_am_viewing_the_products_in_under_for_the_search_term(String subCategory, String category, String searchTerm) {
        home = new HomePage(driver);
        results = home.search(searchTerm);
        terminal =  results.selectSubCategory(subCategory, category);
    }

    @When("I sort by {string}, {string}")
    public void i_sort_by(String sortBy, String sortType) {
        terminal.sortBy(sortBy, sortType);
        terminal.addTopToBasket();
        try{Thread.sleep(5000);}catch(InterruptedException e){}
    }
    @Then("I can add the top product in my basket")
    public void i_can_add_the_top_product_in_my_basket() {
        terminal.addTopToBasket();
        BasketPage basket = new BasketPage(driver);
        basket.emptyBasket();
        try{Thread.sleep(5000);}catch(InterruptedException e){}
    }


}
