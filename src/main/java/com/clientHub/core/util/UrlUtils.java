package com.clientHub.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlUtils {

    public static String extractWrongZipFromUrl(String url) {
        String regex = ".*/ws/(\\d+)/json/?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return matcher.group(1);
        }

        throw new IllegalArgumentException("ZIP code not found in the URL");
    }



}
