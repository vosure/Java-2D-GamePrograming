package com.vosure.game.entity.mob;

import com.vosure.game.graphics.Screen;
import com.vosure.game.graphics.Sprite;
import com.vosure.game.input.Keyboard;

import java.awt.event.KeyEvent;

public class Player extends Mob {

    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    public void update() {
        int x = 0, y = 0;
        if (input.up) --y;
        if (input.down) ++y;
        if (input.left) --x;
        if (input.right) ++x;

        if (x != 0 || y != 0) move(x, y);
    }

    public void render(Screen screen) {
        screen.renderPlayer(x, y, Sprite.player0);
        screen.renderPlayer(x + 16, y, Sprite.player1);
        screen.renderPlayer(x, y + 16, Sprite.player2);
        screen.renderPlayer(x + 16, y + 16, Sprite.player3);
    }

}
