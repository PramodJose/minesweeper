package com.ing.minesweeper.controller;

import com.ing.minesweeper.view.SquareTile;

public interface MouseClickObserver {
    void onLeftClick(SquareTile tile);
    void onRightClick(SquareTile tile);
}
