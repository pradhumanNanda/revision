package com.activity.revision.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperUtil {

    public static boolean isMobileValid(String customerMobile) {
        Pattern p = Pattern.compile("[6-9][0-9]{9}");
        Matcher m = p.matcher(customerMobile);
        boolean result = m.matches();
        return result;
    }

    public static boolean isPincodeValid(String pincode) {
        Pattern p = Pattern.compile("[0-9]{6}");
        Matcher m = p.matcher(pincode);
        boolean result = m.matches();
        return result;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0 || s.trim().equals("") ||
                s.trim().equalsIgnoreCase("null");
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        if (isNullOrEmpty(email)) {
            return false;
        }
        String expression = "^(.+)@(.+)$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static String maskString(String strText, int start, int end, char maskChar) throws Exception {
        if (strText == null || strText.equals(""))
            return "";

        if (start < 0)
            start = 0;

        if (end > strText.length())
            end = strText.length();

        if (start > end)
            throw new RuntimeException("End index cannot be greater than start index");

        int maskLength = end - start;

        if (maskLength == 0)
            return strText;

        StringBuilder sbMaskString = new StringBuilder(maskLength);

        for (int i = 0; i < maskLength; i++) {
            sbMaskString.append(maskChar);
        }

        return strText.substring(0, start) + sbMaskString.toString() +
                strText.substring(start + maskLength);
    }

    public static boolean isPanCardValid(String panCardNo) {
        if (HelperUtil.isNullOrEmpty(panCardNo)) {
            return false;
        }
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(panCardNo);
        return m.matches();
    }

}
