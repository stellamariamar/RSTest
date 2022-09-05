package com.rstest.bdd;

import com.rstest.pom.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static com.rstest.bdd.DriverManager.driver;

public class LoginTest {
    public static LoginPage loginPage;
    @Given("I have visited the RS login page")
    public void i_have_visited_the_rs_login_page() {
        driver.get("https://uk.rs-online.com/web/authHome.html");
        loginPage = new LoginPage(driver);
    }

    @When("I enter my {string} and {string}")
    public void i_enter_my_username_and_password(String myusername, String mypassword) {
        loginPage.enterUsername(myusername);
        loginPage.enterPassword(mypassword);
        loginPage.submit();
    }

    @And("the credentials are correct")
    public void theCredentialsAreCorrect() {
        assertThat(loginPage.failedLogin()).isFalse();
    }

    @Then("I should see the user's name {string}")
    public void i_should_see_the_user_s_name(String name) {

        WelcomePage welcomePage = new WelcomePage(driver);
        String msg = welcomePage.getWelcomeMsg();
        assertThat(msg).isEqualTo("Welcome " + name);

    }

}
