import java.util.Scanner;

public class VowelChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;

        while (true) {
            System.out.print("Enter character (# to stop): ");
            ch = sc.next().charAt(0);

            if (ch == '#') break;

            switch (Character.toLowerCase(ch)) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    System.out.println("Vowel");
                    break;
                default:
                    System.out.println("Consonant");
            }
        }
        sc.close();
    }
}
