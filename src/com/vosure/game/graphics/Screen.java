package com.vosure.game.graphics;

import com.vosure.game.level.tile.Tile;

import java.util.Random;

public class Screen {

    public int width, height;
    public int xOffset, yOffset;
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

    public void renderTile(int xPos, int yPos, Tile tile) {
        xPos -= xOffset;
        yPos -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++) {
            int yAbsolutePos = y + yPos;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xAbsolutePos = x + xPos;
                if (xAbsolutePos < -tile.sprite.SIZE || xAbsolutePos >= width || yAbsolutePos < 0 || yAbsolutePos >= height)
                    break;
                if (xAbsolutePos < 0)
                    xAbsolutePos = 0;
                    pixels[xAbsolutePos + yAbsolutePos * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void setOffsets(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

}
