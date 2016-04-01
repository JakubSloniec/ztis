package pl.edu.agh.ztis.entity;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by kkicinger on 01/04/16.
 */
public enum Language {

    ENGLISH(Locale.ENGLISH),
    FRENCH(Locale.FRANCE),
    SPANISH(new Locale("es"));

    private Locale locale;

    Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }

    public static Language get(final String language) {
        return Arrays.asList(values()).stream().filter(l -> l.getLocale().getLanguage().equals(language)).findFirst().get();
    }

}
