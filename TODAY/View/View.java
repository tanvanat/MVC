package View;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class View extends JFrame{
    // Choosefromwhat
    private JRadioButton choosefromroom = new JRadioButton("choose from room");
    private JRadioButton choosefromgame = new JRadioButton("choose from game");
    private ButtonGroup buttonGroup = new ButtonGroup();

    private JPanel additionalPanel = new JPanel();

    private JLabel additionalLabel = new JLabel("This is the additional panel");
    //receiving input
    private JTextArea input = new JTextArea();
    //summit button
    private JButton summit = new JButton("summit");
    // Print output
    private JLabel Anslb = new JLabel("ANS");
    private JTextArea ANSta = new JTextArea();

    public View(){
        JPanel j = new JPanel();
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Set layout to null to use absolute positioning
        j.setLayout(null);

        // Choose answer type (radio buttons)
        choosefromroom.setBounds(50, 30, 150, 30);
        choosefromgame.setBounds(300, 30, 150, 30);
        buttonGroup.add(choosefromroom);
        buttonGroup.add(choosefromgame);
        j.add(choosefromroom);
        j.add(choosefromgame);

        //additional panel
        additionalPanel.setBounds(30, 70, 350, 20);
        additionalPanel.setVisible(false); // Initially set to invisible
        additionalPanel.add(additionalLabel);
        j.add(additionalPanel);

        // Set action listener for radio buttons
        choosefromroom.addActionListener(e -> handleRadioButtonSelection("choosefromroom"));
        choosefromgame.addActionListener(e -> handleRadioButtonSelection("choosefromgame"));
        
        //receiving input
        input.setBounds(50, 100, 100, 30);
        j.add(input);

        summit.setBounds(430, 80, 90, 30);
        j.add(summit);

        //print output
        Anslb.setBounds(50, 200, 300, 100);
        j.add(Anslb);

        ANSta.setBounds(50, 200, 300, 100);
        j.add(ANSta);

        this.add(j);
        this.setVisible(true);
    }

    private void handleRadioButtonSelection(String selectedType) {
        additionalLabel.setText("");
        if (selectedType.equals("choosefromroom")) {
            additionalLabel.setText("ROOM1 ROOM2 ROOM3 ROOM4 ROOM5");
            additionalPanel.setVisible(true);
        } else if (selectedType.equals("choosefromgame")) {
            additionalLabel.setText("GAME1 GAME2 GAME3 GAME4 GAME5");
            additionalPanel.setVisible(true);
        } else {
            displayErrorMessage("Try again");
        }
    }


    public JButton getsummit() {
        return summit;
    }
    public void setAns(String ans) {
        ANSta.setText(ans);
    }
    public String get_type() {
        if (choosefromgame.isSelected()) {
            return "choosefromgame";
        } else if (choosefromroom.isSelected()) {
            return "choosefromroom";
        } else {
            return "No Type Selected";
        }
    }

    public String getinput() {
        return input.getText();
    }

    public void addCalculationListener(ActionListener listenerForCalcButton) {
        summit.addActionListener(listenerForCalcButton);
    }

    public void displayErrorMessage(String e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
