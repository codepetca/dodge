package ca.codepet.gdz;

import com.badlogic.gdx.utils.Array;

public class World {
    private final Array<GameActor> gameActors = new Array<>();

    public void add(GameActor gameActor) {
        gameActors.add(gameActor);
    }

    public void remove(GameActor gameActor) {
        gameActors.removeValue(gameActor, true);
    }

    public void render(float delta) {
        var iterator = gameActors.iterator();
        while (iterator.hasNext()) {
            var gameActor = iterator.next();
            gameActor.render(delta);
        }
    }
}
