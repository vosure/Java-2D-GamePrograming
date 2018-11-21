package com.vosure.game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    private String path;
    private final int SIZE;
    public int pixels[];

    SpriteSheet(String path, int SIZE) {
        this.path = path;
        this.SIZE = SIZE;
        pixels = new int[SIZE * SIZE];
        loadSprite();
    }

    private void loadSprite() {

        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
