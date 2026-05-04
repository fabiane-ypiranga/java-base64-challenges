import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

public class StreamFileEncoder {

    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output_stream.txt";

        try (
                FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile);
                OutputStream base64Out = Base64.getEncoder().wrap(fos)
        ) {

            byte[] buffer = new byte[8192]; // 8KB
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                base64Out.write(buffer, 0, bytesRead);
            }

            System.out.println("Arquivo codificado com stream com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}