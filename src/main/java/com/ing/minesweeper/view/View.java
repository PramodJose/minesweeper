package com.ing.minesweeper.view;

import com.ing.minesweeper.controller.GameListener;
import com.ing.minesweeper.controller.GameObserver;
import com.ing.minesweeper.controller.MouseClickListener;

import javax.swing.*;
import java.awt.*;

public class View {
    SquareTile[][] squareBoard;
    int size;
    JFrame frame;
    JLabel statusLabel;
    JPanel statusPanel;
    JPanel boardPanel;
    MouseClickListener listener;
    JButton newGame, restartGame;
    GameListener gameListener;

    final int tileSize = 80; // in pixels
    final String GAME_NAME = "Minesweeper";

    public View( int size, MouseClickListener listener, GameListener gameListener ) {
        this.size = size;
        this.listener = listener;
        this.gameListener = gameListener;
        squareBoard = new SquareTile[size][size];
    }

    public void drawWindow() {
        frame = new JFrame(GAME_NAME);
        frame.setSize(size * tileSize, (size + 1) * tileSize);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        statusLabel = new JLabel();
        statusLabel.setFont(new Font("Arial", Font.BOLD, 25));
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setText(GAME_NAME);
        statusLabel.setOpaque(true);

        newGame = new JButton();
        newGame.setFont(new Font("Arial", Font.BOLD, 25));
        newGame.setText("New Game");
        newGame.setFocusable(true);
        newGame.addMouseListener(gameListener);

        restartGame = new JButton();
        restartGame.setFont(new Font("Arial", Font.BOLD, 25));
        restartGame.setText("Restart Game");
        restartGame.setFocusable(true);
        restartGame.addMouseListener(gameListener);

        statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout());
        statusPanel.add(newGame);
        statusPanel.add(restartGame);
        statusPanel.add(statusLabel);
        frame.add(statusPanel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(size, size));
        frame.add(boardPanel);

        drawTiles();

        frame.setVisible(true);
    }

    public void drawTiles() {
        for(int row = 0; row < size; row++)
            for(int col = 0; col < size; col++) {
                SquareTile squareTile = new SquareTile(row, col);
                squareTile.setFocusable(false);
                squareTile.setMargin(new Insets(0, 0, 0 , 0));
                squareTile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));

                squareTile.addMouseListener(listener);

                squareBoard[row][col] = squareTile;
                boardPanel.add(squareTile);
            }
    }

    public void setStatusPanel(String text) {
        statusLabel.setText(text);
    }

    public void setTileLabel (String text, int row, int col) {
        if( withinBounds(row, col) )
            squareBoard[row][col].setText(text);
    }

    public SquareTile getSquareTile(int row, int col) {
        if( withinBounds(row, col) )
            return squareBoard[row][col];
        return null;
    }

    public boolean withinBounds( int row, int col ) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public void repaintPanel() { boardPanel.revalidate(); boardPanel.repaint(); }
}
