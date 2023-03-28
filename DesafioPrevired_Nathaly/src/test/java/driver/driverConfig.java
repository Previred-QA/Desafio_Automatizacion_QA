package driver;

import model.dataCarroCompra;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static utilFunction.readProperties.propertiesRead;


@RunWith(Suite.class)
public class driverConfig {
    public static dataCarroCompra DataCarroCompra = new dataCarroCompra();
    public static RemoteWebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        String navegador = propertiesRead().getProperty("navegador").toLowerCase();
        setDriverSeleniumWD(navegador);
    }
    public static void setDriverSeleniumWD(String navegador) throws Exception {
        switch (navegador) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
                driver.manage().window().maximize();
                break;
        }
    }


}
