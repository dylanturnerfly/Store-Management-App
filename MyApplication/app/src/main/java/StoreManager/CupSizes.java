package StoreManager;

/**
 The CupSizes Enum class stores the possible cup sizes a cup
 can be, and the price associated with it.
 @author Dylan Turner, Noor Hasan
 */
public enum CupSizes {

    SHORT (1.89),
    TALL (2.29),
    GRANDE (2.69),
    VENTI (3.09);

    private final double value;

    /**
     * Creates the constant
     * @param value the corresponding value.
     */
    CupSizes(double value){
        this.value = value;
    }

    /**
     * Getter method for the cup size prices.
     * @return the value of the specified constant.
     */
    public double getPrice(){
        return this.value;
    }
}
