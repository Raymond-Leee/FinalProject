import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class Menu {
    public static void main(String[] args) {
        try {
            File f = new File("src/person.data");
            Scanner s = new Scanner(f);
            int line = 1;
            String username = "";
            String character = "";
            int health = 0;
            int attack = 0;
            int armour = 0;
            ArrayList<String> inventory = new ArrayList<String>();
            // reading from the file line by line
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
                    armour  = Integer.parseInt(data);
                }
                if (line == 6) {
                    inventory.add(data);
                }
                if (line == 7) {
                    inventory.add(data);
                }
                if (line == 8) {
                    inventory.add(data);
                }
                if (line == 9) {
                    inventory.add(data);
                }
                if (line == 10) {
                    inventory.add(data);
                }
                if (line == 11) {
                    inventory.add(data);
                }
                if (line == 12) {
                    inventory.add(data);
                }
                line++;
            }
            s.close();
            Player play = new Player();
            play.setUsername(username);
            play.setCharacter(character);
            play.setHealth(health);
            play.setAttack(attack);
            play.setArmour(armour);
            play.setInventory(inventory);
            System.out.println(play.getPlayerInfo());
            System.out.println(play.getInventoryInfo());

        }
        // if the file doesn't exist, we will create a blank Person object and ask them for a name and hobby
        catch (FileNotFoundException e) {
            Player play = new Player();
            System.out.println("Welcome!");
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
