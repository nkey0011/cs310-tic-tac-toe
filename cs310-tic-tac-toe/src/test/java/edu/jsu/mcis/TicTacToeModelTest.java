package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeModelTest {
	
    private TicTacToeModel board;

    @Before
    public void setup(){
        
        board = new TicTacToeModel(3);
        
    }

    @Test
    public void testInitialBoardIsEmpty() {
        
        for (int row = 0; row < board.getWidth(); row++) {
            
            for (int col = 0; col < board.getWidth(); col++) {
                
                assertEquals(TicTacToeModel.Mark.EMPTY, board.getMark(row,col));   
                
            }
            
        }
        
    }

    @Test
    public void testMarkXInUpperRightCorner() {
        
        assertEquals(TicTacToeModel.Mark.EMPTY, board.getMark(0,2));
        assertTrue(board.makeMark(0,2));
        assertEquals(TicTacToeModel.Mark.X, board.getMark(0,2));
        
    }

    @Test
    public void testMarkOInBottomLeftCorner() {
        
        assertEquals(TicTacToeModel.Mark.EMPTY, board.getMark(1,1));
        assertTrue(board.makeMark(1,1));
        assertEquals(TicTacToeModel.Mark.X, board.getMark(1,1));
        assertEquals(TicTacToeModel.Mark.EMPTY, board.getMark(2,0));
        assertTrue(board.makeMark(2,0));
        assertEquals(TicTacToeModel.Mark.O, board.getMark(2,0));
        
    }

    @Test
    public void testUnableToMarkOverExistingMark() {
        
        assertEquals(TicTacToeModel.Mark.EMPTY, board.getMark(1,1));
        assertTrue(board.makeMark(1, 1));
        assertEquals(TicTacToeModel.Mark.X, board.getMark(1,1));
        assertFalse(board.makeMark(1, 1));
        assertEquals(TicTacToeModel.Mark.X, board.getMark(1,1));
        
    }

    @Test
    public void testGameIsNotOverAfterTheFirstMark() {
        
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        assertTrue(board.makeMark(0, 0));
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        
    }

    @Test
    public void testGameIsWonByXHorizontallyAcrossTopRow() {
        
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 0);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(1, 1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(2, 2);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 2);
        assertEquals(TicTacToeModel.Result.X, board.getResult());
        
    }

    @Test
    public void testGameIsOverByTieIfAllLocationsAreFilled() {
        
        assertEquals(TicTacToeModel.Result.NONE, board.getResult()); 
        board.makeMark(0, 0);										   
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());  
        board.makeMark(0, 2);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(1, 0);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(1, 2);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(1, 1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(2, 0);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(2, 2);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(2, 1);
        assertEquals(TicTacToeModel.Result.TIE, board.getResult());
        
    }

    @Test
    public void testOutOfBoundsMark() {
        
        assertFalse(board.makeMark(0,3));
        assertFalse(board.makeMark(-1,0));
        assertFalse(board.makeMark(0,-1));
        assertFalse(board.makeMark(40000, 3));
        
    }

    @Test  
    public void testGameIsWonByOWithFirstCol() {
        
        board.makeMark(1, 1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 0);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(1, 0);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 2);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(2, 0);
        assertEquals(TicTacToeModel.Result.O, board.getResult());
        
    }

    @Test  
    public void testGameIsWonByXDiagonallyFromTopLeftToBottomRight() {
        
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 0);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(1, 1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0, 2);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(2, 2);
        assertEquals(TicTacToeModel.Result.X, board.getResult());
        
    }

    @Test
    public void testGameisWonByODiagonallyFromBottomLeftToTopRight() {
        
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(2,1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(2,0);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0,0);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(1,1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0,1);
        assertEquals(TicTacToeModel.Result.NONE, board.getResult());
        board.makeMark(0,2);
        assertEquals(TicTacToeModel.Result.O, board.getResult());
        
    }

    @Test
    public void testXWinDiagonallyFromTopLeftToBottomRightOn5x5Board() {
        
        TicTacToeModel largerBoard = new TicTacToeModel(5);
        assertEquals(5, largerBoard.getWidth());
        largerBoard.makeMark(0,0);
        assertEquals(TicTacToeModel.Mark.X, largerBoard.getMark(0,0));
        largerBoard.makeMark(0,1);
        assertEquals(TicTacToeModel.Mark.O, largerBoard.getMark(0,1));
        largerBoard.makeMark(1,1);
        assertEquals(TicTacToeModel.Mark.X, largerBoard.getMark(1,1));
        largerBoard.makeMark(0,2);
        assertEquals(TicTacToeModel.Mark.O, largerBoard.getMark(0,2));
        largerBoard.makeMark(2,2);
        assertEquals(TicTacToeModel.Mark.X, largerBoard.getMark(2,2));
        largerBoard.makeMark(0,3);
        assertEquals(TicTacToeModel.Mark.O, largerBoard.getMark(0,3));
        largerBoard.makeMark(3,3);
        assertEquals(TicTacToeModel.Mark.X, largerBoard.getMark(3,3));
        largerBoard.makeMark(0,4);
        assertEquals(TicTacToeModel.Mark.O, largerBoard.getMark(0,4));
        largerBoard.makeMark(4,4);
        assertEquals(TicTacToeModel.Mark.X, largerBoard.getMark(4,4));
        assertEquals(TicTacToeModel.Result.X, largerBoard.getResult());
        
    }
		
}