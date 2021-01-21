package webdrivertask.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
    private static ResourceBundle resourceBundleEngine = ResourceBundle.getBundle(System.getProperty("engineEnvironment"));

    public static String getTestData(String key) {return resourceBundle.getString(key);}
    public static String getTestDataEngine(String key) {return resourceBundleEngine.getString(key);}
}
