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
	
	/**
	 * this method simply updates the information of the character that is passed
	 * it moves through the array and compares the passed character to all 
	 * characters in the array until found and updates their value by calling 
	 * the respective setter functions 
	 * @param character
	 * @param name
	 * @param health
	 * @param power
	 * @return returns False if character not found, and true if info was updated. 
	 */
	boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		for (int i=0;i<size;i++) {
			if(character.equals(characters[i])) {
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				return true;
			}
		}
		return false; 
	}
	
	/**
	 * this method searches the whole array until it finds the character to delete,
	 * then once found, using a nested for loop, it shifts all elements on the 
	 * right of the index to be deleted on to the left and then  sets the last
	 * index to be null. On success, it decrements size 
	 * @param character
	 * @return returns true if deletion success otherwise false 
	 */
	boolean deleteCharacter(MiddleEarthCharacter character) {
		for (int i=0;i<size;i++) {
			if(character.equals(characters[i])) {
				for(int j=i;i<size-1;i++){
				characters[j]= characters[j+1];				
			}
				characters[size-1]=null;
				size--;
				return true; 
		}
	}
		return false;
	}
	
}
