package com.packtpub.libgdx.canyonbunny;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;


/**
 * Created by bryan on 08/01/2016.
 */
public class Main {
    private static boolean rebuildAtlas = true;
    private static boolean drawDebugOutline = true;

    public static void main(String[] args) {
        if (rebuildAtlas) {
            Settings settings = new Settings();
            settings.maxWidth = 1024;
            settings.maxHeight = 1024;
            settings.duplicatePadding = false;
            settings.debug = drawDebugOutline;
            //TexturePacker.process(settings, "assets-raw/images", "../CanyonBunny-android/assets/images", "canyonbunny.pack");
            TexturePacker.process(settings, "desktop/assets-raw/images", "android/assets/images", "canyonbunny.pack");
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "CanyonBunny";
        config.width = 800;
        config.height = 480;

        new LwjglApplication(new CanyonBunnyMain(), config);
    }
}
