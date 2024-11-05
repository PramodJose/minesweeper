package com.ing.minesweeper.view;

import javax.swing.*;

public class SquareTile extends JButton {
    int row;
    int col;

    SquareTile( int row, int col ) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }

    public int getCol() { return col; }
}
