package lessons.lesson14.example10;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Main {
    
    public static void main(String[] a) throws IOException {
        Properties props = System.getProperties();
        Iterator iter = props.entrySet()
                             .iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
        
        Properties properties = new Properties();
        properties.
                          load(new FileReader(
                                  "C:\\Users\\Vladislav_Rospuskov\\IdeaProjects\\epamejc2020\\com.epamejc" +
                                  ".lessons\\src\\resources\\application.properties"));
        String key = properties.getProperty("keyasdf");
        System.out.println(key);

//        Collections.shuffle(new ArrayList<>(), new Random());
    }
    
}
