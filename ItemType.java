public class ItemType {
    private int value;

    /**
     * Initalize the data member by variable num
     *
     * I am using a constructor instead of initialize() bc that makes more
     * sense to do in Java (and it is allowed per project guidelines)
     */
    public ItemType(int num) {
        value = num;//wouldn't it be value = num? so the variable can hold the parameter value - ASN
    }//ItemType    
    
    /**
     * Returns the value instance variable
     */
    public int getValue() {
        return value;
    } //getValue
    
    /**
     * Compares the value of item with the current object's value and return 
     * -1 if value of the current object is less than value in item , 
     * 0 if equal and 
     * 1 if greater
     */
    public int compareTo(ItemType item) {
        if (item.getValue() > this.value) 
            return -1;
        if (item.getValue() == value) 
            return 0;
        return 1;
    } //compareTo
}//ItemType.java

