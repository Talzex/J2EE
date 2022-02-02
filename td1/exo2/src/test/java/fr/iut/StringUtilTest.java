package fr.iut;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static fr.iut.StringUtil.prettyCurrencyPrint;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {
    @Test
    public void prettyCurrencyPrintTest(){
        String expected = "1 200,00 €";
        String found = prettyCurrencyPrint(1200, Locale.FRANCE);
        assertEquals(expected, found);
    }
}
