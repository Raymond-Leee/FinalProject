import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class RogueMenu {
    public static void main(String[] args) {
        try {
            File dateFile = new File("src/player.data");
            Scanner saveData = new Scanner(dateFile);
            int line = 1;
            String username = "";
            String character = "";
            String weapon = "";
            String armourItem = "";
            String floor = "";
            int health = 0;
            int energy = 0;
            int attack = 0;
            int armour = 0;
            int roomCount = 0;

            while (saveData.hasNextLine()) {
                String data = saveData.nextLine();
                if (line == 1) {
                    username = data;
                }
                if (line == 2) {
                    character = data;
                }
                if (line == 3) {
                    health = Integer.parseInt(data);
                }
                if (line == 4) {
                    energy = Integer.parseInt(data);
                }
                if (line == 5) {
                    attack = Integer.parseInt(data);
                }
                if (line == 6) {
                    armour = Integer.parseInt(data);
                }
                if (line == 7) {
                    weapon = data;
                }
                if (line == 8) {
                    armourItem = data;
                }
                if (line == 9) {
                    floor = data;
                }
                if (line == 10) {
                    roomCount = Integer.parseInt(data);
                }
                line++;
            }

            saveData.close();
            Floor flo;
            Player saveFile = new Player();
            Scanner game = new Scanner(System.in);
            saveFile.setUsername(username);
            saveFile.setCharacter(character);
            saveFile.setHealth(health);
            saveFile.setEnergy(energy);
            saveFile.setAttack(attack);
            saveFile.setArmour(armour);
            saveFile.setWeapon(weapon);
            saveFile.setArmourItem(armourItem);
            saveFile.setRoomCount(roomCount);
            saveFile.setInventory();
            System.out.println("Welcome back " + username + "!\nYou left off on room " + roomCount + " of " + floor);
            System.out.print("Would you like to (C)ontinue where you left off, or (R)estart: ");
            String menuChoice = game.nextLine();
            while (!menuChoice.equalsIgnoreCase("C") && !menuChoice.equalsIgnoreCase("R")) {
                System.out.print("Please enter C or R: ");
                menuChoice = game.nextLine();
            }
            if (menuChoice.equalsIgnoreCase("C")) {
                Room room = new Room(saveFile, floor);
                System.out.println("Good luck " + username + "!\n");
                room.play();
            }
            if (menuChoice.equalsIgnoreCase("R")) {
                System.out.print("Enter a name: ");
                String name = game.nextLine();
                System.out.println("Good luck " + name + "!\n");
                Player newPlayer = new Player(name);
                Room room = new Room(newPlayer);
                room.play();
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Welcome to (Not) Rogue!");
            System.out.print("Would you like to (P)lay or (Q)uit the game: ");
            Scanner newGame = new Scanner(System.in);
            String menuChoice = newGame.nextLine();
            while (!menuChoice.equalsIgnoreCase("P") && !menuChoice.equalsIgnoreCase("Q")) {
                System.out.print("Please enter P or Q: ");
                menuChoice = newGame.nextLine();
            }
            if (menuChoice.equalsIgnoreCase("P")) {
                System.out.print("Enter a name: ");
                String name = newGame.nextLine();
                System.out.println("Good luck " + name + "!\n");
                Player newPlayer = new Player(name);
                Room room = new Room(newPlayer);
                room.play();
            }
            if (menuChoice.equalsIgnoreCase("Q")) {
                System.out.println("Goodbye then.");
            }
        }
    }
}
