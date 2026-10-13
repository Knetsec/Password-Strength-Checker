*A Java desktop application that checks how strong a password really is — not just by length, but by entropy, character variety, and common password blacklisting.*

Built for simplicity: uses JOptionPane so anyone can run it without a console.
✨ What it does

    Interactive GUI — Uses JOptionPane.showInputDialog and showMessageDialog for all input/output
    Blacklists Weak Passwords — Maintains a Set<String> COMMON_PASSWORDS with 100+ most common passwords like password, 123456, qwerty, letmein
    Entropy in Bits — Calculates true randomness: entropy = password_length * log2(charset_pool)
    Enum-Based Levels — Clean StrengthLevel enum to avoid magic strings:
    VERY_WEAK, WEAK, FAIR, STRONG, VERY_STRONG

*🧠 How Strength is Decided*

enum StrengthLevel {
    VERY_WEAK,
    WEAK,
    FAIR,
    STRONG,
    VERY_STRONG
}

    Check if password exists in COMMON_PASSWORDS → instantly VERY_WEAK
    Calculate charset pool:
        lowercase = 26
        uppercase = 26
        digits = 10
        symbols = 32
    Calculate entropy bits
    Map to enum:

Entropy	Level
< 28 bits	VERY_WEAK
28 - 35 bits	WEAK
36 - 59 bits	FAIR
60 - 127 bits	STRONG
128+ bits	VERY_STRONG
🛠️ Built With

    Java 17+
    Java Swing - JOptionPane
    java.util.Set / Set<String>
    Java Enums

*🚀 How to Run*

    Clone

git clone https://github.com/thatgentnuni/password-strength-checker.git

    Open PasswordStrengthChecker.java in IntelliJ / Eclipse / NetBeans

    Run - a dialog will pop up asking for a password.

*📸 Demo*

Input: password123
> VERY_WEAK | Entropy: 28.5 bits | Reason: Found in common passwords list
Input: P@ssw0rd!
> FAIR | Entropy: 52.3 bits | Uses 4 charset types but short
Input: correct-horse-battery-staple!
> VERY_STRONG | Entropy: 155.2 bits | Great length + randomness



* Future Improvements*

    Add password generator
    Add show/hide toggle in dialog
    Export strength report

*👤 Author*

Built by Keamohetsoe (kNetSec). — learning secure coding practices and GUI design in Java.
📄 License

MIT License - free to use, modify and share.
