import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class DecodeString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um Base64: ");
        String input = scanner.nextLine();

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(input);
            String decoded = new String(decodedBytes, StandardCharsets.UTF_8);

            System.out.println("Texto original: " + decoded);
        } catch (IllegalArgumentException e) {
            System.out.println("Base64 inválido!");
        }
    }
}