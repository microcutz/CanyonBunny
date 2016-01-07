package com.packtpub.libgdx.canyonbunny.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;



/**
 * Created by bryan on 07/01/2016.
 */
public class WorldController {
    private static final String TAG = WorldController.class.getName();

    public Sprite[] testSprites;
    public int selectedSprite;

    public WorldController () {
        init();
    }

    private void init () {
        initTestObjects();
    }

    private void initTestObjects() {
        // Create new array for 5 Sprites
        testSprites = new Sprite[5];

        // Create empty POT-sized Pixmap with 8bit RGBA pixel data
        int width = 32;
        int height = 32;

        Pixmap pixmap = createProceduralPixmap(width, height);

        // Create a new texture from pixmapdata
        Texture texture = new Texture(pixmap);

        // Create new sprites using the just created texture
        for (int i = 0; i < testSprites.length; i++) {
            Sprite spr = new Sprite(texture);
            // Define sprite size to be 1m x 1m in game world
            spr.setSize(1, 1);
            // Set origin to sprite's center
            spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);
            // Calculate random positions for sprite
            float randomX = MathUtils.random(-2.0f, 2.0f);
            float randomY = MathUtils.random(-2.0f, 2.0f);
            spr.setPosition(randomX, randomY);
            // Put new sprite into array
            testSprites[i] = spr;
        }

        // Set the first sprite as selected one
        selectedSprite = 0;
    }

    private Pixmap createProceduralPixmap (int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Format.RGBA8888);
        // Fill square with red colour at 50% OPACITY
        pixmap.setColor(1, 0, 0, 0.5f);
        pixmap.fill();

        // Draw a yellow coloured X on shape
        pixmap.setColor(1,1,0,1);
        pixmap.drawLine(0, 0, width,height);
        pixmap.drawLine(width, 0, 0, height);

        // Draw cyan-coloured border around square
        pixmap.setColor(0, 1, 1, 1);
        pixmap.drawRectangle(0, 0, width, height);
        return pixmap;
    }

    public void update (float deltaTime) {
        updateTestObjects(deltaTime);
    }

    private void updateTestObjects (float deltaTime) {
        // Get current rotation from selected sprite
        float rotation = testSprites[selectedSprite].getRotation();
        // Rotate sprite by 90 degress per second
        rotation += 90 * deltaTime;
        // Wrap around at 360 degrees
        rotation %=360;
        // Set new rotation value to selected sprite
        testSprites[selectedSprite].setRotation(rotation);
    }
}
