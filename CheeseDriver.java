/* I worked on the homework assignment alone, using only course materials. */
import java.util.Random;
/**
 * Program to simulate cheese trades for HW05.
 * CS 1331 Spring 2020
 * javadoc CheeseDriver.java
 * javadoc -d C:\Users\Spencer\Desktop\GT Victory Lap\Spring_2020\CS_1331\HW05_Cheese\src CheeseDriver.java
 *
 * @author Spencer Schiavo
 * @version 1.0
 */
public class CheeseDriver {
    /**
     * Main driver of program.
     * Creates 4 Cheese objects and 5 CheeseConnoisseur objects
     *
     * @param args Arguments for the main method
     */
    public static void main(String[] args) {
        Cheese cheddar = new Cheese(10.50, "Cheddar", 0);
        Cheese asiago = new Cheese(15, "Asiago");
        Cheese swiss = new Cheese(4.50, "Swiss", 1);
        Cheese gouda = new Cheese(17, "Gouda", 2);
        CheeseConnoisseur peter = new CheeseConnoisseur("Peter", 100, cheddar);
        CheeseConnoisseur spencer = new CheeseConnoisseur("Spencer", 50, asiago);
        CheeseConnoisseur louie = new CheeseConnoisseur();
        CheeseConnoisseur paige = new CheeseConnoisseur("Paige", 1000, swiss);
        CheeseConnoisseur kristof = new CheeseConnoisseur("Kristof", 40, gouda);
        Cheese[] cheeseArr = {cheddar, asiago, swiss, gouda};
        CheeseConnoisseur[] conArr = {peter, spencer, louie, paige, kristof};
        int[] sentientArr = new int[cheeseArr.length];
        while (sumArr(sentientArr) < 3) {
            int[] twoTraders = pickTraders(conArr);
            System.out.println(conArr[twoTraders[0]].getName() + " is trading with " + conArr[twoTraders[1]].getName()
                    + "...");
            System.out.println("**** BEFORE TRANSACTION *****");
            conArr[twoTraders[0]].printOut();
            conArr[twoTraders[1]].printOut();
            System.out.println("**** AFTER TRANSACTION *****");
            conArr[twoTraders[0]].makeTrade(conArr[twoTraders[1]]);
            conArr[twoTraders[0]].printOut();
            conArr[twoTraders[1]].printOut();
            for (int i = 0; i < sentientArr.length; i++) {
                sentientArr[i] = (cheeseArr[i].isSentient()) ? 1 : 0;
            }
        }
    }

    /**
     * Method to find the sum of a given 1D array.
     *
     * @param arr a 1D array of integers
     * @return Returns the sum of an array
     */
    private static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Method to pick 2 CheeseConnoisseur objects to trade at random.
     *
     * @param conArr A 1D array of CheeseConnoisseur objects
     * @return A 1x2 array containing the indices corresponding to two
     * CheeseConnoisseur objects in the respective array
     */
    private static int[] pickTraders(CheeseConnoisseur[] conArr) {
        Random randGen = new Random();
        int[] randNums = new int[2];
        int rand1 = randGen.nextInt(conArr.length);
        int rand2 = randGen.nextInt(conArr.length);
        while (rand1 == rand2 || conArr[rand1].getCheese() == null || conArr[rand2].getCheese() == null) {
            rand1 = randGen.nextInt(conArr.length);
            rand2 = randGen.nextInt(conArr.length);
        }
        randNums[0] = rand1;
        randNums[1] = rand2;
        return randNums;
    }
}