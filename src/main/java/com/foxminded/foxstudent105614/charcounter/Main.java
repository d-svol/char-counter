package com.foxminded.foxstudent105614.charcounter;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Logic logic = new Logic();
        PrettyPrinter printer = new PrettyPrinter();

        try (Scanner scanner = new Scanner(System.in)) {
            String text;
            System.out.print("Enter text or 'ex' to exit: ");
            text = scanner.nextLine();
            while (!text.equals("ex")) {
                if (!text.trim().isEmpty()) {
                    logic.processAndCacheText(text);
                    System.out.println(printer.print(logic));
                } else {
                    System.out.println("Text cannot be empty.");
                }
                System.out.print("Enter text or 'ex' to exit: ");
                text = scanner.nextLine();
            }
        } catch (NoSuchElementException e) {
            System.err.println("Input error: " + e.getMessage());
        } catch (IllegalStateException e ){
            System.err.println("Program state error: " + e.getMessage());
        }
    }
}

