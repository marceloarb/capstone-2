package com.teksystems.tekcamp.controller;

import java.awt.*;
import java.util.Random;


public class Ghost extends GameCharacter {

    private static final long serialVersionUID = 1L;
    private static final int random = 0;
    private static final int findPath = 2;
    private static final int right = 0;
    private static final int left = 1;
    private static final int up = 2;
    private static final int down = 3;
    private static final int targetTime = 40 * 4;
    private static final int speed = 3;
    private static final Random randomGen = new Random();
    private final Board board = Board.getInstance();
    private int state = random;
    private int direction;
    private int time = 0;
    private int lastDirection = -1;
    private Point playerLocation;
    private Rectangle rectangle;
    

    public Ghost(Point ghostLocation, Point playerLocation) {
        this.playerLocation = playerLocation;
        this.rectangle = new Rectangle(ghostLocation.x, ghostLocation.y, WIDTH, HEIGHT);
        direction = randomGen.nextInt(4);
    }

    public void tick() {
        int smart = 1;
        if (state == random) {
            if (direction == right) {
                if (canMove((int)rectangle.getX() + speed, (int)rectangle.getY())) {
                	rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == left) {
            	if (canMove((int)rectangle.getX() - speed, (int)rectangle.getY())) {
                	rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == up) {
            	if (canMove((int)rectangle.getX(), (int)rectangle.getY() - speed)) {
                	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()- speed); 
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == down) {
            	if (canMove((int)rectangle.getX(), (int)rectangle.getY() + speed)) {
                	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+ speed); 
                } else {
                    direction = randomGen.nextInt(4);
                }
            }

            time++;
            if (time == targetTime) {
                state = smart;
                time = 0;
            }

        } else if (state == smart) {
            boolean move = false;
            if (rectangle.getX() < playerLocation.getLocation().getX()) {
                if (canMove((int)rectangle.getX() + speed, (int)rectangle.getY())) {
                	rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
                    move = true;
                    lastDirection = right;
                }
            }
            if (rectangle.getX() > playerLocation.getLocation().getX()) {
                if (canMove((int)rectangle.getX() - speed, (int)rectangle.getY())) {
                	rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
                    move = true;
                    lastDirection = left;
                }
            }
            if (rectangle.getY() < playerLocation.getLocation().getY()) {
                if (canMove((int)rectangle.getX() , (int)rectangle.getY() + speed)) {
                	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                    move = true;
                    lastDirection = down;
                }
            }
            if (rectangle.getY() > playerLocation.getLocation().getY()) {
                if (canMove((int)rectangle.getX() , (int)rectangle.getY() - speed)) {
                	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()-speed); 
                    move = true;
                    lastDirection = up;
                }
            }
            if (!move) {
                state = findPath;
            }
            time++;
            if (time == targetTime) {
                state = random;
                time = 0;
            } 
             if (state == findPath) {
                if (lastDirection == right) {
                    if (rectangle.getY() < playerLocation.getLocation().getY()) {
                        if (canMove((int)rectangle.getX(), (int)rectangle.getY() + speed)) {
                        	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                            state = smart;
                        }

                    } else {
                        if (canMove((int)rectangle.getX(), (int)rectangle.getY() - speed)) {
                        	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()-speed); 
                            state = smart;
                        }
                    }
                    if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
               		 rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                    }

                } else if (lastDirection == left) {
                	if (rectangle.getY() > playerLocation.getLocation().getY()) {
                        if (canMove((int)rectangle.getX(), (int)rectangle.getY() - speed)) {
                        	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                            state = smart;
                        }

                    } else {
                        if (canMove((int)rectangle.getX(), (int)rectangle.getY() + speed)) {
                        	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()-speed); 
                            state = smart;
                        }
                    }
                	if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
               		 rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                    }

                } else if (lastDirection == up) {
                	if (rectangle.getX() > playerLocation.getLocation().getX()) {
                        if (canMove((int)rectangle.getX()- speed, (int)rectangle.getY() )) {
                        	rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
                            state = smart;
                        }

                    } else {
                        if (canMove((int)rectangle.getX()+ speed, (int)rectangle.getY() )) {
                        	rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
                            state = smart;
                        }
                    }
                	if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
               		 rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                    }

                } else if (lastDirection == down) {
                	if (rectangle.getX() < playerLocation.getLocation().getX()) {
                        if (canMove((int)rectangle.getX()+ speed, (int)rectangle.getY() )) {
                        	rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
                            state = smart;
                        }

                    } else {
                        if (canMove((int)rectangle.getX()- speed, (int)rectangle.getY() )) {
                        	rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
                            state = smart;
                        }
                    }
                	 if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
                		 rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                     }

            }

            time++;
            

            }
        }

    }

    public void render(Graphics g) {

        g.drawImage(Texture.ghost, (int)rectangle.getX(), (int)rectangle.getY(), WIDTH, HEIGHT, null);

    }

}
