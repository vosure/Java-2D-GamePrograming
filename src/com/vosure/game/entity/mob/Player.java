package com.vosure.game.entity.mob;

import com.vosure.game.graphics.Screen;
import com.vosure.game.graphics.Sprite;
import com.vosure.game.input.Keyboard;

import java.awt.event.KeyEvent;

public class Player extends Mob {

    private Sprite player;
    private int animation = 0;
    private boolean walking = false;
    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public void update() {
        int x = 0, y = 0;

        if (animation < 7500)
            animation++;
        else
            animation = 0;
        if (input.up) --y;
        if (input.down) ++y;
        if (input.left) --x;
        if (input.right) ++x;

        if (x != 0 || y != 0) {
            move(x, y);
            walking = true;
        } else
            walking = false;
    }

    public void render(Screen screen) {
        int flip = 0;
        if (direction == 0) {
            sprite = Sprite.player_forward;
            if (walking){
                if (animation % 20 > 10)
                    sprite = Sprite.player_forward_1;
                else
                    sprite = Sprite.player_forward_2;
            }
        }
        if (direction == 1) {
            sprite = Sprite.player_side;
            if (walking){
                if (animation % 20 > 10)
                    sprite = Sprite.player_side_1;
                else
                    sprite = Sprite.player_side_2;
            }
        }
        if (direction == 2) {
            sprite = Sprite.player_backward;
            if (walking){
                if (animation % 20 > 10)
                    sprite = Sprite.player_backward_1;
                else
                    sprite = Sprite.player_backward_2;
            }
        }
        if (direction == 3) {
            sprite = Sprite.player_side;
            flip = 1;
            if (walking){
                if (animation % 20 > 10)
                    sprite = Sprite.player_side_1;
                else
                    sprite = Sprite.player_side_2;
            }
        }
        screen.renderPlayer(x - 16, y - 16, sprite, flip);
    }

}
