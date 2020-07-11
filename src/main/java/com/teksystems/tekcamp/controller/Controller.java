package com.teksystems.tekcamp.controller;

import com.teksystems.tekcamp.Menu.Menu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Controller extends Canvas implements Runnable, KeyListener {
    private static final String TITLE = "PACMAN";
    //Canvas is a blank rectangular area where we can draw or trap input events from the user.
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 1280, HEIGHT = 960;
    private static final boolean IS_STOP_REQUESTED = false;
    public static Player player;
    public static ArrayList<Coin> coins = new ArrayList<>();
    public static ArrayList<Block> walls = new ArrayList<>();
    private static Board board = Board.getInstance();
    int choice = 1;
    State state = State.MENU;
    private Menu menu = new Menu();
    private ArrayList<Ghost> ghosts = new ArrayList<>();
    private Thread thread = new Thread(this);

    public Controller() {
        Dimension dimension = new Dimension(Controller.WIDTH, Controller.HEIGHT);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        addKeyListener(this);
        player = new Player((int) board.getLocationPlayer().getX(), (int) board.getLocationPlayer().getY());
        for (Point location : Board.getInstance().getLocationGhosts()) {
            this.ghosts.add(new Ghost(location));

        }

        for (Point location : Board.getInstance().getLocationCoins()) {
            this.coins.add(new Coin(location));

        }

        for (Point location : Board.getInstance().getLocationWall()) {
            this.walls.add(new Block(location));
            System.out.println(walls);
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

//        if(state == State.GAME) {
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
//        }
//        else if(state == State.MENU) {
//        	menu.render(g);
//        }


        g.dispose();
        bs.show();

    }

    private void tick() {
        if (state == State.GAME) {
            player.tick();
            for (Ghost ghost : ghosts) {
                ghost.tick();
            }
        }
        if (coins.size() == 0) {
            player.reset();


        }


    }


    @Override
    public void run() {
        //So you dont have to click on the window to move the player
        requestFocus();
        //This function below is to set the time we want our tread to run.
        Long lastTime = System.nanoTime();
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
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;
            player.left = false;
            player.up = false;
            player.down = false;
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
            player.right = false;
            player.up = false;
            player.down = false;
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = true;
            player.left = false;
            player.right = false;
            player.down = false;
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = true;
            player.left = false;
            player.up = false;
            player.right = false;
            return;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = false;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) player.left = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) player.up = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) player.down = false;

    }


}
