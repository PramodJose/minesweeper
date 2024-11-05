package com.ing.minesweeper.controller;

import com.ing.minesweeper.view.SquareTile;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickListener extends MouseAdapter {
    MouseClickObserver mouseClickObserver;

    public MouseClickListener(MouseClickObserver mouseClickObserver) {
        this.mouseClickObserver = mouseClickObserver;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        SquareTile tile = (SquareTile) e.getSource();

        if(e.getButton() == MouseEvent.BUTTON1)
            mouseClickObserver.onLeftClick(tile);
        else if(e.getButton() == MouseEvent.BUTTON3)
            mouseClickObserver.onRightClick(tile);
    }
}
