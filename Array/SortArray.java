package Array;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] Numbers = { 5, 7, 20, 2, 5 };
        // sortArrays(Numbers);
        Arrays.sort(Numbers);
        System.out.println("\n" + Arrays.toString(Numbers));
        int balance = 10;
        System.out.println("Balance is " + checkingPalindromes(balance));
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

    private static int checkingPalindromes(int balance) {

        while (true) {
            if (balance < 9)
                break;
            balance = balance - 9;
        }
        return balance;
    }
}
