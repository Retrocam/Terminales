package co.com.movistar.stepsDefinitions;

import co.com.movistar.tasks.FillPaymentMethodForm;
import co.com.movistar.tasks.SelectRandom;
import co.com.movistar.userInterfaces.CheckoutUI;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class BuyFlowWithRandom {
    //CheckoutUI checkoutUI = new CheckoutUI();
    @When("I select a random product")
    public void i_select_a_random_product() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectRandom.inMovistar());
    }

}
