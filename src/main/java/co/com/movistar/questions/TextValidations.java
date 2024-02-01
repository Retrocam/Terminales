package co.com.movistar.questions;


import net.serenitybdd.screenplay.Actor;
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
    /*public static String textValidations2(Target locator){
        String x;
        x = locator.resolveFor(actor).getTextContent();
        return x;
    }*/



}
