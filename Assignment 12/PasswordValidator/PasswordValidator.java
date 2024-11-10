public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        // Check length requirement
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Define regex patterns for each category
        String lowerCasePattern = ".*[a-z].*";
        String upperCasePattern = ".*[A-Z].*";
        String digitPattern = ".*[0-9].*";
        String specialCharPattern = ".*[~!@#$%^&*()\\-=+_].*";

        // Count how many categories the password satisfies
        int categories = 0;
        if (password.matches(lowerCasePattern)) {
            categories++;
        }
        if (password.matches(upperCasePattern)) {
            categories++;
        }
        if (password.matches(digitPattern)) {
            categories++;
        }
        if (password.matches(specialCharPattern)) {
            categories++;
        }

        // Check if at least three categories are satisfied
        return categories >= 3;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
                "P@ssw0rd",
                "12345678",
                "abcdefgH",
                "!@#Ab1",
                "password",
                "Abc@1234",
                "Short1!",
                "LongPassword123@456"
        };

        for (String password : passwords) {
            System.out.println("Password: \"" + password + "\" is valid: " + isValidPassword(password));
        }
    }
}
