package ca.codepet.dodge;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ca.codepet.dodge.screens.FirstScreen;
import ca.codepet.gdz.util.Locator;
import ca.codepet.gdz.util.Util;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class GameRoot extends Game {
    public SpriteBatch batch;
    public AssetManager assetManager;
    public Stage stage;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assetManager = new AssetManager();
        stage = new Stage(new ScreenViewport());

        // Load assets asynchronously
        Util.loadAllAssets(this);

        // Register the game root to access it from anywhere
        Locator.register(GameRoot.class, this);

        // Launch the first screen
        setScreen(new FirstScreen());
    }

    @Override
    public void dispose() {
        batch.dispose();
        assetManager.dispose();
        stage.dispose();
    }
}