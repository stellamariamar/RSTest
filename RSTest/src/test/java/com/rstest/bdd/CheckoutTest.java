package com.rstest.bdd;

import com.rstest.pom.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static com.rstest.bdd.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest {

    public HomePage home;
    public CheckoutPage checkoutPage;

    @Given("I have a product with MPN {string} in my basket")
    public void i_have_a_product_with_mpn_in_my_basket(String MPN) {
        home = new HomePage(driver);
        ProductPage product = home.searchMPN(MPN);
        product.addToCart(1);
    }

    @When("I proceed to checkout as a guest")
    public void i_proceed_to_checkout_as_a_guest() {
       BasketPage basket = new BasketPage(driver);
       checkoutPage = basket.checkout();
    }

    @When("I enter my delivery details:")
    public void i_enter_my_delivery_details(Map<String, String> details) {
        checkoutPage.enterDeliveryDetails(details);
        try { Thread.sleep(5000);} catch (InterruptedException e) {}
        checkoutPage.submit();
    }

    @Then("I can fill in my payment details")
    public void i_can_fill_in_my_payment_details() {
        assertThat(checkoutPage.confirmPaymentIsEnabled()).isTrue();
        try { Thread.sleep(5000);} catch (InterruptedException e) {}
    }

}