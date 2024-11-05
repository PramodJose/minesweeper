package com.ing.minesweeper.controller;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameListener extends MouseAdapter {
    GameObserver gameObserver;

    public GameListener(GameObserver gameObserver) {
        this.gameObserver = gameObserver;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton button = (JButton) e.getSource();

        if(e.getButton() == MouseEvent.BUTTON1)
            if( "Restart Game".equals(button.getText()) )
                gameObserver.onGameRestart();
            else if( "New Game".equals(button.getText()) )
                gameObserver.onNewGame();
    }
}
