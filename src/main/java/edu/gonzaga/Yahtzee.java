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
    Integer[] hand;
    Die die;
    ScoreCard score;

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
    JTextArea oneArea;
    JTextArea twoArea;
    JTextArea threeArea;
    JTextArea fourArea;
    JTextArea fiveArea;
    JTextArea sixArea;
    JTextArea upperScoreArea;
    JTextArea bonusArea;
    JTextArea kline3Area;
    JTextArea kline4Area; // 4 of a kind line
    JTextArea fhlineArea; // full house line
    JTextArea smslineArea; // small straight line
    JTextArea lgslineArea; // large straight line
    JTextArea ylineArea; // yahtzee line
    JTextArea clineArea; // chance line
    JTextArea totalScoreArea; // total score
    JComboBox<String> scorecardLineSelectComboBox;
    JButton scorecardSelectBtn;
    JButton oneBtn;
    JButton twoBtn;
    JButton threeBtn;
    JButton fourBtn;
    JButton fiveBtn;
    JButton sixBtn;
    JButton kline3Btn;
    JButton kline4Btn; // 4 of a kind line
    JButton fhlineBtn; // full house line
    JButton smslineBtn; // small straight line
    JButton lgslineBtn; // large straight line
    JButton ylineBtn; // yahtzee line
    JButton clineBtn; // chance line


    public static void main(String [] args) {
        Yahtzee app = new Yahtzee();    // Create, then run GUI
        app.runGUI();
    }

    // Constructor for the actual Yahtzee object
    public Yahtzee() {
        hand = new Integer[5];
        die = new Die(6);
        score = new ScoreCard();
        
        
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
        JLabel upperScoreLabel = new JLabel("Upper Score");
        JLabel bonusLabel = new JLabel("Bonus");
        JLabel totalScoreLabel = new JLabel("Total Score");

        // scores text area
        this.oneArea = new JTextArea(1, 10);
        this.twoArea = new JTextArea(1, 10);
        this.threeArea = new JTextArea(1, 10);
        this.fourArea = new JTextArea(1, 10);
        this.fiveArea = new JTextArea(1, 10);
        this.sixArea = new JTextArea(1, 10);
        this.upperScoreArea = new JTextArea(1, 10);
        this.bonusArea = new JTextArea(1, 10);
        this.kline3Area = new JTextArea(1, 10);
        this.kline4Area = new JTextArea(1, 10); 
        this.fhlineArea = new JTextArea(1, 10); 
        this.smslineArea = new JTextArea(1, 10); 
        this.lgslineArea = new JTextArea(1, 10); 
        this.ylineArea = new JTextArea(1, 10); 
        this.clineArea = new JTextArea(1, 10); 
        this.totalScoreArea = new JTextArea(1, 10); 

        // Setup the actual scorecard text area to add the scorecard output to
        this.scorecardTextArea = new JTextArea(1, 30); // Adjust if you like, of course
        this.scorecardTextArea.setAlignmentX(0.0f);     // This keeps the title label on the left
        this.scorecardTextArea.setEditable(false);      // Don't let the user edit the "scorecard" text

        // Make the combo box and the button to select lines when you're done rolling
        this.scorecardLineSelectComboBox = new JComboBox<>();
        this.scorecardSelectBtn = new JButton("Select Line");

        

        // scores button
        this.oneBtn = new JButton("One's");
        this.twoBtn = new JButton("Two's");
        this.threeBtn = new JButton("Three's");
        this.fourBtn = new JButton("Four's");
        this.fiveBtn = new JButton("Five's");
        this.sixBtn = new JButton("Six's");
        this.kline3Btn = new JButton("Three of a Kind");
        this.kline4Btn = new JButton("Four of a Kind"); 
        this.fhlineBtn = new JButton("Full House"); 
        this.smslineBtn = new JButton("Small Straight"); 
        this.lgslineBtn = new JButton("Large Straight"); 
        this.ylineBtn = new JButton("Yahtzee"); 
        this.clineBtn = new JButton("Chance"); 

        // One's panel
        JPanel onePanel = new JPanel();
        onePanel.setAlignmentX(0.0f);
        onePanel.add(this.oneBtn);
        onePanel.add(this.oneArea);

        // Two's panel
        JPanel twoPanel = new JPanel();
        twoPanel.setAlignmentX(0.0f);
        twoPanel.add(this.twoBtn);
        twoPanel.add(this.twoArea);

        // Three's panel
        JPanel threePanel = new JPanel();
        threePanel.setAlignmentX(0.0f);
        threePanel.add(this.threeBtn);
        threePanel.add(this.threeArea);

        // Four's panel
        JPanel fourPanel = new JPanel();
        fourPanel.setAlignmentX(0.0f);
        fourPanel.add(this.fourBtn);
        fourPanel.add(this.fourArea);

        // Five's panel
        JPanel fivePanel = new JPanel();
        fivePanel.setAlignmentX(0.0f);
        fivePanel.add(this.fiveBtn);
        fivePanel.add(this.fiveArea);

        // Six's panel
        JPanel sixPanel = new JPanel();
        sixPanel.setAlignmentX(0.0f);
        sixPanel.add(this.sixBtn);
        sixPanel.add(this.sixArea);

        // Three of a Kind panel
        JPanel kline3Panel = new JPanel();
        kline3Panel.setAlignmentX(0.0f);
        kline3Panel.add(this.kline3Btn);
        kline3Panel.add(this.kline3Area);

        // Four of a Kind panel
        JPanel kline4Panel = new JPanel();
        kline4Panel.setAlignmentX(0.0f);
        kline4Panel.add(this.kline4Btn);
        kline4Panel.add(this.kline4Area);

        // Full House panel
        JPanel fhlinePanel = new JPanel();
        fhlinePanel.setAlignmentX(0.0f);
        fhlinePanel.add(this.fhlineBtn);
        fhlinePanel.add(this.fhlineArea);

        // Small Straight panel
        JPanel smslinePanel = new JPanel();
        smslinePanel.setAlignmentX(0.0f);
        smslinePanel.add(this.smslineBtn);
        smslinePanel.add(this.smslineArea);

        // Large Straight panel
        JPanel lgslinePanel = new JPanel();
        lgslinePanel.setAlignmentX(0.0f);
        lgslinePanel.add(this.lgslineBtn);
        lgslinePanel.add(this.lgslineArea);

        // Yahtzee panel
        JPanel ylinePanel = new JPanel();
        ylinePanel.setAlignmentX(0.0f);
        ylinePanel.add(this.ylineBtn);
        ylinePanel.add(this.ylineArea);

        // Chance panel
        JPanel clinePanel = new JPanel();
        clinePanel.setAlignmentX(0.0f);
        clinePanel.add(this.clineBtn);
        clinePanel.add(this.clineArea);

        // Upper Score's panel
        JPanel upperScorePanel = new JPanel();
        upperScorePanel.setAlignmentX(0.0f);
        upperScorePanel.add(upperScoreLabel);
        upperScorePanel.add(this.upperScoreArea);

        // Bonus panel
        JPanel bonusPanel = new JPanel();
        bonusPanel.setAlignmentX(0.0f);
        bonusPanel.add(bonusLabel);
        bonusPanel.add(this.bonusArea);

        // Total Score panel
        JPanel totalScorePanel = new JPanel();
        totalScorePanel.setAlignmentX(0.0f);
        totalScorePanel.add(totalScoreLabel);
        totalScorePanel.add(this.totalScoreArea);
        
        

        // Make a little panel to put the combo and button side by side
        JPanel scorecardSelectionPanel = new JPanel();
        scorecardSelectionPanel.setAlignmentX(0.0f);
        scorecardSelectionPanel.add(this.scorecardLineSelectComboBox);
        scorecardSelectionPanel.add(this.scorecardSelectBtn);

        


        // Add the title, text area, and small panel to the right panel
        newScorecardPanel.add(scorecardTitleLabel);
        newScorecardPanel.add(this.scorecardTextArea);
        newScorecardPanel.add(onePanel);
        newScorecardPanel.add(twoPanel);
        newScorecardPanel.add(threePanel);
        newScorecardPanel.add(fourPanel);
        newScorecardPanel.add(fivePanel);
        newScorecardPanel.add(sixPanel);
        newScorecardPanel.add(upperScorePanel);
        newScorecardPanel.add(bonusPanel);
        newScorecardPanel.add(kline3Panel);
        newScorecardPanel.add(kline4Panel);
        newScorecardPanel.add(fhlinePanel);
        newScorecardPanel.add(smslinePanel);
        newScorecardPanel.add(lgslinePanel);
        newScorecardPanel.add(ylinePanel);
        newScorecardPanel.add(clinePanel);
        newScorecardPanel.add(totalScorePanel);
        

        return newScorecardPanel;
    }

    /*
     *  This is a method to show you how you can set/read the visible values
     *   in the various text widgets.
     */
    private void putDemoDefaultValuesInGUI() {

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
                addReroll();
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

    private void addReroll() {
        if(!this.rerollsLeftTextField.getText().equals("0"))
        {
            this.diceValuesTextField.setText(die.dhand(hand,this.diceKeepStringTextField.getText()));
            if(this.rerollsLeftTextField.getText().equals("1"))
            {
                this.scorecardTextArea.setText(score.printTotalScore(hand));
            }
            int i = Integer.parseInt(this.rerollsLeftTextField.getText());
            i--;
            this.rerollsLeftTextField.setText(String.valueOf(i));
        }
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
