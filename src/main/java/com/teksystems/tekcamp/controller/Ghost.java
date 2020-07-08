package com.teksystems.tekcamp.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ghost extends Rectangle{


	private static final long serialVersionUID = 1L;

	public Ghost(int x , int y) {
		setBounds(x,y,32,32);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
		
	}
	
}
