package StoreManager;

/**
 * Blueprint for the donut Hole Object, extends the MenuItem
 * Class. Stores the flavor of the donut Hole.
 * @author Dylan Turner, Noor Hasan
 */
public class Hole extends MenuItem {
    private String flavor;

    /**
     * Constructor for the donut Hole.
     * @param flavor flavor of the donut.
     */
    public Hole(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Returns the price of a donut Hole.
     * @return 0.39
     */
    @Override
    public double itemPrice() {
        return 0.39;
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
     * Determines whether two donut Holes are equal.
     * @param otherItem other donut Hole to compare to.
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
