package com.vosure.game.graphics;

public class Sprite {

    public final int SIZE;
    private int x;
    private int y;
    public int pixels[];
    private SpriteSheetLoader spriteSheetLoader;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheetLoader.tiles);

    Sprite(int SIZE, int x, int y, SpriteSheetLoader spriteSheetLoader) {

        this.SIZE = SIZE;
        this.x = x;
        this.y = y;
        pixels = new int[SIZE * SIZE];
        this.spriteSheetLoader = spriteSheetLoader;

        loadSprite();

    }

    private void loadSprite() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = spriteSheetLoader.pixels[(x + this.x) + (y + this.y) * spriteSheetLoader.SIZE];
            }
        }

    }

}
