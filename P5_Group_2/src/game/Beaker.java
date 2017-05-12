package game;
import gameEngine.*;

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

	private double xPos, yPos;
	private double speed;
	
	/**
	 * Creates a new {@code Beaker} with the specified 
	 * starting coordinates.
	 * @param xPos the starting x-coordinate
	 * @param yPos the starting y-coordinate
	 */
	public Beaker(double xPos, double yPos) {
		this(xPos, yPos, 5);
	}
	
	/**
	 * Creates a new {@code Beaker} with the specified 
	 * starting coordinates and speed.
	 * @param xPos the starting x-coordinate
	 * @param yPos the starting y-coordinate
	 * @param speed the speed of the beaker
	 */
	public Beaker(double xPos, double yPos, double speed) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
	}

	/**
	 * Sets the class instance variable {@code xPos} to the
	 * parameter {@code newPos}.
	 * @param newPos the new x-coordinate of this beaker.
	 */
	public void setXPos(double newPos) {
		xPos = newPos;
	};

	/**
	 * Returns the x-position of the {@code Beaker}.
	 * @return the x-position of the beaker.
	 */
	public double getXPos() {
		return xPos;
	};

	/**
	 * Sets the class instance variable {@code yPos} to the
	 * parameter {@code newPos}.
	 * @param newPos the new y-coordinate of this beaker.
	 */
	public void setYPos(double newPos) {
		yPos = newPos;
	};

	/**
	 * Returns the y-position of the {@code Beaker}.
	 * @return the y-position of the beaker.
	 */
	public double getYPos() {
		return yPos;
	};

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
	};

	/**
	 * Moves the beaker from left to right.
	 */
	@Override
	public void act() {
		
	};
 }
