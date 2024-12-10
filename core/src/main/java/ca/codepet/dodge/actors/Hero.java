package ca.codepet.dodge.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Hero extends Actor {

    public boolean isAtTop = true;
    private Texture texture;

    // TODO: Set a default texture path
    public Hero(String texturePath) {
        texture = new Texture(Gdx.files.internal(texturePath));
        setSize(texture.getWidth(), texture.getHeight());
        float x = this.getWidth(); // Offset from the left
        float y = Gdx.graphics.getHeight() / 2 - this.getHeight() / 2;
        this.setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor());
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

}
