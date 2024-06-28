package co.com.movistar.stepsDefinitions;

import co.com.movistar.questions.TextValidations;
import co.com.movistar.tasks.SearchProduct;
import co.com.movistar.userInterfaces.HomeUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchProductStepDefinition {
    HomeUI homeUI = new HomeUI();

    @When("I search a product writing the {string} in the search bar")
    public void i_search_a_product_writing_the_in_the_search_bar(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchProduct.inMovistar(product));
    }
    @Then("I confirm the search message with the {string}")
    public void i_confirm_the_search_message_with_the(String product){
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TextValidations.textValidations(homeUI.LBL_TITLE_SEARCH),
                Matchers.containsString(product)));
    }
}
