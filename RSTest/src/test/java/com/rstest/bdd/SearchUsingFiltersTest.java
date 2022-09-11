package com.rstest.bdd;
import com.rstest.pom.HomePage;
import com.rstest.pom.SearchResultsPage;
import static com.rstest.bdd.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

import com.rstest.pom.TerminalNodePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;

public class SearchUsingFiltersTest {

    public HomePage home;
    public SearchResultsPage results;
    public TerminalNodePage terminal;
    public int beforeFilter;

    @Given("I search for a product using the search term {string}")
    public void i_search_for_a_product_using_the_search_term(String searchTerm) {
        home = new HomePage(driver);
        results = home.search(searchTerm);
    }


    @Given("I select the sub category {string} under {string}")
    public void i_select_the_sub_category_under(String subCategory, String category) {
        terminal =  results.selectSubCategory(subCategory, category);
    }
    @When("I apply {string} and {string} for the filter {string}")
    public void i_apply_and_for_the_filter(String value1, String value2, String filter) {
        beforeFilter = terminal.getNumberOfResults();
        terminal.setFilterValues(filter, List.of(value1, value2));
        terminal.applyFilter();
    }


    @Then("I should see the search results narrow down.")
    public void i_should_see_the_search_results_narrow_down() {
        int afterFilter = terminal.getNumberOfResults();
        System.out.println("before "+ beforeFilter + " and after " + afterFilter);
        assertThat(afterFilter).isLessThan(beforeFilter);
        try{Thread.sleep(5000);}catch(InterruptedException e){}
    }


}
