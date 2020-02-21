package homeworks.java.seabattle.resources;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.Properties;

public class Settings {

      private Properties properties = new Properties();
    private String propertiesFilePath =
            "com.epamejc.lessons/src/main/homeworks/java/seabattle/resources/application.config";

    @SneakyThrows
    public Settings() {

        properties.load(new FileReader(propertiesFilePath));

    }

    public Properties getProperties() {

        return properties;

    }

}
