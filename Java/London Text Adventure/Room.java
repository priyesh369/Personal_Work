import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in a game.
 *
 * This class is part of the "World of London" application. 
 * "World of London" is a very simple, text based travel game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling, David J. Barnes and Olaf Chitil
 * @version 29/1/2016
 */

public class Room 
{
    private String description;
    private HashMap<Direction, Room> exits;        // stores exits of this room.
    private HashMap<Item, Room> items;             // stroes items of this room.
    

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * Pre-condition: description is not null.
     */
    public Room(String description) 
    {
        assert description != null : "Room.Room has null description";
        this.description = description;
        exits = new HashMap<Direction, Room>();
        items = new HashMap<Item, Room>();
        sane();
    }
    
    /**
     * Class invariant: getShortDescription() and getLongDescription() don't return null.
     */
    public void sane()
    {
        assert getShortDescription() != null : "Room has no short description" ;
        assert getLongDescription() != null : "Room has no long description" ;
    }
   
    /**
     * Adds item to a room.
     * @param item the item to be associated with the room
     * @param current the room for which the item is to be associated with
     * Pre-condition: item is not null.
     * Pre-condition: current is not null.
     */
    public void setItem(Item item, Room current)
    {
        items.put(item, current);
    }
    
    /**
     * removes item from a room.
     * @param item the item to be removed from the room
     * @param current the room for which the item is to be removed from
     * Pre-condition: item is not null.
     * Pre-condition: current is not null.
     * @ return false if item has not been removed and true if item has been removed
     */
    public Boolean removeItem(Item item, Room current)
    {
        if(items.remove(item, current) == false) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * creates and returns an item string for the current room.
     * @return The item list of the room
     */
     private String getItemString()
    {
        String returnString = "Items:";
        Set<Item> keys = items.keySet();
        for(Item item : keys) {
            returnString += " " + item;
        }
        return returnString;
    }
    
    /**
     * returns the items hashmap for the current room.
     * @return the items hashmap for the current room.
     */
    public HashMap<Item, Room> getItemsReference()
    {
        return items;
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     * Pre-condition: neither direction nor neighbor are null; 
     * there is no room in given direction yet.
     */
    public void setExit(Direction direction, Room neighbor) 
    {
        assert direction != null : "Room.setExit gets null direction";
        assert neighbor != null : "Room.setExit gets null neighbor";
        assert getExit(direction) == null : "Room.setExit set for direction that has neighbor";
        sane();
        exits.put(direction, neighbor);
        sane();
        assert getExit(direction) == neighbor : "Room.setExit has wrong neighbor";
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + ".\n" + getItemString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<Direction> keys = exits.keySet();
        for(Direction exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     * Pre-condition: direction is not null
     */
    public Room getExit(Direction direction) 
    {
        assert direction != null : "Room.getExit has null direction";
        sane();
        return exits.get(direction);
    }
}

