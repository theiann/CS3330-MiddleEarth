package manager;
import manager.CharacterManager;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	private CharacterManager manager;
	
	
	private MiddleEarthCouncil() {
		this.manager = new CharacterManager();
	}
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	CharacterManager getCharacterManager() {
		return this.manager;
	}
	
}
