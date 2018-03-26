
import java.util.List;

public class Battle {
	// fields
	private enum Phase {
		INITIALIZE, START, INPUT, ACTION, TURN, TURN_END, BATTLE_END, ABORT
	}

	private Phase _phase;

	private boolean _canEscape;
	private boolean _canLose;
	private boolean _preemptive;
	private boolean _surprise;
	private int _actorIndex;
	private Actor _actionForcedBattler;
	private List _actionBattlers;
	private Actor _subject;
	private Action _action;
	private List<Actor> _targets;
	private double _escapeRate;
	private boolean _escaped;
	// rewards = new rewards() object -- that's what {} means

	// constructors
	public Battle(Troop troop) {
		// TODO
		// something called "gameTroop.setup(troop)"
	}

	// methods
	public void initializeMembers() {
		// TODO
		this._phase = Phase.INITIALIZE;
		this._canEscape = false;
		this._canLose = false;
		this._preemptive = false;
		this._surprise = false;
		this._actorIndex = -1;
		this._actionForcedBattler = null;
		this._subject = null;
		this._action = null;
		this._targets = null;
		this._escapeRate = 0;
		this._escaped = false;
		// this._rewards = new Object[];
	}

	public void surpriseRate() {
		// TODO - determine if either side has surprise
		// this._surprise = (Math.random() < surpriseRate());
	}

	public void makeEscapeRate() {
		// TODO
		// this._escapeRate = 05 * troop.agility() / enemy.agility();
	}

	// line 1882
	public void update() {
		// TODO
		// if (this.isBusy != true && this.updateEvent() != true) {
		switch (this._phase) {
		case START:
			this.startInput();
			break;
		case TURN:
			this.updateTurn();
			break;
		case ACTION:
			// this.updateAction();
			break;
		case TURN_END:
			this.updateTurnEnd();
			break;
		case BATTLE_END:
			this.updateBattleEnd();
			break;
		}
		// }
	}

	// line 1904
	public boolean updateEvent() {
		switch (this._phase) {
		case START:
		case TURN:
		case TURN_END:
			if (this.isActionForced() != null) {
				this.processForcedAction();
				return true;
			} else {
				return this.updateEventMain();
			}
		}

		return this.checkAbort();
	}

	// line 1919
	public boolean updateEventMain() {
		// TODO
		// troop.updateInterpreter();
		// troop.requestMotionRefresh() -- what is this???
		// if (troop.isEventRunning() || this.checkBattleEnd()) {
		// return true;
		// }

		// troop.setupBattleEvent();
		// if (Troop.isEventRunning() || SceneManager.isSceneChanging()) {
		// return true;
		// }

		return false;
	}

	public boolean isInTurn() {
		return this._phase == Phase.TURN;
	}

	public boolean isTurnEnd() {
		return this._phase == Phase.TURN_END;
	}

	public boolean isBattleEnd() {
		return this._phase == Phase.BATTLE_END;
	}

	public boolean isAborting() {
		return this._phase == Phase.ABORT;
	}

	public boolean canEscape() {
		return this._canEscape;
	}

	public boolean canLose() {
		return this._canLose;
	}

	// line 1965
	public boolean hasEscaped() {
		return this._escaped;
	}

	// line 1969
	// public Actor currentActor() {
	// TODO
	// return this.actorIndex >= 0 ? troop.members()[this.actorIndex] : null;
	// }

	public void clearActor() {
		// TODO
		this.changeActor(-1); // (-1, lastActorActionState)
	}

	// line 1977
	public void changeActor(int nextActorIndex) { // , lastActorActionState) {
		// TODO
		// int previous = this.actor();
		this._actorIndex = nextActorIndex;
		// int current = this.actor();
		// if (previous) previous.setActionState(); //lastActorActionState);
		// if (current) current.setActionState(Phase.INPUT);
	}

	// line 1989
	public void startBattle() {
		// TODO
		this._phase = Phase.START;
		// gameSystem.onBattleStart()
		// gameParty.onBattleStart()
		// gameTroop.onBattleStart()
		this.displayStartMessages();
	}

	// line 1997
	public void displayStartMessages() {
		// TODO
		// troop.enemyNames().forEach ... print, blah blah

		if (this._preemptive) {
			// TODO add message for preempetive
		} else if (this._surprise) {
			// TODO add message for surprise
		}
	}

	// line 2008
	public void startInput() {
		// TODO
		this._phase = Phase.INPUT;
		// party.makeActions()
		// troop.makeActions()
		this.clearActor();
		if (this._surprise) { // || party.canInput != true)
			this.startTurn();
		}
	}

	// line 2018
	public void inputtingAction() {
		// TODO
	}

	// line 2022
	public void selectNextCommand() {
		// TODO
	}

	// line 2034
	public void selectPreviousCommand() {
		// TODO
	}

	// line 2045
	public void refreshStatus() {
		// TODO
	}

	// line 2049
	public void startTurn() {
		// TODO
		this._phase = Phase.TURN;
		this.clearActor();
		// troop.increaseTurn();
		// this.makeActionOrders();
		// requestMotionRefresh();
	}

	// line 2058
	public void updateTurn() {
		// TODO
		// party.requestMotionRefresh();
		if (this._subject == null)
			this._subject = this.getNextSubject();

		if (this._subject != null) {
			this.processTurn();
		} else {
			this.endTurn();
		}
	}

	// line 2070
	public void processTurn() {
		// TODO
		Actor subject = this._subject;
		// Action action = subject.currentAction();
		// if (action) {
		// action.prepare();
		// if (action.isValid()) {
		// this.startAction();
		// }
		// subject.removeCurrentAction();
		// } else {
		// subject.onAllActionsEnd();
		// this.refreshStatus();
		// this._subject = this.getNextSubject();
		// }
	}

	// line 2089
	public void endTurn() {
		// TODO
		this._phase = Phase.TURN_END;
		this._preemptive = false;
		this._surprise = false;
		// this.allBattleMembers().forEach() {
		// battler.onTurnEnd()
		// this.refreshStatus;
		// }
	}

	// line 2101
	public void updateTurnEnd() {
		this.startInput();
	}

	// line 2105
	public Actor getNextSubject() {
		// TODO - gets next available battler who hasn't acted, I assume

		for (;;) {
			// Actor battler = this.actionBattlers.shift();
			// if (battler == null) {
			// return null;
			// }

			// if (battler.isBattleMember() && battler.isAlive()) {
			// return battler;
			// }
		}
	}

	// line 2117
	public void allBattleMembers() {
		// TODO
		// return a merged list of party.members() && troop.members()
	}

	// line 2121
	public void makeActionOrders() {
		// TODO
		// this method organizes all acting battle members by speed
		Actor[] battlers;
		if (this._surprise != true) {
			// if not surprised, merge party with battlers
			// battlers = battlers.concat(party.members());
		}

		if (this._preemptive != true) {
			// if not preemptive, merge troop with battlers
			// battlers = battlers.concat(troop.members());
		}

		// battlers.forEach() {
		// battler.makeSpeed();
		// }

		// battlers.sort();
		// this assumes b.speed - a.speed

		// this.actionBattlers = battlers;
	}

	// line 2138
	public void startAction() {
		// TODO
		Actor subject = this._subject;
		Action action = subject.currentAction();
		List<Actor> targets = action.makeTargets();

		this._phase = Phase.ACTION;
		this._action = action;
		this._targets = targets;
		// subject.useItem(action.item());
		// this._action.applyGlobal();
		this.refreshStatus();
	}

	// line 2151
	public void updateAction() {
		// TODO - create "shift" method somehow
		// Actor target = this._targets.shift();
		// if (target != null) {
		// this.invokeAction(this._subject, target);
		// } else {
		// this.endAction();
		// }
	}

	// line 2160
	public void endAction() {
		this._phase = Phase.TURN;
	}

	// line 2165
	public void invokeAction(Actor subject, Actor target) {
		// TODO
		// pre-method that checks for counters, reflection, etc
		// if (Math.random() < this._action.itemCnt(target)) {
		// this.invokeCounterAttack(subject, target);
		// } else if (Math.random() < this._action.itemMrf(target)) {
		// this.invokeMagicReflection(subject, target);
		// } else {
		// this.invokeNormalAction(subject, target);
		// }
		//
		// subject.setLastTarget(target);
		this.refreshStatus();
	}

	// line 2179
	public void invokeNormalAction(Actor subject, Actor target) {
		// TODO
		// Actor realTarget = this.applySubstitution(target);
		// this._action.apply(realTarget);
	}

	// line 2185
	public void invokeCounterAttack(Actor subject, Actor target) {
		// TODO
		Action action = new Action(target);
		action.setAttack();
		// action.apply(subject);
	}

	// line 2193
	public void invokeMagicReflection(Actor subject, Actor target) {
		// TODO
		// this._action.apply(subject);
	}

	// line 2199
	public Actor applySubstitute(Actor target) {
		// TODO
		// if (this.checkSubstitute(target)) {
		Actor substitute = new Actor(); // = target.friendsUnit().substituteBattler();
		if (substitute != null && target != substitute) {
			return substitute;
		}
		// }

		return target;
	}

	// line 2210
	public boolean checkSubstitute(Actor target) {
		// TODO
		return target.isDying() && this._action.isCertainHit() != true;
	}

	// line 2214
	public Actor isActionForced() {
		if (this._actionForcedBattler != null) {
			return this._actionForcedBattler;
		} else {
			return null;
		}
	}

	// line 2218
	public void forceAction(Actor battler) {
		// TODO
		this._actionForcedBattler = battler;
		int index = this._actionBattlers.indexOf(battler);
		if (index >= 0) {
			// this._actionBattlers.splice(index, 1);
		}
	}

	// line 2226
	public void processForcedAction() {
		if (this._actionForcedBattler != null) {
			this._subject = this._actionForcedBattler;
			this._actionForcedBattler = null;
			this.startAction();
			this._subject.removeCurrentAction();
		}
	}

	// line 2235
	public void abort() {
		this._phase = Phase.ABORT;
	}

	// line 2239
	public boolean checkBattleEnd() {
		// TODO
		if (this._phase != null) {
			if (this.checkAbort()) {
				return true;
			}
			// else if (party.isAllDead()) {
			// this.processDefeat();
			// return true;
			// } else if (troop.isAllDead()) {
			// this.processVictory();
			// return true;
			// }
		}

		return false;
	}

	// line 2254
	public boolean checkAbort() {
		// TODO
		if (this.isAborting()) {// || party.isEmpty()) {
			// this.processAbort();
			return true;
		}

		return false;
	}

	// line 2262
	public void processVictory() {
		// TODO
		// party.removeBattleStates();
		// party.performVictory();
		this.makeRewards();
		this.gainRewards();
		this.endBattle(0);
	}

	// line 2274
	public boolean processEscape() {
		// TODO
		// party.removeBattleStates();
		// party.performEscape();
		boolean success = (this._preemptive) ? true : false; // (Math.random() < this._escapeRate);
		if (success) {
			this._escaped = true;
			this.processAbort();
		} else {
			this._escapeRate += 0.1;
			// party.clearActions();
			this.startTurn();
		}

		return success;
	}

	// line 2292
	public void processAbort() {
		this.endBattle(1);
	}

	// line 2297
	public void processDefeat() {
		// TODO
		this.endBattle(2);
	}

	// line 2308
	public void endBattle(int result) {
		this._phase = Phase.BATTLE_END;
		if (result == 0) {
			// system.onBattleWin();
		} else if (this._escaped) {
			// system.onBattleEscape();
		}
	}

	// line 2320
	public void updateBattleEnd() {
		// if (party.isAllDead()) {
		// if (this._canLose) {
		// party.reviveBattleMembers();
		// } else {
		// // game over
		// }
		// }

		this._phase = null;
	}

	// line 2337
	public void makeRewards() {
		// TODO
		// this._rewards = {};
		// this._rewards.gold = $gameTroop.goldTotal();
		// this._rewards.exp = $gameTroop.expTotal();
		// this._rewards.items = $gameTroop.makeDropItems();
	}

	// line 2392
	public void gainRewards() {
		// TODO
		// this.gainExp();
		// this.gainGold();
		// this.gainDropItems();
	}

	// line 2398
	public void gainExp() {
		// TODO
		// int exp = this._rewards.exp;
		// party.allMembers().forEach() {
		// actor.gainExp(exp);
		// }
	}

	// line 2405
	public void gainGold() {
		// TODO
		// party.gainGold(this._rewards.gold);
	}

	// line 2409
	public void gainDropItems() {
		// TODO
		// Loot(?) items = this._rewards.items;
		// items.forEach() {
		// party.gainItem(item, 1);
		// }
	}

	// "game actions" for battle begin on line 1181 of rpg_objects.js

	// "game action RESULTS" for battle begin at line 1968

	// "battler" data begins at line 2073
}
