package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/LogimHRMWithDataTable.feature",
glue="stepdef", dryRun=true)
public class HRM_Login_DataTable {

}
