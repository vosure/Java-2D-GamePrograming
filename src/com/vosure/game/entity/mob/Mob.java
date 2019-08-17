package com.vosure.game.entity.mob;

import com.vosure.game.entity.Entity;
import com.vosure.game.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move(){
    }

    public void update(){
    }

    public void render(){
    }

    private boolean collision(){
        return false;
    }

}
