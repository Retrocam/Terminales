package co.com.movistar.utils;


import lombok.Getter;


import java.util.List;
import java.util.Map;

import static co.com.movistar.utils.Global.numrandom;

/**La clase DataExcel se encarga de hacer el la conexion al archivo de excel llamando al metodo readData de la clase Excel
 * con el fin de solo hacer este paso una vez*/
@Getter
public class DataExcel {
    public List<Map<String, String>> testData = Excel.readData("User");
    public List<Map<String, String>> addressData = Excel.readData("Direccion");

    private String EMAIL = testData.get(numrandom).get("Email");
    private String NAME = testData.get(numrandom).get("Nombre");
    private String LASTNAME =testData.get(numrandom).get("Apellido");
    private String PHONE = testData.get(numrandom).get("Telefono");
    private String ID = testData.get(numrandom).get("Cedula");


    private String ADDRESS1 = addressData.get(numrandom).get("Calle");
    private String ADDRESS2 = addressData.get(numrandom).get("Numero");
    private String ADDRESS_PLATE = addressData.get(numrandom).get("Placa");
    private String STREET_VALUE = addressData.get(numrandom).get("Cod_Calle");
    private String NEIGHBORHOOD_VALUE = addressData.get(numrandom).get("Cod_Barrio");
    private String ADDRESS_COMPLEMENT = addressData.get(numrandom).get("Complemento");
    private String TYPE = addressData.get(numrandom).get("Tipo");
    private String Detail = addressData.get(numrandom).get("Detalle");



    @Override
    public String toString() {
        String s = " Apellido: "+NAME + "\n Apellido: " +LASTNAME+ "\n Email: "+ EMAIL;
        return s;
    }
}
