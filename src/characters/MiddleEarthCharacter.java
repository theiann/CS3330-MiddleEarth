package characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	public MiddleEarthCharacter() {
		this.name = "Unknown";
		this.health = 100;
		this.power = 10;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
}
