package Array;

import java.util.Scanner;

public class CountOccurrences {
    // Demo: count occurrences of integers in [1, 50], stop on 0.
    // Shows how freq[x]++ updates after each valid input.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] freq = new int[51]; // indices 0..50; using 1..50

        System.out.print("Enter the integers between 1 and 50 (end with 0): ");
        while (true) {
            if (!sc.hasNextInt())
                break;
            int x = sc.nextInt();
            if (x == 0)
                break; // stop condition

            if (1 <= x && x <= 50) {
                freq[x]++; // increase count at index x
                System.out.println("  read " + x + ": freq[" + x + "] = " + freq[x]);
            } else {
                System.out.println("  ignored " + x + " (out of range)");
            }
        }

        // Print final summary in ascending order.
        for (int i = 1; i <= 50; i++) {
            if (freq[i] > 0) {
                String unit = (freq[i] == 1) ? "time" : "times";
                System.out.println(i + " occurs " + freq[i] + " " + unit);
            }
        }
    }
}
