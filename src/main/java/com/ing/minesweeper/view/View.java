package com.ing.minesweeper.view;

import com.ing.minesweeper.model.Board;

import javax.swing.*;
import java.awt.*;

public class View {
    Board board;
    int size;
    JFrame frame;
    JLabel statusLabel;
    JPanel statusPanel;
    JPanel boardPanel;

    final int tileSize = 80; // in pixels
    final String GAME_NAME = "Minesweeper";

    public View( Board board, int size ) {
        this.board = board;
        this.size = size;
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
        statusLabel.setText("Minesweeper: " + board.getMineCount());
        statusLabel.setOpaque(true);

        statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
        statusPanel.add(statusLabel);
        frame.add(statusPanel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(size, size));
        frame.add(boardPanel);

        frame.setVisible(true);
    }
}
