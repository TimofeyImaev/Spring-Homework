package edu.java.bot;

import java.net.URI;

public class URLParser {
    private URLParser() {

    }

    public static String parse(URI url) {
        return url.getPath().split("/")[2];
    }
}
