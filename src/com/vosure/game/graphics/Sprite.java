package com.vosure.game.graphics;

public class Sprite {

    public final int SIZE;
    private int x;
    private int y;
    public int pixels[];
    private SpriteSheetLoader spriteSheetLoader;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheetLoader.tiles);
    public static Sprite voidSprite = new Sprite(16, 0xB16FCD);

    public static Sprite player0 = new Sprite(16, 0, 10, SpriteSheetLoader.tiles);
    public static Sprite player1 = new Sprite(16, 1, 10, SpriteSheetLoader.tiles);
    public static Sprite player2 = new Sprite(16, 0, 11, SpriteSheetLoader.tiles);
    public static Sprite player3 = new Sprite(16, 1, 11, SpriteSheetLoader.tiles);

    Sprite(int size, int x, int y, SpriteSheetLoader spriteSheetLoader) {

        SIZE = size;
        this.x = x * SIZE;
        this.y = y * SIZE;
        pixels = new int[SIZE * SIZE];
        this.spriteSheetLoader = spriteSheetLoader;

        loadSprite();

    }

    Sprite(int size, int color){
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    private void setColor(int color){
        for (int i = 0; i< SIZE * SIZE; i++){
            pixels[i] = color;
        }
    }

    private void loadSprite() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = spriteSheetLoader.pixels[(x + this.x) + (y + this.y) * 256];
            }
        }

    }

}
