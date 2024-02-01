package co.com.movistar.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PDPUI {
    public final Target BTN_BUYNOW = Target.the("botton buy now sticky").located(By.id("button-buy-now"));
    public final Target TXT_STOCK = Target.the("stock")
            .locatedBy("(//p[@class=\"stock-available stock-container__text\"])[2]");
    public final Target TXT_PRODUCT_NAME = Target.the("Name of the product").located(By.className("c-card-detail__title"));
    public final Target TXT_PRODUCT_PRICE = Target.the("Price of the product").located(By.className("c-card-detail__number"));
}
