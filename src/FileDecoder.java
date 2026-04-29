import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class FileDecoder {
    public static void main(String[] args) throws Exception {

        Path inputPath = Path.of("output.txt");

        String base64 = Files.readString(inputPath);

        byte[] decodedBytes = Base64.getDecoder().decode(base64);

        Path outputPath = Path.of("restored.txt");
        Files.write(outputPath, decodedBytes);

        System.out.println("Arquivo restaurado com sucesso!");
    }
}