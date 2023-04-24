package StoreManager;

/**
 The CurrentDonuts Enum class stores possible
 types of donuts that can be selected.
 @author Dylan Turner, Noor Hasan
 */
public enum CurrentDonuts {
    YEAST (" Donut"),
    CAKE (" Cake Donut"),
    HOLE (" Donut Hole");

    private final String value;

    /**
     * Creates the constant
     * @param value the corresponding value.
     */
    CurrentDonuts(String value){
        this.value = value;
    }
    /**
     * Getter method for the constants.
     * @return the value of the specified constant.
     */
    public String getValue(){
        return this.value;
    }
}
