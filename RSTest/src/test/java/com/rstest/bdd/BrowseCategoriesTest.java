package com.rstest.bdd;


import com.rstest.pom.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.assertj.core.api.Assertions.assertThat;
import static com.rstest.bdd.DriverManager.driver;

public class BrowseCategoriesTest {

    public static BrowseCategoriesPage browseCatpage;


    @Given("I am in the homepage and I click Browse")
    public void i_am_in_the_homepage_and_i_click_browse() {
        browseCatpage = new BrowseCategoriesPage(driver);
        browseCatpage.manageCookies();
        browseCatpage.selectBrowse();
    }
    @When("I select the {string}, {string}, {string}")
    public void i_select_the(String cat1, String cat2, String cat3) {
        browseCatpage.selectCategory(cat1);
        browseCatpage.selectCategory(cat2);
        browseCatpage.selectEndCategory(cat3);
    }
    @Then("I should see the 3D printing supplies")
    public void i_should_see_the_3d_printing_supplies() {
    }
}
