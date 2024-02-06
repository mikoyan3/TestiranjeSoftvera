package SudokuTester;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.junit.*;

import nl.elridge.sudoku.controller.SudokuController;
import nl.elridge.sudoku.model.Game;
import nl.elridge.sudoku.model.MockInterface;

import org.easymock.*;

public class MockTest extends EasyMockSupport {
	private MockInterface mi;
	private Game game3;
	@Before
	public void setUp(){
		mi = createNiceMock(MockInterface.class);
		game3 = new Game();
	}
	@Test
	public void testHelpMockito() {
		expect(mi.isHelpMock()).andReturn(true);
		replay(mi);
		game3.setInterface(mi);
		game3.setHelpMockito();
		assertEquals(true, game3.isHelp());
		reset(mi);
		expect(mi.isHelpMock()).andReturn(false);
		replay(mi);
		game3.setInterface(mi);
		game3.setHelpMockito();
		assertEquals(false, game3.isHelp());
	}
	@Test
	public void testGetSelectedMockito() {
		expect(mi.getSelectedCandidateMock()).andReturn(15);
		replay(mi);
		game3.setInterface(mi);
		game3.setNumberMockito();
		assertEquals(15, game3.getSelectedNumber());
	}
	@Test
	public void testIsCandidateMockito() {
		expect(mi.isPossibleBlock()).andReturn(true);
		expect(mi.isPossibleX()).andReturn(true);
		expect(mi.isPossibleY()).andReturn(true);
		replay(mi); //all true
		game3.setInterface(mi);
		assertEquals(true, game3.isNumberCandidateMockito());
		reset(mi);
		expect(mi.isPossibleBlock()).andReturn(true);
		expect(mi.isPossibleX()).andReturn(false);
		expect(mi.isPossibleY()).andReturn(true);
		replay(mi); // x = false
		game3.setInterface(mi);
		assertEquals(false, game3.isNumberCandidateMockito());
		reset(mi);
		expect(mi.isPossibleBlock()).andReturn(false);
		expect(mi.isPossibleX()).andReturn(true);
		expect(mi.isPossibleY()).andReturn(true);
		replay(mi); // block = false
		game3.setInterface(mi);
		assertEquals(false, game3.isNumberCandidateMockito());
		reset(mi);
		expect(mi.isPossibleBlock()).andReturn(false);
		expect(mi.isPossibleX()).andReturn(true);
		expect(mi.isPossibleY()).andReturn(false);
		replay(mi); // y = false
		game3.setInterface(mi);
		assertEquals(false, game3.isNumberCandidateMockito());
	}
}

