import Util.ConsoleColors;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Scanner;

/*
 * File Encoder
 * Converte um arquivo para Base64
 */
public class FileEncoder {

    public static void main(String[] args) {

        System.out.println(ConsoleColors.PURPLE +
                "\n========================");
        System.out.println("     FILE ENCODER");
        System.out.println("========================"
                + ConsoleColors.RESET);

        Scanner sc = new Scanner(System.in);

        try {

            // Caminho do arquivo original
            System.out.println(ConsoleColors.CYAN +
                    "📂 Enter file path:" +
                    ConsoleColors.RESET);

            String filePath = sc.nextLine();

            Path inputPath =
                    Path.of(filePath);

            System.out.println(ConsoleColors.CYAN +
                    "📂 Reading file: "
                    + inputPath +
                    ConsoleColors.RESET);

            // Lê conteúdo do arquivo
            byte[] fileBytes =
                    Files.readAllBytes(
                            inputPath
                    );

            // Converte para Base64
            String encoded =
                    Base64.getEncoder()
                            .encodeToString(
                                    fileBytes
                            );

            // Nome automático do output
            String outputFile =
                    inputPath.getFileName()
                            + ".b64.txt";

            // Caminho do arquivo de saída
            Path outputPath =
                    Path.of(outputFile);

            // Salva Base64 no arquivo
            Files.writeString(
                    outputPath,
                    encoded
            );

            // Sucesso
            System.out.println(ConsoleColors.GREEN +
                    "\n✔ File encoded successfully!" +
                    ConsoleColors.RESET);

            System.out.println(ConsoleColors.YELLOW +
                    "📄 Output file: "
                    + outputPath +
                    ConsoleColors.RESET);

        } catch (Exception e) {

            // Erro
            System.out.println(ConsoleColors.RED +
                    "✖ Error: "
                    + e.getMessage() +
                    ConsoleColors.RESET);
        }

        sc.close();
    }
}