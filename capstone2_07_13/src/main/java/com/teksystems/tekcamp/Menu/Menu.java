package com.teksystems.tekcamp.Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Scanner;


public class Menu extends MouseInput{
	
	private static final long serialVersionUID = 1L;
	boolean exit;
	public static State state = State.MENU;
	private int width = 500;
	
	public Rectangle playButton = new Rectangle(width,250,250,50);
	public Rectangle helpButton = new Rectangle(width,350,250,50);
	
	
	
	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		
		
		g.setColor(Color.blue);
		g.setFont(new Font(Font.DIALOG,Font.BOLD,50));
		g.drawString("Pac-Man", 1000/2, 150);
		
		g.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		g.drawString("Play", playButton.x+100,playButton.y+35 );
		g.drawString("Help", helpButton.x+100,helpButton.y+35 );
		g2d.draw(playButton);
		g2d.draw(helpButton);
	}
	
	public void mousePressed(java.awt.event.MouseEvent e) {
		int locationX = e.getX();
		int locationY = e.getY();
		
		if(locationX >= width+100 && locationX <= width+200) {
			if(locationY >= 250 && locationY <= 325) {
				Menu.state = State.GAME;
			}
		}
		if(locationX >= width+100 && locationX <= width+200) {
			if(locationY >= 325 && locationY <= 400) {
				Menu.state = State.HELP;
			}
		}
		
	}
	
	public void run() {
		
		
		
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}
	
	
	
	



	private void performAction(int choice) {
		switch(choice) {
		case 0:
			exit = true;
			break;
		case 1:
			choice = 1;
		case 2:
			choice = 2;
			default:
				
		}
		
	}


	public void printHeader() {
		System.out.println("|------------------------------------|");
		System.out.println("|             Pac-Man                |");
		System.out.println("|         Menu Application           |");
		System.out.println("|------------------------------------|");
	}
	
	
	public void printMenu() {
		System.out.println("1)PLAY!");
		System.out.println("2)Read how to play!");
		System.out.println("0)EXIT!");
	}
	
	private int getInput() {
		Scanner scanner = new Scanner(System.in);
		int choice = -1;
		while(choice < 0 || choice > 2) {
			try {
				choice = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid selection. Please try again.");
			}
			
		}
		return choice;
		
	}
	
	
		
}
