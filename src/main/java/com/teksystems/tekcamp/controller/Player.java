package com.teksystems.tekcamp.controller;


import java.awt.*;

public class Player extends GameCharacter {

    private static final long serialVersionUID = 1L;
    private final int resetX;
    private final int resetY;
    private final Board board = Board.getInstance();
    public boolean right, left, up, down;
    private int speed = 6;
    private Rectangle rectangle;

    public Player(int x, int y) {
        this.rectangle = new Rectangle(x, y, WIDTH, HEIGHT);
        resetX = x;
        resetY = y;
        reset();
    }

    public void tick() {
    }


    public void render(Graphics g) {
        g.drawImage(Texture.player[0], (int)rectangle.getX(), (int)rectangle.getY(), WIDTH, HEIGHT, null);
    }

    public void reset() {
//        setBounds(resetX, resetY, WIDTH, HEIGHT);
    }

    public boolean intersects(Rectangle gameObject) {
        return rectangle.intersects(gameObject);
    }

    public Point getLocation() {
        return rectangle.getLocation();
    }

	public void moveRight() {
		if (canMove((int)rectangle.getX() + speed,(int) rectangle.getY())) {
			rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
		}
	}
 

	public void moveLeft() {
		if (canMove((int)rectangle.getX() - speed,(int) rectangle.getY())) {
			rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
		}
		
	}

	public void moveUp() {
		if (canMove((int)rectangle.getX(),(int) rectangle.getY() - speed)) {
			rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()- speed); 
		}
		
	}

	public void moveDown() {
		if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
			rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY() + speed); 
		}
		
	}
}
    

