import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class EncodeString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um texto: ");
        String input = scanner.nextLine();

        String encoded = Base64.getEncoder()
                .encodeToString(input.getBytes(StandardCharsets.UTF_8));

        System.out.println("Base64: " + encoded);
    }
}