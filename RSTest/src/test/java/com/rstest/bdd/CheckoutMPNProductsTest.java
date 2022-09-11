package com.rstest.bdd;

import com.rstest.pom.HomePage;
import com.rstest.pom.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.Map;

import static com.rstest.bdd.DriverManager.driver;



public class CheckoutMPNProductsTest {

    // shopping list: pairs of MPNs and quantities
    Map<String, Integer> MPNs;

    @Given("I have a list of products with the following Manufacturer's Part Number")
    public void i_have_a_list_of_products_with_the_following_manufacturer_s_part_number(Map<String, Integer> MPNList) {
        MPNs = MPNList;
    }

    @Given("I add them to the basket")
    public void i_add_them_to_the_basket() {
        // iterator over list of part numbers and quantities
        Iterator<Map.Entry<String, Integer>> iterator = MPNs.entrySet().iterator();

        // first entry in list (treat separately, search on home page)
        Map.Entry<String, Integer> entry = iterator.next();
        // search for product on home page and add to basket
        ProductPage product = new HomePage(driver).searchMPN(entry.getKey());
        product.setQuantity(entry.getValue());
        product.addToBasket();
        while (iterator.hasNext()){
            // next entry in the list
            entry = iterator.next();
            // search for product (while on the previous product page) and add to basket
            product = product.searchMPN(entry.getKey());
            product.setQuantity(entry.getValue());
            product.addToBasket();
        }
    }
    @When("I fill in my delivery details")
    public void i_fill_in_my_delivery_details() {

    }
    @Then("I should be prompted to fill in the payment details.")
    public void i_should_be_prompted_to_fill_in_the_payment_details() {

    }
}
