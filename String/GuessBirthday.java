package String;

import java.util.Scanner;

public class GuessBirthday {

    // Constants for better maintainability
    private static final int[] SET_VALUES = { 1, 2, 4, 8, 16 };

    private static final String[] SETS = {
            " 1  3  5  7\n 9 11 13 15\n17 19 21 23\n25 27 29 31",
            " 2  3  6  7\n10 11 14 15\n18 19 22 23\n26 27 30 31",
            " 4  5  6  7\n12 13 14 15\n20 21 22 23\n28 29 30 31",
            " 8  9 10 11\n12 13 14 15\n24 25 26 27\n28 29 30 31",
            "16 17 18 19\n20 21 22 23\n24 25 26 27\n28 29 30 31"
    };

    public static void main(String[] args) {
        int dayOfBirth = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            //
            for (int i = 0; i < SETS.length; i++) {
                dayOfBirth += askQuestion(scanner, i);
            }
            System.out.println("\nYour birthday is " + dayOfBirth + "!");
        } finally {
            scanner.close();
        }

    }

    private static int askQuestion(Scanner scanner, int setIndex) {
        System.out.print("\nIs your birthday in Set " + (setIndex + 1) + "?\n");
        System.out.println(SETS[setIndex]);
        System.out.println("\nEnter Y for Yes and N for No: ");

        // Input validation: remove spaces and normalize case
        String answer = scanner.nextLine().trim().toUpperCase();

        // Validate answer

        while (!answer.equals("Y") && !answer.equals("N")) {
            System.err.println("Invalid input! Please enter Y or N: ");
            answer = scanner.nextLine().toUpperCase();

        }
        if (answer.equals("Y")) {
            return SET_VALUES[setIndex];
        } else {
            return 0;
        }
    }
}
