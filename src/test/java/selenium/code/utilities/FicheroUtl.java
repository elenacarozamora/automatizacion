package selenium.code.utilities;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static selenium.code.controller.BaseControllerAbstract.getRuta;


public class FicheroUtl {
    private static final JsonObject json = new JsonObject();
    private final JsonParser parser = new JsonParser();

    public static void crearJsonFile() throws IOException {
        FileWriter file = new FileWriter(getRuta());
        file.write(json.toString());
    }

    public static void writeJsonFile(String val, String text) {
        json.put(val, text);
    }

    public static void eliminarJsonFile() throws IOException {
        File file = new File(getRuta());
        file.delete();
    }

}