package engine;

/**
 * Implements a high score record.
 * 
 * @author <a href="mailto:RobertoIA1987@gmail.com">Roberto Izquierdo Amo</a>
 * 
 */
public class Score2 implements Comparable<Score2> {

	/** Player's name. */
	private String name;
	/** Score points. */
	private int score;
	
	private String diffi;
	
	/**
	 * Constructor.
	 * 
	 * @param name
	 *            Player name, three letters.
	 * @param score
	 *            Player score.
	 */
	public Score2(final String name, final int score, final String diffi) {
		this.name = name;
		this.score = score;
		this.diffi = diffi;
	}

	/**
	 * Getter for the player's name.
	 * 
	 * @return Name of the player.
	 */
	public final String getName() {
		return this.name;
	}

	/**
	 * Getter for the player's score.
	 * 
	 * @return High score.
	 */
	public final int getScore() {
		return this.score;
	}
	
	public final String getDiffi() {
		return this.diffi;
	}

	/**
	 * Orders the scores descending by score.
	 * 
	 * @param score
	 *            Score to compare the current one with.
	 * @return Comparison between the two scores. Positive if the current one is
	 *         smaller, positive if its bigger, zero if its the same.
	 */
	@Override
	public final int compareTo(final Score2 score) {
		int comparison = this.score < score.getScore() ? 1 : this.score > score
				.getScore() ? -1 : 0;
		return comparison;
	}

}
