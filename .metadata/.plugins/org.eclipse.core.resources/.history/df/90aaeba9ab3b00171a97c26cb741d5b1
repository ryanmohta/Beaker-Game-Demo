package gameEngine;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>A {@code World} is an extension of a {@code Pane} that holds
 * {@code Actors} (which are custom {@code ImageView} objects).
 * Since a {@code World} is a {@code Pane} it already keeps track
 * of its children {@code Nodes} and this list can be accessed via
 * a call to the {@code Pane}'s {@code getChildren()}.</p>
 * <p>A {@code World} contains an {@code AnimationTimer} which runs
 * on its own {@code act()} method as well as the {@code act()} method
 * for every {@code Actor} in the {@code World}.</p>
 *
 * @author Ryan Mohta
 */
public abstract class World extends Pane {
    private AnimationTimer timer;

    /**
     * Creates a new {@code World} and starts the {@code AnimationTimer}
     * for the world. This is a default {@code World}, meaning there are
     * no {@code Actor}s in it.
     */
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

    /**
     * Starts the {@code AnimationTimer}.
     */
    public void start() {
        timer.start();
    }

    /**
     * Stops the {@code AnimationTimer}.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Adds the given {@code Actor} to the world.
     * @param actor the actor to be added.
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Removes the given {@code Actor} from the world.
     * @param actor the actor to be removed.
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * Returns a list of all the {@code Actor}s in the world of the
     * given {@code class}.
     * @param cls the specified class to be searched.
     * @return a {@code List} of all actors to be removed.
     */
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
