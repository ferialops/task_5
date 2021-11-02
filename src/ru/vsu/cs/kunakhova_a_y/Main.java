package ru.vsu.cs.kunakhova_a_y;

import java.util.Scanner;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        int w = readW();
        if (w != 0) {
            figure(w);
        }
    }

    public static int readW() {
        System.out.print("Enter width w = ");
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        if (w <= 2) {
            System.out.println("Width can be only more than 2");
            w = 0;
        }

        return w;
    }

    public static void newString(int w, int spaces, int exclamationMarks) {
        System.out.print("|");
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < exclamationMarks; i++) {
            if ((i + spaces) > (w - 2)) break;
            System.out.print("!");
        }
        for (int i = 0; i < (w - spaces - exclamationMarks - 2); i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static void firstAndSecondString(int w) {
        System.out.print(" ");
        for (int i = 0; i < (w - 2); i++) {
            System.out.print("-");
        }
        System.out.println(" ");
    }

    public static void figure(int w) {
        int spaces = 0;
        int exclamationMarks;
        firstAndSecondString(w);
        for (exclamationMarks = 1; exclamationMarks < (w - 2 - spaces); exclamationMarks++) {
            newString(w, spaces, exclamationMarks);
            spaces += exclamationMarks;
        }
        newString(w, spaces, (w - spaces - 2));

        while (exclamationMarks > 1) {
            exclamationMarks -= 1;
            spaces -= exclamationMarks;
            newString(w, spaces, exclamationMarks);
        }
        firstAndSecondString(w);
    }
}
