package app;
//import manager.MiddleEarthCouncil;
import characters.*;


public class MiddleEarthApp {

	public static void main(String[] args) {
		Elf char1 = new Elf("elf", 100, 10);
		Dwarf char2 = new Dwarf("dwarf", 100, 10);
		Human char3 = new Human("human", 100, 20);
		Orc char4 = new Orc("orc", 100, 30);
		System.out.println(char2.attack(char1));
		System.out.println(char1.getHealth());
		System.out.println(char4.attack(char3));
	}

}
