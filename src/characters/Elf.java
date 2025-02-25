package characters;

public class Elf extends MiddleEarthCharacter{

	// Set values
	private static final String RACE = "Elf";
	private static final String STRONG_AGAINST = "Orc";
	private static final String WEAK_AGAINST = "Dwarf";
	
	
	/**
	 * 
	 * This method will construct a new Elf subclass with default values.
	 * 
	 */
	public Elf() {
		this.name = "Unknown";
		this.health = 100;
		this.power = 10;
	}
	
	/**
	 * 
	 * This method will construct a new Elf subclass with provided values.
	 * @param n 
	 * 			Name for new character
	 * @param h
	 * 			Health for new character
	 * @param p
	 * 			Power for new character
	 * 
	 */
	public Elf(String n, double h, double p) {
		this.name = n;
		this.health = h;
		this.power = p;
	}
	
	
	/**
	 * 
	 * This method will attack a targeted character.
	 * @param target
	 * 			Targeted character
	 * @return
	 * 			Returns false if the attack failed
	 * 			Returns true if the attack went through successfully
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		double oldHealth = target.getHealth();
		double health = target.getHealth();
		double scalar = 1.0;
		
		
		if((target.getRace() != RACE) && (target.getRace() != WEAK_AGAINST)){
			if(target.getRace() == STRONG_AGAINST) {
				scalar += 0.5;
			}
			health -= this.power * scalar;
			target.setHealth(health);
			System.out.println(this.getName() + " (" + this.getHealth() + ")" + " attacked " + target.getName() 
			+ " (" + target.getHealth() + ") with " + this.power*scalar + " damage! (" + this.power + "x" + scalar + ") (HP: " + oldHealth + " -> " + health + ")"); 
			return true;
		}
		System.out.println(this.getName() + " (" + this.getHealth() + ")" + " tried to attack " + target.getName() + " (" + this.getHealth() + ") but the attack failed!");
		return false;
	}
	
	/**
	 * 
	 * This method will get the Race of the subclass.
	 * @return
	 * 			Returns name of the race
	 */
	@Override
	public String getRace() {
		return RACE;
	}
}
