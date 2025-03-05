package characters;

public abstract class MiddleEarthCharacter {
	protected String name;
	protected double health;
	protected double power;
	
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
	
	
	/**
	 * This method will add display the info for a MiddleEarthCharacter
	 */
	public void displayInfo() {
		System.out.println("Name: " + this.name + " Health: " + this.health + " Power: " + this.power);
	}
	
	
	/**
	 * 
	 * This method will get the name of the MiddleEarthCharacter 
	 * 
	 * @return
	 * 				Returns name of the MiddleEarthCharacter
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * This method will set the name of the MiddleEarthCharacter 
	 * 
	 * @param
	 * 				Name of the MiddleEarthCharacter
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * This method will get the health of the MiddleEarthCharacter 
	 * 
	 * @return
	 * 				Returns health of the MiddleEarthCharacter
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * 
	 * This method will set the health of the MiddleEarthCharacter 
	 * 
	 * @param
	 * 				Health of the MiddleEarthCharacter
	 */
	public void setHealth(double health) {
		this.health = health;
	}
	
	
	/**
	 * 
	 * This method will get the power of the MiddleEarthCharacter 
	 * 
	 * @return
	 * 				Returns power of the MiddleEarthCharacter
	 */
	public double getPower() {
		return power;
	}
	
	/**
	 * 
	 * This method will set the power of the MiddleEarthCharacter 
	 * 
	 * @param
	 * 				Power of the MiddleEarthCharacter
	 */
	public void setPower(double power) {
		this.power = power;
	}
}
