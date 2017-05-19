package game;

import java.awt.event.MouseListener;
import gameEngine.Actor;

public class Dropper extends Actor implements MouseListener {
	private double XPos, YPos;

	public void clicked() {
		
	}

	public void setXPos(double newpos) {
		
	}

	public double getXPos() {
		return XPos;
	}

	public void setYPos(double newpos) {
		
	}

	public double getYPos() {
		return YPos;
	}

	@Override
	public void act() {
		
		
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		this.setXPos(e.getX());
		this.setYPos(e.getY());
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}