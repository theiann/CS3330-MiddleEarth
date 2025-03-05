package manager;
import characters.MiddleEarthCharacter;


public class CharacterManager {
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[10]; 
	private int size=0;

	/**
	 * this method adds a character to the character array, if the size of the array gets filled,
	 * it creates a new array that is 2 times longer and copies everything onto that array
	 * After adding the character it increments the size
	 * @param c
	 * @return returns false if character addition fails and true if it works
	 */
	boolean addCharacter (MiddleEarthCharacter c) {
		if(c== null) {
			return false;
		}
		
		if(size == characters.length) {
			MiddleEarthCharacter[] newCharacterManager = new MiddleEarthCharacter[characters.length*2];
			System.arraycopy(characters, 0, newCharacterManager, 0, characters.length);
			characters = newCharacterManager;
		}
		
		characters[size]= c;
		size++;
		return true; 
	}
	
	/**
	 * This method simply searches the array until it finds an index of character
	 * with the same name, if the name is the same, it returns the character index found
	 * @param name
	 * @return returns the character index if same name is found, otherwise null
	 */
	MiddleEarthCharacter getCharacter(String name) {
		for(int i =0;i<size;i++) {
			if(characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	
	
}
