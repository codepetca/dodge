package ca.codepet.dodge;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ca.codepet.gdz.World;
import ca.codepet.gdz.util.Locator;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class GameRoot extends Game {
    public SpriteBatch batch;
    public AssetManager assetManager;
    public World world;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assetManager = new AssetManager();
        world = new World();

        // Load assets asynchronously
        assetManager.load("textures/car_blue.png", Texture.class);
        assetManager.load("textures/car_green.png", Texture.class);
        assetManager.load("textures/car_red.png", Texture.class);
        assetManager.load("textures/hero.png", Texture.class);
        assetManager.load("audio/shove-1.ogg", Sound.class);
        assetManager.load("audio/shove-2.ogg", Sound.class);
        assetManager.load("audio/shove-3.ogg", Sound.class);
        assetManager.load("audio/shove-4.ogg", Sound.class);
        assetManager.load("audio/beach-house.ogg", Music.class);

        // Register the game root to access it from anywhere
        Locator.register(GameRoot.class, this);

        // Launch the first screen
        setScreen(new FirstScreen());
    }
}