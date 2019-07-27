package co.edu.uptc.sw2.desingmatch.tools;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.io.FileUtils;

public class FilesManager {

    public static final String PATH = "C:\\img";

    /* public static String guardarImagenEnDisco(InputStream input) throws IOException {
     BufferedImage image1 = ImageIO.read(input);
        ImageIO.write(image1, "png", new File(PATH + "\\r.png"));
        return "Guarda";
    }*/
    public static String guardarImagenEnDisco(String base64String, String name) {
        String[] strings = base64String.split(",");
        String extension = "png";
        //convert base64 string to binary data
        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
        String path = PATH + "\\" + name + "." + extension;
        File file = new File(path);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
            return path;
        } catch (IOException e) {
            return "Error al guardar";
        }
    }

    public static List<String>  imgToBase64(String path) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(path));
        String aux = Base64.getEncoder().encodeToString(fileContent);
        List<String> l = new ArrayList<>();
        l.add(aux);
        return l;
    }
}
