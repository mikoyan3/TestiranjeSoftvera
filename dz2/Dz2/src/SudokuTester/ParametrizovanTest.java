package SudokuTester;
import static org.junit.Assert.assertEquals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.*;
import java.util.Observable;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import nl.elridge.sudoku.controller.*;
import nl.elridge.sudoku.model.*;
import nl.elridge.sudoku.view.*;
import nl.elridge.sudoku.view.Field;


public class ParametrizovanTest {
	private static Game igra1 = new Game();
	
	
	@ParameterizedTest
	@CsvFileSource(files = "C:\\Users\\Perovic\\Desktop\\EclipseWorkSpace\\Dz2\\src\\SudokuTester\\Game1TestCSV.csv")
	public void testGame1(int a, int b, int c) {
		igra1.setHelp(true);
		assertEquals(true, igra1.isHelp());
		if(b == -1) {
			igra1.setSelectedNumber(a);
			assertEquals(a, igra1.getSelectedNumber());
		} else {
			igra1.setSelectedNumber(2);
			igra1.setNumber(a, b, c);
			assertEquals(false, igra1.isCheckValid(a, b));
		}
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "C:\\Users\\Perovic\\Desktop\\EclipseWorkSpace\\Dz2\\src\\SudokuTester\\TestFieldCSV.csv")
	public void testField(int a, int b) {
		Field f = new Field(a, b);
		assertEquals(a, f.getFieldX());
		assertEquals(b, f.getFieldY());
		f.setNumber(a, true);
		assertEquals(Color.BLUE, f.getCol());
	}
}
