package SudokuTester;
import static org.junit.Assert.assertEquals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.*;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.*;

import nl.elridge.sudoku.controller.*;
import nl.elridge.sudoku.model.*;
import nl.elridge.sudoku.view.*;
import nl.elridge.sudoku.view.Field;

public class SudokuTester {
	
	@Test
	public void testBP() {
		UpdateAction up1 = UpdateAction.NEW_GAME;
		UpdateAction up2 = UpdateAction.CHECK;
		UpdateAction up3 = UpdateAction.CANDIDATES;
		ButtonPanel bp = new ButtonPanel();
		ButtonController bc = new ButtonController(new Game());
		bp.setController(bc);
		bp.update(new Observable(), up3);
		assertEquals("ELSE", bp.getTest());
		bp.update(new Observable(), up1);
		assertEquals("NEW_GAME", bp.getTest());
		bp.update(new Observable(), up2);
		assertEquals("CHECK", bp.getTest());
	}
	@Test
	public void testSudoku() {
		Sudoku s = new Sudoku();
		assertEquals(true, s.isSudoku());
	}
	@Test
	public void testBC() {
		ButtonController bc = new ButtonController(new Game());
		assertEquals("Exit", bc.getAction());
		ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "New");
		bc.actionPerformed(e);
		assertEquals("New", bc.getAction());
		e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "1");
		bc.actionPerformed(e);
		assertEquals("Else", bc.getAction());
		e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Check");
		bc.actionPerformed(e);
		assertEquals("Check", bc.getAction());
		e = new ActionEvent(new JCheckBox(), ActionEvent.ACTION_PERFORMED, "Help on");
		bc.actionPerformed(e);
		assertEquals("Help on", bc.getAction());
	}
	@Test
	public void testGame2() {
		int igra[][] = new int[9][9];
		int sol[][] = new int[9][9];
		Game game = new Game(sol, igra);
		assertEquals(false, game.isSelectedNumberCandidate(1, 1)); //game = 0
		game.setNumber(1, 1, 1);
		assertEquals(false, game.isSelectedNumberCandidate(1, 1)); //game != 0
		game.setNumber(1, 1, 0);
		assertEquals(false, game.isSelectedNumberCandidate(1, 1)); //possibleX = false
		game.setSelectedNumber(1);
		assertEquals(true, game.isSelectedNumberCandidate(1, 1)); //all = true
		game.setNumber(7, 7, 1);
		assertEquals(false, game.isSelectedNumberCandidate(6, 6)); //block = false
		game.setNumber(7, 7, 0);
		game.setNumber(1, 2, 1);
		assertEquals(false, game.isSelectedNumberCandidate(1, 1)); //possibleY = false
	}
	@Test
	public void testSP() {
		SudokuPanel sp = new SudokuPanel();
		Game game = new Game();
		sp.update(game, UpdateAction.NEW_GAME);
		assertEquals("New_game", sp.getUpdate());
		sp.update(game, UpdateAction.CHECK);
		assertEquals("Check", sp.getUpdate());
		sp.setF(1, 1);
		sp.update(game, UpdateAction.CHECK);
		game.setTrueCheck(1, 1);
		sp.update(game, UpdateAction.CHECK);
		sp.update(game, UpdateAction.SELECTED_NUMBER);
		assertEquals("Selected_number", sp.getUpdate());
		sp.update(game, UpdateAction.CANDIDATES);
		assertEquals("Candidates", sp.getUpdate());
		game.setHelp(false);
		sp.update(game, UpdateAction.HELP);
		assertEquals("Help", sp.getUpdate());
		game.setHelp(true);
		game.setSelectedNumber(1);
		sp.update(game, UpdateAction.HELP);
		sp.update(game, UpdateAction.POMOCNI);
		assertEquals("Else", sp.getUpdate());
	}
	@Test
	public void testSC() {
		SudokuController sc = new SudokuController(new SudokuPanel(), new Game());
		JPanel f = new JPanel();
		MouseEvent me = new MouseEvent(f, 1, 1, 1, 1, 1, 1, false);
		sc.mouseClicked(me);
		assertEquals("mouseClicked", sc.getEvent());
		sc.mouseEntered(me);
		assertEquals("mouseEntered", sc.getEvent());
		sc.mouseReleased(me);
		assertEquals("mouseReleased", sc.getEvent());
		sc.mouseExited(me);
		assertEquals("mouseExited", sc.getEvent());
		sc.mousePressed(me);
		assertEquals("mousePressed", sc.getEvent());
	}
}