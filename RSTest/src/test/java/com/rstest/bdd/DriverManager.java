package com.rstest.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager {
    public static WebDriver driver;

    public static void setUp(){
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("start-maximized");
        chromeoptions.addArguments("enable-popup-blocking");
        driver = new ChromeDriver(chromeoptions);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    public static void tearDown(){
        driver.close();
    }
}
