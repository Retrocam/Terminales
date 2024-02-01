package co.com.movistar.tasks;

import co.com.movistar.userInterfaces.CheckoutUI;
import co.com.movistar.utils.UserData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FillPaymentMethodForm implements Task {
    CheckoutUI checkoutUI = new CheckoutUI();
    UserData user = UserData.USER_1;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                JavaScriptClick.on(checkoutUI.BTN_PSE),
                (Performable) SelectFromOptions.byValue(user.getBANK_VALUE()).from(checkoutUI.LST_BANKS),
                Enter.theValue(user.getNAME()).into(checkoutUI.TXT_NAME_PSE),
                Enter.theValue(user.getLASTNAME()).into(checkoutUI.TXT_LASTNAME_PSE),
                Enter.theValue(user.getPHONE()).into(checkoutUI.TXT_PHONE_PSE),
                Enter.theValue(user.getID()).into(checkoutUI.TXT_IDCARD_PSE),
                Enter.theValue(user.getEMAIL()).into(checkoutUI.TXT_EMAIL_PSE),
                JavaScriptClick.on(checkoutUI.BTN_TYC_EPAYCO),
                WaitUntil.the(checkoutUI.BTN_BUY_NOW, isEnabled()).forNoMoreThan(30).seconds(),
                JavaScriptClick.on(checkoutUI.BTN_BUY_NOW),
                WaitUntil.the(checkoutUI.BTN_CLOSE_PAGE, isClickable()).forNoMoreThan(30).seconds(),
                JavaScriptClick.on(checkoutUI.BTN_CLOSE_PAGE),
                WaitUntil.the(checkoutUI.BTN_CONFIRM_CLOSE, isEnabled() ).forNoMoreThan(20).seconds(),
                JavaScriptClick.on(checkoutUI.BTN_CONFIRM_CLOSE),
                WaitUntil.the(checkoutUI.LBL_ORDER_NUMBER, isVisible() ).forNoMoreThan(20).seconds(),
                new ScrollToTarget(checkoutUI.LBL_ORDER_NUMBER)

        );

    }
    public static Performable inCheckout() {
        return Instrumented.instanceOf(FillPaymentMethodForm.class).withProperties();
    }
}
