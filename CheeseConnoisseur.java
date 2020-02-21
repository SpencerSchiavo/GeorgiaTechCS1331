/* I worked on the homework assignment alone, using only course materials. */
/**
 * A CheeseConnoisseur class represents a person who participates
 * in the cheese trading simulation.
 *
 * javadoc CheeseConnoisseur.java
 * javadoc -d C:\Users\Spencer\Desktop\GT Victory Lap\Spring_2020\CS_1331\HW05_Cheese\src CheeseConnoisseur.java
 *
 * @author Spencer Schiavo
 * @version 1.0
 */
public class CheeseConnoisseur {
    /** The name of the Cheese Connoisseur */
    private String name;
    /** The Cheese object the connoisseur owns */
    private Cheese cheese;
    /** The amount of money the connoisseur owns */
    private double money;

    /**
     * Constructor taking the name of the connoisseur, their money and cheese.
     *
     * @param name The name of the cheese connoisseur
     * @param money The amount of money the connoisseur owns
     * @param cheese The cheese object the connoisseur owns
     */
    public CheeseConnoisseur(String name, double money, Cheese cheese) {
        this.name = name;
        this.money = money;
//        if(cheese != null) {
//            this.cheese = new Cheese(cheese.getPrice(), cheese.getCheeseType(), cheese.getNumTraded()); //FIX THIS
//        } else {
//            this.cheese = cheese;
        this.cheese = cheese;
    }

    /**
     * Constructor taking the name of the connoisseur and their money.
     *
     * @param name The name of the cheese connoisseur
     * @param money The amount of money the connoisseur owns
     */
    public CheeseConnoisseur(String name, double money) {
        this(name, money, null);
    }

    /**
     * Constructor taking the name of the connoisseur.
     *
     * @param name The name fo the cheese connoisseur
     */
    public CheeseConnoisseur(String name) {
        this(name, 0, null);
    }

    /**
     * No-arg constructor that defaults to
     * name "Louis Pasteur", owning 20.00 in money
     * and a null cheese object.
     */
    public CheeseConnoisseur() {
        this("Louis Pasteur", 20.00, null);
    }

    /**
     * Method that takes a cheese object and swaps the instance variable values
     * of the other connoisseur's cheese object with those of the caller's cheese
     * object.
     *
     * @param newCheese the cheese object of the other cheese connoisseur
     */
    public void makeTrade(Cheese newCheese) {
        if (cheese == null || newCheese == null) {
            cheese = newCheese;
        }
        String tempCheeseType = cheese.getCheeseType();
        double tempPrice = cheese.getPrice();
        int tempNumTraded = cheese.getNumTraded();
        boolean tempSentient = cheese.isSentient();
        cheese.setCheeseType(newCheese.getCheeseType());
        cheese.setPrice(newCheese.getPrice());
        cheese.setNumTraded(newCheese.getNumTraded());
        cheese.setSentient(newCheese.isSentient());
        newCheese.setCheeseType(tempCheeseType);
        newCheese.setPrice(tempPrice);
        newCheese.setNumTraded(tempNumTraded);
        newCheese.setSentient(tempSentient);
        cheese.trade();
        newCheese.trade();
        Cheese.setNumCheeseTrades(Cheese.getNumCheeseTrades() + 1);
    }

    /**
     * Method to execute a trade with another cheese connoisseur.
     *
     * @param otherCheeseConnoisseur The second cheese connoisseur object
     * with whom the caller trades cheeses
     */
    public void makeTrade(CheeseConnoisseur otherCheeseConnoisseur) {
        boolean isNull = cheese == null || otherCheeseConnoisseur.cheese == null;
        if (!isNull && !cheese.equals(otherCheeseConnoisseur.cheese, 0)) {
            if (cheese.getPrice() < otherCheeseConnoisseur.cheese.getPrice()) {
                if (money > otherCheeseConnoisseur.cheese.getPrice() - cheese.getPrice()) {
                    money -= otherCheeseConnoisseur.cheese.getPrice() - cheese.getPrice();
                    otherCheeseConnoisseur.money += otherCheeseConnoisseur.cheese.getPrice() - cheese.getPrice();
                }
            } else if (cheese.getPrice() > otherCheeseConnoisseur.cheese.getPrice()) {
                if (otherCheeseConnoisseur.money > cheese.getPrice() - otherCheeseConnoisseur.cheese.getPrice()) {
                    money += cheese.getPrice() - otherCheeseConnoisseur.cheese.getPrice();
                    otherCheeseConnoisseur.money -= cheese.getPrice() - otherCheeseConnoisseur.cheese.getPrice();
                }
            }
            makeTrade(otherCheeseConnoisseur.cheese);
        }
    }

    /**
     * Getter method to get the name of the cheese connoisseur.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Prints out the stats of the cheese connoisseur.
     */
    public void printOut() {
        System.out.printf("Name: %s\n", name);
        if (cheese != null) {
            System.out.printf("Cheese: %s\n", cheese.getCheeseType());
        } else {
            System.out.printf("Cheese: %s\n", "null");
        }
        System.out.printf("Money: $%4.2f\n", money);
        System.out.println("");
    }

    /**
     * Getter method that returns the cheese object belonging to the
     * cheese connoisseur.
     *
     * @return cheese
     */
    public Cheese getCheese() {
        return cheese;
    }
}
