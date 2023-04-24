package StoreManager;

/**
 The MenuItem Enum class stores possible
 types of donuts that can be selected.
 @author Dylan Turner, Noor Hasan
 */
public abstract class MenuItem {

    /**
     * Abstract method to calculate the price of the item
     * depending on the item type.
     * @return the price of the item.
     */
    public abstract double itemPrice();

    /**
     * @return the string representation of the object.
     */
    public abstract String toString();

    /**
     * Abstract method to determines
     * if two MenuItems are equal.
     * @param otherItem other item to compare to.
     * @return true if equal, false if not.
     */
    public abstract boolean equals(MenuItem otherItem);

    /**
     * Tells what type of item it is.
     * @return the item type.
     */
    public abstract String getType();
}