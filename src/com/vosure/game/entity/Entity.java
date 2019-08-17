package com.vosure.game.entity;

import com.vosure.game.graphics.Screen;
import com.vosure.game.level.Level;

import java.util.Random;

public abstract class Entity {

    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    public void update(){
    }

    public void render(Screen screen){
    }

    public void remove(){
        removed = true;
    }

    public boolean isRemoved(){
        return removed;
    }

}
