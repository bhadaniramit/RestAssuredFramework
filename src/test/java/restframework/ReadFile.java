package restframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadFile {
    String filePathWithOutFileName = System.getProperty("user.dir") + File.separator +
            "src/test/resources/Propertiesfile/";

    public Set<Object> readPropertiesFile(String fileName) throws IOException {
        String filePath = filePathWithOutFileName + fileName;
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        return prop.keySet();
    }
}
