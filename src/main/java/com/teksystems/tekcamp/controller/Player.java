package com.teksystems.tekcamp.controller;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	
	public boolean right,left,up,down;
	private int speed = 3;
	private int points = 0;
	
	public Player(int x, int y) {
		setBounds(x,y,30,30);
	}
	
	public void tick() {
		if(right && canMove(x+speed,y)) x+=speed;
		if(left && canMove(x-speed,y)) x-=speed;
		if(up && canMove(x,y-speed)) y-=speed;
		if(down && canMove(x,y+speed)) y+=speed;
		
		for(int i = 0; i<Controller.board.coins.size(); i++) {
			if(this.intersects(Controller.board.coins.get(i))) {
				Controller.board.coins.remove(i);
				points +=100;
				System.out.println(points);
				break;
			}
		};
		
		if(Controller.board.coins.size() == 0) {
			Controller.player = new Player(0,0);
			Controller.board = new Board("/Image/pacman1.png");
			return;
		}
		
	}
	
	private boolean canMove(int nextX, int nextY) {
		
		Rectangle bounds = new Rectangle(nextX,nextY,width,height);
		
		for(int x = 0; x<Controller.board.blocks.length; x++) {
			for(int y = 0; y<Controller.board.blocks[0].length; y++) {
				if(Controller.board.blocks[x][y] != null) {
					if(bounds.intersects(Controller.board.blocks[x][y])) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public void render(Graphics g) {
		g.drawImage(Texture.player[0], x, y, 30,30,null);
	}
	
}
