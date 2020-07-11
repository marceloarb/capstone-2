package com.teksystems.tekcamp.controller;

import java.awt.Rectangle;

import org.w3c.dom.events.MouseEvent;

public abstract class MouseInput implements MouseEvent{
	
	
	public void mousePressed(MouseEvent e) {
		
//		public Rectangle playButton = new Rectangle(1000/2,250,250,50);
//		public Rectangle helpButton = new Rectangle(1000/2,350,250,50);
//		public Rectangle quitButton = new Rectangle(1000/2,450,250,50);
		
		int locationX = e.getClientX();
		int locationY = e.getClientY();
		
//		if(locationX >= )
	}

}
