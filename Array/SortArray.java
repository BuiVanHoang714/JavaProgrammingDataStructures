package Array;

import Utilities.Utilities;
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {

        System.out.println("Enter number of transactions: ");
        Scanner sc = new Scanner(System.in);

        int numberOfTrasactions = Utilities.systemInputIntProcessing(sc, "Enter number of transactions: ");

    }

    private static void sortArrays(int[] Numbers) {

        for (int i = 0; i < Numbers.length - 1; i++) {
            for (int j = i + 1; j < Numbers.length; j++) {
                if (Numbers[i] <= Numbers[j]) {
                    // do nothing
                } else {
                    int temp = Numbers[j];
                    Numbers[j] = Numbers[i];
                    Numbers[i] = temp;
                }

            }

        }
    }

    private static int checkRangeFrom1to10000(int inputs) {

        while (true) {
            if (inputs > 10000) {
                System.out.println("Please enter the number between 1 ≤ n ≤ 10,000 ");
            } else {
                return inputs;

            }

        }
    }
}
