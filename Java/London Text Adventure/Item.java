
/**
 * Items in the game world, only a few different types are available.
 * 
 * @author Priyesh Rajeevkumar Patel
 * @version 2.3 6th Jan 2016
 */
public enum Item
{
    BACKPACK(15), BOTTLE(15), SMARTPHONE(2);
    
    private int weight;
    
    /**
     * Constructor with parameter.
     * Pre-condition: weight is not null.
     */
    private Item(int weight)
    {
        this.weight = weight;
    }
    
    /**
     * Return the item weight.
     * @return the item weight
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Return the item name.
     * @return the item name
     */
    public String toString()
    {
        String itemDescription;
        
        switch(this) {
            case BACKPACK: itemDescription =  "backpack";
            break;
            case BOTTLE: itemDescription =  "bottle";
            break;
            case SMARTPHONE: itemDescription =  "smartphone";
            break;
            default: itemDescription = "";
        }
        
        return itemDescription;
    }
    
}
