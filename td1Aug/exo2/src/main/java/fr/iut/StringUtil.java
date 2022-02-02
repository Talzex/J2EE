package fr.iut;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Currency;

public class StringUtil {
    /**
     * return the amount + the current currency symbol of the Locale
     * @param amount
     * @param locale
     * @return
     */
    public static String prettyCurrencyPrint(final double amount, final Locale locale){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setCurrency(Currency.getInstance(locale));
        String values = amount + nf.getCurrency().getSymbol();

        return (values);
    }
}
