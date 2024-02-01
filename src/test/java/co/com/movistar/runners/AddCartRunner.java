package co.com.movistar.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/addCart.feature",
        glue = "co.com.movistar.stepsDefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty"}
)
public class AddCartRunner {
}
