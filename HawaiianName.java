/* I worked on the homework assignment alone, but consulted related material that can be found at https://stackoverflow.com/questions/7940053/how-to-replace-all-characters-in-a-user-input-string-except-one */

import java.util.Scanner;

public class HawaiianName {

    public static void main(String args[]) {

        Scanner myScanner = new Scanner(System.in);
        char answer = 'y';

        System.out.println("Welcome to Hawaii! Let's check if your name is Hawaiian enough.");
        System.out.println("");

        while (answer == 'y') {

            System.out.print("Enter your name: ");
            String name = myScanner.nextLine();

            String lowerName = name.toLowerCase();

            lowerName = lowerName.replaceAll("[^aeiouklhmn]", "");

            if (lowerName.length() < name.length()) {
                System.out.printf("Sorry %s, you aren't Hawaiian enough to come!%n", name);
                System.out.printf("Let's make your name... %s!%n", lowerName);
                System.out.printf("Aloha, %s%n", lowerName);
            }
            else {
                System.out.printf("Aloha, %s%n", name);
            }

            System.out.print("Would you like to try again? (y/n): ");
            answer = myScanner.nextLine().charAt(0);
            System.out.println("");
        }
    }

}
