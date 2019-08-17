package com.vosure.game.level;

import com.vosure.game.graphics.Screen;
import com.vosure.game.level.tile.Tile;

public class Level {

    protected int width;
    protected int height;
    protected int[] tiles;

    Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    Level(String path) {
        loadLevel(path);
    }

    protected void generateLevel() {
    }

    private void loadLevel(String path) {
    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffsets(xScroll, yScroll);

        int left = xScroll >> 4;
        int right = (xScroll + screen.width + 16) >> 4;
        int top = yScroll >> 4;
        int bottom = (yScroll + screen.height + 16) >> 4;

        for (int y = top ; y < bottom; y++){
            for (int x = left; x< right; x++){
                getTile(x, y).render(x, y, screen);
            }
        }
    }

    public Tile getTile(int x, int y){
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tiles[x + y * width] == 0) return Tile.grass;
        return Tile.voidTile;
    }

    public void update() {
    }

    private void time() {
    }

}
