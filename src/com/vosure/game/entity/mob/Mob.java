package com.vosure.game.entity.mob;

import com.vosure.game.entity.Entity;
import com.vosure.game.graphics.Screen;
import com.vosure.game.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int direction = 0;
    protected boolean moving = false;

    public void move(int xAxis, int yAxis) {
        if (xAxis > 0) direction = 1;
        if (xAxis < 0) direction = 3;
        if (yAxis > 0) direction = 2;
        if (yAxis < 0) direction = 0;
        if (!collision()) {
            this.x += xAxis;
            this.y += yAxis;
        }
    }

    public void update() {
    }

    public void render(Screen screen) {
    }

    private boolean collision() {
        return false;
    }

}
