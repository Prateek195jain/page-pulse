package com.prateek.pagepulse.util;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlValidator {

    public static boolean isValid(String url) {

        if (url == null || url.isBlank()) {
            return false;
        }

        try {

            URI uri = new URI(url);

            return uri.getScheme() != null
                    && uri.getHost() != null
                    && (uri.getScheme().equalsIgnoreCase("http")
                    || uri.getScheme().equalsIgnoreCase("https"));

        } catch (URISyntaxException e) {
            return false;
        }
    }
}