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
     * specified start location
     * @param startX
     * @param startY
     * @param image
     */
	public Actor(double startX, double startY, Image image) {
        setX(startX);
        setY(startY);
        setImage(image);
    }

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return getBoundsInParent().getWidth();
    }

    public double getHeight() {
        return getBoundsInParent().getHeight();
    }

    public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls) {
        ArrayList<A> arrayList = new ArrayList<>();

        for(Actor actor : getWorld().getObjects(cls)) {
            if(this.equals(actor) && actor.intersects(getX(), getY(), getWidth(), getHeight())) {
                arrayList.add((A) actor);
            }
        }

        return arrayList;
    }

    public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
        for(Actor actor : getWorld().getObjects(cls)) {
            if(!this.equals(actor) && actor.intersects(getX(), getY(), getWidth(), getHeight())) {
                return (A) actor;
            }
        }

        return null;
    }

    public abstract void act();

}
