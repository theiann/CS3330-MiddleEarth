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
        System.out.println("2. Kill a character");
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

        characterManager.addCharacter(characterNew);
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
        System.out.println("Enter the name of the character you want to delete");
        String characterToDelete = scanner.nextLine();
        MiddleEarthCharacter foundCharacter = characterManager.getCharacter(characterToDelete);
        
        if (foundCharacter != null) {
            characterManager.deleteCharacter(foundCharacter);
        } else {
            System.out.println("Character not found.");
        }
    }

    private static void updateCharacter() {
        System.out.print("Enter character name to update: ");
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

        characterManager.updateCharacter(character, newName, newHealth, newPower);
    }

    private static void executeAllAttacks() {
      
    }

}