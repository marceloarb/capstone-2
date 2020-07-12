package com.teksystems.tekcamp.controller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import com.teksystems.tekcamp.Menu.Menu;
import com.teksystems.tekcamp.Menu.State;

public class Controller extends Canvas implements Runnable, KeyListener {
    private static final String TITLE = "PACMAN";
    //Canvas is a blank rectangular area where we can draw or trap input events from the user.
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 1280, HEIGHT = 960;
    private static final boolean IS_STOP_REQUESTED = false;
    private static ArrayList<Coin> coins = new ArrayList<>();
    private static ArrayList<Block> walls = new ArrayList<>();
    private final Player player;
    @SuppressWarnings("unused")  // Menu use is currently commented out in another class
    private final Menu menu = new Menu();
    private final ArrayList<Ghost> ghosts = new ArrayList<>();
    private final Thread thread = new Thread(this);
    private int score = 0;

    public Controller() {
        Dimension dimension = new Dimension(Controller.WIDTH, Controller.HEIGHT);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        addKeyListener(this);
        this.addMouseListener(menu);
        Board board = Board.getInstance();
        player = new Player((int) board.getLocationPlayer().getX(), (int) board.getLocationPlayer().getY());
        Board.getInstance().getLocationGhosts().stream().forEach(location->this.ghosts.add(new Ghost(location, player.getLocation())));
        Board.getInstance().getLocationCoins().stream().forEach(location -> this.coins.add(new Coin(location)));
        for (Block block : Board.getInstance().getWalls()) {
        	Point location = block.getLocation();
            this.walls.add(new Block(location));
        }
        new Texture();
    }

    public static String getTitle() {
        return TITLE;
    }

    public synchronized void start() {
        if (thread.isAlive()) {
            return;
        }
        thread.start();
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if(Menu.state == State.GAME) {
        	for (Block wall : walls) {
            wall.render(g);
	        }
	        for (Coin coin : coins) {
	            coin.render(g);
	        }
	        for (Ghost ghost : ghosts) {
	            ghost.render(g);
	        }
	
	        player.render(g);
        }else if(Menu.state == State.MENU) {
        	menu.render(g);
        }
        
        g.dispose();
        bs.show();
    }

    private void tick() {
        if (Menu.state == State.GAME) {
            player.tick();
            ghosts.stream().forEach(ghost -> ghost.tick());
            for (Coin candidate : coins) {
            if (player.intersects(candidate)) {
                this.score += 50;
                coins.remove(candidate);
                break;
            	}
	        }
	        if (coins.size() == 0) {
	            player.reset();
	        }
        }
        


    }

    @Override
    public void run() {
        //So you dont have to click on the window to move the player
        requestFocus();
        //This function below is to set the time we want our tread to run.
        long lastTime = System.nanoTime();
        double delta = 0;
        //targetTick is the time we want our game to run.
        double targetTick = 40.0;
        double interval = 1000000000 / targetTick;
        int framespersecond = 0;
        double timer = System.currentTimeMillis();
        //noinspection InfiniteLoopStatement,LoopConditionNotUpdatedInsideLoop,LoopConditionNotUpdatedInsideLoop
        while (!IS_STOP_REQUESTED) {
            long now = System.nanoTime();
            delta += (now - lastTime) / interval;
            lastTime = now;
            while (delta >= 1) {
                tick();
                render();
                framespersecond++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                framespersecond = 0;
                timer += 1000;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent key) {
    	switch(key.getKeyCode()) {
    	case KeyEvent.VK_RIGHT:
    		player.moveRight();
    		break;
    	case KeyEvent.VK_LEFT:
    		player.moveLeft();	
    		break;
    	case KeyEvent.VK_UP:
    		player.moveUp();
    		break;
    	case KeyEvent.VK_DOWN:
    		player.moveDown();
    		break;
    		default:
    			
    	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

	

	

	
}
