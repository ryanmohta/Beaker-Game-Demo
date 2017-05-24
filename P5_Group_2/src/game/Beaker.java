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

	private double speed;
	private boolean toRight = true;
	private double acceleration = 0.001; //the amount the beaker speeds
											//up every act method

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
	 * @param startSpeed the starting speed of the beaker
	 */
	public Beaker(double startX, double startY, double startSpeed) {
		super(startX, startY, new Image("file:images/beaker.png"));
		this.speed = startSpeed;
	}
	
	/**
	 * Moves the {@code Beaker} from left to right, or right to left if it hits 
	 * the right wall.
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
	
	public void stop() {
		speed = 0;
		acceleration = 0;
	}
	
	/**
	 * Changes the current direction of the {@code Beaker}.
	 */
	public void changeDirection() {
		toRight = !toRight;
	}

}
	

