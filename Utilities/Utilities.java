package Utilities;

import java.util.Scanner;

public class Utilities {
    /**
     * Read a line from Scanner with basic, practical processing:
     * - Optional prompt
     * - Trim leading/trailing spaces
     * - Collapse multiple internal spaces to single space
     * - Reprompt on empty input
     * - Return null if user types exit/quit (case-insensitive)
     */
    public static String systemInputProcessing(Scanner sc) {
        return systemInputProcessing(sc, null);
    }

    public static String systemInputProcessing(Scanner sc, String prompt) {
        if (sc == null) {
            throw new IllegalArgumentException("Scanner must not be null");
        }

        while (true) {
            if (prompt != null && !prompt.isEmpty()) {
                System.out.print(prompt);
            }

            if (!sc.hasNextLine()) {
                return null; // no more input
            }

            String inputs = sc.nextLine().trim();

            if (inputs.equalsIgnoreCase("exit") || inputs.equalsIgnoreCase("quit")) {
                return null; // signal caller to stop
            }

            if (inputs.isEmpty()) {
                System.out.println("Nhap khong hop le (rong). Vui long thu lai.");

            }

            return inputs;
        }

    }

    public static Integer systemInputIntProcessing(Scanner sc, String prompt) {
        if (sc == null) {
            throw new IllegalArgumentException("Scanner must not be null");
        }

        while (true) {
            if (prompt != null && !prompt.isEmpty()) {
                System.out.print(prompt);
            }

            if (!sc.hasNextLine()) {
                return null; // no more input
            }

            String inputs = sc.nextLine().trim();

            if (inputs.equalsIgnoreCase("exit") || inputs.equalsIgnoreCase("quit")) {
                return null; // signal caller to stop
            }

            if (inputs.isEmpty()) {
                System.out.println("Nhap khong hop le (rong). Vui long thu lai.");
                continue;
            }

            try {
                return Integer.parseInt(inputs);
            } catch (NumberFormatException e) {
                System.out.println("Nhap khong hop le (khong phai so nguyen). Vui long thu lai.");
            }
        }

    }

    public static int checkPositive(int inputs) {

        while (true) {
            if (inputs <= 0) {
                System.out.println("Please enter the positive number");
            } else {
                return inputs;

            }

        }
    }

}
