/*package com.rstest.bdd;
import com.rstest.pom.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;

import static org.assertj.core.api.Assertions.assertThat;
import static com.rstest.bdd.DriverManager.driver;

public class AddToCartTest {

    public static CartPage cartPage;
    public static SearchPage searchPage;
    public static ResultsPage resultsPage;


    @Given("The user is on the homepage of the website")
    public void the_user_is_on_the_homepage_of_the_website() {
        searchPage = new SearchPage(driver);
        searchPage.visitHomePage();
        searchPage.manageCookies();
    }


    @When("The user enters the {string} description in the search field")
    public void The_user_enters_the_description_in_the_search_field(String searchTerm) {

        try {searchPage.manageCookies();
        } catch(ElementNotInteractableException e){}
        searchPage.enterSearchTerm(searchTerm);
        resultsPage = new ResultsPage(driver);
        cartPage = new CartPage(driver);
    }


    @Then("The user gets the result page containing matching products with {string}")
    public void The_user_gets_the_result_page_containing_matching_products_with(String searchTerm) {
        int num1 = resultsPage.getNumMatchingProducts(searchTerm);
        int num2 = resultsPage.getNumOfSearchResults();
       // assertThat(num1).isEqualTo(num2);

    }
    @Then("can add items of a selected product to the cart.")
    public void can_add_items_of_a_selected_product_to_the_cart() {
       // resultsPage.addToCart();
        cartPage.viewBasket();
    }

}
*/