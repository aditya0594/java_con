package StepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
        private static Properties properties;

        static {
            try {
                FileInputStream fis = new FileInputStream("src/test/java/StepDefination/config.properties");
                properties = new Properties();
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("config.properties file not found.");
            }
        }

        public static String get(String key) {
            return properties.getProperty(key);
        }
    }
