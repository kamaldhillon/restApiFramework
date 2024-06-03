package propertymanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiProperties {

    private ApiProperties() {

    }

    private static final String PROPERTIES_FILE = "Api.properties";
    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(ApiProperties.class);

    static {

        logger.info("Loading Web Property");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            logger.error("Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");

        }

        try {
            properties.load(propertiesFile);
        } catch (IOException e) {
            logger.error("Cannot load properties file :'" + PROPERTIES_FILE + "'");
        }
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }

    public static String getProperty(String name, String defaultValue) {
        return properties.getProperty(name, defaultValue);
    }


    public static void setProperty(String name, String value) {
        properties.setProperty(name, value);
    }
}
