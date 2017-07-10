import javax.swing.JButton;
/**
 * This class handles the button elements to be used in the gui of the program
 * 
 * @author Priyesh Patel
 * @version 25/3/16
 */
public class CardButton extends JButton
{
    private int value;

    /**
     * Constructor for objects of class CardButton.
     */
    public CardButton()
    {

    }

    /**
     * sets the value field of the CardButton object.
     * @param value the number that is to be assigned as the object's value.
     * Pre-condition: value is greater than -1.
     */
    public void setValue(int value)
    {
        if(value>-1){
            this.value = value;
        }
    }

    /**
     * returns the field value.
     * @returns the field value.
     */
    public int getValue()
    {
        return value;
    }
}
