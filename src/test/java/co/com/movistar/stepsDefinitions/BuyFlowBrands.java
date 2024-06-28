package co.com.movistar.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BuyFlowBrands {


    @Given("I am in {string}")
    public void i_am_in(String urlBrand) {
        WebDriverManager.chromedriver().clearDriverCache().setup();//elimina cache
        theActorCalled("Buyer").wasAbleTo(Open.url(urlBrand));
    }
}
