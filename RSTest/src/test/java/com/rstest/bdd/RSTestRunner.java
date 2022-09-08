package com.rstest.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(tags = "@execute")
    public class RSTestRunner {

        @BeforeClass
        public static void init() {
            DriverManager.setUp();
        }

        @AfterClass
        public static void teardown() {
            DriverManager.tearDown();
        }
    }

