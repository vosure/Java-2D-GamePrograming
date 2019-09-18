package com.vosure.game.graphics;

public class Sprite {

    public final int SIZE;
    private int x;
    private int y;
    public int pixels[];
    private SpriteSheetLoader spriteSheetLoader;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheetLoader.tiles);
    public static Sprite voidSprite = new Sprite(16, 0xB16FCD);

    public static Sprite player_forward = new Sprite(32, 0, 5, SpriteSheetLoader.tiles);
    public static Sprite player_backward = new Sprite(32, 2, 5, SpriteSheetLoader.tiles);
    public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheetLoader.tiles);

    public static Sprite player_forward_1 = new Sprite(32, 0, 6, SpriteSheetLoader.tiles);
    public static Sprite player_forward_2 = new Sprite(32, 0, 7, SpriteSheetLoader.tiles);

    public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheetLoader.tiles);
    public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheetLoader.tiles);

    public static Sprite player_backward_1 = new Sprite(32, 2, 6, SpriteSheetLoader.tiles);
    public static Sprite player_backward_2 = new Sprite(32, 2, 7, SpriteSheetLoader.tiles);


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
