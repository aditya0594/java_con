package SeleniumTopic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class validates_usernames_validation {
    /**
     Only alphanumeric characters (letters and numbers).
     No spaces or special characters.
     No duplicate usernames allowed.
     **/

        // Set to store unique usernames
        private static HashSet<String> usernames = new HashSet<>();

        // Regex to allow only alphanumeric characters
        private static final Pattern VALID_USERNAME = Pattern.compile("^[a-zA-Z0-9]+$");

        public static boolean isValid(String username) {
            if (!VALID_USERNAME.matcher(username).matches()) {
                System.out.println("❌ Invalid: Only alphanumeric characters allowed.");
                return false;
            }
            if (usernames.contains(username)) {
                System.out.println("❌ Invalid: Duplicate username.");
                return false;
            }
            // If valid, add to the set
            usernames.add(username);
            System.out.println("✅ Username accepted.");
            return true;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter usernames to validate (type 'exit' to stop):");

            while (true) {
                System.out.print("Username: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                isValid(input);
            }

            scanner.close();
        }
    }

