package assessment.fin_tech_app.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static assessment.fin_tech_app.utils.Constants.passwordRegex;

public class Utils {

    public static boolean isValidMobileNumber(String mobileNumber) {

        Pattern pattern = Pattern.compile(Constants.mobileRegex);
        Matcher matcher = pattern.matcher(mobileNumber);

        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {

        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
