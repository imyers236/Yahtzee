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
    JTextArea onePossArea;
    JTextArea twoPossArea;
    JTextArea threePossArea;
    JTextArea fourPossArea;
    JTextArea fivePossArea;
    JTextArea sixPossArea;
    JTextArea upperScoreArea;
    JTextArea bonusArea;
    JTextArea kline3PossArea;
    JTextArea kline4PossArea; // 4 of a kind line
    JTextArea fhlinePossArea; // full house line
    JTextArea smslinePossArea; // small straight line
    JTextArea lgslinePossArea; // large straight line
    JTextArea ylinePossArea; // yahtzee line
    JTextArea clinePossArea; // chance line
    JTextArea totalScoreArea; // total score
    JTextArea oneActArea;
    JTextArea twoActArea;
    JTextArea threeActArea;
    JTextArea fourActArea;
    JTextArea fiveActArea;
    JTextArea sixActArea;
    JTextArea kline3ActArea; // 3 of a kind line
    JTextArea kline4ActArea; // 4 of a kind line
    JTextArea fhlineActArea; // full house line
    JTextArea smslineActArea; // small straight line
    JTextArea lgslineActArea; // large straight line
    JTextArea ylineActArea; // yahtzee line
    JTextArea clineActArea; // chance line
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
        JLabel scoreLineLabel = new JLabel("Score Line, ");
        JLabel possibleLabel = new JLabel("Possible Score, ");
        JLabel actualLabel = new JLabel("Actual Score");

        // possible scores text area
        this.onePossArea = new JTextArea(1, 10);
        this.twoPossArea = new JTextArea(1, 10);
        this.threePossArea = new JTextArea(1, 10);
        this.fourPossArea = new JTextArea(1, 10);
        this.fivePossArea = new JTextArea(1, 10);
        this.sixPossArea = new JTextArea(1, 10);
        this.kline3PossArea = new JTextArea(1, 10);
        this.kline4PossArea = new JTextArea(1, 10); 
        this.fhlinePossArea = new JTextArea(1, 10); 
        this.smslinePossArea = new JTextArea(1, 10); 
        this.lgslinePossArea = new JTextArea(1, 10); 
        this.ylinePossArea = new JTextArea(1, 10); 
        this.clinePossArea = new JTextArea(1, 10); 

        // Bonus and total scores text area
        this.bonusArea = new JTextArea(1, 10);
        this.totalScoreArea = new JTextArea(1, 10);
        this.upperScoreArea = new JTextArea(1, 10); 

        // Actual scores text area
        this.oneActArea = new JTextArea(1, 10);
        this.twoActArea = new JTextArea(1, 10);
        this.threeActArea = new JTextArea(1, 10);
        this.fourActArea = new JTextArea(1, 10);
        this.fiveActArea = new JTextArea(1, 10);
        this.sixActArea = new JTextArea(1, 10);
        this.bonusArea = new JTextArea(1, 10);
        this.kline3ActArea = new JTextArea(1, 10);
        this.kline4ActArea = new JTextArea(1, 10); 
        this.fhlineActArea = new JTextArea(1, 10); 
        this.smslineActArea = new JTextArea(1, 10); 
        this.lgslineActArea = new JTextArea(1, 10); 
        this.ylineActArea = new JTextArea(1, 10); 
        this.clineActArea = new JTextArea(1, 10); 

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

        // title's panel
        JPanel titlePanel = new JPanel();
        titlePanel.setAlignmentX(0.0f);
        titlePanel.add(scoreLineLabel);
        titlePanel.add(possibleLabel);
        titlePanel.add(actualLabel);


        // One's panel
        JPanel onePanel = new JPanel();
        onePanel.setAlignmentX(0.0f);
        onePanel.add(this.oneBtn);
        onePanel.add(this.onePossArea);
        onePanel.add(this.oneActArea);

        // Two's panel
        JPanel twoPanel = new JPanel();
        twoPanel.setAlignmentX(0.0f);
        twoPanel.add(this.twoBtn);
        twoPanel.add(this.twoPossArea);
        twoPanel.add(this.twoActArea);

        // Three's panel
        JPanel threePanel = new JPanel();
        threePanel.setAlignmentX(0.0f);
        threePanel.add(this.threeBtn);
        threePanel.add(this.threePossArea);
        threePanel.add(this.threeActArea);

        // Four's panel
        JPanel fourPanel = new JPanel();
        fourPanel.setAlignmentX(0.0f);
        fourPanel.add(this.fourBtn);
        fourPanel.add(this.fourPossArea);
        fourPanel.add(this.fourActArea);

        // Five's panel
        JPanel fivePanel = new JPanel();
        fivePanel.setAlignmentX(0.0f);
        fivePanel.add(this.fiveBtn);
        fivePanel.add(this.fivePossArea);
        fivePanel.add(this.fiveActArea);

        // Six's panel
        JPanel sixPanel = new JPanel();
        sixPanel.setAlignmentX(0.0f);
        sixPanel.add(this.sixBtn);
        sixPanel.add(this.sixPossArea);
        sixPanel.add(this.sixActArea);

        // Three of a Kind panel
        JPanel kline3Panel = new JPanel();
        kline3Panel.setAlignmentX(0.0f);
        kline3Panel.add(this.kline3Btn);
        kline3Panel.add(this.kline3PossArea);
        kline3Panel.add(this.kline3ActArea);

        // Four of a Kind panel
        JPanel kline4Panel = new JPanel();
        kline4Panel.setAlignmentX(0.0f);
        kline4Panel.add(this.kline4Btn);
        kline4Panel.add(this.kline4PossArea);
        kline4Panel.add(this.kline4ActArea);

        // Full House panel
        JPanel fhlinePanel = new JPanel();
        fhlinePanel.setAlignmentX(0.0f);
        fhlinePanel.add(this.fhlineBtn);
        fhlinePanel.add(this.fhlinePossArea);
        fhlinePanel.add(this.fhlineActArea);

        // Small Straight panel
        JPanel smslinePanel = new JPanel();
        smslinePanel.setAlignmentX(0.0f);
        smslinePanel.add(this.smslineBtn);
        smslinePanel.add(this.smslinePossArea);
        smslinePanel.add(this.smslineActArea);

        // Large Straight panel
        JPanel lgslinePanel = new JPanel();
        lgslinePanel.setAlignmentX(0.0f);
        lgslinePanel.add(this.lgslineBtn);
        lgslinePanel.add(this.lgslinePossArea);
        lgslinePanel.add(this.lgslineActArea);

        // Yahtzee panel
        JPanel ylinePanel = new JPanel();
        ylinePanel.setAlignmentX(0.0f);
        ylinePanel.add(this.ylineBtn);
        ylinePanel.add(this.ylinePossArea);
        ylinePanel.add(this.ylineActArea);

        // Chance panel
        JPanel clinePanel = new JPanel();
        clinePanel.setAlignmentX(0.0f);
        clinePanel.add(this.clineBtn);
        clinePanel.add(this.clinePossArea);
        clinePanel.add(this.clineActArea);

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
        newScorecardPanel.add(titlePanel);
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
        this.oneBtn.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

    }

    private void addReroll() {
        if(!this.rerollsLeftTextField.getText().equals("0"))
        {
            this.diceValuesTextField.setText(die.dhand(hand,this.diceKeepStringTextField.getText()));
            if(this.rerollsLeftTextField.getText().equals("1"))
            {
                setupScore();
            }
            int i = Integer.parseInt(this.rerollsLeftTextField.getText());
            i--;
            this.rerollsLeftTextField.setText(String.valueOf(i));
        }
    }

    private void setupScore()
    {
        this.scorecardTextArea.setText(score.printSortedArray(hand));
        score.storeCard(hand);
        this.onePossArea.setText(score.getArrayVal("p", 0));
        this.twoPossArea.setText(score.getArrayVal("p", 1));
        this.threePossArea.setText(score.getArrayVal("p", 2));
        this.fourPossArea.setText(score.getArrayVal("p", 3));
        this.fivePossArea.setText(score.getArrayVal("p", 4));
        this.sixPossArea.setText(score.getArrayVal("p", 5));
        this.kline3PossArea.setText(score.getArrayVal("p", 8));
        this.kline4PossArea.setText(score.getArrayVal("p", 9)); 
        this.fhlinePossArea.setText(score.getArrayVal("p", 10)); 
        this.smslinePossArea.setText(score.getArrayVal("p", 11)); 
        this.lgslinePossArea.setText(score.getArrayVal("p", 12)); 
        this.ylinePossArea.setText(score.getArrayVal("p", 13)); 
        this.clinePossArea.setText(score.getArrayVal("p", 14)); 

        // Bonus and total scores text area
        this.bonusArea.setText(score.getArrayVal("p", 7));
        this.totalScoreArea.setText(score.getArrayVal("p", 15));
        this.upperScoreArea.setText(score.getArrayVal("p", 6)); 

        // Actual scores text area
        this.oneActArea.setText(score.getArrayVal("a", 0));
        this.twoActArea.setText(score.getArrayVal("a", 1));
        this.threeActArea.setText(score.getArrayVal("a", 2));
        this.fourActArea.setText(score.getArrayVal("a", 3));
        this.fiveActArea.setText(score.getArrayVal("a", 4));
        this.sixActArea.setText(score.getArrayVal("a", 5));
        this.kline3ActArea.setText(score.getArrayVal("a", 8));
        this.kline4ActArea.setText(score.getArrayVal("a", 9)); 
        this.fhlineActArea.setText(score.getArrayVal("a", 10)); 
        this.smslineActArea.setText(score.getArrayVal("a", 11)); 
        this.lgslineActArea.setText(score.getArrayVal("a", 12)); 
        this.ylineActArea.setText(score.getArrayVal("a", 13)); 
        this.clineActArea.setText(score.getArrayVal("a", 14)); 
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
