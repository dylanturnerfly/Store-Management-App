package StoreManager;

/**
 The Flavors Enum class stores the possible flavors a
 donut can be, the donut type associated with it.
 @author Dylan Turner, Noor Hasan
 */
public enum Flavors {
    Tuna (" Donut"),
    Mint (" Donut"),
    Space (" Donut"),
    Sus (" Donut"),
    Tomato (" Donut"),
    Glowstone (" Donut"),
    Strawberry (" Cake Donut"),
    Chocolate (" Cake Donut"),
    MacnCheese (" Cake Donut"),
    Cat (" Donut Hole"),
    Dog (" Donut Hole"),
    Banana (" Donut Hole");

    private final String donutType;

    /**
     * Creates the Donut Flavor
     * @param donutType the donut type for the value
     */
    Flavors(String donutType) {
        this.donutType = donutType;

    }

    /**
     *Getter method for the donut type.
     * @return the donut type.
     */
    public String getDonutType(){
        return this.donutType;
    }
}
