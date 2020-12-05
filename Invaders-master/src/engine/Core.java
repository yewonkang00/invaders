package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import screen.*;

/**
 * Implements core game logic.
 * 
 * @author <a href="mailto:RobertoIA1987@gmail.com">Roberto Izquierdo Amo</a>
 * 
 */
public final class Core {

	/** Width of current screen. */
	private static final int WIDTH = 448;
	/** Height of current screen. */
	private static final int HEIGHT = 520;
	/** Max fps of current screen. */
	private static final int FPS = 60;

	/** Max lives. */
	private static final int MAX_LIVES = 3;
	/** Levels between extra life. */
	private static final int EXTRA_LIFE_FRECUENCY = 3;
	/** Total number of levels. */
	private static final int NUM_LEVELS = 13;

	/** Max lives. */
	private static final int MAX_LIVES_NORMAL = 3;
	/** Levels between extra life. */
	private static final int EXTRA_LIFE_FRECUENCY_NORMAL = 3;
	/** Total number of levels. */
	private static final int NUM_LEVELS_NORMAL = 10;
	private static final String DIFFICULTY_NORMAL = "N";
//	private static final int NUM_LEVELS = 1;

	private static final int MAX_LIVES_EASY = 5;
	/** Levels between extra life. */
	private static final int EXTRA_LIFE_FRECUENCY_EASY = 3;
	/** Total number of levels. */
	private static final int NUM_LEVELS_EASY = 7;
	private static final String DIFFICULTY_EASY = "E";

	private static final int MAX_LIVES_HARD = 3;
	/** Levels between extra life. */
	private static final int EXTRA_LIFE_FRECUENCY_HARD = 2;
	/** Total number of levels. */
	private static final int NUM_LEVELS_HARD = 13;
	private static final String DIFFICULTY_HARD = "H";





	/** Easy -> level 1~7,
	 *  Normal -> Level 4~10
	 *  Hard -> level 7~13 */
	/** Difficulty settings for level 1. */
	private static final GameSettings SETTINGS_LEVEL_1 =
			new GameSettings(3, 2, 70, 2500);
	/** Difficulty settings for level 2. */
	private static final GameSettings SETTINGS_LEVEL_2 =
			new GameSettings(4, 3, 70, 2250);
	/** Difficulty settings for level 3. */
	private static final GameSettings SETTINGS_LEVEL_3 =
			new GameSettings(4, 3, 60, 2000);
	/** Difficulty settings for level 4. */
	private static final GameSettings SETTINGS_LEVEL_4 =
			new GameSettings(5, 4, 60, 2000);
	/** Difficulty settings for level 5. */
	private static final GameSettings SETTINGS_LEVEL_5 =
			new GameSettings(5, 4, 50, 2500);
	/** Difficulty settings for level 6. */
	private static final GameSettings SETTINGS_LEVEL_6 =
			new GameSettings(6, 5, 40, 1500);
	/** Difficulty settings for level 7. */
	private static final GameSettings SETTINGS_LEVEL_7 =
			new GameSettings(6, 6, 30, 1500);
	/** Difficulty settings for level 8. */
	private static final GameSettings SETTINGS_LEVEL_8 =
			new GameSettings(7, 6, 20, 1000);
	/** Difficulty settings for level 9. */
	private static final GameSettings SETTINGS_LEVEL_9 =
			new GameSettings(7, 7, 10, 500);
	/** Difficulty settings for level 10. */
	private static final GameSettings SETTINGS_LEVEL_10 =
			new GameSettings(8, 7, 5, 500);
	/** Difficulty settings for level 11. */
	private static final GameSettings SETTINGS_LEVEL_11 =
			new GameSettings(8, 8, 2, 200);
	/** Difficulty settings for level 12. */
	private static final GameSettings SETTINGS_LEVEL_12 =
			new GameSettings(9, 8, 2, 100);
	/** Difficulty settings for level 13. */
	private static final GameSettings SETTINGS_LEVEL_13 =
			new GameSettings(9, 9, 0, 50);

	/** Frame to draw the screen on. */
	private static Frame frame;
	/** Screen currently shown. */
	private static Screen currentScreen;
	/** Difficulty settings list. */
	private static List<GameSettings> gameSettings;
	private static List<GameSettings> gameSettings_normal;
	private static List<GameSettings> gameSettings_easy;
	private static List<GameSettings> gameSettings_hard;


	/** Application logger. */
	private static final Logger LOGGER = Logger.getLogger(Core.class
			.getSimpleName());
	/** Logger handler for printing to disk. */
	private static Handler fileHandler;
	/** Logger handler for printing to console. */
	private static ConsoleHandler consoleHandler;


	/**
	 * Test implementation.
	 * 
	 * @param args
	 *            Program args, ignored.
	 */
	public static void main(final String[] args) {
		try {
			LOGGER.setUseParentHandlers(false);

			fileHandler = new FileHandler("log");
			fileHandler.setFormatter(new MinimalFormatter());

			consoleHandler = new ConsoleHandler();
			consoleHandler.setFormatter(new MinimalFormatter());

			LOGGER.addHandler(fileHandler);
			LOGGER.addHandler(consoleHandler);
			LOGGER.setLevel(Level.ALL);

		} catch (Exception e) {
			// TODO handle exception
			e.printStackTrace();
		}

		frame = new Frame(WIDTH, HEIGHT);
		DrawManager.getInstance().setFrame(frame);
		int width = frame.getWidth();
		int height = frame.getHeight();

//		gameSettings = new ArrayList<GameSettings>();
//		gameSettings.add(SETTINGS_LEVEL_1);
//		gameSettings.add(SETTINGS_LEVEL_2);
//		gameSettings.add(SETTINGS_LEVEL_3);
//		gameSettings.add(SETTINGS_LEVEL_4);
//		gameSettings.add(SETTINGS_LEVEL_5);
//		gameSettings.add(SETTINGS_LEVEL_6);
//		gameSettings.add(SETTINGS_LEVEL_7);
//		gameSettings.add(SETTINGS_LEVEL_8);
//		gameSettings.add(SETTINGS_LEVEL_9);
//		gameSettings.add(SETTINGS_LEVEL_10);
//		gameSettings.add(SETTINGS_LEVEL_11);
//		gameSettings.add(SETTINGS_LEVEL_12);
//		gameSettings.add(SETTINGS_LEVEL_13);


		gameSettings_easy = new ArrayList<GameSettings>();
		gameSettings_easy.add(SETTINGS_LEVEL_1);
		gameSettings_easy.add(SETTINGS_LEVEL_2);
		gameSettings_easy.add(SETTINGS_LEVEL_3);
		gameSettings_easy.add(SETTINGS_LEVEL_4);
		gameSettings_easy.add(SETTINGS_LEVEL_5);
		gameSettings_easy.add(SETTINGS_LEVEL_6);
		gameSettings_easy.add(SETTINGS_LEVEL_7);



		gameSettings_normal = new ArrayList<GameSettings>();
		gameSettings_normal.add(SETTINGS_LEVEL_4);
		gameSettings_normal.add(SETTINGS_LEVEL_5);
		gameSettings_normal.add(SETTINGS_LEVEL_6);
		gameSettings_normal.add(SETTINGS_LEVEL_7);
		gameSettings_normal.add(SETTINGS_LEVEL_8);
		gameSettings_normal.add(SETTINGS_LEVEL_9);
		gameSettings_normal.add(SETTINGS_LEVEL_10);

		gameSettings_hard = new ArrayList<GameSettings>();
		gameSettings_hard.add(SETTINGS_LEVEL_7);
		gameSettings_hard.add(SETTINGS_LEVEL_8);
		gameSettings_hard.add(SETTINGS_LEVEL_9);
		gameSettings_hard.add(SETTINGS_LEVEL_10);
		gameSettings_hard.add(SETTINGS_LEVEL_11);
		gameSettings_hard.add(SETTINGS_LEVEL_12);
		gameSettings_hard.add(SETTINGS_LEVEL_13);


		GameState gameState;
		GameState2 gameState2;
		
		GameState gameState_normal;
		GameState gameState_easy;
		GameState gameState_easy2;
		GameState gameState_hard;
		GameState2 gameState2_normal;
		GameState2 gameState2_easy;
		GameState2 gameState2_hard;

		Musicmanager.Sound("c:/Space_Invaders_Music.ogg.wav", true);

		int returnCode = 1;
		do {
//			gameState = new GameState(1, DIFFICULTY_NORMAL, 0,  MAX_LIVES, 0, 0);
			gameState_normal = new GameState(1, DIFFICULTY_NORMAL, 0,  MAX_LIVES, 0, 0); // normal�뿉�꽌 level_1�뒗 �떎�젣�젅踰� 4
			gameState_easy = new GameState(1, DIFFICULTY_EASY, 0,  MAX_LIVES_EASY, 0, 0);
			gameState_easy2 = new GameState(1, DIFFICULTY_EASY, 0,  MAX_LIVES, 0, 0);
			gameState_hard = new GameState(1, DIFFICULTY_HARD, 0,  MAX_LIVES_HARD, 0, 0);
			gameState2_normal = new GameState2(1, DIFFICULTY_NORMAL, 0,  MAX_LIVES, 0, 0); // normal�뿉�꽌 level_1�뒗 �떎�젣�젅踰� 4
			gameState2_easy = new GameState2(1, DIFFICULTY_EASY, 0,  MAX_LIVES, 0, 0);
			gameState2_hard = new GameState2(1, DIFFICULTY_HARD, 0,  MAX_LIVES_HARD, 0, 0);

			switch (returnCode) {
			case 1:
				// Main menu.
				currentScreen = new TitleScreen(width, height, FPS);
				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " title screen at " + FPS + " fps.");
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing title screen.");
				break;
			/*
			 * case 7: // Difficulty Select Menu currentScreen = new
			 * SelectDifficultyScreen(width, height, FPS); LOGGER.info("Starting " + WIDTH +
			 * "x" + HEIGHT + " difficulty select screen at " + FPS + " fps."); returnCode =
			 * frame.setScreen(currentScreen);
			 * LOGGER.info("Closing Difficulty select screen."); break;
			 */
//			case 2:
			case 51:
				//1 player
				currentScreen = new SelectDifficultyScreen(width, height, FPS);
				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " difficulty select screen at " + FPS + " fps.");
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing Difficulty select screen.");
				break;
				
			case 52:
				//2 player
				currentScreen = new SelectDifficultyScreen2(width, height, FPS);
				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " difficulty select screen at " + FPS + " fps.");
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing Difficulty select screen.");
				break;
				
			case 11:
				//난이도 선택 화면에서 back 기능
				currentScreen = new TitleScreen(width, height, FPS);
				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " title screen at " + FPS + " fps.");
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing title screen.");
				break;
			/** Easy Level Game */
			case 4:
				do {
					// One extra live every few levels.
					boolean bonusLife = gameState_easy.getLevel()
							% EXTRA_LIFE_FRECUENCY_EASY == 0
							&& gameState_easy.getLivesRemaining() < MAX_LIVES_EASY;
					currentScreen = new GameScreen(gameState_easy, gameSettings_easy.get(gameState_easy.getLevel() - 1),
							bonusLife, width, height, FPS);

					LOGGER.info("Starting Level " + gameState_easy.getLevel() +" with "+ WIDTH + "x" + HEIGHT
							+ " game screen at " + FPS + " fps.");
					frame.setScreen(currentScreen);
					LOGGER.info("Closing game screen. Next Level is :" + gameState_easy.getLevel() + 1);

					gameState_easy = ((GameScreen) currentScreen).getGameState();

					gameState_easy = new GameState(gameState_easy.getLevel() + 1,
							DIFFICULTY_EASY,
							gameState_easy.getScore(),
							gameState_easy.getLivesRemaining(),
							gameState_easy.getBulletsShot(),
							gameState_easy.getShipsDestroyed());

					} while (gameState_easy.getLivesRemaining() > 0
							&& gameState_easy.getLevel() <= NUM_LEVELS_EASY);

					LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
							+ " score screen at " + FPS + " fps, with a score of "
							+ gameState_easy.getScore() + ", "
							+ gameState_easy.getLivesRemaining() + " lives remaining, "
							+ gameState_easy.getBulletsShot() + " bullets shot and "
							+ gameState_easy.getShipsDestroyed() + " ships destroyed.");
					currentScreen = new ScoreScreen(width, height, FPS, gameState_easy);
					returnCode = frame.setScreen(currentScreen);
					LOGGER.info("Closing score screen.");
					break;



			/** Normal Level Game */
			case 5:
				// Game & score.
				do {
					// One extra live every few levels.
					boolean bonusLife = gameState_normal.getLevel()
							% EXTRA_LIFE_FRECUENCY_NORMAL == 0
							&& gameState_normal.getLivesRemaining() < MAX_LIVES_NORMAL;

					currentScreen = new GameScreen(gameState_normal,
							gameSettings_normal.get(gameState_normal.getLevel() - 1),
							bonusLife, width, height, FPS);

					LOGGER.info("Starting Level " + gameState_normal.getLevel() +" with "+ WIDTH + "x" + HEIGHT
							+ " game screen at " + FPS + " fps.");
					frame.setScreen(currentScreen);
					LOGGER.info("Closing game screen. Next Level is :" + gameState_normal.getLevel() + 1);

					gameState_normal = ((GameScreen) currentScreen).getGameState();

					gameState_normal = new GameState(gameState_normal.getLevel() + 1,
							DIFFICULTY_NORMAL,
							gameState_normal.getScore(),
							gameState_normal.getLivesRemaining(),
							gameState_normal.getBulletsShot(),
							gameState_normal.getShipsDestroyed());

				} while (gameState_normal.getLivesRemaining() > 0
						&& gameState_normal.getLevel() <= NUM_LEVELS);

				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " score screen at " + FPS + " fps, with a score of "
						+ gameState_normal.getScore() + ", "
						+ gameState_normal.getLivesRemaining() + " lives remaining, "
						+ gameState_normal.getBulletsShot() + " bullets shot and "
						+ gameState_normal.getShipsDestroyed() + " ships destroyed.");
				currentScreen = new ScoreScreen(width, height, FPS, gameState_normal);
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing score screen.");
				break;

			/** hard **/
			case 6:
					// Game & score.
				do {
					boolean bonusLife = gameState_hard.getLevel()
							% EXTRA_LIFE_FRECUENCY_HARD == 0
							&& gameState_hard.getLivesRemaining() < MAX_LIVES_HARD;

					currentScreen = new GameScreen(gameState_hard,
							gameSettings_hard.get(gameState_hard.getLevel() - 1),
							bonusLife, width, height, FPS);

					LOGGER.info("Starting Level " + gameState_hard.getLevel() +" with "+ WIDTH + "x" + HEIGHT
							+ " game screen at " + FPS + " fps.");
					frame.setScreen(currentScreen);
					LOGGER.info("Closing game screen. Next Level is :" + gameState_hard.getLevel() + 1);

					gameState_hard = ((GameScreen) currentScreen).getGameState();

					gameState_hard = new GameState(gameState_hard.getLevel() + 1,
							DIFFICULTY_HARD,
							gameState_hard.getScore(),
							gameState_hard.getLivesRemaining(),
							gameState_hard.getBulletsShot(),
							gameState_hard.getShipsDestroyed());

				} while (gameState_hard.getLivesRemaining() > 0
							&& gameState_hard.getLevel() <= NUM_LEVELS);

				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " score screen at " + FPS + " fps, with a score of "
						+ gameState_hard.getScore() + ", "
						+ gameState_hard.getLivesRemaining() + " lives remaining, "
						+ gameState_hard.getBulletsShot() + " bullets shot and "
						+ gameState_hard.getShipsDestroyed() + " ships destroyed.");
				currentScreen = new ScoreScreen(width, height, FPS, gameState_hard);
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing score screen.");
				break;

				/** Easy Level Game */
			case 8:
				do {
					// One extra live every few levels.
					boolean bonusLife = gameState_easy2.getLevel()
							% EXTRA_LIFE_FRECUENCY_EASY == 0
							&& gameState_easy.getLivesRemaining() < MAX_LIVES;
					boolean bonusLife2 = gameState2_easy.getLevel()
							% EXTRA_LIFE_FRECUENCY_EASY == 0
							&& gameState2_easy.getLivesRemaining() < MAX_LIVES;
					currentScreen = new GameScreen2(gameState_easy2, gameState2_easy, gameSettings_easy.get(gameState_easy2.getLevel() - 1),
							bonusLife, bonusLife2, width, height, FPS);

					LOGGER.info("Starting Level " + gameState_easy.getLevel() +" with "+ WIDTH + "x" + HEIGHT
							+ " game screen at " + FPS + " fps.");
					frame.setScreen(currentScreen);
					LOGGER.info("Closing game screen. Next Level is :" + gameState_easy.getLevel() + 1);

					gameState_easy2 = ((GameScreen2) currentScreen).getGameState();
					gameState2_easy = ((GameScreen2) currentScreen).getGameState2();

					gameState_easy2 = new GameState(gameState_easy2.getLevel() + 1,
							DIFFICULTY_EASY,
							gameState_easy2.getScore(),
							gameState_easy2.getLivesRemaining(),
							gameState_easy2.getBulletsShot(),
							gameState_easy2.getShipsDestroyed());
					gameState2_easy = new GameState2(gameState2_easy.getLevel() + 1,
							DIFFICULTY_EASY,
							gameState2_easy.getScore(),
							gameState2_easy.getLivesRemaining(),
							gameState2_easy.getBulletsShot(),
							gameState2_easy.getShipsDestroyed());

					} while ((gameState2_easy.getLivesRemaining() > 0 || gameState_easy2.getLivesRemaining() > 0)
							&& gameState_easy2.getLevel() <= NUM_LEVELS_EASY);

					LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
							+ " score screen at " + FPS + " fps, with a score of "
							+ gameState_easy.getScore() + ", "
							+ gameState_easy.getLivesRemaining() + " lives remaining, "
							+ gameState_easy.getBulletsShot() + " bullets shot and "
							+ gameState_easy.getShipsDestroyed() + " ships destroyed.");
					currentScreen = new ScoreScreen(width, height, FPS, gameState_easy);
					returnCode = frame.setScreen(currentScreen);
					LOGGER.info("Closing score screen.");
					break;



			/** Normal Level Game */
			case 9:
				// Game & score.
				do {
					// One extra live every few levels.
					boolean bonusLife = gameState_normal.getLevel()
							% EXTRA_LIFE_FRECUENCY_NORMAL == 0
							&& gameState_normal.getLivesRemaining() < MAX_LIVES_NORMAL;
					
					boolean bonusLife2 = gameState2_normal.getLevel()
							% EXTRA_LIFE_FRECUENCY_NORMAL == 0
							&& gameState2_normal.getLivesRemaining() < MAX_LIVES_NORMAL;

					currentScreen = new GameScreen2(gameState_normal, gameState2_normal,
							gameSettings_normal.get(gameState_normal.getLevel() - 1),
							bonusLife, bonusLife2, width, height, FPS);

					LOGGER.info("Starting Level " + gameState_normal.getLevel() +" with "+ WIDTH + "x" + HEIGHT
							+ " game screen at " + FPS + " fps.");
					frame.setScreen(currentScreen);
					LOGGER.info("Closing game screen. Next Level is :" + gameState_normal.getLevel() + 1);

					gameState_normal = ((GameScreen2) currentScreen).getGameState();
					gameState2_normal = ((GameScreen2) currentScreen).getGameState2();

					gameState_normal = new GameState(gameState_normal.getLevel() + 1,
							DIFFICULTY_NORMAL,
							gameState_normal.getScore(),
							gameState_normal.getLivesRemaining(),
							gameState_normal.getBulletsShot(),
							gameState_normal.getShipsDestroyed());
					gameState2_normal = new GameState2(gameState2_normal.getLevel() + 1,
							DIFFICULTY_NORMAL,
							gameState2_normal.getScore(),
							gameState2_normal.getLivesRemaining(),
							gameState2_normal.getBulletsShot(),
							gameState2_normal.getShipsDestroyed());

				}while ((gameState2_normal.getLivesRemaining() > 0 || gameState_normal.getLivesRemaining() > 0)
						&& gameState_normal.getLevel() <= NUM_LEVELS);
				LOGGER.info("***" + gameState2_normal.getLivesRemaining() + "\n" + gameState_normal.getLivesRemaining());
				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " score screen at " + FPS + " fps, with a score of "
						+ gameState_normal.getScore() + ", "
						+ gameState_normal.getLivesRemaining() + " lives remaining, "
						+ gameState_normal.getBulletsShot() + " bullets shot and "
						+ gameState_normal.getShipsDestroyed() + " ships destroyed.");
				currentScreen = new ScoreScreen(width, height, FPS, gameState_normal);
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing score screen.");
				break;

			/** hard **/
			case 10:
					// Game & score.
				do {
					boolean bonusLife = gameState_hard.getLevel()
							% EXTRA_LIFE_FRECUENCY_HARD == 0
							&& gameState_hard.getLivesRemaining() < MAX_LIVES_HARD;
					
					boolean bonusLife2 = gameState2_hard.getLevel()
							% EXTRA_LIFE_FRECUENCY_HARD == 0
							&& gameState2_hard.getLivesRemaining() < MAX_LIVES_HARD;

					currentScreen = new GameScreen2(gameState_hard, gameState2_hard,
							gameSettings_hard.get(gameState_hard.getLevel() - 1),
							bonusLife, bonusLife2, width, height, FPS);

					LOGGER.info("Starting Level " + gameState_hard.getLevel() +" with "+ WIDTH + "x" + HEIGHT
							+ " game screen at " + FPS + " fps.");
					frame.setScreen(currentScreen);
					LOGGER.info("Closing game screen. Next Level is :" + gameState_hard.getLevel() + 1);

					gameState_hard = ((GameScreen2) currentScreen).getGameState();
					gameState2_hard = ((GameScreen2) currentScreen).getGameState2();

					gameState_hard = new GameState(gameState_hard.getLevel() + 1,
							DIFFICULTY_HARD,
							gameState_hard.getScore(),
							gameState_hard.getLivesRemaining(),
							gameState_hard.getBulletsShot(),
							gameState_hard.getShipsDestroyed());
					gameState2_hard = new GameState2(gameState2_hard.getLevel() + 1,
							DIFFICULTY_HARD,
							gameState2_hard.getScore(),
							gameState2_hard.getLivesRemaining(),
							gameState2_hard.getBulletsShot(),
							gameState2_hard.getShipsDestroyed());

				} while ((gameState2_hard.getLivesRemaining() > 0 || gameState_hard.getLivesRemaining() > 0)
							&& gameState_hard.getLevel() <= NUM_LEVELS);

				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " score screen at " + FPS + " fps, with a score of "
						+ gameState_hard.getScore() + ", "
						+ gameState_hard.getLivesRemaining() + " lives remaining, "
						+ gameState_hard.getBulletsShot() + " bullets shot and "
						+ gameState_hard.getShipsDestroyed() + " ships destroyed.");
				currentScreen = new ScoreScreen(width, height, FPS, gameState_hard);
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing score screen.");
				break;


			case 3:
				// High scores.
				currentScreen = new HighScoreScreen(width, height, FPS);
				LOGGER.info("Starting " + WIDTH + "x" + HEIGHT
						+ " high score screen at " + FPS + " fps.");
				returnCode = frame.setScreen(currentScreen);
				LOGGER.info("Closing high score screen.");
				break;
			default:
				break;
			}

		} while (returnCode != 0);

		fileHandler.flush();
		fileHandler.close();
		System.exit(0);
	}

	/**
	 * Constructor, not called.
	 */
	private Core() {

	}

	/**
	 * Controls access to the logger.
	 * 
	 * @return Application logger.
	 */
	public static Logger getLogger() {
		return LOGGER;
	}

	/**
	 * Controls access to the drawing manager.
	 * 
	 * @return Application draw manager.
	 */
	public static DrawManager getDrawManager() {
		return DrawManager.getInstance();
	}

	/**
	 * Controls access to the input manager.
	 * 
	 * @return Application input manager.
	 */
	public static InputManager getInputManager() {
		return InputManager.getInstance();
	}

	/**
	 * Controls access to the file manager.
	 * 
	 * @return Application file manager.
	 */
	public static FileManager getFileManager() {
		return FileManager.getInstance();
	}

	/**
	 * Controls creation of new cooldowns.
	 * 
	 * @param milliseconds
	 *            Duration of the cooldown.
	 * @return A new cooldown.
	 */
	public static Cooldown getCooldown(final int milliseconds) {
		return new Cooldown(milliseconds);
	}

	/**
	 * Controls creation of new cooldowns with variance.
	 * 
	 * @param milliseconds
	 *            Duration of the cooldown.
	 * @param variance
	 *            Variation in the cooldown duration.
	 * @return A new cooldown with variance.
	 */
	public static Cooldown getVariableCooldown(final int milliseconds,
			final int variance) {
		return new Cooldown(milliseconds, variance);
	}
}