package com.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/LoginOrangeHRM.feature",glue="stepdef", dryRun=false)
public class Runner_Class_01 {

}
