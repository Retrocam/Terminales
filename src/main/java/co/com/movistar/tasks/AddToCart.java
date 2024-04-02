package co.com.movistar.tasks;

import co.com.movistar.userInterfaces.PDPUI;
import co.com.movistar.utils.Global;
import co.com.movistar.utils.JsMethods;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart implements Task {
    PDPUI pdpui = new PDPUI();

    @Override
    public <T extends Actor> void performAs(T actor) {
        Global.Product_name = pdpui.TXT_PRODUCT_NAME.resolveFor(actor).getTextContent().substring(1);
        Global.Product_price = pdpui.TXT_PRODUCT_PRICE.resolveFor(actor).getText().substring(2);
        System.out.println(Global.Product_name +" price: "+ Global.Product_price);
        //JsMethods.scrollByPx(actor,500);
        actor.attemptsTo(
                WaitUntil.the(pdpui.BTN_BUYNOW, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(pdpui.BTN_BUYNOW)

        );
        //JsMethods.scrollByPx(actor,350);

    }
    public static Performable inMovistar() {
        return Instrumented.instanceOf(AddToCart.class).withProperties();
    }
}
