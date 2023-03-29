package utilFunction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readProperties {
    private static Properties prop = null;
    public static Properties propertiesRead() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
            prop.load(ip);
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
