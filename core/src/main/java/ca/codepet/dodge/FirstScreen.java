package ca.codepet.dodge;

import com.badlogic.gdx.Gdx;

import ca.codepet.gdz.GameScreen;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen extends GameScreen {

    float inputCooldown = 0.3f;
    float timeSinceLastInput = 0;

    /*
     * Prepare the screen to be displayed.
     */
    @Override
    public void show() {
        // Blocks execution until all assets are loaded
        game.assetManager.finishLoading();

        // Spawn the hero
        Hero hero = new Hero("textures/hero.png");
        game.world.add(hero);

        // Spawn a car
        Car car = new Car("textures/car_red.png");
        game.world.add(car);
    }

    @Override
    public void render(float delta) {
        timeSinceLastInput += delta;
        if (timeSinceLastInput >= inputCooldown) {
            onInput();
        }

        super.render(delta);
    }

    /**
     * Handles input from the user.
     */
    private void onInput() {
        if (Gdx.input.isTouched()) {

            timeSinceLastInput = 0;
        }
    }

}