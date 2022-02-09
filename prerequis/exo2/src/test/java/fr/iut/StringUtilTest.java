package fr.iut;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertEquals("21 500,39 €",StringUtil.prettyCurrencyPrint(21500.390, Locale.FRANCE));
        assertEquals("$21,500.39",StringUtil.prettyCurrencyPrint(21500.390, Locale.US));
        assertEquals("£21,500.39",StringUtil.prettyCurrencyPrint(21500.390, Locale.UK));
        assertEquals("￥21,500",StringUtil.prettyCurrencyPrint(21500.390, Locale.JAPAN));
    }

}
