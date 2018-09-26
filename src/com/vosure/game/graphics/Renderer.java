package com.vosure.game.graphics;

public class Renderer {

    private int width;
    private int height;
    private int[] pixels;

    //private int xtime = 0, ytime = 0;
    //private int counter = 0;

    public Renderer(int width, int height, int[] pixels) {

        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public void render() {
        //counter++;
        //if (counter % 60 == 0) xtime++;
        //if (counter % 120 == 0) ytime++;
        for (int y = 0; y < height; y++) {
            //if (ytime < 0 || ytime >= height) break;
            for (int x = 0; x < width; x++) {
                //if (xtime < 0 || xtime >= width) break;
                //pixels[xtime + ytime * width] = 0x0FF2BA;
                pixels[x + y * width] = 0x0FF2BA;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

}
