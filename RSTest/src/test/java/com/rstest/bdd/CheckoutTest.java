package com.rstest.bdd;

import com.rstest.pom.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.Map;

import static com.rstest.config.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest {

    public HomePage home;
    public CheckoutPage checkoutPage;

    @Given("I have a product with MPN {string} in my basket")
    public void i_have_a_product_with_mpn_in_my_basket(String MPN) {
        ProductPage product = new HomePage(driver).searchForMPN(MPN);
        product.addToBasket();
    }

    @When("I proceed to checkout as a guest")
    public void i_proceed_to_checkout_as_a_guest() {
        BasketPage basket = new BasketPage(driver);
        checkoutPage = basket.checkout();
    }

    @When("I enter my delivery details:")
    public void i_enter_my_delivery_details(Map<String, String> details) {
        checkoutPage.enterDeliveryDetails(details);
        checkoutPage.submitDeliveryDetails();
    }

    @Given("I have a list of products with the following Manufacturer's Part Numbers in my basket")
    public void i_have_a_list_of_products_with_the_following_manufacturer_s_part_numbers_in_my_basket(Map<String, Integer> MPNs) {
            // iterator over list of part numbers and quantities
            Iterator<Map.Entry<String, Integer>> iterator = MPNs.entrySet().iterator();

            // first entry in list (treat separately, search on home page)
            Map.Entry<String, Integer> entry = iterator.next();
            // search for product on home page and add to basket
            ProductPage product = new HomePage(driver).searchForMPN(entry.getKey());
            product.setQuantity(entry.getValue());
            product.addToBasket();
            while (iterator.hasNext()){
                // next entry in the list
                entry = iterator.next();
                // search for product (while on the previous product page) and add to basket
                product = product.searchForMPN(entry.getKey());
                product.setQuantity(entry.getValue());
                product.addToBasket();
        }
    }

    @Then("I cannot proceed to payment")
    public void i_cannot_proceed_to_payment() {
        assertThat(checkoutPage.confirmPaymentIsEnabled()).isFalse();
    }

    @Then("I can fill in my payment details")
    public void i_can_fill_in_my_payment_details() {
        assertThat(checkoutPage.confirmPaymentIsEnabled()).isTrue();
    }

}