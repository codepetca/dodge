package ca.codepet.dodge;

import com.badlogic.gdx.Gdx;

import ca.codepet.gdz.GameActor;

public class Car extends GameActor {

    public Car(String texturePath) {
        super(texturePath);
        this.scale(0.1f);

        float screenWidth = Gdx.graphics.getWidth();
        float y = Math.random() < 0.5 ? 0 : Gdx.graphics.getHeight() - this.getHeight();
        this.setPosition(screenWidth, y);
    }

    @Override
    public void render(float delta) {
        /**
         * Updates the car's position.
         */
        float speed = 200;
        this.setX(this.getX() - speed * Gdx.graphics.getDeltaTime());
        if (this.getX() < -this.getWidth()) {
            game.world.remove(this);
        }

    }

}
