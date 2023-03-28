package run;

import driver.driverConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/carroCompra.feature",
        glue = {"steps", "driverConfig"},
        plugin = {"pretty",
                "json:reportes/Json-Report_CarroCompra/ExtentJson.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@CarroCompras"
)
public class CarroCompraRunner extends driverConfig {
    @AfterClass
    public static void writeExtentReport() throws IOException {
        // ** Limpia la instancia de WebDriver a nivel S.O. **
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        driver.quit();
    }
}
