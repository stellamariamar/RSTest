package com.rstest.bdd;

import com.rstest.pom.HomePage;
import com.rstest.pom.SearchResultsPage;
import com.rstest.pom.TerminalNodePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

import static com.rstest.config.DriverManager.driver;

public class SearchUsingPopularCategoryTest {
    public SearchResultsPage results;
    public TerminalNodePage terminal;

    @Given("I am on the HomePage and I search using the search term {string}")
    public void i_am_on_the_homepage_and_i_search_using_the_search_term(String searchTerm) {
        HomePage home = new HomePage(driver);
        results = home.searchForTerm(searchTerm);
    }
    @Given("I select the popular category {string}")
    public void i_select_the_popular_category(String popCategory) {

        terminal = results.selectPopCategory(popCategory);
    }
    @When("I select to see {string} results on the page")
    public void i_select_to_see_results_on_the_page(String numProducts) {
        terminal.setNumOfResultsPerPage(numProducts);
    }
    @Then("I should see {string} products on the page, if there are enough")
    public void i_should_see_products_on_the_page_if_there_are_enough(String numProducts) {
        int numOnPage = terminal.getNumberOfResultsOnPage();
        int numTotal =  terminal.getTotalNumberOfResults();
        int numPerPage = Integer.parseInt(numProducts);
        System.out.println("numOnPage "+numOnPage);
        System.out.println("numTotal "+numTotal);
        System.out.println("numPerPage "+numPerPage);
        assertThat(numOnPage).isEqualTo(Math.min(numTotal, numPerPage));

    }


}