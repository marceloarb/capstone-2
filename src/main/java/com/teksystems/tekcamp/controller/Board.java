package com.teksystems.tekcamp.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Board {

    private ArrayList<Point> coinsLocations = new ArrayList<>();
    private ArrayList<Point> ghostsLocations = new ArrayList<>();
    private ArrayList<Point> wallLocations = new ArrayList<>();
    private static ArrayList<Block> walls = new ArrayList<>();
    
    private int width;
    private int height;
    private Point playerLocation;
    private volatile static Board board;

    public Board() {
        try {
            BufferedImage map = ImageIO.read(getClass().getResource("/Image/maze.png"));
            this.width = map.getWidth();
            this.height = map.getHeight();
            int[] pixels = new int[width * height];
            map.getRGB(0, 0, width, height, pixels, 0, width);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int val = pixels[x + (y * width)];
                    if (val == 0xFF000000) {
                    	this.walls.add(new Block(new Point(x*32,y*32)));
                    } else if (val == 0xFF0000FF) {
                     playerLocation = new Point(x*32,y*32);
                    } else if (val == 0xFFFF0000) {
                        ghostsLocations.add(new Point(x * 32, y * 32));
                    } else {
                    	coinsLocations.add(new Point(x * 32, y * 32));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Board getInstance() {
		if(board == null) {
			board = new Board();
		}
		return board;
	}
    public Point getLocationPlayer() {
		return playerLocation;
    	
    }
    
    public ArrayList<Point> getLocationGhosts(){
    	
    	return ghostsLocations;
    }
    
    public ArrayList<Point> getLocationCoins(){
    	return coinsLocations;
    }
    
    public ArrayList<Point> getLocationWall(){
    	return wallLocations;
    }
    


    public int width() {

        return width;
    }

    public int height() {

        return height;
    }

	public boolean isOpen(Rectangle nextPosition) {
		
		for (int x = 0; x < wallLocations.size(); x++) {
            if (Controller.walls.get(x) != null) {
                if (nextPosition.intersects(Controller.walls.get(x))) {
                    return false;
                }
           }
        }
		
				return false;
	}

	

}
