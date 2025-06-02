package SeleniumTopic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Read_properties_File {
    public static Properties read_properties() throws IOException {
        FileInputStream file = new FileInputStream("src/main/resources/config.properties");
        Properties prop = new Properties();
        prop.load(file);
        return prop;
    }

    public static void main(String[] args) throws IOException {
       String browsername =  read_properties().getProperty("browserName");
        System.out.println("this is the values from  : " +browsername);
    }
}
