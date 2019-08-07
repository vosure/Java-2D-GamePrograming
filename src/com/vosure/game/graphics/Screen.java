package com.vosure.game.graphics;

import com.vosure.game.level.tile.Tile;

import java.util.Random;

public class Screen {

    private int width;
    private int height;
    private int[] pixels;
    private static final int MAP_SIZE = 64;
    private static final int MAP_SIZE_MASK = MAP_SIZE - 1;
    private int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private Random random = new Random();

    public Screen(int width, int height, int[] pixels) {

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
            int yy = y - yOffset * 2;
            if (yy < 0 || yy >= height) continue;
            for (int x = 0; x < width; x++) {
                int xx = x - xOffset * 2;
                if (xx < 0 || xx >= width) continue;
                pixels[xx + yy * width] = Sprite.grass.pixels[(x & 15) + ((y & 15) * Sprite.grass.SIZE)];
            }
        }
    }

    public void renderTile(int xPos, int yPos, Tile tile) {
        for (int y = 0; y < height; y++) {
            int yAbsolutePos = y + yPos;
            for (int x = 0; x < width; x++) {
                int xAbsolutePos = x + xPos;
                if (xAbsolutePos < 0 || xAbsolutePos >= width || yAbsolutePos < 0 || yAbsolutePos >= height)
                    break;;
                    pixels[xAbsolutePos + yAbsolutePos * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

}
