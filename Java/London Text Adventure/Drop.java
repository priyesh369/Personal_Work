
/**
 * This is the drop command of the game.
 * requires an item.
 * 
 * @author Priyesh Rajeevkumar Patel 
 * @version 1.0 6th Jan 2016
 */
public class Drop extends Command
{
    private Item item;
    
    /**
     * Initialise the item.
     * Pre-condition: item is not null.
     */
    public Drop(Item item)
    {
        this.item = item;
    }
    
    /**
     * drop the given item.
     * Pre-condition: game is not null.
     */
    public String process (GameMain ui, Game game)
    {
        return game.dropItem(item);
    }
}
