package com.mycompany.app;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World!";
    private static final String AUTHOR = "Riyan";

    public App() {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(MESSAGE);
        System.out.println("Ditulis oleh: " + AUTHOR);
        showAboutMe();
    }

    public static void showAboutMe() {
        System.out.println("Tentang Saya");
        System.out.println("TERUS LAH BERKARYA WALAUPUN ITU TIDAK MUDAH, TETAPLAH MENJADI PRIBADI YANG SELALU SEMANGAT SETIAP SAAT >_<");
    }

    public String getMessage() {
        return MESSAGE;
    }
}
