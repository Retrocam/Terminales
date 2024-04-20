package co.com.movistar.stepsDefinitions;

import co.com.movistar.questions.TextValidations;
import co.com.movistar.tasks.FindAvailable;
import co.com.movistar.userInterfaces.PDPUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AvailabilityStepDefinition {
    PDPUI pdpui = new PDPUI();

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }
    @Given("I am in movistar.com")
    public void i_am_in_movistar_com() {
        WebDriverManager.chromedriver().clearDriverCache().setup();//elimina cache
        theActorCalled("Buyer").wasAbleTo(Open.url("https://tienda.movistar.com.co/celulares.html")); //usar una variable con el excel
    }
    @When("I select a product")
    public void i_select_a_product() {
        OnStage.theActorInTheSpotlight().attemptsTo(FindAvailable.inMovistar());
    }

    @Then("I check if there is stock")
    public void i_check_if_there_is_stock() {
        String text = "Stock disponible:";

        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TextValidations.textValidations(pdpui.TXT_STOCK),
               Matchers.startsWith(text)));
    }
}
