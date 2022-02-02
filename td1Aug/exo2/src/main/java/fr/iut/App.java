package fr.iut;


import java.util.Locale;

public class App {
    
    public static void main(String[] args) {
        System.out.println("En France : " + StringUtil.prettyCurrencyPrint(30, Locale.FRANCE));
        System.out.println("Au Canada : " + StringUtil.prettyCurrencyPrint(30, Locale.CANADA));
    }
    
}
