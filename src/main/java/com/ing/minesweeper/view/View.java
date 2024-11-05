package com.ing.minesweeper.view;

import com.ing.minesweeper.controller.MouseClickListener;
import com.ing.minesweeper.model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View {
    SquareTile[][] squareBoard;
    int size;
    JFrame frame;
    JLabel statusLabel;
    JPanel statusPanel;
    JPanel boardPanel;
    MouseClickListener listener;

    final int tileSize = 80; // in pixels
    final String GAME_NAME = "Minesweeper";

    public View( int size, MouseClickListener listener ) {
        this.size = size;
        this.listener = listener;
        squareBoard = new SquareTile[size][size];
    }

    public void drawWindow() {
        frame = new JFrame(GAME_NAME);
        frame.setSize(size * tileSize, size * tileSize);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        statusLabel = new JLabel();
        statusLabel.setFont(new Font("Arial", Font.BOLD, 25));
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setText("Minesweeper");
        statusLabel.setOpaque(true);

        statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
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
}
