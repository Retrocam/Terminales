package co.com.movistar.tasks;

import co.com.movistar.userInterfaces.HomeUI;
import co.com.movistar.userInterfaces.PDPUI;
import co.com.movistar.utils.JsMethods;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedCondition;


import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectRandom implements Task {
    HomeUI homeUI = new HomeUI();
    @Override
    public <T extends Actor> void performAs(T actor) {
        PDPUI pdpui = new PDPUI();
        Random random = new Random();
        int index=-1;
        Boolean flag = true;
        while (flag) {
            JsMethods.scrollByPx(actor,800);
            List<WebElementFacade> devicesList =  homeUI.LST_PRODUCT.resolveAllFor(actor);
            try {
                System.out.println("tamano lista: " + devicesList.size());
                index = random.nextInt(8) + 1;
                System.out.println(index);
                devicesList.get(index).click();
            } catch (org.openqa.selenium.ElementNotInteractableException ex) {
                try {
                    System.out.println("no se pudo elegir el equipo" + index);
                    index = random.nextInt(8) + 1;
                    System.out.println("reintento con: " + index);
                    devicesList.get(index).click();
                }catch (Exception e){
                    System.out.println("Manejar excepcion: "+e);
                    index = random.nextInt(8) + 1;
                    System.out.println("reintento con: " + index);
                    devicesList.get(index).click();
                }
            }
            JsMethods.scrollByPx(actor,650);
            actor.attemptsTo(
                    WaitUntil.the(pdpui.BTN_BUYNOW, isClickable() ).forNoMoreThan(60).seconds() );

            if (pdpui.BTN_BUYNOW.resolveFor(actor).getTextContent().contains("cuando este disponible")||
                    pdpui.BTN_BUYNOW.resolveFor(actor).getTextContent().contains("recoge")) {

                System.out.println("xxxxxxx No Tiene xxxxxxxx");
                JsMethods.scrollByPx(actor,0);
                actor.attemptsTo(
                        WaitUntil.the(pdpui.BTN_RETURN, isClickable() ).forNoMoreThan(60).seconds(),
                        Click.on(pdpui.BTN_RETURN)
                );
            } else {
                System.out.println(pdpui.BTN_BUYNOW.resolveFor(actor).getTextContent());
                flag = false;
            }
        }



    }
    public static Performable inMovistar() {
        return Instrumented.instanceOf(SelectRandom.class).withProperties();
    }
}
