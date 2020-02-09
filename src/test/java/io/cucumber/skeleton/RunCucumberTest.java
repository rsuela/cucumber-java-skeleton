package io.cucumber.skeleton;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
     plugin = {"pretty", "json:build/test-results/test/Cucumber.json"}
  )
public class RunCucumberTest {
}