package com.ing.minesweeper.model;

public class Tile {
    int adjacentMines;
    boolean hasMine;
    boolean revealed;
    boolean flagged;

    Tile() {
        adjacentMines = 0;
        hasMine = false;
        revealed = false;
        flagged = false;
    }

    void setMine() { hasMine = true; }

    boolean isMine() { return hasMine; }

    boolean isRevealed() { return revealed; }

    void reveal() { revealed = true; }

    boolean isFlagged() { return flagged; }

    void setFlag() { flagged = true; }

    void incrementAdjacentMines() { ++adjacentMines; }
}
