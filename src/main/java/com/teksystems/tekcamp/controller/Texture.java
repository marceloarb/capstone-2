package com.teksystems.tekcamp.controller;

import java.awt.image.BufferedImage;

public class Texture {
    public static BufferedImage[] player;
    public static BufferedImage ghost;
    private final SpriteSheet spriteSheet;

    public Texture() {
        spriteSheet = new SpriteSheet("/Image/caracter1.png");
        player = new BufferedImage[2];
        player[0] = spriteSheet.getSprite(16, 0);
        player[1] = spriteSheet.getSprite(32, 0);
        ghost = spriteSheet.getSprite(0, 0);
    }
}
