package nl.elridge.sudoku.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import nl.elridge.sudoku.model.Game;

/**
 * This class controls all user actions from ButtonPanel.
 *
 * @author Eric Beijer
 */
public class ButtonController implements ActionListener {
    private Game game;
    private String action;
    /**
     * Constructor, sets game.
     *
     * @param game  Game to be set.
     */
    public ButtonController(Game game) {
        this.game = game;
        action = "Exit";
    }
    public String getAction() {
    	return action;
    }
    /**
     * Performs action after user pressed button.
     *
     * @param e ActionEvent.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            game.newGame();
            action = "New";
        }
        else if (e.getActionCommand().equals("Check")) {
            game.checkGame();
            action = "Check";
        }
        else if (e.getActionCommand().equals("Exit"))
            System.exit(0);
        else if (e.getActionCommand().equals("Help on"))
        {
            game.setHelp(((JCheckBox)e.getSource()).isSelected());
            action = "Help on";
        }
        else {
            game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
            action = "Else";
        }
    }
}