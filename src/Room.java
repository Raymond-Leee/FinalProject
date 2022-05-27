import java.util.Scanner;

public class Room {
    private Player player;

    public Room() {}

    public Room(Player player) {
        this.player = player;
    }

    public void play() {
        boolean quit = false;
        int roomCount = player.getRoomCount();
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
                System.out.print("You can go (L)eft, (R)ight, (A)head or (B)ehind, or you can (Q)uit: ");
                String characterDecision = choice.nextLine();
                if (characterDecision.equalsIgnoreCase("Q")) {
                    quit = true;
                }
                else {
                    move(characterDecision);
                    roomCount++;
                }
            }
            else {
                quit = true;
            }
        }
        System.out.println("Saving your data. Goodbye.");
        player.setRoomCount(roomCount);
        player.save();
    }

    public void move(String input) {
        Scanner move = new Scanner(System.in);
        boolean fight = false;
        boolean findSomething = false;
        int encounterChance = (int) (Math.random() * 100) + 1;
        if (encounterChance > 60) {
            fight = true;
        }
        else if (encounterChance > 30) {
            findSomething = true;
        }
        while (!input.equalsIgnoreCase("L") && !input.equalsIgnoreCase("R") && !input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("B")) {
            System.out.println("You can only go (L)eft, (R)ight, (A)head, or (B)ehind.");
            input = move.nextLine();
        }
        if (input.equalsIgnoreCase("L")) {
            System.out.println("You enter into the room to your left.");
            if (fight) {
                fight();
            }
            if (findSomething) {
                find();
            }
        }
        else if (input.equalsIgnoreCase("R")) {
            System.out.println("You enter into the room to your right.");
            if (fight) {
                fight();
            }
            if (findSomething) {
                find();
            }
        }
        else if (input.equalsIgnoreCase("A")) {
            System.out.println("You enter into the room ahead of you.");
            if (fight) {
                fight();
            }
            if (findSomething) {
                find();
            }
        }
        else if (input.equalsIgnoreCase("B")) {
            System.out.println("You enter into the room behind you.");
            if (fight) {
                fight();
            }
            if (findSomething) {
                find();
            }
        }
    }

    public void fight() {
        Monster foe = new Monster();
        System.out.println(foe.monsterAppears());
        while (player.getHealth() != 0 && foe.getMonsterHealth() != 0) {

        }
    }

    public void find() {
        Scanner choice = new Scanner(System.in);
        PlayerItem found = new PlayerItem();
        int determineFind = (int) (Math.random() * 3) + 1;
        if (determineFind == 3) {
            String weaponFound = found.rollWeapon();
            System.out.println("You found " + weaponFound + "!");
            System.out.println("Would you like to pick it up? Y/N");
            String pickUp = choice.nextLine();
            while (!pickUp.equalsIgnoreCase("Y") && !pickUp.equalsIgnoreCase("N")) {
                System.out.println("Please enter Y or N.");
                pickUp = choice.nextLine();
            }
            if (pickUp.equalsIgnoreCase("Y")) {
                player.setWeapon(weaponFound);
                System.out.println("You picked up the " + weaponFound + ".");
            }
            else {
                System.out.println("You left it behind and carried on.");
            }
        }
        else if (determineFind == 2) {
            String armourFound = found.rollArmour();
            System.out.println("You found " + armourFound + "!");
            System.out.println("Would you like to pick it up? Y/N");
            String pickUp = choice.nextLine();
            while (!pickUp.equalsIgnoreCase("Y") && !pickUp.equalsIgnoreCase("N")) {
                System.out.println("Please enter Y or N.");
                pickUp = choice.nextLine();
            }
            if (pickUp.equalsIgnoreCase("Y")) {
                player.setArmourItem(armourFound);
                System.out.println("You picked up the " + armourFound + ".");
            }
            else {
                System.out.println("You left it behind and carried on.");
            }
        }
        else {
            String itemFound = found.rollItem();
            System.out.println("You found " + itemFound + "!");
            System.out.println("Would you like to pick it up? Y/N");
            String pickUp = choice.nextLine();
            while (!pickUp.equalsIgnoreCase("Y") && !pickUp.equalsIgnoreCase("N")) {
                System.out.println("Please enter Y or N.");
                pickUp = choice.nextLine();
            }
            if (pickUp.equalsIgnoreCase("Y")) {
                player.setItem(itemFound);
                System.out.println("You picked up the " + itemFound + ".");
            }
            else {
                System.out.println("You left it behind and carried on.");
            }
        }
    }
}
