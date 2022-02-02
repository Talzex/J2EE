package fr.iut;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtil {
    /**
     * This method show the amount gave with the format of the location gave with the currency of this location
     * @param amount the amount of currency
     * @param locale the location to choose
     * @return a string with the number formatted
     */
        public static String prettyCurrencyPrint(final double amount, final Locale locale){
            return NumberFormat.getCurrencyInstance(locale).format(amount);
        }
        }
