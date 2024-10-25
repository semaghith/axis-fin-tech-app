package assessment.fin_tech_app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidators {

    public static boolean isValidMobileNumber(String mobileNumber) {

        Pattern pattern = Pattern.compile(Constants.mobileRegex);
        Matcher matcher = pattern.matcher(mobileNumber);

        return matcher.matches();
    }
}
