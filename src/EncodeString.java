import Util.ConsoleColors;

import java.util.Base64;
import java.util.Scanner;

/*
 * Base64 Encoder Tool
 * Converte texto normal para Base64
 */
public class EncodeString {

    public static void main(String[] args) {

        // Cabeçalho do sistema
        System.out.println(ConsoleColors.PURPLE +
                "\n========================");
        System.out.println("   BASE64 ENCODER");
        System.out.println("========================"
                + ConsoleColors.RESET);

        // Scanner para ler texto
        Scanner sc = new Scanner(System.in);

        // Solicita texto ao usuário
        System.out.println(ConsoleColors.CYAN +
                "Enter text to encode:" +
                ConsoleColors.RESET);

        // Texto digitado
        String input = sc.nextLine();

        // Converte texto para Base64
        String encoded = Base64.getEncoder()
                .encodeToString(
                        input.getBytes(
                                java.nio.charset.StandardCharsets.UTF_8
                        )
                );

        // Resultado
        System.out.println(ConsoleColors.GREEN +
                "\n✔ Encoded text:" +
                ConsoleColors.RESET);

        System.out.println(ConsoleColors.YELLOW +
                encoded +
                ConsoleColors.RESET);

        // Fecha scanner
        sc.close();
    }
}