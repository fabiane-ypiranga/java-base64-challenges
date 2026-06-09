import Util.ConsoleColors;

import java.util.Base64;
import java.util.Scanner;

/*
 * Base64 Decoder Tool
 * Converte texto Base64 para texto normal
 */
public class DecodeString {

    public static void main(String[] args) {

        System.out.println(ConsoleColors.PURPLE + "\n========================");
        System.out.println("   BASE64 DECODER");
        System.out.println("========================" + ConsoleColors.RESET);

        Scanner sc = new Scanner(System.in);

        System.out.println(ConsoleColors.CYAN +
                "Enter Base64 string:" +
                ConsoleColors.RESET);

        String input = sc.nextLine();

        try {

            byte[] decodedBytes = Base64.getDecoder().decode(input);

            String result = new String(
                    decodedBytes,
                    java.nio.charset.StandardCharsets.UTF_8
            );

            System.out.println(ConsoleColors.GREEN +
                    "\n✔ Decoded text:" +
                    ConsoleColors.RESET);

            System.out.println(ConsoleColors.YELLOW + result + ConsoleColors.RESET);

        } catch (IllegalArgumentException e) {

            System.out.println(ConsoleColors.RED +
                    "✖ Invalid Base64 input!" +
                    ConsoleColors.RESET);
        }

        sc.close();
    }
}