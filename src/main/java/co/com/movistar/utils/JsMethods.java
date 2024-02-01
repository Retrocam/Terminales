package co.com.movistar.utils;

import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;


public class JsMethods {

    public static void scrollByPx(Actor actor, int y) {
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollBy(0," + y + ")", "");

    }
}
