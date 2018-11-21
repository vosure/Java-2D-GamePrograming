package com.vosure.game.graphics;

import java.util.Random;

public class Renderer {

    private int width;
    private int height;
    private int[] pixels;
    private static final int MAP_SIZE = 64;
    private static final int MAP_SIZE_MASK = MAP_SIZE - 1;
    private int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private Random random = new Random();

    public Renderer(int width, int height, int[] pixels) {

        this.width = width;
        this.height = height;
        this.pixels = pixels;
        fill();
    }

    private void fill() {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = random.nextInt(0xfffffff);
        }
    }

    public void render(int xOffset, int yOffset) {
        for (int y = 0; y < height; y++) {
            //if (y < 0 || y >= height) break;
            int yy = y + yOffset;
            for (int x = 0; x < width; x++) {
                //if (x < 0 || x >= width) break;
                int xx = x + xOffset;
                int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
                pixels[x + y * width] = Sprite.grass.pixels[(x & 15) + ((y & 15) * Sprite.grass.SIZE)];
                //pixels[x + y * width] = tiles[tileIndex];
            }
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

}
