package co.com.movistar.tasks;

import co.com.movistar.userInterfaces.HomeUI;
import co.com.movistar.utils.JsMethods;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;


public class FindAvailable implements Task {
    HomeUI homeUI = new HomeUI();
    @Override
    public <T extends Actor> void performAs(T actor) {
        JsMethods.scrollByPx(actor,650);
        //List <WebElementFacade>  devicesList = (List<WebElementFacade>) homeUI.BTN_PRODUCT.resolveFor(actor);

        actor.attemptsTo(

                Click.on(homeUI.BTN_PRODUCT)
        );


    }
    public static Performable inMovistar() {
        return Instrumented.instanceOf(FindAvailable.class).withProperties();
    }
}
