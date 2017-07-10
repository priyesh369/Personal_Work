import java.util.ArrayList;

/**
 *  This class is the central class of the "World of London" application. 
 *  "World of London" is a very simple, text based travel game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 * @author  Michael Kölling, David J. Barnes and Olaf Chitil
 * @version 29/1/2016
 */

public class Game 
{
    private Room currentRoom;
    private Room winningRoom;
    private boolean finished;
    private int carryingCurrent;
    private int carryingCapacity;
    private int timeLimit;
    private ArrayList<Item> playerItems;  //the players inventory of picked up items stored here

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        finished = false;
        createRooms();
        timeLimit = 12;
        carryingCapacity = 30;
        carryingCurrent = 0;
        playerItems = new ArrayList<Item>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room trafalgarSquare, chinatown, oxfordStreet, soho, coventGarden, 
        britishMuseum, stPancras, kingsCross, britishLibrary, leicesterSquare;

        // create the rooms
        trafalgarSquare = new Room("on Trafalgar Square");
        chinatown = new Room("in Chinatown");
        oxfordStreet = new Room("on Oxford Street");
        soho = new Room("in Soho");
        coventGarden = new Room("in Covent Garden");
        britishMuseum = new Room("in the British Museum");
        stPancras = new Room("in St Pancras");
        kingsCross = new Room("in Kings Cross");
        britishLibrary = new Room("in the British Library");
        leicesterSquare = new Room("on Leicester Square");

        // initialise room exits

        kingsCross.setExit(Direction.WEST, stPancras);
        stPancras.setExit(Direction.EAST, kingsCross);
        stPancras.setExit(Direction.WEST, britishLibrary);
        britishLibrary.setExit(Direction.EAST, stPancras);
        britishLibrary.setExit(Direction.SOUTH, britishMuseum);
        britishMuseum.setExit(Direction.NORTH, britishLibrary);
        britishMuseum.setExit(Direction.WEST, oxfordStreet);
        oxfordStreet.setExit(Direction.EAST, britishMuseum);
        britishMuseum.setExit(Direction.SOUTH, coventGarden);
        coventGarden.setExit(Direction.NORTH, britishMuseum);
        oxfordStreet.setExit(Direction.SOUTH, soho);
        soho.setExit(Direction.NORTH, oxfordStreet);
        soho.setExit(Direction.SOUTH, chinatown);
        chinatown.setExit(Direction.NORTH, soho);
        chinatown.setExit(Direction.SOUTH, leicesterSquare);
        leicesterSquare.setExit(Direction.NORTH, chinatown);
        leicesterSquare.setExit(Direction.EAST, coventGarden);
        coventGarden.setExit(Direction.WEST, leicesterSquare);
        leicesterSquare.setExit(Direction.SOUTH, trafalgarSquare);
        trafalgarSquare.setExit(Direction.NORTH, leicesterSquare);

        // initialise room items

        kingsCross.setItem(Item.BOTTLE, kingsCross);
        kingsCross.setItem(Item.BACKPACK, kingsCross);
        kingsCross.setItem(Item.SMARTPHONE, kingsCross);

        currentRoom = stPancras;  // start game at St Pancras
        winningRoom = trafalgarSquare; //sets the winning room
    }

    /**
     * Takes item from the current room and adds it to the player's 'inventory'.
     * 
     * @param item The item that the player wants to pickup
     * @return a string to be printed out to the terminal
     * 
     * Pre-Condition : item is not null. 
     */
    public String takeItem(Item item)
    {
        if(carryingCurrent >= carryingCapacity) {
            return "You cannot carry anymore, try dropping something if you want to pick this item up" + "\n" + currentRoom.getLongDescription();
        }
        else {
            if((currentRoom.getItemsReference().get(item)) == currentRoom) {
                if((carryingCurrent + item.getWeight() > carryingCapacity)) {
                    return "You cannot pick this item up, taking this item will cause you to be over encumbered" + "\n" + currentRoom.getLongDescription();
                }
                else {
                    playerItems.add(item);
                    currentRoom.removeItem(item, currentRoom);
                    carryingCurrent = item.getWeight() + carryingCurrent;
                    return "You have picked up the " + item.toString() + ". \n" + currentRoom.getLongDescription();
                }   
            }
            else {
                return "No item found in current area with that name." + "\n" + currentRoom.getLongDescription();
            }
        }
    }

    /**
     * Drops item from the  player's 'inventory' and adds it to the current room.
     * 
     * @param item The item that the player wants to drop.
     * @return a string to be printed out to the terminal
     * 
     * Pre-Condition : item is not null. 
     */
    public String dropItem(Item item)
    {
        if(playerItems.contains(item) == true) {
            currentRoom.setItem(item, currentRoom);
            carryingCurrent = carryingCurrent - item.getWeight();
            playerItems.remove(item);
            return "You have dropped " + item.toString() + ". \n" + currentRoom.getLongDescription();
        }
        else {
            return "You cannot drop something you don't have" + "\n" + currentRoom.getLongDescription();
        }     
    }

    /**
     * Return whether the game has finished or not.
     */
    public boolean finished()
    {
        return finished;
    }

    /**
     * Opening message for the player.
     */
    public String welcome()
    {
        return "\nWelcome to the World of London!\n" +
        "World of London is a new travel game.\n" +
        currentRoom.getLongDescription() + "\n";
    }

    // implementations of user commands:
    /**
     * Give some help information.
     */
    public String help() 
    {
        return "You are lost. You are alone. You wander around foggy London.\n";
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room and return its long description; otherwise return an error message.
     * @param direction The direction in which to go.
     * @return a string describing the result of the method
     * Pre-condition: direction is not null.
     */
    public String goRoom(Direction direction) 
    {
        assert direction != null : "Game.goRoom gets null direction";

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return "There is no exit in that direction!";
        }
        else if(nextRoom == winningRoom) {
            quit();
            currentRoom = nextRoom;
            return currentRoom.getShortDescription() + ", You Win! You found Trafalgar Square. Thanks for playing, goodbye.";
        }
        else{
            if(timeLimit==0) {
                quit();
                currentRoom = nextRoom;
                return currentRoom.getLongDescription() + ", You have failed to reach the goal within 12 moves. Thanks for playing, goodbye.";
            }
            else {
                timeLimit = timeLimit - 1;
                currentRoom = nextRoom;
                return currentRoom.getLongDescription();
            }
        }
    }

    /**
     * Give information on the current room.
     * @return the string of information on the room.
     */
    public String lookAround()
    {
        return currentRoom.getLongDescription();
    }

    /**
     * Execute quit command.
     */
    public String quit()
    {
        finished = true;
        return "Thank you for playing.  Good bye.";
    }

}
