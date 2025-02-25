package characters;

public class Dwarf extends MiddleEarthCharacter{
	
	// Set values
	private static final String RACE = "Dwarf";
	private static final String STRONG_AGAINST = "Elf";
	private static final String WEAK_AGAINST = "Wizard";
	
	
	public Dwarf() {
		this.name = "Unknown";
		this.health = 100;
		this.power = 10;
	}
	public Dwarf(String n, double h, double p) {
		this.name = n;
		this.health = h;
		this.power = p;
	}
	
	
	
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
	
	@Override
	public String getRace() {
		return RACE;
	}
}
