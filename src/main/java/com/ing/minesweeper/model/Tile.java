package com.ing.minesweeper.model;

import java.awt.Point;

public class Tile {
    Point position;
    int neighboringMines;
    boolean hasMine;
    boolean revealed;
    boolean flagged;

    Tile( int x, int y ) {
        position = new Point(x, y);
        neighboringMines = 0;
        hasMine = false;
        revealed = false;
        flagged = false;
    }

    void setMine() {
        hasMine = true;
    }

    boolean isMine() {
        return hasMine;
    }

    boolean isRevealed() {
        return revealed;
    }

    void reveal() {
        revealed = true;
    }

    boolean isFlagged() {
        return flagged;
    }

    void setFlag() {
        flagged = true;
    }

    void incrementNeighboringMines() {
        ++neighboringMines;
    }
}
