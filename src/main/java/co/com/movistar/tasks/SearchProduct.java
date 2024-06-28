package co.com.movistar.tasks;

import co.com.movistar.userInterfaces.HomeUI;
import co.com.movistar.utils.JsMethods;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchProduct implements Task {
    private String product;

    public SearchProduct(String product) {
        this.product = product;
    }
    HomeUI homeUI = new HomeUI();
    @Override
    public <T extends Actor> void performAs(T actor) {
        HomeUI homeUI = new HomeUI();

        actor.attemptsTo(
                Enter.theValue(product).into(homeUI.TXT_SEARCHBAR),
                Enter.keyValues(Keys.ENTER).into(homeUI.TXT_SEARCHBAR)
        );


    }
    public static Performable inMovistar(String Product) {
        return Instrumented.instanceOf(SearchProduct.class).withProperties(Product);
    }

}
