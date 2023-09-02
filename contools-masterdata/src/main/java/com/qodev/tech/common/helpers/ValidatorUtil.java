package com.qodev.tech.common.helpers;

import java.text.*;
import java.util.regex.Pattern;

public class ValidatorUtil extends DateUtils {
    public Pattern ALPHANUM = Pattern.compile("^[a-zA-Z0-9]+$");
    public Pattern DIGIT = Pattern.compile("^[0-9]+$");
    public Pattern ALPHABET = Pattern.compile("^[a-zA-Z]+$");
    public Pattern WORD = Pattern.compile("^[a-zA-Z0-9_]+$");
    public Pattern EMAIL = Pattern.compile("^[_A-Za-z0-9-\\+]+([\\._A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    public Pattern TEXT = Pattern.compile("^[a-zA-Z0-9 _]+$");
    public Pattern COMPONENTID = Pattern.compile("^[_a-zA-Z]+([_a-zA-Z0-9]*)$");
    public Pattern NUMERIC = Pattern.compile("^[0-9]([0-9]*)*(\\.)*([0-9]*)*$");
    public Pattern INTEGERUNSIGNED = Pattern.compile("^[1-9]([0-9]*)*$");
    public DateFormat DATEFORMAT_FOR_LOOKUP_SETUP = new SimpleDateFormat("dd-MM-yyyy");
    public DateFormat DATEFORMAT = new SimpleDateFormat("dd-MMM-yyyy");
    public DateFormat DATETIMEFORMAT = new SimpleDateFormat("dd-MMM-yyyy kk:mm:ss");
    public Pattern PHONE_NUMBER = Pattern.compile("^[\\+]([0-9])*$");
    public Pattern ALPHABET_WITH_SPACE = Pattern.compile("^[a-zA-Z ]+$");
    public Pattern ALPHANUM_WITH_SPACE = Pattern.compile("^[a-zA-Z0-9 ]+$");
    public Pattern NPWP = Pattern.compile("^[0-9]{2}(\\.)[0-9]{3}(\\.)[0-9]{3}(\\.)[0-9](\\-)[0-9]{3}(\\.)[0-9]{3}$");
    public Pattern SYMBOLIC = Pattern.compile("[%$#@!^&*\\\\(\\\\)-_<>?/;:'\\\"\\\\\\\\|\\\\]\\\\[{},.]");

    public boolean matches(String str, Pattern pattern) {
        if (null == str || null == pattern) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    public boolean isAlphaNumeric(String str) {
        return matches(str, ALPHANUM);
    }

    public boolean isDigit(String str) {
        return matches(str, DIGIT);
    }

    public boolean isAlphabet(String str) {
        return matches(str, ALPHABET);
    }

    public boolean isWord(String str) {
        return matches(str, WORD);
    }

    public boolean isEmail(String str) {
        return matches(str, EMAIL);
    }

    public boolean isText(String str) {
        return matches(str, TEXT);
    }

    public boolean isComponentId(String str) {
        return matches(str, COMPONENTID);
    }

    public boolean isNumeric(String str) {
        if (matches(str, NUMERIC)) {
            String number = str.split("\\.")[0];
            if (number.length() > 1 && number.charAt(0) == '0') {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isDecimal(String str, int precision) {
        String pattern = "^(\\+|-)?([0-9]+(\\.[0-9]{0," + precision + "}+))$";
        Pattern DECIMAL = Pattern.compile(pattern);
        return matches(str, DECIMAL);
    }

    public boolean isCurrency(String str) {
        return isNumeric(str);
    }

    public boolean isValidDateTime(String str) {
        try {
            DATETIMEFORMAT.setLenient(false);
            String strDateTime = DATETIMEFORMAT.format(DATETIMEFORMAT
                    .parse(str));
            String[] splitDateTime = strDateTime.split(" ");
            if (splitDateTime.length == 2) {
                String[] splitDate = splitDateTime[0].split("-");
                if (splitDate.length == 3) {
                    int year = Integer.parseInt(splitDate[2]);
                    if (String.valueOf(year).length() != 4) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }

            return true;

        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isValidDateForLookupSetup(String str) {
        try {
            DATEFORMAT_FOR_LOOKUP_SETUP.setLenient(false);
            DATEFORMAT_FOR_LOOKUP_SETUP.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isValidDate(String str) {
        try {
            DATEFORMAT.setLenient(false);
            String strDate = DATEFORMAT.format(DATEFORMAT.parse(str));
            String[] splitDate = strDate.split("-");
            if (splitDate.length == 3) {
                int year = Integer.parseInt(splitDate[2]);
                if (String.valueOf(year).length() != 4) {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isIntegerUnsigned(String str) {
        return matches(str, INTEGERUNSIGNED);
    }

    public boolean isPhoneNumber(String str) {
        return matches(str, PHONE_NUMBER);
    }

    public boolean isAlphabetWithSpace(String str) {
        return matches(str, ALPHABET_WITH_SPACE);
    }

    public boolean isAlphanumWithSpace(String str) {
        return matches(str, ALPHANUM_WITH_SPACE);
    }

    public boolean isNPWP(String str) {
        return matches(str, NPWP);
    }

    public boolean isSymbol(String str) {
        return matches(str, SYMBOLIC);
    }
}
