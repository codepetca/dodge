package ca.codepet.gdz;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ca.codepet.dodge.GameRoot;
import ca.codepet.gdz.util.Locator;

public class GameActor extends Sprite {

    protected final GameRoot game = Locator.get(GameRoot.class);

    public GameActor(String texturePath) {
        Texture texture = game.assetManager.get(texturePath);
        super.setTexture(texture);
        super.setOriginCenter();
    }

    // public void update(float delta) {
    // }

    public void render(float delta) {
        game.batch.draw(this, getX(), getY());
    }

}
