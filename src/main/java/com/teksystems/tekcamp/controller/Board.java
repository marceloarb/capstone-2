package com.teksystems.tekcamp.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Board {

    private ArrayList<Point> coins = new ArrayList<>();
    private ArrayList<Point> ghosts = new ArrayList<>();
    private ArrayList<Point> wall = new ArrayList<>();
    
    private int width;
    private int height;
    private Point playerLocation;

    public Board(String path, Player player) {
        coins = new ArrayList<>();
        try {
            BufferedImage map = ImageIO.read(getClass().getResource(path));
            this.width = map.getWidth();
            this.height = map.getHeight();
            int[] pixels = new int[width * height];
            map.getRGB(0, 0, width, height, pixels, 0, width);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int val = pixels[x + (y * width)];
                    if (val == 0xFF000000) {
                    	wall.add(new Point(x * 32, y * 32));
                    } else if (val == 0xFF0000FF) {
                     playerLocation = new Point(x*32,y*32);
                    } else if (val == 0xFFFF0000) {
                        ghosts.add(new Point(x * 32, y * 32));
                    } else {
                    	coins.add(new Point(x * 32, y * 32));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Point getLocationPlayer() {
		return playerLocation;
    	
    }
    
    public ArrayList<Point> getLocationGhosts(){
    	
    	return ghosts;
    }
    
    public ArrayList<Point> getLocationCoins(){
    	return coins;
    }
    
    public ArrayList<Point> getLocationWall(){
    	return wall;
    }
    


    public int width() {

        return width;
    }

    public int height() {

        return height;
    }

}
