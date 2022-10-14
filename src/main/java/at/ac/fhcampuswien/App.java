package at.ac.fhcampuswien;

import java.util.Locale;
import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber() {
        //zwei Variablen deklarieren und mit 0 initialisieren
        double letzteEingabe = 0;
        double largestNum = 0;
        // Standardeingabe Scanner
        Scanner eingabe = new Scanner(System.in);
        //   for-Schleife erstellt, Variable mit zaehler deklariert und mit 1 initialisiert, Bedingung kleiner als 99, ++ wird immer eins rauf gezählt
        for (int zaehler = 1; zaehler < 999; zaehler++) {
            //Standardausgabe mit Text und der Variable zaehler
            System.out.print("Number " + zaehler + ": ");
            //double variable nutzereingabe deklariert und Scannereingabe(double) wird der Variabel Nutzereinagbe übergeben
            double nutzerEingabe = eingabe.nextDouble();

            if (zaehler == 1) {
                letzteEingabe = nutzerEingabe;
                if (nutzerEingabe <= 0) {
                    System.out.println("No number entered.");
                    break;
                }
            }
            //wenn die Nutzereingabe größer als die letzte ist, ist diese die neue largestNum
            if (nutzerEingabe >= letzteEingabe) {
                largestNum = nutzerEingabe;
                //wenn die obige Bedingung nicht erfüllt wurde, ist die largestNum die letzteEingabe
            }

            if (nutzerEingabe <= 0) {
                // Gibt den Text aus + eine String Variable wird formatiert auf die normalen Settings in englisch
                System.out.println("The largest number is " + String.format(Locale.ENGLISH, "%,.2f", largestNum));
                break;
            }
        }
    }

    //todo Task 2
    public void stairs() {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("n: ");
        int input = eingabe.nextInt();
        int zahl = 1;
        if (input <= 0) {
            System.out.println("Invalid number!");
        }
        for (int i = 1; i <= input; i++) {
            for (int j = 1 + input; j <= input + i; j++) {
                System.out.print(zahl + " ");
                zahl++;
            }
            System.out.println();

        }

    }



    //todo Task 3
    public void printPyramid() {
        String stern = "*";
        String leerzeichen = " ";
        final int zeilen = 6;
        // Die äußere Schleife erzeugt die Zeilenumbrüche mit der fix angegebenen Zeilenanzahl
        for (int x = 1; x <= zeilen; x++) {
            //Die erste innere Schleife erzeugt die Spaces, immer ein pace weniger pro Zeile
            for (int y = 1; y <= zeilen - x; y++) {
                System.out.print(leerzeichen);
            }
            //Die zweite innere Schleife bestimmt die Anzahl der Sterne, immer zwei Sterne mehr als zuvor
            for (int z = 1; z <= x * 2 - 1; z++) {
                System.out.print(stern);
            }
            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("h: ");
        int h = scanner.nextInt();
        System.out.print("c: ");
        char c = scanner.next().charAt(0);
        if (h % 2 == 0) {
            System.out.println("Invalid number!");
        } else {
            for (int i = 0; i < h / 2; i++) {
                rhombusCalc(h, c, i);
            }

            for (int i = h / 2; i >= 0; i--) {
                rhombusCalc(h, c, i);
            }
        }
    }

    private static void rhombusCalc(int h, char c, int i) {
        for (int k = h - i; k > h / 2 + 1; k--) {
            System.out.print(" ");
        }
        for (int j = i; j > 0; j--) {
            System.out.print((char) (c - j));
        }
        System.out.print(c);
        for (int j = 1; j < i + 1; j++) {
            System.out.print((char) (c - j));
        }
        System.out.println();
    }

    //todo Task 5
    public void marks() {
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        double summe = 0.00;
        int negativenote = 0;
        int i = 0;
        while (x > 0) {
            System.out.print("Mark " + x + ": ");
            double input = scanner.nextInt();
            if (input >= 1 && input <= 5) {
                summe += input;
                x++;
            } else if (input == 0) {
                i = x - 1;
                x = -1;
            } else {
                System.out.println("Invalid mark!");
            }
            if (input == 5) {
                negativenote++;
            }
        }
        if (x == -1) {
            if (summe != 0) {
                summe /= i;
            }
            System.out.printf("Average: %.2f", summe);
            System.out.println(System.lineSeparator()+"Negative marks: " + negativenote);
        }
    }

    //todo Task 6
    public void happyNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int input = scanner.nextInt();
        int sum = 0;
        int start = input;
        while (sum != 1 && sum != 4) {
            sum = 0;
            while (start > 0) {
                sum += Math.pow(start % 10, 2);
                start /= 10;
            }
            start = sum;
        }
        if (sum == 1) {
            System.out.println("Happy number!");
        } else {
            System.out.println("Sad number!");
        }
    }

    public static void main(String[] args) {
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}