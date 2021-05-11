package com.teksystems.tekcamp.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Coin extends Rectangle{
	
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 8, HEIGHT = 8;

	public Coin(Point coordinate) {
		setBounds(coordinate.x+15,coordinate.y+13,WIDTH,HEIGHT);
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
		
	}
	
}
