package StoreManager;

/**
 * Blueprint for the Yeast donut Object, extends the MenuItem
 * Class. Stores the flavor of the Yeast donut.
 * @author Dylan Turner, Noor Hasan
 */
public class Yeast extends MenuItem {
    private String flavor;

    /**
     * Constructor method for a Yeast donut.
     * @param flavor flavor of the donut.
     */
    public Yeast(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Returns the price of a donut Hole.
     * @return 1.59
     */
    @Override
    public double itemPrice() {
        return 1.59;
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
     * Determines whether two Yeast donuts are equal.
     * @param otherItem other Yeast donut to compare to.
     * @return true if equal, false if not.
     */
    @Override
    public boolean equals(MenuItem otherItem) {
        return (otherItem.toString().equals(otherItem.toString()));
    }

    /**
     * Returns what type of MenuItem this is.
     * @return "Yeast"
     */
    @Override
    public String getType() {
        return "Yeast";
    }
}
