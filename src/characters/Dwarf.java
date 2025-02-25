package characters;

public class Dwarf extends MiddleEarthCharacter{
	private String name;
	private double health;
	private double power;
	
	
	// Set values
	private String race = "Dwarf";
	private String strongAgainst = "Elf";
	private String weakAgainst = "Wizard";
	
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
		double health = target.getHealth();
		double damage = this.power;
		if((target.getRace() != this.race) || (target.getRace() != this.weakAgainst)){
			if(target.getRace() == this.strongAgainst) {
				damage *= 1.5;
			}
			health -= damage;
			target.setHealth(health);
			return true;
		}
		return false;
	}
	
	@Override
	public String getRace() {
		return this.race;
	}
}
