import java.util.Base64;
import java.util.Scanner;

public class EncodeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String encoded = Base64.getEncoder().encodeToString(input.getBytes());

        System.out.println(encoded);

        sc.close();
    }
}