import java.util.Scanner;

public class Room {
    public Room() {}

    public void play(Player player) {
        boolean quit = false;
        int roomCount = 1;
        Scanner choice = new Scanner(System.in);
        if (player.getCharacter().equals("")) {
            System.out.println("Choose a character (1, 2, 3):");
            System.out.println(player.getCharacters());
            int characterInput = choice.nextInt();
            while (characterInput != 1 && characterInput != 2 && characterInput != 3) {
                System.out.println("Please enter 1, 2, or 3.");
                System.out.println(player.getCharacters());
                characterInput = choice.nextInt();
            }
            if (characterInput == 1) {
                player.setCharacter("Rogue");
                System.out.println("You are now playing as a " + player.getCharacter());
                player.setEnergy(player.getEnergy() + 1);
            }
            else if (characterInput == 2) {
                player.setCharacter("Knight");
                System.out.println("You are now playing as a " + player.getCharacter());
                player.setAttack(player.getAttack() + 5);
            }
            else if (characterInput == 3) {
                player.setCharacter("Traveller");
                System.out.println("You are now playing as a " + player.getCharacter());
                player.setHealth(player.getHealth() + 10);
            }
        }
        while (!quit) {

            if (roomCount == 1) {
                System.out.println("You awaken in a dark room. You see entrances on all 4 sides.");
                System.out.print("You can go left, right, ahead, or behind: ");
                String characterDecision = choice.nextLine();
                move(characterDecision);
                quit = true;
            }
        }
    }

    public void move(String input) {
        Scanner move = new Scanner(System.in);
        boolean fight = false;
        boolean findSomething = false;
        int encounterChance = (int) (Math.random() * 101);
        if (encounterChance > 60) {
            fight = true;
        }
        else if (encounterChance > 40) {
            findSomething = true;
        }
        while (!input.equalsIgnoreCase("Left") && !input.equalsIgnoreCase("Right") && !input.equalsIgnoreCase("Ahead") && !input.equalsIgnoreCase("Behind")) {
            System.out.println("You can only go left, right, ahead, or behind.");
            input = move.nextLine();
        }
        if (input.equalsIgnoreCase("Left")) {
            System.out.println("You enter into the room to your left.");
            if (fight == true) {
                fight();
            }
            if (findSomething == true) {

            }
        }
        else if (input.equalsIgnoreCase("Right")) {
            System.out.println("You enter into the room to your right.");
            if (fight == true) {
                fight();
            }
        }
        else if (input.equalsIgnoreCase("Ahead")) {
            System.out.println("You enter into the room ahead of you.");
            if (fight == true) {
                fight();
            }
        }
        else if (input.equalsIgnoreCase("Behind")) {
            System.out.println("You enter into the room behind you.");
            if (fight == true) {
                fight();
            }
        }
    }

    public void fight() {
        Monster foe = new Monster();
        System.out.println(foe.monsterAppears());
    }

    public void find() {
        PlayerItem itemFound = new PlayerItem();
        int determineFind = (int) (Math.random() * 100);
        if (determineFind >= 66) {

        }
        else if (determineFind >= 33) {

        }
        else {

        }
    }
}
