package Array;

import java.util.Arrays;
import java.util.Scanner;

import Utilities.Utilities;

public class AssignGrades {
    public static void main(String[] args) {
        // Example: Assign grades based on scores
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = Utilities.systemInputIntProcessing(sc, "\nEnter the number of students: ");
        int[] listOfScores = Utilities.systemInputListIntProcessing(sc, "Enter " + numberOfStudents + " scores:\n");
        if (Utilities.checkPositive(listOfScores)) {
            int best = Arrays.stream(listOfScores).max().orElse(0);
            for (int i = 0; i < listOfScores.length; i++) {
                char grade = assignGrade(listOfScores[i], best);
                System.out.println("Student " + i + " score is " + listOfScores[i] + " and grade is: " + grade);
            }
        }
    }

    private static char assignGrade(int score, int bestScore) {
        if (score >= bestScore - 5) {
            return 'A';
        } else if (score >= bestScore - 10) {
            return 'B';
        } else if (score >= bestScore - 15) {
            return 'C';
        } else if (score >= bestScore - 20) {
            return 'D';
        } else {
            return 'F';
        }

    }
}
