/* I worked on the homework assignment alone, using only course materials. */

import java.util.Scanner;
import java.util.Random;

public class CoinFlip {

    public static void main(String[] args) {

        boolean runAnotherFirst = true;
        Scanner myScan = new Scanner(System.in);
        int seqInput;
        int headsInput;
        int tailsInput;
        String answer;
        int arrLen;
        int[] numEach;

        while (runAnotherFirst) {
            System.out.print("Ready to run a coin flip simulation. Enter the number of sequences: ");
            seqInput = myScan.nextInt();
            myScan.nextLine();
            arrLen = 2 * seqInput;

            if (seqInput <= 0) {
                runAnotherFirst = promptUser(myScan);
                continue;
            }

            System.out.print("How many heads should each sequence have? ");
            headsInput = myScan.nextInt();
            myScan.nextLine();

            if (headsInput < 0) {
                runAnotherFirst = promptUser(myScan);
                continue;
            }

            System.out.print("How many tails should each sequence have? ");
            tailsInput = myScan.nextInt();
            myScan.nextLine();

            if (tailsInput < 0) {
                runAnotherFirst = promptUser(myScan);
                continue;
            }

            System.out.println("Simulating Sequences");
            numEach = getSequence(arrLen, seqInput, headsInput, tailsInput);
            System.out.printf("The average number of flips was %f and maximum was %d%n",
                avgFlips(numEach, seqInput), getMax(numEach, seqInput));

            runAnotherFirst = promptUser(myScan);
        }

    }

    public static int[] getSequence(int arrLen, int numSeqs, int numHeads, int numTails) {

        int headsGen = 0;
        int tailsGen = 0;
        Random randGen = new Random();
        int randNum;
        int[] numEach = new int[arrLen];
        int y = 0;

        for (int i = 1; i <= numSeqs; i++) {
            System.out.print(i + " - ");
            headsGen = 0;
            tailsGen = 0;
            while (headsGen < numHeads || tailsGen < numTails) {
                randNum = 1 + randGen.nextInt(2);                                   /* 1 = heads, 2 = tails */

                if (randNum == 1) {
                    headsGen += 1;
                    System.out.print("H");
                } else {
                    tailsGen += 1;
                    System.out.print("T");
                }
            }
            numEach[y] = headsGen;
            numEach[y + 1] = tailsGen;
            y += 2;
            System.out.println("");

        }

        return numEach;

    }

    public static double avgFlips(int[] numEach, int numSeqs) {

        int sum = 0;
        double avgFlips = 0;
        for (int i = 0; i < numEach.length; i++) {
            sum += numEach[i];
        }
        avgFlips = sum / numSeqs;
        return avgFlips;

    }

    public static int getMax(int[] numEach, int numSeqs) {

        int[] numTot = new int[numSeqs];
        int y = 0;
        for (int i = 0; i < numTot.length; i++) {
            numTot[i] = numEach[y] + numEach[y + 1];
            y += 2;
        }

        int max = numTot[0];
        for (int i = 0; i < numTot.length; i++) {
            if (numTot[i] > max) {
                max = numTot[i];
            }
        }

        return max;
    }

    public static boolean promptUser(Scanner myScan) {

        boolean runAnother = true;
        boolean prompt = true;
        while (prompt) {
            System.out.print("Would you like to run another simulation? (y/n): ");
            String answer = myScan.nextLine();
            if (answer.charAt(0) == 'n' && answer.length() == 1) {
                runAnother = false;
                prompt = false;
                continue;
            } else if (answer.charAt(0) == 'y' && answer.length() == 1) {
                runAnother = true;
                prompt = false;
                break;
            } else {
                prompt = true;
            }
        }

        return runAnother;

    }

}
