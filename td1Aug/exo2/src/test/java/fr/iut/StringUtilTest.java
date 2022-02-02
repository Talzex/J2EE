package fr.iut;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.lang.*;

public class StringUtilTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(StringUtil.prettyCurrencyPrint(3020, Locale.FRANCE).equals("3020.0€") );
    }

}


