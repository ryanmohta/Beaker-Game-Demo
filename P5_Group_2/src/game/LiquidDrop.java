package game;

import gameEngine.*;
import javafx.scene.image.Image;

/**
 * A {@code LiquidDrop} is an {@code Actor} that is able
 * to be released upon the click of the dropper. Once released,
 * the drop will fall straight down and could possibly fall
 * into the moving beaker depending on the accuracy of the click.
 * If the timing of the click is not accurate, the drop will
 * fall on the ground.
 *
 * @author Pratha Bodas and Oleon Hariharan
 */
public class LiquidDrop extends Actor {

    private double speed;

    /**
     * Creates a new {@code LiquidDrop} object with specified
     * starting coordinates and a gravity of {@code 5}.
     * @param startX the starting x-coordinate
     * @param startY the starting y-coordinate
     */
    public LiquidDrop(double startX, double startY) {
        this(startX, startY, 3);
    }

    /**
     * Creates a new {@code LiquidDrop} object with specified
     * starting coordinates and speed.
     * @param startX the starting x-coordinate
     * @param startY the starting y-coordinate
     * @param speed the gravity to which this drop falls
     */
    public LiquidDrop(double startX, double startY, double speed) {
        super(startX, startY, new Image("file:images/drop.png"));
        this.speed = speed;
    }

    /**
     * Returns if this liquid drop is touching the floor
     * @return if this liquid drop is touching the floor
     */
    public boolean isTouchingFloor() {
        return getY() + getHeight() >= getWorld().getHeight();
    }

    /**
     * Allows for the liquid drop to fall, resetting the 
     * {@code y} position every millisecond.
     */
    @Override
    public void act() {
        move(0, speed += 0.5);
        if(isTouchingFloor()) {
        	getWorld().remove(this);
        }
        else if(getOneIntersectingObject(Beaker.class) != null) {
        	((BeakerWorld)getWorld()).getModel().incrementScore();
        	getWorld().remove(this);
        }
    }

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
