package StoreManager;

/**
 * Blueprint for the Cake Object, extends the MenuItem
 * Class. Stores the flavor of the cake donut.
 * @author Dylan Turner, Noor Hasan
 */
public class Cake extends MenuItem {
    private String flavor;

    /**
     * Constructor method for the Cake Donut.
     * @param flavor flavor of the donut.
     */
    public Cake(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Returns the price of a Cake donut.
     * @return 1.79
     */
    @Override
    public double itemPrice() {
        return 1.79;
    }

    /**
     * Returns the flavor of the Donut.
     * @return the flavor.
     */
    @Override
    public String toString() {
        return flavor;
    }

    /**
     * Determines whether two Cake Donuts are equal.
     * @param otherItem other Cake to compare to.
     * @return true if equal, false if not.
     */
    @Override
    public boolean equals(MenuItem otherItem) {
        return (otherItem.toString().equals(otherItem.toString()));
    }

    /**
     * Returns what type of MenuItem this is.
     * @return "Donut"
     */
    @Override
    public String getType() {
        return "Donut";
    }
}