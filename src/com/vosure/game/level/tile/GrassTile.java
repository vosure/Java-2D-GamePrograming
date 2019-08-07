package com.vosure.game.level.tile;

import com.vosure.game.graphics.Screen;
import com.vosure.game.graphics.Sprite;

public class GrassTile extends Tile{

    public GrassTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen){
        screen.renderTile(x, y, this);
    }
}
