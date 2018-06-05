package model;

public interface ISpell {

	SpellState getState();

	/**
	 * Updates the spell state
	 * @param state
	 * 			It's a SpellState
	 */
	void setState(SpellState state);
	}
