import java.util.ArrayList;

public class Actor {
	// static
	private static ArrayList<Actor> actors;
	
	// fields
	private int _actorID;
	private String _name;
	// _nickname
	// _classID
	private int _level;
	// _characterName
	// _characterIndex
	// _faceName
	// _faceIndex
	// _battlerName
	private int _exp;
	// _skills
	// _equips
	private int _actionInputIndex;
	// _lastMenuSkill
	// _lastBattleSkill
	// _lastCommandSymbol
	
	
	// constructors
	public Actor actor(int actorID) {
		// if (this.actors[actorID]) {
		// if (this.data[actorID]) {
		// this.data[actorID] = new Actor(actorID);
		// }
		// return this.data[actorID];
		// }
		return null;
	}

	// methods
	
	
	public Action currentAction() {
		// TODO
		return null;
	}
	
	public void removeCurrentAction() {
		// TODO
	}
	
	public boolean isDying() {
		// TODO
		return false;
	}
}
