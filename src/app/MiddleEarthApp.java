package app;
//import manager.MiddleEarthCouncil;
import characters.Elf;
import characters.Dwarf;

public class MiddleEarthApp {

	public static void main(String[] args) {
		Elf char1 = new Elf("elf", 100, 10);
		Dwarf char2 = new Dwarf("dwarf", 100, 10);
		
		System.out.println(char2.attack(char1));
		System.out.println(char1.getHealth());
	}

}
