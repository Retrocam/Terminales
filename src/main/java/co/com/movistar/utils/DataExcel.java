package co.com.movistar.utils;


import lombok.Getter;


import java.util.List;
import java.util.Map;

/**La clase DataExcel se encarga de hacer el la conexion al archivo de excel llamando al metodo readData de la clase Excel
 * con el fin de solo hacer este paso una vez*/
@Getter
public class DataExcel {
    public List<Map<String, String>> testData = Excel.readData("User");

    private String EMAIL = testData.get(0).get("Email");
    private String NAME = testData.get(0).get("Nombre");
    private String LASTNAME =testData.get(0).get("Apellido");
    private String PHONE = testData.get(0).get("Telefono");
    private String ID = testData.get(0).get("Cedula");


    @Override
    public String toString() {
        String s = " Apellido: "+NAME + "\n Apellido: " +LASTNAME+ "\n Email: "+ EMAIL;
        return s;
    }
}
