package com.ing.minesweeper.model;

public class Tile {
    int row;
    int col;
    int adjacentMines;
    boolean hasMine;
    boolean revealed;

    Tile(int row, int col) {
        adjacentMines = 0;
        hasMine = false;
        this.row = row;
        this.col = col;
        revealed = false;
    }

    public int getRow() { return row; }

    public int getCol() { return col; }

    public void setMine() { hasMine = true; }

    public boolean isMine() { return hasMine; }

    public boolean isRevealed() { return revealed; }

    public void setRevealed() { revealed = true; }

    public void unsetRevealed() { revealed = false; }

    public int getAdjacentMines () { return adjacentMines; }

    void incrementAdjacentMines() { ++adjacentMines; }
}
