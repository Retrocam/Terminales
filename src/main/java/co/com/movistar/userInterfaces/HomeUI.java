package co.com.movistar.userInterfaces;


import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {
    public final Target BTN_PRODUCT = Target.the("Product")
            .locatedBy("(//a[@class=\"product-item-photo\"])[7]");
    public final Target LST_PRODUCT = Target.the("Product")
            .locatedBy("//div[@class=\"cat-card__link\"]");

}
