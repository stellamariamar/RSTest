package com.rstest.config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Arrays;

public class DriverManager {
    public static WebDriver driver;

    @Before
    public static void setUp(){
        System.out.println("Setting up webdriver....");
        ChromeOptions chromeoptions = new ChromeOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        chromeoptions.addArguments("start-maximized");
        chromeoptions.addArguments("enable-popup-blocking");
        chromeoptions.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        caps.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
        driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


    @After
    public static void tearDown(){
        System.out.println("Shutting down webdriver....");
        //driver.close();
        driver.quit();
    }
}
