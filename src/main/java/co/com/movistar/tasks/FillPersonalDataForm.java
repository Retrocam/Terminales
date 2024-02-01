package co.com.movistar.tasks;

import co.com.movistar.userInterfaces.CartUI;
import co.com.movistar.userInterfaces.CheckoutUI;
import co.com.movistar.utils.DataExcel;
import co.com.movistar.utils.JsMethods;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FillPersonalDataForm implements Task {
    CheckoutUI checkoutUI = new CheckoutUI();
    CartUI cartUI = new CartUI();
    //UserData user = UserData.USER_1;
    DataExcel user = new DataExcel();

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                //WaitUntil.the(checkoutUI.BTN_CONTINUE, isEnabled() ).forNoMoreThan(20).seconds(),
                Click.on(cartUI.BTN_CONTINUE),
                WaitUntil.the(checkoutUI.TXT_EMAIL, isClickable() ).forNoMoreThan(60).seconds(),
                /*Enter.theValue(user.getEMAIL()).into(checkoutUI.TXT_EMAIL),
                Enter.theValue(user.getNAME()).into(checkoutUI.TXT_NAME),
                Enter.theValue(user.getLASTNAME()).into(checkoutUI.TXT_LASTNAME),
                Enter.theValue(user.getPHONE()).into(checkoutUI.TXT_PHONE),
                Enter.theValue(user.getID()).into(checkoutUI.TXT_IDCARD),*/

                Enter.theValue(user.getEMAIL()).into(checkoutUI.TXT_EMAIL),
                Enter.theValue(user.getNAME()).into(checkoutUI.TXT_NAME),
                Enter.theValue(user.getLASTNAME()).into(checkoutUI.TXT_LASTNAME),
                Enter.theValue(user.getPHONE()).into(checkoutUI.TXT_PHONE),
                Enter.theValue(user.getID()).into(checkoutUI.TXT_IDCARD),
                Click.on(checkoutUI.BTN_CONTINUE)
        );
        JsMethods.scrollByPx(actor,350);

    }
    public static Performable inCheckout() {
        return Instrumented.instanceOf(FillPersonalDataForm.class).withProperties();
    }


}
