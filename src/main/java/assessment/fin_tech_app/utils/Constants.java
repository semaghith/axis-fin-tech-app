package assessment.fin_tech_app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constants {

    public static String mobileRegex = "^(?:\\+20|0020|0)?1[0-2,5,7]\\d{8}$";
    public static String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    boolean isValidMobileNumber(String mobileNumber) {

        Pattern pattern = Pattern.compile(mobileRegex);
        Matcher matcher = pattern.matcher(mobileNumber);

        return matcher.matches();
    }

    public static class SuccessMessages {

        public static final String ACCOUNT_CREATED_SUCCESSFULLY = "Account created successfully.";
    }

    public static class ErrorMessages {

        public static final String USERNAME_ALREADY_EXISTS = "Username already exists!";
        public static final String INVALID_MOBILE_NUMBER = "Invalid mobile number format!";
        public static final String INVALID_PASSWORD = "Invalid password format!";
        public static final String WRONG_USERNAME_OR_PASSWORD = "Wrong username or password!";
        public static final String USER_NOT_FOUND = "User not found!";
    }
}
