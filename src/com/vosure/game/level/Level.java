package com.vosure.game.level;

import com.vosure.game.graphics.Screen;

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

    public void render(int xScroll, int xScrollm, Screen screen) {
    }

    public void update() {
    }

    private void time() {
    }

}
