package com.vosure.game.level;

import javafx.stage.Screen;

public class Level {

    private int width;
    private int height;
    private int[] tiles;

    Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    Level(String path) {
        loadLevel(path);
    }

    private void generateLevel() {
    }

    private void loadLevel(String path) {
    }

    public void render(int xScroll, int xScrollm, Screen screen) {
    }

    public void update() {
    }

    private void time(){
    }

}
