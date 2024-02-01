package co.com.movistar.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum UserData {

    USER_1("Juan","Pruebas","3003333333","Prueba@terminales.com","888888881",
            "7","27","7","CL","1486464778355100116",
            "CASA 1",
            "1001");

    private String NAME;
    private String LASTNAME;
    private String PHONE;
    private String EMAIL;
    private String ID;
    private String ADDRESS1;
    private String ADDRESS2;
    private String ADDRESS_PLATE;
    private String STREET_VALUE;
    private String NEIGHBORHOOD_VALUE;
    private String ADDRESS_COMPLEMENT;
    private String BANK_VALUE;

}
