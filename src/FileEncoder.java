import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class FileEncoder {
    public static void main(String[] args) throws Exception {

        Path inputPath = Path.of("input.txt");

        byte[] fileBytes = Files.readAllBytes(inputPath);

        String encoded = Base64.getEncoder().encodeToString(fileBytes);

        Path outputPath = Path.of("output.txt");
        Files.writeString(outputPath, encoded);

        System.out.println("Arquivo codificado com sucesso!");
    }
}