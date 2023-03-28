package dao;

import model.dataCarroCompra;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utilFunction.constant;

import java.io.FileReader;
import java.io.IOException;

public class dataJsonDao {
    public static dataCarroCompra getDataCarroCompra(String jsonPath) throws IOException, ParseException {
        dataCarroCompra carroCompra = new dataCarroCompra();
        Object ob = new JSONParser().parse(new FileReader(constant.pathJsonData + jsonPath));
        JSONObject js = (JSONObject) ob;
        carroCompra.setArticuloUno((String) js.get("articuloUno"));
        carroCompra.setArticuloDos((String) js.get("articuloDos"));
        carroCompra.setNombre((String) js.get("nombre"));
        carroCompra.setApellido((String) js.get("apellido"));
        carroCompra.setCorreo((String) js.get("correo"));
        carroCompra.setTelefono((String) js.get("telefono"));
        carroCompra.setClave((String) js.get("clave"));
        carroCompra.setConfirmaClave((String) js.get("confirmaClave"));
        carroCompra.setDireccion((String) js.get("direccion"));
        carroCompra.setCiudad((String) js.get("ciudad"));
        carroCompra.setCodigoPostal((String) js.get("codigoPostal"));
        carroCompra.setPais((String) js.get("pais"));
        carroCompra.setRegion((String) js.get("region"));
        carroCompra.setShipping((String) js.get("shipping"));
        carroCompra.setEstadoCompra((String) js.get("estadoCompra"));
        return carroCompra;
    }

}
