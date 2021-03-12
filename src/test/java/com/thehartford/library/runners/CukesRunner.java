package com.thehartford.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
//                "html:target/default-cucumber-reports",
                "pretty",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/features",
        glue = "com/thehartford/library/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
