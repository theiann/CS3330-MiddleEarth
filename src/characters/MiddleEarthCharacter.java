package characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	
	public MiddleEarthCharacter(String n, double h, double p) {
		this.name = n;
		this.health = h;
		this.power = p;
	}
	
	public abstract boolean attack(MiddleEarthCharacter target);
	
	public abstract String getRace();
	
	public void displayInfo() {
		System.out.println("Name: " + this.name + " Health: " + this.health + " Power: " + this.power);
	}
}
