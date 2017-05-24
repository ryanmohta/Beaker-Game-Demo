package game;
import gameEngine.*;
import javafx.scene.image.Image;

/**
 * {@code Beaker} is an {@code Actor} that is a 
 * cylindrical container. The beaker moves across 
 * the screen from left to right and bounces off the 
 * wall. The beaker is meant to hold {@code LiquidDrop} 
 * objects.
 * 
 * @author Pratha Bodas and Ryan Mohta
 */
public class Beaker extends Actor { 

	private final double INITIAL_SPEED, INITIAL_ACCELERATION = 0.001; // the initial speed and acceleration of the beaker.
	private double speed, acceleration = INITIAL_ACCELERATION; // the current speed and acceleration of the beaker.
	private boolean toRight = true; // the direction of the beaker.

	/**
	 * Creates a new {@code Beaker} with the specified
	 * starting coordinates and starting speed of 
	 * {@code 5}.
	 * @param xPos the starting x-coordinate
	 * @param yPos the starting y-coordinate
	 */
	public Beaker(double xPos, double yPos) {
		this(xPos, yPos, 5);
	}

	/**
	 * Creates a new {@code Beaker} with the specified
	 * starting coordinates and starting speed.
	 * @param startX the starting x-coordinate
	 * @param startY the starting y-coordinate
	 * @param initialSpeed the initial speed of the beaker
	 */
	public Beaker(double startX, double startY, double initialSpeed) {
		super(startX, startY, new Image("file:images/beaker.png"));
		this.speed = INITIAL_SPEED = initialSpeed;
	}
	
	/**
	 * Moves the {@code Beaker} from left to right, or right to left if it hits 
	 * the right wall. Additionally, the speed of the beaker increases by the
	 * acceleration every time the {@code act()} method is called.
	 */
	@Override
	public void act() {
		if(toRight) {
			move(speed += acceleration, 0);
		}
		else move(-(speed += acceleration), 0);
		
		if(getX() <= 0 || getX() + getWidth() >= getWorld().getWidth()) {
			changeDirection();
		}
	}

	/**
	 * Sets the class instance variable {@code speed} to the
	 * parameter {@code newSpeed}.
	 * @param newSpeed the new speed of this beaker.
	 */
	public void setSpeed(double newSpeed) {
		speed = newSpeed;
	};

	/**
	 * Returns the speed of the {@code Beaker}.
	 * @return the speed of the beaker.
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * Starts the {@code Beaker} with initial speed and acceleration values.
	 */
	public void start() {
		speed = INITIAL_SPEED;
		acceleration = INITIAL_ACCELERATION;
	}

	/**
	 * Removes movement from the {@code Beaker}.
	 */
	public void stop() {
		speed = acceleration = 0;
	}
	
	/**
	 * Changes the current direction of the {@code Beaker}.
	 */
	public void changeDirection() {
		toRight = !toRight;
	}

}
	

