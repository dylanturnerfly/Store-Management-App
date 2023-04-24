package StoreManager;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Blueprint for the OrderHistory object. Keeps track of all orders placed. Stores the
 * list of all orders as well as a list of all donut types.
 * @author Dylan Turner, Noor Hasan
 */
public class OrderHistory {
    private ArrayList<Order> orders;
    Flavors[] donutTypes = {Flavors.Tuna,Flavors.Mint,Flavors.Space,Flavors.Sus,Flavors.Tomato,Flavors.Glowstone,Flavors.Strawberry,Flavors.Chocolate,Flavors.MacnCheese,Flavors.Cat,Flavors.Dog,Flavors.Banana};

    /**
     * Constructor for OrderHistory object.
     */
    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    /**
     * Method to place a new order to the history array.
     * @param newOrder new order to be stored.
     */
    public void placeOrder(Order newOrder) {
        orders.add(newOrder);
    }

    /**
     * Getter method for the orders list
     * @return arraylist of the orders.
     */
    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    /**
     * Getter method for a specific order.
     * @param orderNumber ordernumber of desired order.
     * @return corresponding order.
     */
    public Order getOrder(int orderNumber){
        for(Order order : orders) {
            if(order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }

    /**
     * Removes an order from the order history.
     * @param cancelOrder orderNumber of order to cancel.
     */
    public void cancelOrder(int cancelOrder) {
        orders.removeIf(order -> order.getOrderNumber() == cancelOrder);
    }

    /**
     * Exports all current orders to a text field, displaying the
     * item type, quantity, and details of each order.
     * @throws IOException exception for missing file.
     */
    public void exportOrders() throws IOException {
        File export = new File("ExportOrders.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(export, true)));
        for (Order order : orders) {
            pw.println("Order " + order.getOrderNumber() + ":");
            writeItem(order,pw);
            pw.println("Order Total: $" + formatDouble(order.getCurrentTotal()) + "\n");
        }
        pw.close();
    }

    /**
     * Helper method for exportOrders()
     * @param displayOrder order to write to file.
     * @param pw printwrite for file.
     */
    public void writeItem(Order displayOrder, PrintWriter pw) {
        ArrayList<String> coffeeTypes = new ArrayList<>();
        for (MenuItem item : displayOrder.getMenuItems()) {
            if (item.getType().equals("Coffee")) {
                int count = 0;
                for (MenuItem item2 : displayOrder.getMenuItems()) {
                    if (item.equals(item2) && !coffeeTypes.contains(item.toString())) {
                        count++;
                    }
                }
                coffeeTypes.add(item.toString());
                if (count != 0)
                    pw.println(item + " (" + count + ")");
            }
        }
        for (Flavors donutType : donutTypes) {
            int count = 0;
            for (MenuItem donut : displayOrder.getMenuItems()) {
                if (donut.toString().equals(donutType.toString())) {
                    count++;
                }
            }
            if (count != 0)
                pw.println(donutType + donutType.getDonutType() + " (" + count + ")");
        }
    }

    /**
     * Checks if order history is empty.
     * @return true if empty, false if not.
     */
    public boolean isEmpty() {
        return (orders.isEmpty());
    }

    /**
     * Correctly formats the amount due.
     * @param total amount to format
     * @return correctly formated total amount due.
     */
    public String formatDouble(double total){
        String pattern = "0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(total);
    }
}
