package com.rstest.bdd;

import com.rstest.pom.HomePage;
import com.rstest.pom.ProductPage;

import graphql.util.Pair;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.groups.Tuple;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.rstest.bdd.DriverManager.driver;



public class CheckoutMPNProductsTest {
    public HomePage home;

    @Given("I have a list of products with the following Manufacturer's Part Number")
    public void i_have_a_list_of_products_with_the_following_manufacturer_s_part_number(Map<String, Integer> MPNList) {
        home = new HomePage(driver);

        Iterator<Map.Entry<String, Integer>> iterator = MPNList.entrySet().iterator();
        Map.Entry<String, Integer> entry = iterator.next();
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
        ProductPage product = home.searchMPN(entry.getKey());
        product.addToCart(entry.getValue());
        while (iterator.hasNext()){
            entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            product = product.searchMPN(entry.getKey());
            product.addToCart(entry.getValue());
        }

    }

    @Given("I add them to the basket")
    public void i_add_them_to_the_basket() {

    }
    @When("I fill in my delivery details")
    public void i_fill_in_my_delivery_details() {

    }
    @Then("I should be prompted to fill in the payment details.")
    public void i_should_be_prompted_to_fill_in_the_payment_details() {

    }
}
