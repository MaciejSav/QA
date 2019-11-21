package com.jsystems.qa.qagui.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",  //scenariusze testowe
        glue = "classpath:com.jsystems.qa.qagui.cucumber",  // gdzie ma szukac stepów
        plugin = {"html:target/cucumber-html-report", "rerun:target.txt"},
        tags = {
                "@wordpress"
//                "@login"
//                "@userprofile"
                }
)
public class RunTest {
}
