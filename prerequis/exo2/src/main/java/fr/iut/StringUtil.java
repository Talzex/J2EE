package fr.iut;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *  String utility class
 */
public class StringUtil {

    /**
     * @param v, la valeur
     * @param locale, la monnaie du pays en question
     * @return, le prix du pays
     */
    public static String prettyCurrencyPrint(final double v, final Locale locale){
        Locale currentLocale = locale;
        return NumberFormat.getCurrencyInstance(currentLocale).format(v);
    }
}
