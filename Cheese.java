/* I worked on the homework assignment alone, using only course materials. */
/**
 * A Cheese class represents the cheeses that the Cheese Connoisseur object will trade.
 * javadoc Cheese.java
 * javadoc -d C:\Users\Spencer\Desktop\GT Victory Lap\Spring_2020\CS_1331\HW05_Cheese\src Cheese.java
 *
 * @author Spencer Schiavo
 * @version 1.0
 */
public class Cheese {
    /** The type of cheese */
    private String cheeseType;
    /** The price of the cheese */
    private double price;
    /** Whether the cheese is sentient */
    private boolean sentient;
    /** The number of times the cheese has been traded */
    private int numTraded;
    /** The number of trades that have occurred */
    private static int numCheeseTrades;

    /**
     * Constructor taking price, cheese type, and number of times traded.
     *
     * @param price The price of the cheese
     * @param cheeseType The name of the type of cheese
     * @param numTraded The number of times that cheese has been traded
     */
    public Cheese(double price, String cheeseType, int numTraded) {
        this.price = price;
        this.cheeseType = cheeseType;
        this.numTraded = numTraded;
        this.sentient = numTraded >= 3;
    }

    /**
     * Constructor taking in price and type of cheese.
     *
     * @param price The price of the cheese
     * @param cheeseType The name of the type of cheese
     */
    public Cheese(double price, String cheeseType) {
        this.price = price;
        this.cheeseType = cheeseType;
        this.numTraded = 0;
        this.sentient = false;
    }

    /**
     * Method that returns a String representation of the type of cheese and
     * the number of times it has been traded.
     *
     * @return Returns a String outlining the number of times traded for
     * a particular cheese
     */
    public String toString() {
        String toStr = "This is a slice of " + cheeseType + " that has been traded "
                + numTraded + " times.";
        if (sentient) {
            toStr = "I am a slice of " + cheeseType + " cheese that has been traded "
                    + numTraded + " times.";
        }
        return toStr;
    }

    /**
     * Method to test the equality of two cheese objects.
     *
     * @param cheese Cheese object to be tested for equality to the caller
     * @param i A placeholder to overload, not override, the equals method
     * @return Boolean corresponding to the equality
     */
    public boolean equals(Cheese cheese, int i) {
        return cheeseType.equals(cheese.cheeseType) && price == cheese.price
                && sentient == cheese.sentient;
    }

    /**
     * Method to increment the appropriate variables involved in the trading of cheeses.
     */
    public void trade() {
        numTraded += 1;
        if (numTraded >= 3 && !sentient) {
            sentient = true;
            price *= 2;
            System.out.println(cheeseType + ": I'm ALIIIIIVE!");
        }
    }

    /**
     * Getter method to return the type of cheese.
     *
     * @return String representing the type of the cheese
     */
    public String getCheeseType() {
        return cheeseType;
    }

    /**
     * Getter method to retrieve the price of the cheese.
     *
     * @return A double representing the price of the cheese
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter method to check the sentience of the cheese.
     *
     * @return Boolean representing whether the cheese is sentient
     */
    public boolean isSentient() {
        return sentient;
    }

    /**
     * Getter method to return the number of trades a particular cheese has experienced.
     *
     * @return Int representing the number of trades for a cheese
     */
    public int getNumTraded() {
        return numTraded;
    }

    /**
     * Setter method to set the cheese type.
     *
     * @param cheeseType A String representing the name of the cheese type
     */
    public void setCheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }

    /**
     * Setter method to set the price of the cheese.
     *
     * @param price A double representing the price of the cheese
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * A setter method to set the whether a cheese is sentient.
     *
     * @param sentient A boolean representing whether the cheese is sentient
     */
    public void setSentient(boolean sentient) {
        this.sentient = sentient;
    }

    /**
     * A setter method to set the number of trades for a cheese.
     *
     * @param numTraded An int representing the number of trades experienced by a cheese
     */
    public void setNumTraded(int numTraded) {
        this.numTraded = numTraded;
    }

    /**
     * A getter method to retrieve the total number of trades that have
     * occurred in the simulation.
     *
     * @return An int representing the number of trades
     */
    public static int getNumCheeseTrades() {
        return numCheeseTrades;
    }

    /**
     * A setter method to set the number of trades that have occurred in the simulation.
     *
     * @param numCheeseTrades An int representing the number of trades
     */
    public static void setNumCheeseTrades(int numCheeseTrades) {
        Cheese.numCheeseTrades = numCheeseTrades;
    }
}
