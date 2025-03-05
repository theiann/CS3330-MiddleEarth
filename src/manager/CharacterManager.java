package manager;
import characters.MiddleEarthCharacter;


public class CharacterManager {
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[10]; 
	private int size=0;

	/**
	 * this method adds a character to the character array, if the size of the array get filled,
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
	
	
	
}
