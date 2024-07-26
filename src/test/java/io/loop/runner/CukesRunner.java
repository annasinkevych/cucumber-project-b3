package io.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
    created a new directory under resources named features

    right click on features -->copy path reference-->path from content root --> paste above to cucumber options
    repeat for glue - step_definitions
    add LoginFeature.feature to features
    add Hooks to step_definitions
    add class LoginStepDefs to step_definitions

    cucumber runner takes this tag smoke and goes to login defs class to find where the code is

    cucumber helps us to generate code snippets for us

    set dryRun to true - to generate code sniopet for LoginStepDefs doesn't run the code just checks if any steps are missing from step definitions



    DryRun - turns on and off the running of step definitions
            set to true - code inside the snippet does not run
              if we don't want to actually run my codem and just want to my snippets for implementing - set to true
 */
//
@RunWith(Cucumber.class) //run the class as Cucumber BDD tests
@CucumberOptions(
        features = "src/test/resources/features", //goes to this folder where file is stored
        glue = "io/loop/step_definitions",
        dryRun = false,  //gets code snippet for this scenario when true
        tags = "@smoke",
        monochrome = false //reduces unnecessary locks
)

public class CukesRunner {



}
