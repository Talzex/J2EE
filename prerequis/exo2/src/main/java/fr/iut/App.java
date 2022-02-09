package fr.iut;
import java.util.Locale;

public class App {
    
    public static void main(String[] args) {
        String texte = StringUtil.prettyCurrencyPrint(21500.390, Locale.KOREA);
        System.out.println(texte);

    }
    
}
