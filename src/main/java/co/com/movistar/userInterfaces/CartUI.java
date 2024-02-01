package co.com.movistar.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartUI {
    public final Target TXT_CART_PRODUCT_NAME = Target.the("Title product in cart")
            .locatedBy("(//div[@class='details-data']/p)[1]");
    public final Target TXT_CART_PRODUCT_PRICE = Target.the("Price product in cart")
            .located(By.className("detail-price"));
    public final Target BTN_CONTINUE = Target.the("continue in cart")
            .locatedBy( "(//button[@class=\"o-btn o-btn_height56 u-width-100 c-form__btn_full\"])[1]");


}
