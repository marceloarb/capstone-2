package com.teksystems.tekcamp.controller;

import java.awt.*;
import java.util.Random;


public class Ghost extends Rectangle {

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
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

    public Ghost(Point ghostLocation, Point playerLocation) {
        this.playerLocation = playerLocation;
        setBounds(ghostLocation.x, ghostLocation.y, WIDTH, HEIGHT);
        direction = randomGen.nextInt(4);
    }

    public void tick() {
        int smart = 1;
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
            boolean move = false;
            if (x < playerLocation.getX()) {
                if (canMove(x + speed, y)) {
                    x += speed;
                    move = true;
                    lastDirection = right;
                }
            }
            if (x > playerLocation.getY()) {
                if (canMove(x - speed, y)) {
                    x -= speed;
                    move = true;
                    lastDirection = left;
                }
            }
            if (y < playerLocation.getY()) {
                if (canMove(x, y + speed)) {
                    y += speed;
                    move = true;
                    lastDirection = down;
                }
            }
            if (y > playerLocation.getY()) {
                if (canMove(x, y - speed)) {
                    y -= speed;
                    move = true;
                    lastDirection = up;
                }
            }

            if (getLocation().equals(playerLocation)) move = true;
            if (!move) {
                state = findPath;
            }
            time++;
            if (time == targetTime) {
                state = random;
                time = 0;
            } else if (state == findPath) {
                if (lastDirection == right) {
                    if (y < playerLocation.getY()) {
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
                    if (y < playerLocation.getY()) {
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
                    if (x < playerLocation.getX()) {
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
                    if (x < playerLocation.getX()) {
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
