package com.rstest.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;



public class DriverManager {
    public static WebDriver driver;

    public static void setUp(){
        ChromeOptions chromeoptions = new ChromeOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        chromeoptions.addArguments("start-maximized");
        chromeoptions.addArguments("enable-popup-blocking");
        chromeoptions.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        caps.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
        driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    public static void tearDown(){
        driver.close();
    }
}
