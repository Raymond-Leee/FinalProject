import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class RogueMenu {
    public static void main(String[] args) {
        try {
            File f = new File("src/player.data");
            Scanner s = new Scanner(f);
            int line = 1;
            String username = "";
            String character = "";
            String weapon = "";
            String armourItem = "";
            String item = "";
            String floor = "";
            int health = 0;
            int attack = 0;
            int armour = 0;

            while (s.hasNextLine()) {
                String data = s.nextLine();
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
                    attack = Integer.parseInt(data);
                }
                if (line == 5) {
                    armour = Integer.parseInt(data);
                }
                if (line == 6) {
                    weapon = data;
                }
                if (line == 7) {
                    armourItem = data;
                }
                if (line == 8) {
                    item = data;
                }
                if (line == 9) {
                    floor = data;
                }
                line++;
            }

            s.close();
            Player player = new Player();
            player.setUsername(username);
            player.setCharacter(character);
            player.setHealth(health);
            player.setAttack(attack);
            player.setArmour(armour);
            player.setWeapon(weapon);
            player.setArmourItem(armourItem);
            player.setItem(item);
            player.setInventory();
            System.out.println("Welcome back " + username + "!\nYou left off on " + floor);
            System.out.println(player.getPlayerInfo());
            System.out.println(player.getInventoryInfo());
        }

        catch (FileNotFoundException e) {
            System.out.println("Welcome to !");
            System.out.println("Would you like to play the game? Y/N");
            Scanner s = new Scanner(System.in);
            String response = s.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                System.out.print("Enter a name: ");
                String name = s.nextLine();
                System.out.println("Good luck " + name + "!");
                Player player = new Player(name);
                player.setCharacter("Knight");
                player.save();
            }
            if (response.equalsIgnoreCase("N")) {
                System.out.println("Goodbye then.");
            }
        }

        /*
        Monster the = new Monster();
        System.out.println(the.getMonsterInfo());
        the.makeMove();
        System.out.println(the.getMonsterInfo());

        Monster the2 = new Monster();
        System.out.println(the2.getMonsterInfo());
        the2.makeMove();
        System.out.println(the2.getMonsterInfo());

        Monster the3 = new Monster();
        System.out.println(the3.getMonsterInfo());
        the3.makeMove();
        System.out.println(the3.getMonsterInfo());

        Monster the4 = new Monster();
        System.out.println(the4.getMonsterInfo());
        the4.makeMove();
        System.out.println(the4.getMonsterInfo());

        Monster the5 = new Monster();
        System.out.println(the5.getMonsterInfo());
        the5.makeMove();
        System.out.println(the5.getMonsterInfo());

        Monster the6 = new Monster();
        System.out.println(the6.getMonsterInfo());
        the6.makeMove();
        System.out.println(the6.getMonsterInfo());

        Monster the7 = new Monster();
        System.out.println(the7.getMonsterInfo());
        the7.makeMove();
        System.out.println(the7.getMonsterInfo());

        Monster the8 = new Monster();
        System.out.println(the8.getMonsterInfo());
        the8.makeMove();
        System.out.println(the8.getMonsterInfo());

        Monster the9 = new Monster();
        System.out.println(the9.getMonsterInfo());
        the9.makeMove();
        System.out.println(the9.getMonsterInfo());

        Monster the10 = new Monster();
        System.out.println(the10.getMonsterInfo());
        the10.makeMove();
        System.out.println(the10.getMonsterInfo());
        */

        /*
        Floor flo = new Floor();
        System.out.println(flo.getFloorInfo());

        Floor flo2 = new Floor();
        System.out.println(flo2.getFloorInfo());

        Floor flo3 = new Floor();
        System.out.println(flo3.getFloorInfo());

        Floor flo4 = new Floor();
        System.out.println(flo4.getFloorInfo());

        Floor flo5 = new Floor();
        System.out.println(flo5.getFloorInfo());

        Floor flo6 = new Floor();
        System.out.println(flo6.getFloorInfo());

        Floor flo7 = new Floor();
        System.out.println(flo7.getFloorInfo());

        Floor flo8 = new Floor();
        System.out.println(flo8.getFloorInfo());

        Floor flo9 = new Floor();
        System.out.println(flo9.getFloorInfo());

        Floor flo10 = new Floor();
        System.out.println(flo10.getFloorInfo());
        */
    }
}
