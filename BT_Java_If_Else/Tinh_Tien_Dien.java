package BT_Java_If_Else;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tinh_Tien_Dien {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#,###");
        int electricityUsage = 0;
        boolean validInput = false;

        /// Validate input: repeat until a non-negative integer is entered
        while (!validInput) {

            try {
                System.out.println("Enter electricity usge (KWh)");
                electricityUsage = sc.nextInt();

                if (electricityUsage <= 0) {
                    System.err.println("Electricity usge can not be 0 or negative value!");

                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.err.println("Please enter a valid integer");
                sc.nextLine();

            }

        }
        // Calculate bill.
        float billAmount = 0;
        if (electricityUsage <= 100) {
            billAmount = electricityUsage * 1000;
        } else if (electricityUsage > 100) {
            billAmount = 100 * 1000 + (electricityUsage - 100) * 1500;

        }
        // In ra tien dien
        System.out.println("Tien dien cua ban la:" + formatter.format(billAmount) + "VND");
        sc.close();

    }
}