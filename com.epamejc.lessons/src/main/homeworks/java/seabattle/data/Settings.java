package homeworks.java.seabattle.data;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.Properties;

public class Settings {

      private Properties properties = new Properties();
    private String propertiesFilePath =
            "com.epamejc.lessons/src/resources/seabattle.config";

    @SneakyThrows
    public Settings() {

        properties.load(new FileReader(propertiesFilePath));

    }

    public Properties getProperties() {

        return properties;

    }

}
