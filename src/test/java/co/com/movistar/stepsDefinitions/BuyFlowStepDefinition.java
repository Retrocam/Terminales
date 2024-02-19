package co.com.movistar.stepsDefinitions;

import co.com.movistar.questions.TextValidations;
import co.com.movistar.tasks.FillAddressForm;
import co.com.movistar.tasks.FillPaymentMethodForm;
import co.com.movistar.tasks.FillPersonalDataForm;
import co.com.movistar.userInterfaces.CheckoutUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyFlowStepDefinition {
    CheckoutUI checkoutUI = new CheckoutUI();


    @When("I fill the personal data form")
    public void i_fill_the_personal_data_form() {

        OnStage.theActorInTheSpotlight().attemptsTo(FillPersonalDataForm.inCheckout());
    }

    @When("I fill the address form")
    public void i_fill_the_address_form() {
        OnStage.theActorInTheSpotlight().attemptsTo(FillAddressForm.inCheckout());

    }
    @When("I fill the Pay method form")
    public void i_fill_the_pay_method_form() {
        OnStage.theActorInTheSpotlight().attemptsTo(FillPaymentMethodForm.inCheckout());

    }
    @Then("I verify the number order is not null")
    public void i_verify_the_number_order_is_not_null() {

        String order = checkoutUI.LBL_ORDER_NUMBER.resolveFor(OnStage.theActorInTheSpotlight()).getTextContent() ;
        //System.out.println(Product_name);
        System.out.println("The order number is: "+order);


        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TextValidations.textValidations(checkoutUI.LBL_ORDER_NUMBER),
                Matchers.notNullValue()));

    }
}
