
/**
 * The help command of the game.
 * It provides information about all commands.
 * 
 * @author Olaf Chitil
 * @version 29/1/2016
 */
public class Help extends Command
{
    /**
     * Return help information.
     * Pre-condition: both ui and game are not null;
     */
    public String process(GameMain ui, Game game)
    {
        assert ui != null : "Help.process gets null ui";
        assert game != null : "Help.process gets null game";
        return game.help() + ui.getCommands();
    }
}
