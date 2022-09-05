package com.rstest.pom;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.rstest.bdd.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends PageObject{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername (String username){
        WebElement wUsername = driver.findElement(By.xpath("//input[@data-automation-id='login-username-field']"));
        wUsername.clear();
        wUsername.sendKeys(username);
    }

    public void enterPassword (String password){
        WebElement wPassword = driver.findElement(By.xpath("//input[@data-automation-id='login-password-field']"));
        wPassword.clear();
        wPassword.sendKeys(password);
    }

    public void submit (){
        WebElement loginBtn = driver.findElement(By.xpath("//button[@data-automation-id='login-submit-button']"));
        loginBtn.submit();
    }

    public boolean failedLogin(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-automation-id='login-message-bad-credentials']")));
            return true;
        } catch(TimeoutException e) {
            return false;
        }
    }
    /**


}

    @Then("I should see the user's name {string}")
    public void i_should_see_the_user_s_name(String name) {
        String welcomeText = "";
        Boolean loginSuccessful = false;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-welcome")));
            welcomeText = welcome.getText();
            loginSuccessful = true;
            assertThat(welcomeText).isEqualTo("Welcome " + name);

        } catch (TimeoutException e) {
            assertThat(name).isEqualTo("");
        }
    **/
}
