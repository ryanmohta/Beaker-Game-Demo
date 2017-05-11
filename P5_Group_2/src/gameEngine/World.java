package gameEngine;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class World extends Pane {
    private AnimationTimer timer;

    public World() {
        super();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                for(Actor actor : getObjects(Actor.class)) {
                    actor.act();
                }
            }
        };
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void add(Actor actor) {
        getChildren().add(actor);
    }

    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> arrayList = new ArrayList<>();

        for(Node n : getChildren()) {
            if(cls.isInstance(n)) {
                arrayList.add((A) n);
            }
        }

        return arrayList;
    }

    /**
     * This method is called every frame once start has been called.
     * @param now the current time in nanoseconds
     */
    public abstract void act(long now);

}
