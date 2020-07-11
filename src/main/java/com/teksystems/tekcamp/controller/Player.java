package com.teksystems.tekcamp.controller;


import java.awt.*;

public class Player extends Rectangle {
	
	private static final long serialVersionUID = 1L;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private final int resetX;
    private final int resetY;
    public boolean right, left, up, down;
    private int speed = 3;
    public Player(int x, int y) {
        resetX = x;
        resetY = y;
		reset();
    }

    public void tick() {
        if (right && canMove(x + speed, y)) x += speed;
        if (left && canMove(x - speed, y)) x -= speed;
        if (up && canMove(x, y - speed)) y -= speed;
        if (down && canMove(x, y + speed)) y += speed;

        
    }

    private boolean canMove(int nextX, int nextY) {

        Rectangle bounds = new Rectangle(nextX, nextY, width, height);
         
       
       for (int x = 0; x < Controller.walls.size(); x++) {
            if (Controller.walls.get(x) != null) {
                if (bounds.intersects(Controller.walls.get(x))) {
                    return false;
                }
           }
        }

        return true;
    }

    public void render(Graphics g) {
        g.drawImage(Texture.player[0], x, y, 25, 25, null);
    }
    
    public void reset() {
        setBounds(resetX, resetY, WIDTH, HEIGHT);
    }

	
	
}
    

