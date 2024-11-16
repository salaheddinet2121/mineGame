package org.example;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.event.MouseEvent;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;
    private JLabel statusbar;

    @Before
    public void setUp() {
        statusbar = new JLabel();
        board = new Board(statusbar);
    }

    @Test
    public void newGameInitializesBoardCorrectly() {
        board.newGame();
        assertEquals(40, board.getMinesLeft());
        assertTrue(board.isInGame());
    }

    @Test
    public void findEmptyCellsRevealsCorrectCells() {
        board.newGame();
        board.find_empty_cells(0);
        assertEquals(Board.EMPTY_CELL, board.getField()[0]);
    }

    @Test
    public void paintUpdatesStatusbarOnGameWin() {
        board.newGame();
        board.setInGame(false);
        board.paint(board.getGraphics());
        assertEquals("Game won", statusbar.getText());
    }

    @Test
    public void paintUpdatesStatusbarOnGameLoss() {
        board.newGame();
        board.getField()[0] = Board.MINE_CELL;
        board.setInGame(false);
        board.paint(board.getGraphics());
        assertEquals("Game lost", statusbar.getText());
    }

    @Test
    public void mousePressedStartsNewGameOnRightClick() {
        board.newGame();
        board.getMouseListeners()[0].mousePressed(new MouseEvent(board, 0, 0, MouseEvent.BUTTON3, 0, 0, 1, false));
        assertTrue(board.isInGame());
    }

    @Test
    public void mousePressedMarksCellOnRightClick() {
        board.newGame();
        board.getMouseListeners()[0].mousePressed(new MouseEvent(board, 0, 0, MouseEvent.BUTTON3, 0, 0, 1, false));
        assertEquals(Board.MARKED_MINE_CELL, board.getField()[0]);
    }

    @Test
    public void mousePressedRevealsCellOnLeftClick() {
        board.newGame();
        board.getMouseListeners()[0].mousePressed(new MouseEvent(board, 0, 0, MouseEvent.BUTTON1, 0, 0, 1, false));
        assertEquals(Board.EMPTY_CELL, board.getField()[0]);
    }

    @Test
    public void newGameResetsMinesLeft() {
        board.newGame();
        assertEquals(40, board.getMinesLeft());
    }

    @Test
    public void newGameResetsInGameStatus() {
        board.newGame();
        assertTrue(board.isInGame());
    }

    @Test
    public void findEmptyCellsDoesNotRevealMines() {
        board.newGame();
        board.getField()[0] = Board.COVERED_MINE_CELL;
        board.find_empty_cells(1);
        assertEquals(Board.COVERED_MINE_CELL, board.getField()[0]);
    }

    @Test
    public void paintDoesNotChangeStatusbarWhenInGame() {
        board.newGame();
        board.paint(board.getGraphics());
        assertEquals("40", statusbar.getText());
    }
}