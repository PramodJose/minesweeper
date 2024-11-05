package com.ing.minesweeper.controller;

import com.ing.minesweeper.model.Board;
import com.ing.minesweeper.model.Tile;
import com.ing.minesweeper.view.SquareTile;
import com.ing.minesweeper.view.View;

public class GameController implements MouseClickObserver {
    Board board;
    View view;
    int size;
    int mineCount;
    MouseClickListener listener;
    int tilesClicked;
    boolean gameOver;

    public GameController( int size, int mineCount, GameListener gameListener ) throws IllegalArgumentException {
        if( size < 3 || size > 30 )
            throw new IllegalArgumentException("Invalid board size selected");
        else if( mineCount > (size * size)/4 )
            throw new IllegalArgumentException("Too many mines");

        this.size = size;
        this.mineCount = mineCount;
        board = new Board(size, mineCount);
        listener = new MouseClickListener(this);
        view  = new View(size, listener, gameListener);
        tilesClicked = 0;
        gameOver = false;
    }

    public void start() {
        view.drawWindow();
        view.setStatusPanel("Mines: " + board.getMineCount());
    }

    @Override
    public void onLeftClick(SquareTile tile) {
        if(gameOver)
            return;
        int row = tile.getRow();
        int col = tile.getCol();
        if( tile.getText().isEmpty() )
            if( board.isMine(row, col) ) {
                gameOver = true;
                revealMines();
                view.setStatusPanel("You lost ☹");
            }
            else {
                checkMine(row, col);
                view.repaintPanel();
            }
    }

    @Override
    public void onRightClick(SquareTile tile) {
        if(gameOver)
            return;
        if (tile.getText().isEmpty() && tile.isEnabled())
            tile.setText("🚩");
        else if (tile.getText().equals("🚩")) {
            tile.setText("");
        }
    }

    void revealMines() {
        Tile[] mines = board.getMines();

        for(Tile mine: mines) {
            mine.setRevealed();
            view.setTileLabel("💣", mine.getRow(), mine.getCol());
        }
    }

    void checkMine(int row, int col) {
        if ( !board.withinBounds(row, col) || board.isRevealed(row, col))
            return;

        board.setRevealed(row, col);
        int adjacentMines = board.getAdjacentMines(row, col);
        SquareTile squareTile = view.getSquareTile(row, col);
        squareTile.setEnabled(false);
        tilesClicked++;

        if( adjacentMines > 0 )
            squareTile.setText(String.valueOf(adjacentMines));
        else {
            squareTile.setText("");

            for( int r = row - 1; r <= row + 1; r++ )     // a 3x3 sub-grid of tiles adjacent to the current tile (row, col)
                for( int c = col - 1; c <= col + 1; c++ )
                    if( board.withinBounds(r, c) && (r != row || c != col) ) // check all adjacent tiles, except (row, col)
                        checkMine(r, c);
        }

        if( tilesClicked == (size * size) - mineCount ) {
            gameOver = true;
            view.setStatusPanel("You won!");
        }
    }
}
