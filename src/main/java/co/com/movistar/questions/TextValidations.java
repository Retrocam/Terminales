package co.com.movistar.questions;


import co.com.movistar.tasks.AddToCart;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


public class TextValidations implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return null;
    }

    public static Question<String> textValidations(Target locator){
        return actor ->locator.resolveFor(actor).getTextContent();
    }

    public static Performable inMovistar() {
        return (Performable) Instrumented.instanceOf(TextValidations.class).withProperties();
    }
    /*public static String textValidations2(Target locator){
        String x;
        x = locator.resolveFor(actor).getTextContent();
        return x;
    }*/



}
