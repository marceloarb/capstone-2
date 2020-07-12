package com.teksystems.tekcamp.controller;

import java.awt.Rectangle;

public abstract class GameCharacter {
	protected int WIDTH = 28;
	protected int HEIGHT = 28;
	
	protected boolean canMove(int nextX, int nextY) {
        Rectangle nextPosition = new Rectangle(nextX, nextY, WIDTH, HEIGHT);
        return Board.getInstance().isOpen(nextPosition);
    }
}
