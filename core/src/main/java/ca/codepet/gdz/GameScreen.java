package ca.codepet.gdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import ca.codepet.dodge.GameRoot;
import ca.codepet.gdz.util.Locator;

public class GameScreen implements Screen {
    protected GameRoot game = Locator.get(GameRoot.class);

    /**
     * Clears the screen.
     */
    public static final void clear() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public float getHeight() {
        return Gdx.graphics.getHeight();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Clear the screen
        clear();

        // Begin drawing the sprites on the batch
        game.batch.begin();

        game.stage.act();
        game.stage.draw();

        // Stop drawing sprites
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
