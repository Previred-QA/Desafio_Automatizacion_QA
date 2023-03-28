package steps;

import dao.dataJsonDao;
import driver.driverConfig;
import io.cucumber.java.en.Given;
import utilFunction.utilFunctions;

public class joinUrlSteps {

    utilFunctions function = new utilFunctions();
    @Given("^Ingreso a la URL del sitio web \"([^\"]*)\"\"([^\"]*)\"$")
    public void ingreso_a_la_url_del_sitio_web (String tipoFlujo, String jsonPath) throws Throwable {

        switch (tipoFlujo) {
            case "carroCompra":
                driverConfig.DataCarroCompra = dataJsonDao.getDataCarroCompra(jsonPath);
                break;
        }
        function.ingresarUrl("http://opencart.abstracta.us/");
        System.out.println("Ingreso la URL correctamente");
    }

}
