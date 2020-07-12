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
		g.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		g.drawString("This game is blabla", 450, 400);
		
	}
	
	
	


}
