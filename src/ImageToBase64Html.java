import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class ImageToBase64Html {

    public static void main(String[] args) throws Exception {

        Path imagePath = Path.of("image.png");

        byte[] imageBytes = Files.readAllBytes(imagePath);

        String base64 = Base64.getEncoder().encodeToString(imageBytes);

        String html = "<html><body><img src=\"data:image/png;base64,"
                + base64 + "\"/></body></html>";

        Files.writeString(Path.of("image.html"), html);

        System.out.println("HTML gerado com sucesso!");
    }
}