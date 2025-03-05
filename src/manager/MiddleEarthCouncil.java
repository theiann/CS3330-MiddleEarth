package manager;
import manager.CharacterManager;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	private CharacterManager manager;
	
	/**
	 * This method will make the first instance of MiddleEarthCouncil
	 */
	private MiddleEarthCouncil() {
		this.manager = new CharacterManager();
	}
	
	/**
	 * This method gets the instance of MiddleEarthCouncil and if one has not been made, it will be.
	 */
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	
	/**
	 * 
	 * This method will get the character manager.
	 * 
	 * @return
	 * 			returns the instance of the character manager
	 */
	public CharacterManager getCharacterManager() {
		return this.manager;
	}
	
}
