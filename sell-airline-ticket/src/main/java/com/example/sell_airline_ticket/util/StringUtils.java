package com.example.sell_airline_ticket.util;

import java.util.Locale;

public class StringUtils {
    public static String capitalizeAndTrim(String input) {
        /*Delete redundant spaces*/
        String trimmed = input.trim().replaceAll("\\s+", " ");
        /*Capitalize*/
        StringBuilder result = new StringBuilder();
        String[] words = trimmed.split(" ");

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return result.toString().trim();
    }
}
