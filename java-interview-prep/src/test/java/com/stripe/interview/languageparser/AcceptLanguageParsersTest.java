package com.stripe.interview.languageparser;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class AcceptLanguageParsersTest{
    private AcceptLanguageParsers parser;

    @Before
    public void setup(){
        parser = AcceptLanguageParsers.getInstance();
    }

    @Test
    public void testParseAcceptedLanguages_SingleLanguage() {
        String acceptedLanguages = "en";
        List<String> parsedLanguages = parser.parseAcceptedLanguages(acceptedLanguages);
        Assert.assertEquals(3, parsedLanguages.size());
        Assert.assertTrue(parsedLanguages.contains("en-US"));
    }

    @Test
    public void testParseAcceptedLanguages_MultipleLanguagesWithWildcard() {
        String acceptedLanguages = "fr, *";
        List<String> parsedLanguages = parser.parseAcceptedLanguages(acceptedLanguages);
        Assert.assertEquals(5, parsedLanguages.size());
        Assert.assertTrue(parsedLanguages.contains("fr-FR"));
    }

    @Test
    public void testParseAcceptedLanguages_NonRegionSpecificRequest() {
        String acceptedLanguages = "en";
        List<String> parsedLanguages = parser.parseAcceptedLanguages(acceptedLanguages);
        Assert.assertEquals(3, parsedLanguages.size());
        Assert.assertTrue(parsedLanguages.contains("en-US"));
    }

    @Test
    public void testParseAcceptedLanguages_NoAcceptedLanguagesSpecified() {
        String acceptedLanguages = "";
        List<String> parsedLanguages = parser.parseAcceptedLanguages(acceptedLanguages);
        Assert.assertEquals(0, parsedLanguages.size());
    }

}