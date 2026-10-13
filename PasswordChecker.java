import javax.swing.JOptionPane; //Reading the password from a dialog box
import java.util.Set;	//toring the common-password denylist
  public class PasswordChecker {

    enum Strength {
        VERY_WEAK, WEAK, MEDIUM, STRONG, VERY_STRONG
    }

    private static final Set<String> COMMON_PASSWORDS = Set.of(
            "123456", "password", "123456789", "12345678", "12345", "111111", "1234567",
            "sunshine", "qwerty", "iloveyou", "princess", "admin", "welcome", "666666", "abc123");
    
    public static void main(String[] args) {
        String password = JOptionPane.showInputDialog(
                null,
                "Enter a password to check:",
                "Password Checker",
                JOptionPane.QUESTION_MESSAGE);

        // User pressed Cancel or closed the dialog
        if (password == null) {
            System.exit(0);
        }

        double entropy = entropyBits(password);
        Strength strength;

        if (entropy < 28) {
            strength = Strength.VERY_WEAK;
        } else if (entropy < 36) {
            strength = Strength.WEAK;
        } else if (entropy < 60) {
            strength = Strength.MEDIUM;
        } else if (entropy < 128) {
            strength = Strength.STRONG;
        } else {
            strength = Strength.VERY_STRONG;
        }

        JOptionPane.showMessageDialog(
                null,
                "Entropy: " + String.format("%.1f", entropy) + " bits\n"
                        + "Strength: " + strength,
                "Result",
                JOptionPane.INFORMATION_MESSAGE);
    }

    static double entropyBits(String password) {
        int pool = 0;
        if (password.matches(".*[a-z].*")) pool += 26;
        if (password.matches(".*[A-Z].*")) pool += 26;
        if (password.matches(".*[0-9].*")) pool += 10;
        if (password.matches(".*[^a-zA-Z0-9].*")) pool += 32;
        if (pool == 0) return 0;
        return password.length() * (Math.log(pool) / Math.log(2));
    }
}

