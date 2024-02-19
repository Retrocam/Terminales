package co.com.movistar.tasks;

import co.com.movistar.userInterfaces.CheckoutUI;
import co.com.movistar.utils.DataExcel;
import co.com.movistar.utils.UserData;
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
        UserData user = UserData.USER_1;
        DataExcel user2 = new DataExcel();



        actor.attemptsTo(
                Click.on(checkoutUI.TXT_EDIT_ADDRESS),
                SelectFromOptions.byValue(user2.getSTREET_VALUE()).from(checkoutUI.LST_ADDRESS),
                //Enter.theValue(user.getADDRESS1()).into(checkoutUI.TXT_ADDRESS_1),
                Enter.theValue(user2.getADDRESS1()).into(checkoutUI.TXT_ADDRESS_1),
                Enter.theValue(user2.getADDRESS2()).into(checkoutUI.TXT_ADDRESS_2),
                Enter.theValue(user2.getADDRESS_PLATE()).into(checkoutUI.TXT_ADRESS_PLATE),
                WaitUntil.the(checkoutUI.LST_NEIGHBORHOOD, isEnabled() ).forNoMoreThan(60).seconds(),
                SelectFromOptions.byValue(user2.getNEIGHBORHOOD_VALUE()).from(checkoutUI.LST_NEIGHBORHOOD),
                Click.on(checkoutUI.BTN_CONTINUE_ADDRESS),
                WaitUntil.the(checkoutUI.BTN_RADIO_CHECK_ADDRESS, isClickable() ).forNoMoreThan(10).seconds(),
                Click.on(checkoutUI.BTN_RADIO_CHECK_ADDRESS),
                Click.on(checkoutUI.BTN_CONFIRM_ADDRESS)

        );
        if (user2.getTYPE()!= null){
            actor.attemptsTo(
                    SelectFromOptions.byValue(user2.getTYPE()).from(checkoutUI.LST_TYPE),
                    SelectFromOptions.byValue(user2.getDetail()).from(checkoutUI.LST_DETAIL)
            );
        }

        actor.attemptsTo(

                Click.on(checkoutUI.BTN_SECOND_CONFIRM),
                Enter.theValue(user2.getADDRESS_COMPLEMENT()).into(checkoutUI.TXT_COMPLEMENT)

        );
    }
    public static Performable inCheckout() {
        return Instrumented.instanceOf(FillAddressForm.class).withProperties();
    }


}
