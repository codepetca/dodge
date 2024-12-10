package ca.codepet.dodge.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import ca.codepet.dodge.actors.Hero;
import ca.codepet.gdz.GameScreen;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen extends GameScreen {

    float inputCooldown = 0.3f;
    float timeSinceLastInput = 0;

    Hero hero;

    /*
     * Prepare the screen to be displayed.
     */
    @Override
    public void show() {
        // Blocks execution until all assets are loaded
        game.assetManager.finishLoading();

        // Spawn the hero
        hero = new Hero("textures/hero.png");
        hero.setPosition(100, 100);
        game.stage.addActor(hero);

    }

    // Handle user input
    private void onInput() {
        if (Gdx.input.isTouched()) {
            timeSinceLastInput = 0;
        }
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update the stage
        game.stage.act(delta);

        // Render the stage
        game.stage.draw();

        // Handle input
        onInput();

    }

}