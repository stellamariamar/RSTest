package com.rstest.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@execute",
        glue= {"com.rstest.bdd", "com.rstest.config"}
)
public class RSTestRunner {}

