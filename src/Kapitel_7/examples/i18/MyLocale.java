package Kapitel_7.examples.i18;

import java.util.Locale;

public class MyLocale {

	public static void main(String[] args) {

		Locale locale = Locale.getDefault();

		String country = locale.getCountry();
		String language = locale.getLanguage();
		String variant = locale.getVariant();

		System.out.println("Land:"+country);
		System.out.println("Sprache:"+language);
		System.out.println("Variante:"+variant);
	}

}
