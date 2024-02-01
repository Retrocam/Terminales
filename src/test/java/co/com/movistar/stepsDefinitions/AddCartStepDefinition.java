package co.com.movistar.stepsDefinitions;

import co.com.movistar.questions.TextValidations;
import co.com.movistar.tasks.AddToCart;
import co.com.movistar.userInterfaces.CartUI;
import co.com.movistar.utils.Global;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddCartStepDefinition {
    CartUI cartUI = new CartUI();
    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }
    @When("I click on the button Buy now")
    public void i_click_on_the_button_buy_now() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddToCart.inMovistar());
    }
    @Then("I validate the name of the product")
    public void i_validate_the_name_of_the_product() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TextValidations.textValidations(cartUI.TXT_CART_PRODUCT_NAME),
                Matchers.containsString(Global.PRODUCT_NAME)));
    }
    @Then("I validate the price of the product")
    public void i_validate_the_price_of_the_product() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TextValidations.textValidations(cartUI.TXT_CART_PRODUCT_PRICE),
                Matchers.containsString(Global.PRODUCT_PRICE)));
    }

}
