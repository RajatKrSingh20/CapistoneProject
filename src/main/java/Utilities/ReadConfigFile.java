package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {


    Properties properties;
    FileInputStream inputStream;

    public ReadConfigFile() {

        try {
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties";
            properties = new Properties();
            inputStream = new FileInputStream(path);
            properties.load(inputStream);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String getUrl() {

        return properties.getProperty("url");

    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }
}






