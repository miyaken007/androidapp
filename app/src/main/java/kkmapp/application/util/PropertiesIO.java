package kkmapp.application.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesIO {

    public static ExtendedProperties loadEProperties(String url, Context context) {
        ExtendedProperties properties = new ExtendedProperties();
        try {
            InputStream inputStream = context.getAssets().open(url);
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bReader = new BufferedReader(reader);
            properties.load(bReader);
            inputStream.close();
        }

        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return properties;
    }

    public static void saveProperties(Properties properties, String comments, File file) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            properties.store(outputStream, comments);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void saveProperties(Properties properties, String comments, String url) {
	    saveProperties(properties, comments, new File(url));
    }

	public static void saveProperties(ExtendedProperties properties, String comments, File file) {
	    try {
            OutputStream outputStream = new FileOutputStream(file);
            properties.storeWithoutTimeStamp(outputStream, comments);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void saveProperties(ExtendedProperties properties, String comments, String url) {
	    saveProperties(properties, comments, new File(url));
    }
}
