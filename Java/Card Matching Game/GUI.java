import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * This class handles the gui elements of the program
 * 
 * @author Priyesh Patel
 * @version 25/3/16
 */
public class GUI
{
    private JFrame frame;
    private Game game;
    private Container contentArea;
    private JPanel centerContent;
    private JLabel scoreLine;
    private CardButton button1;
    private CardButton button2;
    private Timer timer; //resets the buttons back to starting state after a short delay

    /**
     * Constructor for objects of class GUI.
     */
    public GUI()
    {
        game = new Game();
        timer = new Timer(300,new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    button1.setText("");
                    button2.setText("");
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button1 = null;
                    button2 = null;
                }
            });
        timer.setRepeats(false);
        setUp();
    }

    /**
     * Creates the content to be placed in the centre of the contentpane with use of information
     * provided by the class Game.
     */
    private void createContent()
    {
        ArrayList<Integer> values = game.getCardNumbers();
        Collections.shuffle(values);
        for(int value : values){
            CardButton button = new CardButton();
            button.setValue(value);
            button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        button.setText("" + button.getValue());
                        button.setEnabled(false);
                        cardButtonFunction(button);
                    }
                });
            centerContent.add(button);
        }
    }

    /**
     * This method contains the logic used by the button actionListener for the GUI to display correctly as well as win state message based on 
     * results from the Game Logic. No acctual calculation about the game are made in this method, it just uses results from method calculations
     * in the Game class.
     * 
     * @param button the button currenlty calling the method.
     */
    private void cardButtonFunction(CardButton button)
    {
        if(game.prepareToPair(button.getValue())){
            button1 = button;
        }
        else{
            button2 = button;
        }

        if(game.isReadyToPair()){
            if(game.attemptPairing()){
                button1 = null;
                button2 = null;
                scoreLine.setText("Score: " + game.getScore());
            }
            else{
                if(button1 != null && button2 != null){
                    timer.start();
                }
            }
        }

        if(game.hasWon()){

            if (JOptionPane.showConfirmDialog(frame,"You Win!" + "\n" + "Would you like to play again?","Congratulations",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                frame.dispose();
                new GUI();
            }
            else{
                System.exit(0);
            }
        }
    }

    /**
     * Creates the gui window and it's content(menubar, buttons, name, score label) with use of other methods
     * once it is ready it makes the gui visable to the user.
     */
    private void setUp()
    {
        frame = new JFrame("ZIPpy Pairs");
        makeMenu(frame);
        contentArea = frame.getContentPane();
        contentArea.setLayout(new BorderLayout());
        centerContent = new JPanel(new GridLayout(5, 4));
        contentArea.add(centerContent,BorderLayout.CENTER);
        scoreLine = new JLabel("Score: " + game.getScore());
        scoreLine.setFont(new Font("San Serif",Font.PLAIN,18));
        contentArea.add(scoreLine,BorderLayout.SOUTH);
        createContent();
        frame.pack();
        frame.setSize(600,600);
        frame.setMinimumSize(new Dimension(300,300));
        frame.setVisible(true);
    }

    /**
     * Creates the menubar for the gui and allocates it to the gui frame.
     * @param frame the gui window to which the menu is to be added to.
     */
    private void makeMenu(JFrame frame)
    {
        
        JMenuBar menubar = new JMenuBar();
        JMenu menu;
        JMenuItem item;

        frame.setJMenuBar(menubar);
        menu = new JMenu("File");

        item = new JMenuItem("Reset");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                    frame.dispose();
                    new GUI();
                }
            });
        menu.add(item);

        item = new JMenuItem("Quit");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { System.exit(0);}
            });
        menu.add(item);
        menubar.add(menu);

        menu = new JMenu("Help");

        item = new JMenuItem("About");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(frame, "Zippy Pairs is a memory matching game to test your brain." + "\n"+ "Creator: Priyesh Patel" +"\n"+ "Version: 1.0" +"\n"+ "Created: 25/03/16","About Zippy Pairs", JOptionPane.INFORMATION_MESSAGE);}
            });
        menu.add(item);

        item = new JMenuItem("Instructions");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(frame, "Press two buttons, if they match they will be paired and unselectable." + "\n"+ "If they don't match then just try again until you find a match." +"\n"+ "You win once all pairs are found." +"\n"+ "Have fun!","How to Play", JOptionPane.INFORMATION_MESSAGE);}
            });
        menu.add(item);
        menubar.add(menu);
    }
}
