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
 * The subclass of {@link World}. It uses a {@link Model} to keep track of
 * game variables like score and whether the Game is done or not.
 *
 * @author Ryan Mohta, Pratha Bodas, Oleon Hariharan
 */
public class BeakerWorld extends World {

	private Model model;
	private boolean acceptingKeystrokes = true;

	/**
	 * Creates a new {@link BeakerWorld} with the specified {@link Model}.
	 * @param model a {@link Model} that keeps track of score and whether
	 *                 the game is done or not.
	 */
	public BeakerWorld(Model model) {
		this.model = model;
		
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
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(acceptingKeystrokes && event.getCode() == KeyCode.SPACE) {
					add(new LiquidDrop(400, 50));
				}
			};
		});
		
	}

	/**
	 * Returns the {@link Model} used by this {@link BeakerWorld}.
	 * @return the Model used by the BeakerWorld.
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the current {@link Model} to the new specified Model.
	 * @param newModel a new {@link Model}.
	 */
	public void setModel(Model newModel) {
		model = newModel;
	}

	/**
	 * Returns if this {@link BeakerWorld} is accepting keystrokes.
	 * @return whether this BeakerWorld is accepting keystrokes.
	 */
	public boolean getAcceptingKeystrokes() {
		return acceptingKeystrokes;
	}

	/**
	 * Sets if this {@link BeakerWorld} is accepting keystrokes.
	 * @param acceptingKeystrokes whether this BeakerWorld is accepting keystrokes.
	 */
	public void setAcceptingKeystrokes(boolean acceptingKeystrokes) {
		this.acceptingKeystrokes = acceptingKeystrokes;
	}

	/**
	 * Switches this {@link BeakerWorld} from accepting keystrokes to not, or vice versa.
	 */
	public void toggleAcceptingKeystrokes() {
		setAcceptingKeystrokes(!acceptingKeystrokes);
	}
}