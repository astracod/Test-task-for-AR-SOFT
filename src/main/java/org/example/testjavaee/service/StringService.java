package org.example.testjavaee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StringService {

    public String answer(String text) {
        String regex = "([а-яА-ЯёЁ](?!\\s))";
        return text.replaceAll(regex, ("$0   "));
    }

    public String reductionToNumber(String text) {
        String a = text.toUpperCase(Locale.forLanguageTag(text));
        List<String> stringList = new ArrayList<>(a.length());
        for (int i = 0; i <= a.length() - 1; i++) {
            int code = getAlphabetNumber(a.charAt(i));
            if (code == -1) {
                stringList.add("");
            } else {
                stringList.add(String.valueOf(code));
            }
        }
        return String.join("  ", stringList);
    }

    /**
     * кодировка символов DEC
     * 1040-1045 от А - Е
     * 1025 - Ё
     * 1046 - 1103 от Ж - я
     *
     * @param c
     * @return
     */
    private int getAlphabetNumber(char c) {
        if (c <= 1045 && c >= 1040) {
            return c - 1039;
        } else if (c == 1025) {
            return c - 1018;
        } else if (c > 1045 && c <= 1103) {
            return c - 1038;
        }
        return -1;
    }
}



















