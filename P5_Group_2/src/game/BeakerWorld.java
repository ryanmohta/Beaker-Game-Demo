package game;

import gameEngine.Actor;
import gameEngine.World;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Documentation coming soon
 *
 * @author Ryan Mohta
 */
public class BeakerWorld extends World {

	private int secondCount = 0;
	private double actCount = 0;
	
	public BeakerWorld() {
		sceneProperty().addListener(new ChangeListener<Scene>() {
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if(newValue != null) {
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) {
								getOnKeyPressed().handle(event);
							}

							for(Actor actor : getObjects(Actor.class)) {
								if(actor.getOnKeyPressed() != null) {
									actor.getOnKeyPressed().handle(event);
								}
							}
						}
					});
				}
			}
		});
	}

	@Override
	public void act(long now) {
		int currentActCount = (int)(now / 10E8);
		if(currentActCount >= actCount + 1) {
			actCount = currentActCount;
		}
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.SPACE) {
					add(new LiquidDrop(400, 100));
				}
			};
		});
		
	}
}