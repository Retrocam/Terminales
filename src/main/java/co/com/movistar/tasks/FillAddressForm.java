package co.com.movistar.tasks;

import co.com.movistar.userInterfaces.CheckoutUI;
import co.com.movistar.utils.DataExcel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class FillAddressForm implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        CheckoutUI checkoutUI = new CheckoutUI();
        DataExcel user = new DataExcel();
        actor.attemptsTo(
                //Click.on(checkoutUI.TXT_EDIT_ADDRESS),
                //SelectFromOptions.byValue(user.getSTREET_VALUE()).from(checkoutUI.LST_ADDRESS),
                Click.on(checkoutUI.DEPARTMENT),
                Enter.theValue("Bogota").into(checkoutUI.SEARCH_DEPARTMENT),
                Click.on(checkoutUI.DEPARTMENT_SELECTED),
                SelectFromOptions.byValue(user.getSTREET_VALUE()).from(checkoutUI.LST_ADDRESS),
                Enter.theValue(user.getADDRESS1()).into(checkoutUI.TXT_ADDRESS_1),
                Enter.theValue(user.getADDRESS2()).into(checkoutUI.TXT_ADDRESS_2),
                Enter.theValue(user.getADDRESS_PLATE()).into(checkoutUI.TXT_ADRESS_PLATE),
                WaitUntil.the(checkoutUI.LST_NEIGHBORHOOD, isEnabled() ).forNoMoreThan(60).seconds(),
                SelectFromOptions.byValue(user.getNEIGHBORHOOD_VALUE()).from(checkoutUI.LST_NEIGHBORHOOD),
                Enter.theValue(user.getADDRESS_COMPLEMENT()).into(checkoutUI.TXT_COMPLEMENT),
                Click.on(checkoutUI.BTN_CONTINUE)


                //Click.on(checkoutUI.BTN_CONTINUE_ADDRESS),
                //WaitUntil.the(checkoutUI.BTN_RADIO_CHECK_ADDRESS, isClickable() ).forNoMoreThan(10).seconds(),
                //Click.on(checkoutUI.BTN_RADIO_CHECK_ADDRESS),
                //Click.on(checkoutUI.BTN_CONFIRM_ADDRESS)

        );
        /*
        if (user.getTYPE()!= null){
            actor.attemptsTo(
                    SelectFromOptions.byValue(user.getTYPE()).from(checkoutUI.LST_TYPE),
                    SelectFromOptions.byValue(user.getDETAIL()).from(checkoutUI.LST_DETAIL)
            );
        }*/

    }
    public static Performable inCheckout() {
        return Instrumented.instanceOf(FillAddressForm.class).withProperties();
    }
}
