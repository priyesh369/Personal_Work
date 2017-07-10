    To start the game call the newGUI() method in the class GUI. below is a copy of the report incase
    you wanted to read it in here but it is also available as a seperate file within the ZIP.
    Program by: Priyesh Patel.
    Started: 25/03/16
    Completed: 30/03/16


    >>>>>> Description --------------Priyesh Patel – prp6--------------<<<<<<
This is an A4 overview of the game and GUI designed for the game entitled ZIPpy Pairs. It is a memory matching 
game where the user presses button to reveal a number and attempts to find and match its pair.
    >>>>>> Does the game window have an appropriate title? <<<<<<
The window is title with the name of the game by passing the parameter “ZIPpy Pairs” into the JFrame constructor.
>>>>>> If the window is resized, does the GUI still look appropriate? <<<<<<
The window is set a default size of 600x600 pixels and the buttons scale accordingly to the window size down to a 
defined minimum width and height of 300x300 and any maximum width and height.
    >>>>>> Does any menu have appropriate, functional menu items? <<<<<<
The menu bar has a File menu and a Help menu. The file menu contains a reset option which disposes of the current 
instance then creates a new one hence “resetting” the game “frame.dispose(); new GUI();”. It also contains a quit 
option which simply exits the game and subsequently ends the virtual machine “System.exit(0)”. The help menu 
contains an about and an instruction option which I will describe in the dialogue window section.
    >>>>>> Have layout managers been used appropriate to create something that fits the game. <<<<<<
The contentArea (contentPane) has been given a border layout as it seemed most appropriate to position a score
line at the bottom (SOUTH) and the main content can be placed in the centre (CENTER). The panel that contains the
main content (the buttons) has been given a 5 by 4 grid layout as once again this seemed the most appropriate
choice for the job and handles compensating for the window resizing as desired (maintains the grid formation 
whereas the flow layout wouldn’t have worked, at least to my knowledge).
    >>>>>> Have dialog windows been used (e.g., Help/About)? <<<<<<
As I mentioned earlier the menu bar has a help menu containing help and instruction options. Both these options
result in dialog boxes containing the relevant information. The boxes were creating using JOptionPane and the code
can be seen in the makeMenu method in the GUI. There is also another dialog window when the game is won which
gives the user the option to quit or start a new game with use of “.YES_NO_OPTION” of the JOptionPane. It can be
seen in the setUp method in the GUI
    >>>>>> Have listeners been attached to components? <<<<<<
All buttons have a listener attached which manages the interaction between the game and GUI. You can find the
code within the setUp method of the GUI. Essentially the listener calls the cardButtonFunction method which stores
the pressed button in GUI and sends the value of the button over to game where all the pair checking is managed,
the GUI then receives Boolean response based on outcomes of the Game class’s processes which it can then use to 
determine what to display to the user. 
    >>>>>> Does the game have any dynamic modality? <<<<<<
Buttons are the aspect that have dynamic modality, once pressed the button is set to a disabled state
“.setEnabled(false)” and its value is “printed” on the button. The user can then select another button which
undergoes the same process. If the two values match the Game will return true and the GUI will then keep the
buttons as they are, otherwise a timer is called to set the text back to blank and then re enable the button so it can
be pressed again. The relevant code can be seen in the button listener (in setUp method of GUI) and in the GUI
constructor.
    >>>>>> Have a good range of components been used? <<<<<<
The list of components used for the GUI are as follows: JFrame, JLabel, JPanel, Timer, JButton, Container,
JOptionPane, ActionListeners, JMenu and JMenuItem. So 10 in total, which I think for the particular game is a decent
range as they get the task done in a reasonable fashion.
------------------------------------------------------------------------END-----------------------------------------------------------------------------
