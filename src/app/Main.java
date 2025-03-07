package app;

import java.util.Scanner;

import characters.MiddleEarthCharacter;
import characters.Dwarf;
import characters.Wizard;
import characters.Human;
import characters.Orc;
import characters.Elf;
import manager.CharacterManager;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CharacterManager characterManager = new CharacterManager();

    public static void main(String[] args) {
    	/**
    	 * Until prompted to exit the menu, the switch case will be used to perform
    	 * different actions to the characters array. It will first print the commands 
    	 * menu to let the user know what Middle earth functions they can do 
    	 */
        boolean exit = false;
        while (!exit) {
            commandsMenu();
            int command = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (command) {
                case 1:
                    addCharacter();
                    break;
                case 2:
                    deleteCharacter();
                    break;
                case 3:
                    updateCharacter();
                    break;
                case 4:
                    viewAllCharacters();
                    break;
                case 5:
                    executeAllAttacks();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you, try again later.");
                    break;
                default:
                    System.out.println("Try another input please!");
            }
        }
    }

    private static void commandsMenu() {
        System.out.println("\nChoose:");
        System.out.println("1. Add character to Middle Earth");
        System.out.println("2. Delete a character");
        System.out.println("3. Update character stats");
        System.out.println("4. View all characters");
        System.out.println("5. ATTACK!!");
        System.out.println("6. EXIT");
        System.out.println("\nChoose:");
    }
/**
 * The add character method first prints the options that users have
 * regarding selection of the character's race, then it uses input to 
 * also get the health and power of the character being added.
 * All of this is then sent to a method in one of the race classes
 * using a switch case
 */
    
    private static void addCharacter() {
        System.out.println("Select character race:");
        System.out.println("1. Dwarf");
        System.out.println("2. Wizard");
        System.out.println("3. Human");
        System.out.println("4. Orc");
        System.out.println("5. Elf");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        System.out.print("Enter hp: ");
        double health = scanner.nextDouble();

        System.out.print("Enter power: ");
        double power = scanner.nextDouble();

        MiddleEarthCharacter characterNew = null;

        switch (choice) {
            case 1:
                characterNew = new Dwarf(name, health, power);
                break;
            case 2:
                characterNew = new Wizard(name, health, power);
                break;
            case 3:
                characterNew = new Human(name, health, power);
                break;
            case 4:
                characterNew = new Orc(name, health, power);
                break;
            case 5:
                characterNew = new Elf(name, health, power);
                break;
            default:
                System.out.println("Choose another number please");
                return;
        }

       boolean addCharacterStatus = characterManager.addCharacter(characterNew);
       if(addCharacterStatus == false) {
    	   System.out.println("Your character could not be Added");
       }
       else {
    	   System.out.println("Your character was successfully Added");
       }
    }
    
    /**
     * This method simply calls the display all characters method in character manager. 
     */
    private static void viewAllCharacters() {
        characterManager.displayAllCharacters();
    }

    /**
     * In this delete character method, first it asks the user some input regarding
     * what character they want to delete, which would be the name, the name is then 
     * passed onto the get character method in the character manager class, when the 
     * character is returned, after the character returned is passed onto the delete 
     * method in the character manager class. 
     */
    private static void deleteCharacter() {
    	boolean deleteCharacterStatus; 
        System.out.println("Enter the name of the character you want to delete");
        String characterToDelete = scanner.nextLine();
        MiddleEarthCharacter foundCharacter = characterManager.getCharacter(characterToDelete);
        
        deleteCharacterStatus = characterManager.deleteCharacter(foundCharacter);
        
        if(deleteCharacterStatus == false) {
     	   System.out.println("Your character could not be deleted");
        }
        else {
     	   System.out.println("Your character was successfully deleted");
        }
    }
/**
 * This method scans for a character name, using the name, it finds the character in the 
 * array to be updated, after, it asks for user input regarding a new name , health and power
 * , then it calls the update character method in the character manager class, while passing 
 * the new health, power and name values. Using boolean, it also lets the user know 
 * weather the character was updated or not
 */
    private static void updateCharacter() {
        System.out.print("Enter the name of the character you want to update: ");
        String name = scanner.nextLine();

        MiddleEarthCharacter character = characterManager.getCharacter(name);

        if (character == null) {
            System.out.println("Character not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter new health: ");
        double newHealth = scanner.nextDouble();

        System.out.print("Enter new power: ");
        double newPower = scanner.nextDouble();

        boolean updateCharacterStatus= characterManager.updateCharacter(character, newName, newHealth, newPower);
        if(updateCharacterStatus == false) {
      	   System.out.println("Your character could not be Updated");
         }
         else {
      	   System.out.println("Your character was successfully updated");
         }
        
    }

    /**
     * This method allows all the characters in the array to attack each other. This is 
     * done by first asking the user for the attacker name and then the defender name. 
     * Both characters are then found using a call to the get character method
     * after, using polymorphism, the attack method is called using earlier attacker and 
     * defender characters found. At the end, if the defender reaches 0 or lower health, the 
     * delete character method is called on them, and they are removed from the array. 
     */
    private static void executeAllAttacks() {
    	System.out.println("Enter the name of the character you want to attack with:");
    	String attackerName = scanner.nextLine();
    	
    	MiddleEarthCharacter LuckyAttacker = characterManager.getCharacter(attackerName);
    	
    	if(LuckyAttacker == null) {
    		System.out.println("Character not found");
    		return;
    	}
    	else {
    		System.out.println("Enter the name of the character you want to set destruction upon:");
    		String defenderName = scanner.nextLine();
    		
    		MiddleEarthCharacter unluckyDefender = characterManager.getCharacter(defenderName);
    		if(unluckyDefender == null) {
        		System.out.println("Character not found");
        		return;
        	}
    		else {
    			 LuckyAttacker.attack(unluckyDefender); 
    			if(unluckyDefender.getHealth()<=0) {
    				System.out.println("You killed him, how could you??:");
    				characterManager.deleteCharacter(unluckyDefender);
    			}
    			
    		}
    		
    	}
    }

}