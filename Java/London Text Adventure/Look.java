
/**
 * This is the look command of the game.
 * provides a printout to the user detailing the room they stand in.
 * 
 * @author Priyesh Rajeevkumar Patel 
 * @version 1.0 6th Jan 2016
 */
public class Look extends Command
{
    /**
     * Return room description.
     * @return room description.
     * Pre-condition:  game is not null;
     */
    public String process(GameMain ui, Game game)
    {
        return game.lookAround();
    }
}
