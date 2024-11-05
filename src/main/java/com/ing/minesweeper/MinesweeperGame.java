package com.ing.minesweeper;

import com.ing.minesweeper.controller.GameController;
import com.ing.minesweeper.controller.GameListener;
import com.ing.minesweeper.controller.GameObserver;

public class MinesweeperGame implements GameObserver {
    GameController controller;
    GameListener gameListener;

    public MinesweeperGame() {
        gameListener = new GameListener(this);
        controller = new GameController(8, 1, gameListener);
        controller.start();
    }

    @Override
    public void onNewGame() {
        controller = new GameController(8, 1, gameListener);
        controller.start();
    }

    @Override
    public void onGameRestart() {

    }
}
