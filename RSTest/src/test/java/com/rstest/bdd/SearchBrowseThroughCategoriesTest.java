package com.rstest.bdd;
import com.rstest.pom.HomePage;
import static com.rstest.config.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

import com.rstest.pom.L2CategoryPage;
import com.rstest.pom.TerminalNodePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBrowseThroughCategoriesTest {

    public HomePage home;
    public L2CategoryPage l2Page;
    public TerminalNodePage terminal;
    @Given("I visit the Homepage")
    public void i_visit_the_homepage() {
        home = new HomePage(driver);
    }
    @When("I browse from {string} through {string} to {string}")
    public void i_browse_from_through_to(String l0Category, String l1Category, String l2Category) {
        l2Page = home.browse(l0Category, l1Category, l2Category);
    }

    @When("I select the sub-category {string}")
    public void i_select_the_sub_category(String subCategory) {
        assertThat(l2Page.confirm()).isTrue();
        terminal = l2Page.selectSubCategory(subCategory);
    }


    @Then("I see the sub-category page")
    public void i_see_the_sub_category_page() {
        assertThat(terminal.confirm()).isTrue();
    }
}
