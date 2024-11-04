package com.ing.minesweeper.controller;

import com.ing.minesweeper.model.Board;
import com.ing.minesweeper.view.View;

public class GameController {
    Board board;
    View view;

    public GameController( int size, int mineCount ) throws IllegalArgumentException {
        if( size < 3 || size > 30 )
            throw new IllegalArgumentException("Invalid board size selected");
        else if( mineCount > (size * size)/4 )
            throw new IllegalArgumentException("Too many mines");

        board = new Board(size, mineCount);
        view  = new View(board, size);
    }

    public void start() {
        view.drawWindow();
    }
}
