package gameEngine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor extends ImageView {

	/**
	 * Creates a new Actor with a question mark image 
	 * and a starting location of (0, 0).
	 */
	public Actor() {
        this(new Image("file:question mark.png"));
    }

    /**
     * Creates a new Actor with the specified image and 
     * a starting location of (0, 0).
     * @param image the image that is assigned to this actor.
     */
	public Actor(Image image) {
        this(0, 0, image);
    }

    /**
     * Creates a new Actor with the specified image and the 
     * specified start location.
     * @param startX the starting x-coordinate.
     * @param startY the starting y-coordinate.
     * @param image the image that is assigned to this actor.
     */
	public Actor(double startX, double startY, Image image) {
        setX(startX);
        setY(startY);
        setImage(image);
    }

    /**
     * Moves the actor by the specified coordinates.
     * @param dx the x-coordinate that the actor moves by.
     * @param dy the y-coordinate that the actor moves by.
     */
	public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Returns the world.
     * @return the world.
     */
	public World getWorld() {
        return (World) getParent();
    }

    /**
     * Returns the width of the actor.
     * @return the width of the actor.
     */
	public double getWidth() {
        return getBoundsInParent().getWidth();
    }

    /**
     * Returns the height of the actor.
     * @return the height of the actor.
     */
	public double getHeight() {
        return getBoundsInParent().getHeight();
    }

    /**
     * Gets all interesting objects of the specified class.
     * @param cls the class that is checked for.
     * @return a list of all intersecting objects of the given class.
     */
	public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls) {
        ArrayList<A> arrayList = new ArrayList<>();

        for(Actor actor : getWorld().getObjects(cls)) {
            if(this.equals(actor) && actor.intersects(getX(), getY(), getWidth(), getHeight())) {
                arrayList.add((A) actor);
            }
        }

        return arrayList;
    }

    /**
     * Returns an intersecting object of the particular class.
     * @param cls the class that is checked for.
     * @return an intersecting object -- null if none.
     */
	public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
        for(Actor actor : getWorld().getObjects(cls)) {
            if(!this.equals(actor) && actor.intersects(getX(), getY(), getWidth(), getHeight())) {
                return (A) actor;
            }
        }

        return null;
    }

    /**
     * This method is called every frame of the game.
     */
	public abstract void act();

}
