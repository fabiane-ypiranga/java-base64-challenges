import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

public class StreamFileEncoder {

    public static void main(String[] args) {

        // Arquivo entrada
        String inputFile =
                "input.txt";

        // Arquivo saída
        String outputFile =
                "output_stream.txt";

        try (

                // Lê arquivo
                FileInputStream fis =
                        new FileInputStream(
                                inputFile
                        );

                // Cria arquivo saída
                FileOutputStream fos =
                        new FileOutputStream(
                                outputFile
                        );

                // Converte saída para Base64
                OutputStream base64Out =
                        Base64.getEncoder()
                                .wrap(fos)
        ) {

            // Buffer de leitura (8KB)
            byte[] buffer =
                    new byte[8192];

            int bytesRead;

            // Lê arquivo aos poucos
            while ((bytesRead =
                    fis.read(buffer))
                    != -1) {

                // Escreve no arquivo Base64
                base64Out.write(
                        buffer,
                        0,
                        bytesRead
                );
            }

            // Mensagem sucesso
            System.out.println(
                    "Arquivo codificado com stream com sucesso!"
            );

        } catch (Exception e) {

            // Mostra erro
            System.out.println(
                    "Erro: "
                            + e.getMessage()
            );
        }
    }
}