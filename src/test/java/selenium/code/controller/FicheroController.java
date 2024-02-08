package selenium.code.controller;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroController extends BaseControllerAbstract {
    private static final JsonObject json = new JsonObject();
    private final JsonParser parser = new JsonParser();

    public static void crearJson(WebDriver driver) throws IOException {
        FileWriter file = new FileWriter(getRuta());
        file.write(json.toString());
    }

    public static void writeJson(String val, String text) {
        json.put(val, text);
    }

    public static boolean eliminarJson() throws IOException {
        File file = new File(getRuta());
        return file.delete();
    }


}