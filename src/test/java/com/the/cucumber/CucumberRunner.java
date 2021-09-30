package com.the.cucumber;

import com.the.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/com/the/resources/feature/")

public class CucumberRunner extends TestBase {
    
}
