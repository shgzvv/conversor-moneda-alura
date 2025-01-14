package org.example;

import java.io.IOException;
import java.util.Scanner;

import static org.example.Backend.cambioMoneda;

public class Menu {

    public static void display_value_text (String countryValueFrom, String countryValueTo) throws IOException, InterruptedException {
        double currencyValue = cambioMoneda(countryValueFrom, countryValueTo);
        double valueToConvert;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor a convertir: ");
        do{
            valueToConvert = sc.nextDouble();
            if (valueToConvert < 0) System.out.println("Ingrese un valor positivo.");
        }  while (valueToConvert < 0);

        double valueConverted = valueToConvert * currencyValue;
        System.out.println("El valor " + valueToConvert + "[" + countryValueFrom + "] corresponde al valor final de =>>> " + valueConverted + "[" + countryValueTo + "]\n");
    }

    public static void display_menu () throws IOException, InterruptedException {

        int opc;
        Scanner sc = new Scanner(System.in);
        String menu = "******************************************************"
                + "\nSea bienvenido al Conversor de Moneda =) "
                + "\n1) Dólar =>> Peso argentino "
                + "\n2) Peso argentino =>> Dólar "
                + "\n3) Dolar =>> Real brasileño "
                + "\n4) Real brasileño =>> Dólar "
                + "\n5) Dolar ==> Peso colombiano "
                + "\n6) Peso colombiano ==> Dolar "
                + "\n7) Salir "
                + "\n******************************************************"
                + "\nIngrese una opción: ";

        do {
            System.out.println(menu);
            do {
                opc = sc.nextInt();
                if (opc < 1 || opc > 7) System.out.println("Opción inválida, intente de nuevo.");
            } while (opc < 1 || opc > 7);
            double currencyValue = 0;
            switch (opc) {
                case 1: // Dólar =>> Peso argentino
                    display_value_text("USD", "ARS");
                    break;

                case 2: // Peso argentino =>> Dólar
                    display_value_text("ARS", "USD");
                    break;

                case 3: // Dolar =>> Real brasileño
                    display_value_text("USD", "BRL");
                    break;

                case 4: // Real brasileño =>> Dólar
                    display_value_text("BRL", "USD");
                    break;

                case 5: // Dolar ==> Peso colombiano
                    display_value_text("USD", "COP");
                    break;

                case 6: // Peso colombiano ==> Dolar
                    display_value_text("COP", "USD");
                    break;
            }

            if (opc == 7) System.out.println("Gracias por usar el conversor de monedas!");
        } while (opc != 7);
    }
}
