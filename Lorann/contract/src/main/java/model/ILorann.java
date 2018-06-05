package model;

public interface ILorann {


	public LorannState getState() ;
	
	
	public void setState(LorannState state);
	

	public SpellState getPossessionSpell();

	public void setPossessionSpell(SpellState spellState);
	
	
}
