package StoreManager;

import java.util.ArrayList;

/**
 * Blueprint for the Order object. Stores the order number, a list
 * of items in the order, and the current total price.
 * @author Dylan Turner, Noor Hasan
 */
public class Order {
    private int orderNumber;
    private ArrayList<MenuItem> menuItems;
    private double currentTotal;

    /**
     * Constructor for an Order object.
     * @param orderNumber the order number.
     */
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        menuItems = new ArrayList<>();
    }

    /**
     * Adds an item to the order.
     * @param menuItem item to add.
     */
    public void addItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    /**
     * Sets the current total price of the order.
     * @param currentTotal price to set to.
     */
    public void setCurrentTotal(double currentTotal) {
        this.currentTotal = currentTotal;
    }

    /**
     * Gets the current total price of the order.
     * @return the total price.
     */
    public double getCurrentTotal() {
        return this.currentTotal;
    }

    /**
     * Gets the order number.
     * @return order number
     */
    public int getOrderNumber() {
        return this.orderNumber;
    }

    /**
     * Gets a reference to the arraylist of items in the order.
     * @return arraylist of order items.
     */
    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }
}