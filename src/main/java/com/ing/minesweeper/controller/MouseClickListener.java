package com.ing.minesweeper.controller;

import com.ing.minesweeper.view.SquareTile;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickListener extends MouseAdapter {
    Observer observer;

    public MouseClickListener(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        SquareTile tile = (SquareTile) e.getSource();

        if(e.getButton() == MouseEvent.BUTTON1)
            observer.onLeftClick(tile);
        else if(e.getButton() == MouseEvent.BUTTON3)
            observer.onRightClick(tile);
    }
}
