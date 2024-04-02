package co.com.movistar.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class CheckoutUI {
    public final Target TXT_EMAIL = Target.the("Email personal form")
            .locatedBy("//input[@id=\"email\"]");
    public final Target TXT_NAME = Target.the("name personal form")
            .locatedBy("//input[@id=\"names\"]");
    public final Target TXT_LASTNAME = Target.the("Lastname personal form")
            .locatedBy("//input[@id=\"lastnames\"]");
    public final Target TXT_PHONE = Target.the("phone personal form")
            .locatedBy("//input[@id=\"numberphone\"]");
    public final Target TXT_IDCARD = Target.the("cc personal form")
            .locatedBy("//input[@id=\"document\"]");
    public final Target BTN_CONTINUE = Target.the("continue botton")
            .locatedBy("//button[@id=\"continuarBtn\"]");

   //Address

    public final Target DEPARTMENT = Target.the(" Departments List")
           .located(By.id("select2-departamento-container"));
    public final Target SEARCH_DEPARTMENT = Target.the("Search bar")
            .locatedBy("//input[@class=\"select2-search__field\"]");
    public final Target DEPARTMENT_SELECTED = Target.the(" Bogota")
            .locatedBy("//*[substring(@id, string-length(@id) - string-length('-1486464778355100001')+1) = '-1486464778355100001']");
    public final Target LST_NEIGHBORHOOD = Target.the("neighborhood")
            .locatedBy("//select[@id=\"barrio\"]");
    public final Target LST_ADDRESS = Target.the("address").located(By.id("tipoDireccion"));
    public final Target TXT_ADDRESS_1 = Target.the("num1").located(By.id("numone"));
    public final Target TXT_ADDRESS_2 = Target.the("num2").located(By.id("numtwo"));
    public final Target TXT_ADRESS_PLATE = Target.the("plate")
            .locatedBy("//input[@id=\"placa\"]");
    public final Target BTN_CONTINUE_ADDRESS = Target.the("continue address form")
            .located(By.id("ver-cobertura"));
    //
    public final Target BTN_RADIO_CHECK_ADDRESS = Target.the("radio button confirm address")
            .locatedBy("//div[@class=\"c-form__radio c-form__radio_border dirRadio direccionTL\"]");
    public final Target LST_TYPE = Target.the("Type of address").located(By.id("tipo"));
    public final Target LST_DETAIL = Target.the("Detail of address").located(By.id("detalle"));
    public final Target BTN_CONFIRM_ADDRESS = Target.the("button confirm address")
            .locatedBy("//button[@class=\"selectAddress o-btn o-btn_w255 o-btn_height56 o-btn_height40_mb o-message__btn\"]");
    public final Target BTN_SECOND_CONFIRM = Target.the("Second button confirm address")
            .located(By.id("btn-verifyOrch"));
    public final Target TXT_COMPLEMENT = Target.the("complement address")
            .located(By.id("complement"));

    //Pay method

    public final Target BTN_PSE = Target.the("Button PSE")
            .located(By.id("switch-pse"));
    public final Target LST_BANKS = Target.the("neighborhood")
            .locatedBy("//select[@id=\"banckPse\"]");
    public final Target TXT_NAME_PSE = Target.the("name PSE")
            .located(By.id("fullname_pse") );
    public final Target TXT_LASTNAME_PSE = Target.the("Lastname PSE")
            .located(By.id("lastname_pse"));
    public final Target TXT_PHONE_PSE = Target.the("phone PSE")
            .located(By.id("phone_pse") );
    public final Target TXT_IDCARD_PSE = Target.the("cc PSE")
            .located(By.id("documentPse") );
    public final Target TXT_EMAIL_PSE = Target.the("Email PSE")
            .located(By.id("email_pse") );
    public final Target BTN_TYC_EPAYCO = Target.the("TYC PSE")
            .located(By.id("tyc_pseEpayco") );

    public final Target BTN_BUY_NOW = Target.the("Buy now Button")
            .locatedBy("(//button[@class=\"o-btn c-form__btn o-btn_height56\"])[1]" );
    public final Target BTN_CLOSE_PAGE = Target.the("button x, to close")
            .located(By.id("btnCloseInfo") );
    public final Target BTN_CONFIRM_CLOSE = Target.the("button confirm close")
            .locatedBy("(//button[@class=\"btn-main\"])[2]") ;
    public final Target LBL_ORDER_NUMBER = Target.the("Order number")
            .located(By.id("n_orden_fail") );








}
/*
            correo
            nombre
            apellido
            tele
            cc
            btn continuar
            dir
             BARRIO
                DIR
                NUM
                #
                NUM2
                CONTINUAR
                SELECT DIR
                CONFIRM *2

            complemento
            *titular porteria
            *fecha
            PSE
            BANCO, NOMBRE, APELLIDO, CC, TEL, CORREO
            CHECKBOX TYC
            COMPRAR
 */
