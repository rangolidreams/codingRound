package codinground.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadingTestData {

    private static Properties props = new Properties();

    static {
        FileInputStream in = null;
        try {
            in =
                    new FileInputStream(System.getProperty("user.dir")
                            + File.separator + "testData" + File.separator + "TestData.properties");
            props.load(in);
        } catch (IOException e) {
            System.err.println("Failed to read: "
                    + "TestData.properties");
        }
    }
    public static String getData(String locatorName) {
        String locvalue = props.getProperty(locatorName);
        return locvalue;

    }


}
