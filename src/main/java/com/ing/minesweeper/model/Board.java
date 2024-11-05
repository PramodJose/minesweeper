package com.ing.minesweeper.model;

import java.util.Random;

public class Board {
    Tile[][] board;
    Tile[] mines;

    public Board( int size, int mineCount ) {
        board = new Tile[size][size];
        for( int row = 0; row < board.length; row++ )
            for( int col = 0; col < board[row].length; col++ )
                board[row][col] = new Tile(row, col);

        this.mines = new Tile[mineCount];
        placeMines();
    }

    void placeMines() {
        Random random = new Random(0); // TODO: Remove seed; it's meant for debugging
        int minesPlaced = 0;

        while( minesPlaced < mines.length) {
            int row = random.nextInt(board.length);
            int col = random.nextInt(board[row].length);

            if( board[row][col].isMine() )
                continue;

            board[row][col].setMine();
            incrementAdjacentTiles(row, col);
            mines[minesPlaced++] = board[row][col];
        }
    }

    void incrementAdjacentTiles( int row, int col ) {
        for( int r = row - 1; r <= row + 1; r++ )     // a 3x3 sub-grid of tiles adjacent to (row, col)
            for( int c = col - 1; c <= col + 1; c++ )
                if( withinBounds(r, c) && (r != row || c != col) ) // increment all adjacent tiles, except (row, col)
                    board[r][c].incrementAdjacentMines();
    }

    public boolean isMine( int row, int col ) {
        if( withinBounds(row, col) )
            return board[row][col].isMine();
        return false;
    }

    public int getAdjacentMines( int row, int col ) {
        if( withinBounds(row, col) )
            return board[row][col].getAdjacentMines();
        return 0;
    }

    public void setRevealed( int row, int col ) {
        if( withinBounds(row, col) )
            board[row][col].setRevealed();
    }

    public boolean isRevealed( int row, int col ) {
        if( withinBounds(row, col) )
            return board[row][col].isRevealed();
        return true;
    }

    public boolean withinBounds( int row, int col ) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }

    public int getMineCount() { return mines.length; }

    public Tile[] getMines() { return mines; }
}
