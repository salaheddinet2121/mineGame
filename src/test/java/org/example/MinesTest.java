package org.example;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class MinesTest {

    private Mines mines;

    @Before
    public void setUp() {
        mines = new Mines();
    }

    @Test
    public void minesWindowIsVisible() {
        assertTrue(mines.isVisible());
    }

    @Test
    public void minesWindowHasCorrectTitle() {
        assertEquals("Minesweeper", mines.getTitle());
    }

    @Test
    public void minesWindowHasCorrectSize() {
        assertEquals(250, mines.getWidth());
        assertEquals(290, mines.getHeight());
    }

    @Test
    public void minesWindowIsNotResizable() {
        assertFalse(mines.isResizable());
    }

    @Test
    public void minesWindowHasStatusBar() {
        assertNotNull(mines.getContentPane().getComponent(1));
        assertTrue(mines.getContentPane().getComponent(1) instanceof JLabel);
    }
}