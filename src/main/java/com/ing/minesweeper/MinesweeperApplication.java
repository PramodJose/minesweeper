package com.ing.minesweeper;

import com.ing.minesweeper.controller.GameController;

public class MinesweeperApplication {

	public static void main(String[] args) {
		GameController controller = new GameController(8, 1);
		controller.start();
	}
}
