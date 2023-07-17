package com.stripe.interview.languageparser;

import java.util.*;
import java.util.stream.Collectors;

public class AcceptLanguageParsers {

    private static AcceptLanguageParsers instance;
    private final List<String> supportedLanguages;
    private AcceptLanguageParsers(){
        supportedLanguages = Arrays.asList("en-US", "en-CA", "en-GB", "fr-FR", "es-ES");
    }

    public static AcceptLanguageParsers getInstance(){
        if(instance == null){
            instance = new AcceptLanguageParsers();
        }
        return instance;
    }

    public List<String> parseAcceptedLanguages(String acceptedLanguages) {
        Set<String> uniqueLanguages = new HashSet<>();

        if (acceptedLanguages != null && !acceptedLanguages.isEmpty()) {
            String[] requestedLanguages = acceptedLanguages.split(",");

            for (String requestedLanguage : requestedLanguages) {
                String trimmedLanguage = requestedLanguage.trim();

                if (trimmedLanguage.contains("*")) {
                    uniqueLanguages.addAll(supportedLanguages);
                } else {
                    for (String supportedLanguage : supportedLanguages) {
                        if (supportedLanguage.startsWith(trimmedLanguage)) {
                            uniqueLanguages.add(supportedLanguage);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(uniqueLanguages);
    }

    private Set<String> filterSupportedLanguages(String trimmedLanguage) {
        return supportedLanguages.stream()
                .filter(supportedLanguage -> startsWithIgnoreCase(supportedLanguage, trimmedLanguage))
                .collect(Collectors.toSet());
    }

    private boolean startsWithIgnoreCase(String str, String prefix) {
        return str.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static void main(String[] args) {

        AcceptLanguageParsers parser = AcceptLanguageParsers.getInstance();
        // Test case 1: Single language
        String acceptedLanguages1 = "en";
        List<String> parsedLanguages1 = parser.parseAcceptedLanguages(acceptedLanguages1);
        System.out.println("Accepted Languages 1:");
        for (String language : parsedLanguages1) {
            System.out.println(language);
        }
        System.out.println();

        // Test case 2: Multiple languages with wildcard
        String acceptedLanguages2 = "fr, *";
        List<String> parsedLanguages2 = parser.parseAcceptedLanguages(acceptedLanguages2);
        System.out.println("Accepted Languages 2:");
        for (String language : parsedLanguages2) {
            System.out.println(language);
        }
        System.out.println();

        // Test case 3: Non-region specific request
        String acceptedLanguages3 = "en";
        List<String> parsedLanguages3 = parser.parseAcceptedLanguages(acceptedLanguages3);
        System.out.println("Accepted Languages 3:");
        for (String language : parsedLanguages3) {
            System.out.println(language);
        }
        System.out.println();

        // Test case 4: No accepted languages specified
        String acceptedLanguages4 = "";
        List<String> parsedLanguages4 = parser.parseAcceptedLanguages(acceptedLanguages4);
        System.out.println("Accepted Languages 4:");
        for (String language : parsedLanguages4) {
            System.out.println(language);
        }
        System.out.println();
    }
}

