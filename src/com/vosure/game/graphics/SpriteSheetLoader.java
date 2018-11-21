package com.vosure.game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheetLoader {

    private String path;
    public final int SIZE;
    public int pixels[];

    public static SpriteSheetLoader tiles = new SpriteSheetLoader("/res/textures/spriteSheet.png", 256);

    SpriteSheetLoader(String path, int SIZE) {
        this.path = path;
        this.SIZE = SIZE;
        pixels = new int[SIZE * SIZE];
        loadSprite();
    }

    private void loadSprite() {

        try {
            BufferedImage image = ImageIO.read(getClass().getResource("/textures/spriteSheet.png")); //"/resources/images/spriteSheet.png"
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
