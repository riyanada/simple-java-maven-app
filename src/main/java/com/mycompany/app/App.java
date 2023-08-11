package com.mycompany.app;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello Dicoding Indonesia!";
    private static final String NAME = "Riyan";
    private static final String USERNAME = "riyanada";

    public App() {}

    public static void main(String[] args) {
        System.out.println(MESSAGE);
        System.out.println("Name: " + NAME);
        System.out.println("Username: " + USERNAME);
    }

    public String getMessage() {
        return MESSAGE;
    }
}
