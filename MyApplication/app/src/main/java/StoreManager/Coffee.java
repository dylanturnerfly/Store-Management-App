package StoreManager;

import java.util.ArrayList;

/**
 * Blueprint for the Coffee Object, extends the MenuItem
 * Class.Stores the cup size and an array of the add-ins.
 * @author Dylan Turner, Noor Hasan
 */
public class Coffee extends MenuItem{
    private CupSizes cupSize;
    private ArrayList<String> addIns;

    /**
     * Constructor for the Coffee Object.
     * @param cupSize desired cup size.
     * @param addIns array of desired add ins.
     */
    public Coffee(String cupSize, ArrayList<String> addIns) {
        this.addIns = addIns;
        for (CupSizes allowedCupSize : CupSizes.values()) {
            if (cupSize.toString().toUpperCase().equals(allowedCupSize.toString())) {
                this.cupSize = allowedCupSize;
                break;
            }
        }
    }

    /**
     * Returns the price of the coffee based
     * on cup size and amount of add ins.
     * @return price of the coffee in cents.
     */
    @Override
    public double itemPrice() {
        return this.cupSize.getPrice() + addIns.size() * 0.30;
    }

    /**
     * Builds a string representation of
     * the coffee object and returns it.
     * @return a string representation of the coffee.
     */
    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder(this.cupSize + " coffee with ");
        if(addIns.size() != 0) {
            for (String addIn : addIns) {
                toReturn.append(" " + addIn).append(", ");
            }
            toReturn.append("added in");
        } else {
            toReturn.append("nothing added in");
        }
        return toReturn.toString();
    }

    /**
     * Determines whether two Coffees are equal.
     * @param otherCoffee other Coffee to compare to.
     * @return true if equal, false if not.
     */
    @Override
    public boolean equals(MenuItem otherCoffee) {
        return ((this.toString().equals(otherCoffee.toString())));
    }

    /**
     * Tells what type of MenuItem this object is.
     * @return "Coffee"
     */
    @Override
    public String getType() {
        return "Coffee";
    }
}