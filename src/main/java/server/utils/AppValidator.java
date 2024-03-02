package server.utils;

import java.util.HashMap;
import java.util.Map;

public class AppValidator {

    private final static String INPUT_REQ_MSG = "Input required.";

    private final static String ID_RGX = "^[1-9]$";

    private final static String WRONG_ID_MSG = "Wrong id input.";
    private final static String WRONG_PHONE_MSG = "Wrong phone input";

    public final static String PHONE_RGX = "[0-9]{10}";

    public static boolean isIdValid(String id) {
        if (id != null)
            return id.isEmpty() || !id.matches(ID_RGX);
        return false;
    }

    public static boolean isPhoneValid(String phone) {
        if (phone != null)
            return phone.isEmpty() || !phone.matches(PHONE_RGX);
        return false;
    }

    public Map<String, String> validateContactDataCreate(String[] data) {
        Map<String, String> errors = new HashMap<>();
        if (data[0] != null && data[0].isEmpty())
            errors.put("name", INPUT_REQ_MSG);
        if (data[1] != null && isPhoneValid(data[1]))
            errors.put("phone", WRONG_PHONE_MSG);
        return errors;
    }

    public Map<String, String> validateContactDataUpdate(String[] data) {
        Map<String, String> errors = new HashMap<>();
        if (data[0] != null && isIdValid(data[0]))
            errors.put("id", WRONG_ID_MSG);
        if (data[1] != null && data[1].isEmpty())
            errors.put("name", INPUT_REQ_MSG);
        if (data[2] != null && isPhoneValid(data[2]))
            errors.put("phone", WRONG_PHONE_MSG);
        return errors;
    }

    public Map<String, String> validateContactDataDelete(String[] data) {
        Map<String, String> errors = new HashMap<>();
        if (isIdValid(data[0]))
            errors.put("id", WRONG_ID_MSG);
        return errors;
    }

    public Map<String, String> validateContactDataReadById(String[] data) {
        Map<String, String> errors = new HashMap<>();
        if (isIdValid(data[0]))
            errors.put("id", WRONG_ID_MSG);
        return errors;
    }

}
