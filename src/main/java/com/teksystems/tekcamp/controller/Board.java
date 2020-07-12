package com.teksystems.tekcamp.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

    private volatile static Board board;
    private final ArrayList<Block> walls = new ArrayList<>();
    private final ArrayList<Point> coinsLocations = new ArrayList<>();
    private final ArrayList<Point> ghostsLocations = new ArrayList<>();
    private int width;
    private int height;
    private Point playerLocation;
    private Board() {
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
                        this.walls.add(new Block(new Point(x * 32, y * 32)));
                    } else if (val == 0xff4800ff) {
                        playerLocation = new Point(x * 32, y * 32);
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
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    public Point getLocationPlayer() {
        return playerLocation;
    }

    public ArrayList<Point> getLocationGhosts() {

        return ghostsLocations;
    }

    public ArrayList<Point> getLocationCoins() {
        return coinsLocations;
    }

    public ArrayList<Block> getWalls() {
        return walls;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public boolean isOpen(Rectangle nextPosition) {
        for (Block wall : walls) {
            if (nextPosition.intersects(wall)) {
                return false;
            }
        }
        return true;
    }
}
