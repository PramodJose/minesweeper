package com.ing.minesweeper.controller;

import com.ing.minesweeper.view.SquareTile;

public interface Observer {
    void onLeftClick(SquareTile tile);
    void onRightClick(SquareTile tile);
}
