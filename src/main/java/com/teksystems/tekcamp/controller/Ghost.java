package com.teksystems.tekcamp.controller;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Ghost extends Rectangle {

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 30, HEIGHT = 30;
    private int random = 0, smart = 1, findPath = 2;
    private int state = random;
    private int right = 0, left = 1, up = 2, down = 3;
    private int direction = -1;
    private int time = 0;

    private int targetTime = 40 * 4;

    private int speed = 3;

    private Random randomGen = new Random();

    private int lastDirection = -1;
	private Board board = Board.getInstance();

    public Ghost(Point coordinates) {
        setBounds(coordinates.x, coordinates.y, WIDTH, HEIGHT);
        direction = randomGen.nextInt(4);
    }

//	private int[] identifyLegalDirections(){
//		int[] directions = new int[4];
//
//		Rectangle right = new Rectangle((x+1),y, WIDTH, HEIGHT);
//
//		(x-1), y;
//		x, (y-1);
//		x, (y+1);
//
//		if(!board.doesIntersectWithWall(right)){
//			directions[0]=right;
//		}
//
//		return directions;
//	}

    public void tick() {

//		moveGhost();
//		int[] possibleDirections = identifyLegalDirections();
//		int selectedDirection = getRandomDirection();
//		setNextMove(selectedDirection);
//


        if (state == random) {
            if (direction == right) {
                if (canMove(x + speed, y)) {
                    x += speed;
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == left) {
                if (canMove(x - speed, y)) {
                    x -= speed;
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == up) {
                if (canMove(x, y - speed)) {
                    y -= speed;
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == down) {
                if (canMove(x, y + speed)) {
                    y += speed;
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
            //Follow the player

            boolean move = false;
            if (x < Controller.player.x) {
                if (canMove(x + speed, y)) {
                    x += speed;
                    move = true;
                    lastDirection = right;
                }
            }
            if (x > Controller.player.x) {
                if (canMove(x - speed, y)) {
                    x -= speed;
                    move = true;
                    lastDirection = left;
                }
            }
            if (y < Controller.player.y) {
                if (canMove(x, y + speed)) {
                    y += speed;
                    move = true;
                    lastDirection = down;
                }
            }
            if (y > Controller.player.y) {
                if (canMove(x, y - speed)) {
                    y -= speed;
                    move = true;
                    lastDirection = up;
                }
            }

            if (x == Controller.player.x && y == Controller.player.y) move = true;
            if (!move) {
                state = findPath;
            }
            time++;
            if (time == targetTime) {
                state = random;
                time = 0;
            } else if (state == findPath) {
                if (lastDirection == right) {
                    if (y < Controller.player.y) {
                        if (canMove(x, y + speed)) {
                            y += speed;
                            state = smart;
                        }

                    } else {
                        if (canMove(x, y - speed)) {
                            y -= speed;
                            state = smart;
                        }
                    }
                    if (canMove(x + speed, y)) {
                        x += speed;
                    }

                } else if (lastDirection == left) {
                    if (y < Controller.player.y) {
                        if (canMove(x, y + speed)) {
                            y += speed;
                            state = smart;
                        }

                    } else {
                        if (canMove(x, y - speed)) {
                            y -= speed;
                            state = smart;
                        }
                    }
                    if (canMove(x - speed, y)) {
                        x -= speed;
                    }

                } else if (lastDirection == up) {
                    if (x < Controller.player.x) {
                        if (canMove(x + speed, y)) {
                            x += speed;
                            state = smart;
                        }

                    } else {
                        if (canMove(x - speed, y)) {
                            x -= speed;
                            state = smart;
                        }
                    }
                    if (canMove(x, y - speed)) {
                        y -= speed;
                    }

                } else if (lastDirection == down) {
                    if (x < Controller.player.x) {
                        if (canMove(x + speed, y)) {
                            x += speed;
                            state = smart;
                        }

                    } else {
                        if (canMove(x - speed, y)) {
                            x -= speed;
                            state = smart;
                        }
                    }
                    if (canMove(x, y + speed)) {
                        y += speed;
                    }
                }

            }

            time++;
            if (time == targetTime) {
                state = random;
                time = 0;
            }

        }

    }

    private boolean canMove(int nextX, int nextY) {
        Rectangle nextPosition = new Rectangle(nextX, nextY, width, height);
        
        return board.isOpen(nextPosition);
       
    }

    public void render(Graphics g) {
    	
        g.drawImage(Texture.ghost, x, y, WIDTH, HEIGHT, null);

    }

}
