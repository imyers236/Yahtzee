package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Java Swing based Yahtzee frontend
// Add/edit/change as you see fit to get it to play Yahtzee!
class Yahtzee {
    // If you have your HW3 code, you could include it like this
    // Player player;

    // Main game GUI window and two main panels (left & right)
    JFrame mainWindowFrame;
    JPanel controlPanel;
    JPanel scorecardPanel;

    // Player name - set it to your choice
    JTextField playerNameTextField;

    // Dice view, user input, reroll status, and reroll button
    JTextField diceValuesTextField;
    JTextField diceKeepStringTextField;
    JButton diceRerollBtn;
    JTextField rerollsLeftTextField;

    // Scorecard view and controls
    JTextArea scorecardTextArea;
    JComboBox<String> scorecardLineSelectComboBox;
    JButton scorecardSelectBtn;


    public static void main(String [] args) {
        Yahtzee app = new Yahtzee();    // Create, then run GUI
        app.runGUI();
    }

    // Constructor for the actual Yahtzee object
    public Yahtzee() {
        Integer[] hand = new Integer[5];
        Die die = new Die(6);
        ScoreCard score = new ScoreCard();
        String h = this.diceValuesTextField.getText();
        for(int i = 0; i < hand.length; i++)
        {
            hand[i] = Integer.parseInt(h.substring(i));
        }
        if((rerollsLeftTextField.getText() != "0"))
        {

        }
        // Create any object you'll need for storing the game:
        // Player, Scorecard, Hand/Dice
    }

    // Sets up the full Swing GUI, but does not do any callback code
    void setupGUI() {
        this.mainWindowFrame = new JFrame("Simple GUI Yahtzee");
        this.mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainWindowFrame.setSize(400, 400);
        this.mainWindowFrame.setLocation(100,100);
        
        this.controlPanel = new JPanel();
        this.scorecardPanel = new JPanel();

        // Control panel setup
        this.controlPanel = genControlPanel();


        // Scorecard panel setup
        this.scorecardPanel = genScorecardPanel();

        // Window add panels and layout
        mainWindowFrame.getContentPane().add(BorderLayout.WEST, controlPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.CENTER, scorecardPanel);
        mainWindowFrame.pack();
    }

    // Create the left panel with the game controls/status
    private JPanel genControlPanel() {
        JPanel newControlPanel = new JPanel();
        newControlPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // Player name row widgets
        JLabel playerNameLabel = new JLabel("Player name:");
        this.playerNameTextField = new JTextField();

        // Dice Values row widgets
        JLabel diceValuesLabel = new JLabel("Dice values:");
        this.diceValuesTextField = new JTextField();
        this.diceValuesTextField.setEditable(false);

        // Die keep user selection
        JLabel diceKeepInputLabel = new JLabel("Dice keep string:");
        this.diceKeepStringTextField = new JTextField();

        // Rolls left and roll button
        JPanel rollsLeftPanel = new JPanel();
        JLabel rollsLeftLabel = new JLabel("Rolls left:");
        this.rerollsLeftTextField = new JTextField(2); // Only 2 wide
        this.rerollsLeftTextField.setEditable(false);
        rollsLeftPanel.add(rollsLeftLabel);
        rollsLeftPanel.add(this.rerollsLeftTextField);

        this.diceRerollBtn = new JButton("Reroll");

        // Add all of our control panel widgets to the panel
        newControlPanel.add(playerNameLabel);
        newControlPanel.add(this.playerNameTextField);

        newControlPanel.add(diceValuesLabel);
        newControlPanel.add(this.diceValuesTextField);

        newControlPanel.add(diceKeepInputLabel);
        newControlPanel.add(this.diceKeepStringTextField);

        newControlPanel.add(rollsLeftPanel);
        newControlPanel.add(this.diceRerollBtn);

        // Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newControlPanel.setLayout(new GridLayout(0, 2));    // Making it pretty
        return newControlPanel;
    }

    // Create the right panel with the scorecard and chooser for lines
    private JPanel genScorecardPanel() {
        JPanel newScorecardPanel = new JPanel();
        newScorecardPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // Tell panel to put widgets in vertically with a BoxLayout
        newScorecardPanel.setLayout(new BoxLayout(newScorecardPanel, BoxLayout.Y_AXIS));

        // A simple label to title the right scorecard area
        JLabel scorecardTitleLabel = new JLabel("Scorecard");

        // Setup the actual scorecard text area to add the scorecard output to
        this.scorecardTextArea = new JTextArea(20, 30); // Adjust if you like, of course
        this.scorecardTextArea.setAlignmentX(0.0f);     // This keeps the title label on the left
        this.scorecardTextArea.setEditable(false);      // Don't let the user edit the "scorecard" text

        // Make the combo box and the button to select lines when you're done rolling
        this.scorecardLineSelectComboBox = new JComboBox<>();
        this.scorecardSelectBtn = new JButton("Select Line");

        // Make a little panel to put the combo and button side by side
        JPanel scorecardSelectionPanel = new JPanel();
        scorecardSelectionPanel.setAlignmentX(0.0f);
        scorecardSelectionPanel.add(this.scorecardLineSelectComboBox);
        scorecardSelectionPanel.add(this.scorecardSelectBtn);

        // Add the title, text area, and small panel to the right panel
        newScorecardPanel.add(scorecardTitleLabel);
        newScorecardPanel.add(this.scorecardTextArea);
        newScorecardPanel.add(scorecardSelectionPanel);

        return newScorecardPanel;
    }

    /*
     *  This is a method to show you how you can set/read the visible values
     *   in the various text widgets.
     */
    private void putDemoDefaultValuesInGUI() {
        Integer[] hand = new Integer[5];
        Die die = new Die(6);

        // Example setting of player name
        this.playerNameTextField.setText("Player's Name ");

        // Example of player entered dice keep string
        this.diceKeepStringTextField.setText("nnnyn");

        // Example of setting the rerolls left
        this.rerollsLeftTextField.setText("2");


        // The scorecard can be "printed" to the text area widget
        this.scorecardTextArea.setText("Scorecard text goes here");

        // Player's starting dice string
        this.diceValuesTextField.setText(die.defaultHand(hand));

    }

    /*
     * This is a demo of how to add callbacks to the buttons
     *  These callbacks can access the class member variables this way
     */
    private void addDemoButtonCallbackHandlers() {
        // You can add and remove choices from the scorecard selection combo box
        String[] defaultChoices = { "Chance", "Sixes", "Flip Table" };
        for( String currChoice : defaultChoices ) {
            this.scorecardLineSelectComboBox.addItem(currChoice);
        }

        // Example of a button callback - just prints when clicked
        this.diceRerollBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("They clicked the reroll button!");
            }
        });

        // Example of another button callback
        // Reads the combo box selected value and writes it to the dice reroll box
        this.scorecardSelectBtn.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                String currentChoice = (String)scorecardLineSelectComboBox.getSelectedItem();
                System.out.println("Player is selecting line: " + currentChoice);
                diceKeepStringTextField.setText(currentChoice);
            }
        });

    }

    /*
     *  Builds the GUI frontend and allows you to hook up the callbacks/data for game
     */
    void runGUI() {
        System.out.println("Starting GUI app");
        setupGUI();

        // These methods are to show you how it works
        // Once you get started working, you can comment them out so they don't
        //  mess up your own code.
        putDemoDefaultValuesInGUI();
        addDemoButtonCallbackHandlers();

        // Right here is where you could methods to add your own callbacks
        // so that you can make the game actually work.

        // Run the main window - begins GUI activity
        mainWindowFrame.setVisible(true);
        System.out.println("Done in GUI app");
    }

}
