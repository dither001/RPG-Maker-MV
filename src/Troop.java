
/*
 * TODO - probably rename this to BAND, maybe "squad" b/c it's for up to 10 troops
 * or the equivalent of two fireteams ... these things get complicated
 */

import java.util.LinkedList;
import java.util.List;

public class Troop {
	/*
	 * Combat phases are organized by which attacks must necessarily be launched
	 * first, at greater distance, and which are innate, et cetera; monsters
	 * generally attack first. Thrown (including sling) attacks are distinct from
	 * missile (bow, crossbow, firearm), as reach is from melee. Spells are last.
	 */
	private enum CombatSegment {
		MISSILE, GAZE, THROWN, BREATH, REACH, AURA, MELEE, SPELL
	}

	// fields
	private Actor[][] actors;

	private final int[] STACK_BONUS = { 0, 1, 1, 3, 3, 4, 4, 6, 3, 2 };
	private final int[][] LEADERSHIP = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 0, 1, 2, 3, 3, 4, 5, 6, 6, 7 },
			{ 0, 1, 1, 2, 2, 3, 3, 4, 4, 5 } };

	// constructors
	public Troop() {
		// 2- front/back v. 5- left to right
		actors = new Actor[2][5];
	}

	// methods
	/*
	 * Collects both front and back lines
	 */
	public List<Actor> getTroop() {
		List<Actor> troop = new LinkedList<Actor>();

		for (int i = 0; i < 5; ++i) {
			if (actors[0][i] != null)
				troop.add(actors[0][i]);
		}
		for (int i = 0; i < 5; ++i) {
			if (actors[1][i] != null)
				troop.add(actors[1][i]);
		}

		return troop;
	}

	/*
	 * Collects only front line
	 */
	public List<Actor> getFrontLine() {
		List<Actor> troop = new LinkedList<Actor>();

		for (int i = 0; i < 5; ++i) {
			if (actors[0][i] != null)
				troop.add(actors[0][i]);
		}

		return troop;
	}

	/*
	 * Collects only back line
	 */
	public List<Actor> getBackLine() {
		List<Actor> troop = new LinkedList<Actor>();

		for (int i = 0; i < 5; ++i) {
			if (actors[1][i] != null)
				troop.add(actors[1][i]);
		}

		return troop;
	}

	/*
	 * TODO - this method currently does only the most rudimentary target search: a
	 * valid melee target must be within one position left, right, or center of the
	 * attacker; no special abilities like reach or anything are taken into account
	 */
	public Actor findSingleMeleeTarget(int position) {
		Actor target = null;

		if (position == 0) {
			// targets front line middle -> outward
			if (actors[0][3] != null)
				target = actors[0][3];
			else if (actors[0][4] != null)
				target = actors[0][4];
			else if (actors[1][3] != null)
				target = actors[1][3];
			else if (actors[1][4] != null)
				target = actors[1][4];
		} else if (position == 1) {
			// targets front line middle -> outward
			if (actors[0][2] != null)
				target = actors[0][2];
			else if (actors[0][3] != null)
				target = actors[0][3];
			else if (actors[0][4] != null)
				target = actors[0][4];
			else if (actors[1][2] != null)
				target = actors[1][2];
			else if (actors[1][3] != null)
				target = actors[1][3];
			else if (actors[1][4] != null)
				target = actors[1][4];
		} else if (position == 2) {
			// targets front line middle -> left -> right
			if (actors[0][2] != null)
				target = actors[0][2];
			else if (actors[0][3] != null)
				target = actors[0][3];
			else if (actors[0][1] != null)
				target = actors[0][1];
			else if (actors[1][2] != null)
				target = actors[1][2];
			else if (actors[1][3] != null)
				target = actors[1][3];
			else if (actors[1][1] != null)
				target = actors[1][1];
		} else if (position == 3) {
			// targets front line middle -> right -> right
			if (actors[0][2] != null)
				target = actors[0][2];
			else if (actors[0][1] != null)
				target = actors[0][1];
			else if (actors[0][0] != null)
				target = actors[0][0];
			else if (actors[1][2] != null)
				target = actors[1][2];
			else if (actors[1][1] != null)
				target = actors[1][1];
			else if (actors[1][0] != null)
				target = actors[1][0];
		} else if (position == 4) {
			// targets front line right -> right
			if (actors[0][1] != null)
				target = actors[0][1];
			else if (actors[0][0] != null)
				target = actors[0][0];
			else if (actors[1][1] != null)
				target = actors[1][1];
			else if (actors[1][0] != null)
				target = actors[1][0];
		}

		return target;
	}

}
