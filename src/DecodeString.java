import java.util.Base64;
import java.util.Scanner;

public class DecodeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(input);
            String result = new String(decodedBytes);

            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Base64 input");
        }

        sc.close();
    }
}