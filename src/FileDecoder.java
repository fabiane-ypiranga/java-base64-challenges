import Util.ConsoleColors;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

/*
 * File Decoder
 * Restaura um arquivo Base64 para texto normal
 */
public class FileDecoder {

    public static void main(String[] args) {

        System.out.println(ConsoleColors.PURPLE +
                "\n========================");
        System.out.println("     FILE DECODER");
        System.out.println("========================"
                + ConsoleColors.RESET);

        Scanner sc = new Scanner(System.in);

        try {

            // Caminho do arquivo Base64
            System.out.println(ConsoleColors.CYAN +
                    "📂 Enter Base64 file path:" +
                    ConsoleColors.RESET);

            String filePath =
                    sc.nextLine();

            Path inputPath =
                    Path.of(filePath);

            System.out.println(ConsoleColors.CYAN +
                    "📂 Reading file: " + inputPath +
                    ConsoleColors.RESET);

            // Lê conteúdo do arquivo
            String base64 =
                    Files.readString(inputPath);

            // Decodifica Base64
            byte[] decodedBytes =
                    Base64.getDecoder()
                            .decode(base64);

            // Caminho do arquivo restaurado
            Path outputPath =
                    Path.of("restored.txt");

            // Salva arquivo restaurado
            Files.write(
                    outputPath,
                    decodedBytes
            );

            // Sucesso
            System.out.println(ConsoleColors.GREEN +
                    "\n✔ File restored successfully!" +
                    ConsoleColors.RESET);

            System.out.println(ConsoleColors.YELLOW +
                    "📄 Output file: " + outputPath +
                    ConsoleColors.RESET);

            // Comparação dos arquivos
            System.out.println(ConsoleColors.CYAN +
                    "\n📂 Enter original file path to compare:" +
                    ConsoleColors.RESET);

            String originalFile =
                    sc.nextLine();

            boolean match =
                    Arrays.equals(
                            Files.readAllBytes(
                                    Path.of(originalFile)
                            ),
                            Files.readAllBytes(
                                    outputPath
                            )
                    );

            if (match) {

                System.out.println(ConsoleColors.GREEN +
                        "✔ Files match!" +
                        ConsoleColors.RESET);

            } else {

                System.out.println(ConsoleColors.RED +
                        "✖ Files differ!" +
                        ConsoleColors.RESET);
            }

        } catch (IllegalArgumentException e) {

            System.out.println(ConsoleColors.RED +
                    "✖ Invalid Base64 file!" +
                    ConsoleColors.RESET);

        } catch (Exception e) {

            // Erro
            System.out.println(ConsoleColors.RED +
                    "✖ Error: " + e.getMessage() +
                    ConsoleColors.RESET);
        }

        sc.close();
    }
}