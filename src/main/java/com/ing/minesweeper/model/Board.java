package com.ing.minesweeper.model;

import java.util.Random;

public class Board {
    Tile[][] board;
    Tile[] mines;
    boolean gameOver;

    Board( int size, int mineCount ) throws IllegalArgumentException{
        if( size < 3 || size > 50 )
            throw new IllegalArgumentException("Invalid board size selected");
        else if( mineCount > (size * size)/4 )
            throw new IllegalArgumentException("Too many mines");

        board = new Tile[size][size];
        mines = new Tile[mineCount];
        gameOver = false;

        initializeBoard();
    }

    void initializeBoard() {
        for( int row = 0; row < board.length; row++ )
            for( int col = 0; col < board[row].length; col++ )
                board[row][col] = new Tile(row, col);

        Random generator = new Random(0); // TODO: Remove seed; it's meant for debugging
        int minesPlaced = 0;
        while( minesPlaced < mines.length ) {
            int row = generator.nextInt(board.length);
            int col = generator.nextInt(board[row].length);

            if( board[row][col].isMine() )
                continue;

            board[row][col].setMine();
            mines[minesPlaced] = board[row][col];
            minesPlaced++;

            // Upper row
            incrementNeighbor(row - 1, col - 1);
            incrementNeighbor(row - 1, col);
            incrementNeighbor(row - 1, col + 1);

            // Same row
            incrementNeighbor(row, col - 1);
            incrementNeighbor(row, col + 1);

            // Bottom row
            incrementNeighbor(row + 1, col - 1);
            incrementNeighbor(row + 1, col);
            incrementNeighbor(row + 1, col + 1);
        }
    }

    void incrementNeighbor( int row, int col ) {
        if( row > 0 && row < board.length && col > 0 && col < board[row].length ) // check board bounds
            board[row][col].incrementNeighboringMines();
    }
}
