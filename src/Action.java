import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

public class Action {
	private enum Effect {
		RECOVER_HP, RECOVER_MP, GAIN_TP, ADD_STATE, REMOVE_STATE, ADD_BUFF, ADD_DEBUFF, REMOVE_BUFF, REMOVE_DEBUFF, SPECIAL, GROW, LEARN_SKILL, ESCAPE, CERTAIN, PHYSICAL, MAGICAL
	}

	// fields
	private Actor _subject;
	private Actor[] _targets;

	// constructors
	public Action(Actor target) {
		// TODO
	}

	// methods
	// line 1208
	public void initialize(Actor subject, boolean forced) {
		// TODO
		// this._subjectActorID = 0;
		// this._subjectEnemyIndex = -1;
		// this._forced = (forced) ? forced : false;
		// this.setSubject(subject);
		this.clear();
	}

	// line 1216
	public void clear() {
		// TODO
		// this._item = new Object();
		// this._targetIndex = -1;
	}

	// line 1221
	public void setSubject(Actor subject) {
		// TODO
		// if (_subject.isActor()) {
		// this._subjectActorID = subject.actorID();
		// this._subjectEnemyIndex = -1;
		// } else {
		// this._subjectEnemyIndex = subject.index();
		// this._subjectActorID = 0;
		// }
	}

	// line 1231
	public int subject() {
		// TODO - I don't know what this method does
		// if (this._subjectActorID > 0) {
		// return actors.actor(this._subjectActorID);
		// } else {
		// return troop.members()[this._subjectEnemyIndex];
		// }
		return 0;
	}

	// line 1239
	public List<Actor> friendsUnit() {
		// TODO - connects character to Game_Party
		// return this._subject().friendsUnit();
		return null;
	}

	// line 1243
	public List<Actor> opponentsUnit() {
		// TODO - connects character to Game_Troop
		// return this._subject().opponentsUnit();
		return null;
	}

	// line 1247
	public void setEnemyAction(Action action) {
		// TODO
		// if (action) {
		// this.setSkill(action.skillID);
		// } else {
		// this.clear();
		// }
	}

	// line 1255
	public void setAttack() {
		// TODO
		// this.setSkill(this._subject().attackSkillID));
	}

	// line 1259
	public void setGuard() {
		// TODO
		// this.setSkill(this._subject().guardSkillID()));
	}

	// line 1263
	public void setSkill(int SkillID) {
		// TODO - requires database reference
		// this._item.setObject($dataSkills[skillID]);
	}

	// line 1267
	public void setItem(int itemID) {
		// TODO - requires database reference
		// this._item.setObject($dataItems[itemID]);
	}

	// line 1271
	public void setItemObject(Object generic) {
		// TODO - requires database reference
		// this._item.setObject(generic);
	}

	// line 1275
	public void setTarget(int targetIndex) {
		// TODO
		// this._targetIndex = targetIndex;
	}

	// line 1279
	public Object item() {
		// TODO - not sure what the purpose of this method is
		// this._item.object();
		return null;
	}

	// line 1283
	public boolean isSkill() {
		// TODO - invokes Game_Item to see if skill
		// return this._item.isSkill;
		return false;
	}

	// line 1287
	public boolean isItem() {
		// TODO - invokes Game_Item to see if item
		// return this._item.isItem;
		return false;
	}

	// line 1291
	public int numRepeats() {
		// TODO
		// double repeats = this.item().repeats;
		// if (this.isAttack()) {
		// repeats += this.subject().attackTimesAdd();
		// }
		//
		// return Math.floor(repeats);
		return 0;
	}

	// line 1299
	public Object checkItemScope(List list) {
		// TODO
		// return list.contains(this.item().scope);
		return null;
	}

	// line 1303
	public boolean isForOpponent() {
		// TODO
		// return this.checkItemScope([1, 2, 3, 4, 5, 6]);
		return false;
	}

	// line 1307
	public boolean isForFriend() {
		// TODO
		// return this.checkItemScope([7, 8, 9, 10, 11]);
		return false;
	}

	// line 1311
	public boolean isForDeadFriend() {
		// TODO
		// return this.checkItemScope([9, 10]);
		return false;
	}

	// line 1315
	public boolean isForUser() {
		// TODO
		// return this.checkItemScope([11]);
		return false;
	}

	// line 1319
	public boolean isForOne() {
		// TODO
		// return this.checkItemScope([1, 3, 7, 9, 11]);
		return false;
	}

	// line 1323
	public boolean isForRandom() {
		// TODO
		// return this.checkItemScope([3, 4, 5, 6]);
		return false;
	}

	// line 1327
	public boolean isForAll() {
		// TODO
		// return this.checkItemScope([2, 8, 10]);
		return false;
	}

	// line 1331
	public boolean needsSelection() {
		// TODO
		// return this.checkItemScope([1, 7, 9]);
		return false;
	}

	// line 1335
	public int numTargets() {
		// TODO
		// return (this.isForRandom()) ? this.item().scope - 2 : 0;
		return 0;
	}

	// line 1339
	public List checkDamageType(List list) {
		// TODO
		// return list.contains(this.item().damage.type);
		return null;
	}

	// line 1343
	public boolean isHpEffect() {
		// TODO
		// return this.checkDamageType([1, 3, 5]);
		return false;
	}

	// line 1347
	public boolean isMpEffect() {
		// TODO
		// return this.checkDamageType([2, 4, 6]);
		return false;
	}

	// line 1351
	public boolean isDamage() {
		// TODO
		// return this.checkDamageType([1, 2]);
		return false;
	}

	// line 1355
	public boolean isRecover() {
		// TODO
		// return this.checkDamageType([3, 4]);
		return false;
	}

	// line 1359
	public boolean isDrain() {
		// TODO
		// return this.checkDamageType([5, 6]);
		return false;
	}

	// line 1363
	public boolean isHpRecover() {
		// TODO
		// return this.checkDamageType([3]);
		return false;
	}

	// line 1367
	public boolean isMpRecover() {
		// TODO
		// return this.checkDamageType([4]);
		return false;
	}

	// line 1371
	public boolean isCertainHit() {
		// TODO
		// return this.item().hitType === Game_Action.HITTYPE_CERTAIN;
		return false;
	}

	// line 1375
	public boolean isPhysical() {
		// TODO
		// return this.item().hitType === Game_Action.HITTYPE_PHYSICAL;
		return false;
	}

	// line 1379
	public boolean isMagical() {
		// TODO
		// return this.item().hitType === Game_Action.HITTYPE_MAGICAL;
		return false;
	}

	// line 1383
	public boolean isAttack() {
		// TODO
		// return this.item() === $dataSkills[this.subject().attackSkillId()];
		return false;
	}

	// line 1387
	public boolean isGuard() {
		// TODO
		// return this.item() === $dataSkills[this.subject().guardSkillId()];
		return false;
	}

	// line 1391
	public boolean isMagicSkill() {
		// TODO
		// if (this.isSkill()) {
		// return $dataSystem.magicSkills.contains(this.item().stypeId);
		// } else {
		// return false;
		// }

		return false;
	}

	// line 1399
	public void decideRandomTarget() {
		// TODO
		Actor target;
		// if (this.isForDeadFriend()) {
		// target = this.friendsUnit().randomDeadTarget();
		// } else if (this.isForFriend()) {
		// target = this.friendsUnit().randomTarget();
		// } else {
		// target = this.opponentsUnit().randomTarget();
		// }

		// if (target != null) {
		// this._targetIndex = target.index;
		// } else {
		// this.clear();
		// }
	}

	// line 1415
	public void setConfusion() {
		this.setAttack();
	}

	// line 1419
	public void prepare() {
		// TODO - checks if target is confused
		// if (this.subject().isConfused() && this._forced != true) {
		// this.setConfusion();
		// }
	}

	// line 1425
	public boolean isValid() {
		// TODO
		// return ((this.forced && this.item()) || this.subject().canUse(this.item()));
		return false;
	}

	// line 1429
	public int speed() {
		// TODO
		int agility = 0; // this.subject().agi;
		int speed = (int) (agility + (Math.random() * Math.floor(5 + agility / 4)));

		if (this.item() != null) {
			// speed += this.item().speed;
		}

		if (this.isAttack()) {
			// speed += this.subject().attackSpeed();
		}

		return speed;
	}

	// line 1441
	public List<Actor> makeTargets() {
		List<Actor> targets = new LinkedList<Actor>();

		// if (this._forced != true && this._subject().isConfused()) {
		// targets = this.confusionTarget();
		// } else if (this.isForOpponent()) {
		// targets = this.targetsForOpponents();
		// } else if (this.isForFriend()) {
		// targets = this.targetsForFriends();
		// }

		return targets;
	}

	// line 1453
	public List<Actor> repeatTargets(List<Actor> targets) {
		// TODO - make sure this actually works
		ArrayList<Actor> repeatedTargets = new ArrayList<Actor>();
		int repeats = this.numRepeats();

		for (int i = 0; i < targets.size(); i++) {
			Actor target = targets.get(i);
			if (target != null) {
				for (int j = 0; j < repeats; j++) {
					repeatedTargets.add(target);
				}
			}
		}

		return repeatedTargets;
	}

	// line 1467
	public Actor confusionTarget() {
		// TODO
		// switch (this.subject().confusionLevel()) {
		// case 1:
		// return this.opponentsUnit().randomTarget();
		// case 2:
		// if (Math.randomInt(2) === 0) {
		// return this.opponentsUnit().randomTarget();
		// }
		// return this.friendsUnit().randomTarget();
		// default:
		// return this.friendsUnit().randomTarget();
		// }

		return null;
	}

	// line 1481
	public List<Actor> targetsForOpponents() {
		// TODO
		List<Actor> targets = new ArrayList<Actor>();
		// Troop unit = this.opponentsUnit();
		if (this.isForRandom()) {
			for (int i = 0; i < this.numTargets(); i++) {
				// targets.add(unit.randomTarget());
			}
		} else if (this.isForOne()) {
			// if (this._targetIndex < 0) {
			// targets.push(unit.randomTarget());
			// } else {
			// targets.push(unit.smoothTarget(this._targetIndex));
			// }
		} else {
			// targets = unit.aliveMembers();
		}

		return targets;
	}

	// line 1500
	public List<Actor> targetsForFriends() {
		// TODO
		List<Actor> targets = new ArrayList<Actor>();
		// Game_Party unit = this.friendsUnit();
		if (this.isForUser()) {
			targets.add(this._subject);
		} else if (this.isForDeadFriend()) {
			if (this.isForOne()) {
				// targets.push(unit.smoothDeadTarget(this._targetIndex));
			} else {
				// targets = unit.deadMembers();
			}
		} else if (this.isForOne()) {
			// if (this._targetIndex < 0) {
			// targets.push(unit.randomTarget());
			// } else {
			// targets.push(unit.smoothTarget(this._targetIndex));
			// }
		} else {
			// targets = unit.aliveMembers();
		}

		return targets;
	}

	// line 1523
	public int evaluate() {
		// TODO - this might take some time to interpret & translate
		int value = 0;
		// this.itemTargetCandidates().forEach(function(target) {
		// var targetValue = this.evaluateWithTarget(target);
		// if (this.isForAll()) {
		// value += targetValue;
		// } else if (targetValue > value) {
		// value = targetValue;
		// this._targetIndex = target.index;
		// }
		// }, this);
		// value *= this.numRepeats();
		// if (value > 0) {
		// value += Math.random();
		// }

		return value;
	}

	// line 1541
	public List<Actor> itemTargetCandidates() {
		List<Actor> candidates = new LinkedList<Actor>();

		// TODO
		if (!this.isValid()) {
			return null;
		} else if (this.isForOpponent()) {
			// return this.opponentsUnit().aliveMembers();
		} else if (this.isForUser()) {
			candidates.add(this._subject);
		} else if (this.isForDeadFriend()) {
			// return this.friendsUnit().deadMembers();
		} else {
			// return this.friendsUnit().aliveMembers();
		}

		return candidates;
	}

	// line 1555
	public void evaluateWithTarget(Actor target) {
		// TODO
		if (this.isHpEffect()) {
			// int value = this.makeDamageValue(target, false);
			// if (this.isForOpponent()) {
			// return value / Math.max(target.hp, 1);
			// } else {
			// int recovery = Math.min(-value, target.mhp - target.hp);
			// return recovery / target.mhp;
			// }
		}
	}

	// line 1567
	public boolean testApply(Actor target) {
		// TODO
		// return (this.isForDeadFriend() === target.isDead() &&
		// ($gameParty.inBattle() || this.isForOpponent() ||
		// (this.isHpRecover() && target.hp < target.mhp) ||
		// (this.isMpRecover() && target.mp < target.mmp) ||
		// (this.hasItemAnyValidEffects(target))));
		return false;
	}

	// line 1575
	public boolean hasItemAnyValidEffects(Actor target) {
		// TODO - this confuses me
		// return this.item().effects.some(function(effect) {
		// return this.testItemEffect(target, effect);
		// }, this);

		return false;
	}

	// line 1581
	public boolean testItemEffect(Actor target, Effect effect) {
		// TODO
		switch (effect) {
		case RECOVER_HP:
			// return target.hp < target.mhp || effect.value1 < 0 || effect.value2 < 0;
		case RECOVER_MP:
			// return target.mp < target.mmp || effect.value1 < 0 || effect.value2 < 0;
		case ADD_STATE:
			// return !target.isStateAffected(effect.dataId);
		case REMOVE_STATE:
			// return target.isStateAffected(effect.dataId);
		case ADD_BUFF:
			// return !target.isMaxBuffAffected(effect.dataId);
		case ADD_DEBUFF:
			// return !target.isMaxDebuffAffected(effect.dataId);
		case REMOVE_BUFF:
			// return target.isBuffAffected(effect.dataId);
		case REMOVE_DEBUFF:
			// return target.isDebuffAffected(effect.dataId);
		case LEARN_SKILL:
			// return target.isActor() && !target.isLearnedSkill(effect.dataId);
		default:
			return true;
		}
	}

	// line 1606
	public double itemCnt(Actor target) {
		// TODO
		// if (this.isPhysical() && target.canMove()) {
		// return target.cnt;
		// } else {
		// return 0;
		// }

		return 0;
	}

	// line 1614
	public double itemMrf(Actor target) {
		// TODO
		// if (this.isMagical()) {
		// return target.mrf;
		// } else {
		// return 0;
		// }

		return 0;
	}

	// line 1622
	public double itemHit(Actor target) {
		// TODO
		// if (this.isPhysical()) {
		// return this.item().successRate * 0.01 * this.subject().hit;
		// } else {
		// return this.item().successRate * 0.01;
		// }

		return 0;
	}

	// line 1630
	public double itemEva(Actor target) {
		// TODO
		// if (this.isPhysical()) {
		// return target.eva;
		// } else if (this.isMagical()) {
		// return target.mev;
		// } else {
		// return 0;
		// }

		return 0;
	}

	// line 1640
	public double itemCri(Actor target) {
		// TODO
		// return this.item().damage.critical ? this.subject().cri * (1 - target.cev) :
		// 0;
		return 0;
	}

	// line 1644
	public void apply(Actor target) {
		// TODO
		// var result = target.result();
		// this.subject().clearResult();
		// result.clear();
		// result.used = this.testApply(target);
		// result.missed = (result.used && Math.random() >= this.itemHit(target));
		// result.evaded = (!result.missed && Math.random() < this.itemEva(target));
		// result.physical = this.isPhysical();
		// result.drain = this.isDrain();
		// if (result.isHit()) {
		// if (this.item().damage.type > 0) {
		// result.critical = (Math.random() < this.itemCri(target));
		// var value = this.makeDamageValue(target, result.critical);
		// this.executeDamage(target, value);
		// }
		// this.item().effects.forEach(function(effect) {
		// this.applyItemEffect(target, effect);
		// }, this);
		// this.applyItemUserEffect(target);
		// }
	}

	// line 1666
	public void makeDamageValue(Actor target, boolean critical) {
		// TODO
		// Object item = this.item();
		// int baseValue = this.evalDamageFormula(Actor target);
		// int value = baseValue * this.calcElementRate(target);
		// if (this.isPhysical()) {
		// value *= target.pdr;
		// }
		// if (this.isMagical()) {
		// value *= target.mdr;
		// }
		// if (baseValue < 0) {
		// value *= target.rec;
		// }
		// if (critical) {
		// value = this.applyCritical(value);
		// }
		// value = this.applyVariance(value, item.damage.variance);
		// value = this.applyGuard(value, target);
		// value = Math.round(value);
		//
		// return value;
	}

	// line 1688
	public void evalDamageFormula(Actor target) {
		// TODO
		try {
			Object item = this.item();
			int a = this.subject();
			// var b = target;
			// int v = $gameVariables._data;
			// var sign = ([3, 4].contains(item.damage.type) ? -1 : 1);
			// return Math.max(eval(item.damage.formula), 0) * sign;
		} catch (Error e) {
			// return 0;
		}
	}

	// line 1701
	public void calcElementRate(Actor target) {
		// TODO
		// if (this.item().damage.elementId < 0) {
		// return this.elementsMaxRate(target, this.subject().attackElements());
		// } else {
		// return target.elementRate(this.item().damage.elementId);
		// }
	}

	// line 1709
	public void elementsMaxRate(Actor target, EnumSet<Element> elements) {
		// TODO
		// if (elements.length > 0) {
		// return Math.max.apply(null, elements.map(function(elementId) {
		// return target.elementRate(elementId);
		// }, this));
		// } else {
		// return 1;
		// }
	}

	// line 1719
	public int applyCritical(int damage) {
		return damage * 3;
	}

	// line 1723
	public int applyVariance(int damage, int variance) {
		// TODO
		int amp = (int) Math.floor(Math.max(Math.abs(damage) * variance / 100, 0));
		int v = (int) (Math.random() * (amp + 1) + Math.random() * (amp + 1) - amp);
		return (damage >= 0) ? damage + v : damage - v;
	}

	// line 1729
	public int applyGuard(int damage, Actor target) {
		// TODO
		// return damage / (damage > 0 && target.isGuard() ? 2 * target.grd : 1);
		return 0;
	}

	// line 1733
	public void executeDamage(Actor target, int value) {
		// TODO
		// var result = target.result();
		// if (value == 0) {
		// result.critical = false;
		// }
		// if (this.isHpEffect()) {
		// this.executeHpDamage(target, value);
		// }
		// if (this.isMpEffect()) {
		// this.executeMpDamage(target, value);
		// }
	}

	// line 1746
	public void executeHpDamage(Actor target, int value) {
		// if (this.isDrain()) {
		// value = Math.min(target.hp, value);
		// }
		//
		// this.makeSuccess(target);
		// target.gainHp(-value);
		//
		// if (value > 0) {
		// target.onDamage(value);
		// }
		//
		// this.gainDrainedHp(value);
	}

	// line 1758
	public void executeMpDamage(Actor target, int value) {
		// if (!this.isMpRecover()) {
		// value = Math.min(target.mp, value);
		// }
		//
		// if (value != 0) {
		// this.makeSuccess(target);
		// }
		//
		// target.gainMp(-value);
		// this.gainDrainedMp(value);
	}

	// line 1769
	public void gainDrainedHp(int value) {
		// if (this.isDrain()) {
		// this.subject().gainHp(value);
		// }
	}

	// line 1775
	public void gainDrainedMp(int value) {
		// if (this.isDrain()) {
		// this.subject().gainMp(value);
		// }
	}

	// line 1781
	public void applyItemEffect(Actor target, Effect effect) {
		// TODO
		switch (effect) {
		// case RECOVER_HP:
		// this.itemEffectRecoverHp(target, effect);
		// break;
		// case RECOVER_MP:
		// this.itemEffectRecoverMp(target, effect);
		// break;
		// case GAIN_TP:
		// this.itemEffectGainTp(target, effect);
		// break;
		// case ADD_STATE:
		// this.itemEffectAddState(target, effect);
		// break;
		// case REMOVE_STATE:
		// this.itemEffectRemoveState(target, effect);
		// break;
		// case ADD_BUFF:
		// this.itemEffectAddBuff(target, effect);
		// break;
		// case ADD_DEBUFF:
		// this.itemEffectAddDebuff(target, effect);
		// break;
		// case REMOVE_BUFF:
		// this.itemEffectRemoveBuff(target, effect);
		// break;
		// case REMOVE_DEBUFF:
		// this.itemEffectRemoveDebuff(target, effect);
		// break;
		// case SPECIAL:
		// this.itemEffectSpecial(target, effect);
		// break;
		// case GROW:
		// this.itemEffectGrow(target, effect);
		// break;
		// case LEARN_SKILL:
		// this.itemEffectLearnSkill(target, effect);
		// break;
		default:
			break;
		}
	}

}
