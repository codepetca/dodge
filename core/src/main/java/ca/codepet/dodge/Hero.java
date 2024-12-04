package ca.codepet.dodge;

import com.badlogic.gdx.Gdx;

import ca.codepet.gdz.GameActor;

public class Hero extends GameActor {

    public boolean isAtTop = true;

    // TODO: Set a default texture path
    public Hero(String texturePath) {
        super(texturePath);
        this.scale(0.5f);
        float x = this.getWidth();
        float y = Gdx.graphics.getHeight() / 2 - this.getHeight() / 2;
        this.setPosition(x, y);
    }

    @Override
    public void render(float delta) {
        if (isAtTop) {
            setY(00);
        } else {
            setY(getY() - 5);
        }

        if (getY() >= 500) {
            isAtTop = false;
        } else if (getY() <= 0) {
            isAtTop = true;
        }
    }
}
