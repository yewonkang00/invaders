package screen;

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import engine.Cooldown;
import engine.Core;
import engine.Score;

/**
 * Implements the high scores screen, it shows player records.
 * 
 * @author <a href="mailto:RobertoIA1987@gmail.com">Roberto Izquierdo Amo</a>
 * 
 */
public class PauseScreen extends Screen {
	private static final int SELECTION_TIME = 200;
	/** Time between changes in user selection. */
	private Cooldown selectionCooldown;
	// end = 0, continue = 1
	private int num=1;
	/**
	 * Constructor, establishes the properties of the screen.
	 * 
	 * 
	 * @param width
	 *            Screen width.
	 * @param height
	 *            Screen height.
	 * @param fps
	 *            Frames per second, frame rate at which the game is run.
	 */
	public PauseScreen(final int width, final int height, final int fps) {
		super(width, height, fps);

		this.fps = 60;
		num = 1;
		this.selectionCooldown = Core.getCooldown(SELECTION_TIME);
        this.selectionCooldown.reset();
		
	}

	/**
	 * Starts the action.
	 * 
	 * @return Next screen code.
	 */
	public final int run() {
		super.run();

		return num;
	}

	/**
	 * Updates the elements on screen and checks for events.
	 */
	protected final void update() {
		super.update();

		draw();
		if (this.selectionCooldown.checkFinished()
                && this.inputDelay.checkFinished()) {
            if (inputManager.isKeyDown(KeyEvent.VK_UP)
                    || inputManager.isKeyDown(KeyEvent.VK_W)) {
                previousMenuItem();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_DOWN)
                    || inputManager.isKeyDown(KeyEvent.VK_S)) {
                nextMenuItem();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_SPACE))
                this.isRunning = false;
        }
	}

	private void nextMenuItem() {
        if (num == 0) //0ÀÌ stop, 1ÀÌ continue
            num = 1;
        else {
            num = 0;
        }
    }

    /**
     * Shifts the focus to the previous menu item.
     */

    private void previousMenuItem() {
        if (num == 1)
        	num = 0;
        else
            num = 1;
    }
	/**
	 * Draws the elements associated with the screen.
	 */
	private void draw() {
		drawManager.initDrawing(this);

		drawManager.drawPauseMenu(this,num);

		drawManager.completeDrawing(this);
	}
}
