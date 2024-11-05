package com.ing.minesweeper.controller;

public interface GameObserver {
    void onNewGame();
    void onGameRestart();
}