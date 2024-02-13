package utilities;

import com.github.cliftonlabs.json_simple.JsonObject;

import java.io.File;


public class FicheroUtl {

    public JsonObject crearJsonFile() {
        return new JsonObject();
    }

    public boolean eliminarJsonFile(String ruta) {
        File file = new File(ruta);
        return file.delete();
    }

}