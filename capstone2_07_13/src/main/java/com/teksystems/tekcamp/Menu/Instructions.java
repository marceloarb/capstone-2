package com.teksystems.tekcamp.Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Instructions extends Menu{
	private int width = 500;
	
	
	public static State state = State.MENU;
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.blue);
		g.setFont(new Font(Font.DIALOG,Font.BOLD,50));
		g.drawString("Pac-Man", 1000/2, 150);
		g.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		g.drawString("Play", playButton.x+100,playButton.y+35 );
		g.setColor(Color.white);
		
		
		g.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		g.drawString("Eat all of the Pac-dots around the maze while avoiding the ghosts.", 250, 400);
		g.drawString("To move the Pac-man use the arrow keys.", 250, 450);
		g.drawString("If a ghost attacks, you will lose your life and start over.", 250, 500);
		
				
				
		
	}
	
	
	


}
