package com.rstest.bdd;

import com.rstest.pom.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;

import static com.rstest.bdd.DriverManager.driver;

public class CheckoutTest {


    public static SearchPage searchPage = new SearchPage(driver);
    public static ResultsPage resultsPage = new ResultsPage(driver);
    public static CartPage cartPage = new CartPage(driver);

    String stockNo = " ";
    @Given("I have a {string} in my basket")
    public void i_have_a_in_my_basket(String product) {
        searchPage.visitHomePage();
        searchPage.deleteStorage();
        searchPage.visitHomePage();
        try {
            searchPage.manageCookies();
        } catch(ElementNotInteractableException e){

        }
        searchPage.enterSearchTerm(product);
       // stockNo = resultsPage.addToCart();
        cartPage.viewBasket();

    }

    @Given("I adjust the quantity to {int}")
    public void i_adjust_the_quantity_to(Integer quantity) {
        System.out.println("Will try to increase quantity for "+stockNo);
        //cartPage.quantityIncrease(stockNo);
        //cartPage.setQuantity(stockNo, quantity);
        cartPage.viewBasket();

    }

    @When("I enter my delivery details {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_enter_my_delivery_details(String name, String surname, String email, String delName, String address, String postcode) {
       CheckoutPage checkoutPage =  cartPage.checkout();
       checkoutPage.enterDeliveryDetails(name, surname, email, delName, address, postcode);

       try {Thread.sleep(5000);}
       catch(InterruptedException e){}
    }
    @Then("I can proceed to the payment page")
    public void i_can_proceed_to_the_payment_page() {

    }




}
