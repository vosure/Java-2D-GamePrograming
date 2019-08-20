package com.vosure.game.level.tile;

import com.vosure.game.graphics.Screen;
import com.vosure.game.graphics.Sprite;
import com.vosure.game.graphics.SpriteSheetLoader;

public class Tile {

    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);


    public Tile(Sprite sprite) {
        this.sprite = sprite;

    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }

}
