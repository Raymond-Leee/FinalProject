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
        if (player.getWeapon().equals("Shoddy Sword")) {
            player.setAttack(10);
        }
        else if (player.getWeapon().equals("Iron Sword")) {
            player.setAttack(15);
        }
        else if (player.getWeapon().equals("Iron Greatsword")) {
            player.setAttack(20);
        }
        else if (player.getWeapon().equals("Steel Dagger")) {
            player.setAttack(25);
        }
        else if (player.getWeapon().equals("VT7 High-Frequency Blade")) {
            player.setAttack(35);
        }
        if (player.getArmourItem().equals("Leather Garments")) {
            player.setArmour(10);
        }
        else if (player.getArmourItem().equals("Chainmail Armour")) {
            player.setArmour(15);
        }
        else if (player.getArmourItem().equals("Iron Armour")) {
            player.setArmour(20);
        }
        else if (player.getArmourItem().equals("Hunter Garments")) {
            player.setArmour(25);
        }
        else if (player.getArmourItem().equals("Exo-suit")) {
            player.setArmour(35);
        }
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
                System.out.print("You can go (L)eft, (R)ight, (A)head or (B)ehind, or you can (C)heck your inventory or (Q)uit: ");
                String characterDecision = choice.nextLine();
                if (characterDecision.equalsIgnoreCase("Q")) {
                    quit = true;
                }
                else if (characterDecision.equalsIgnoreCase("C")) {
                    System.out.println(player.getInventoryInfo());
                }
                else {
                    move(characterDecision);
                    roomCount++;
                    player.setRoomCount(roomCount);
                }
            }
            else {
                System.out.print("You can go (L)eft, (R)ight, (A)head or (B)ehind, or you can (C)heck your inventory or (Q)uit: ");
                String characterDecision = choice.nextLine();
                if (characterDecision.equalsIgnoreCase("Q")) {
                    quit = true;
                }
                else if (characterDecision.equalsIgnoreCase("C")) {
                    System.out.println(player.getInventoryInfo());
                }
                else {
                    move(characterDecision);
                    roomCount++;
                    player.setRoomCount(roomCount);
                }
            }
        }
        System.out.println("Saving your data. Goodbye.");
        player.save();
    }

    public void move(String input) {
        Scanner move = new Scanner(System.in);
        boolean fight = false;
        boolean findSomething = false;
        int encounterChance = (int) (Math.random() * 0) + 1;
        if (encounterChance > 60) {
            fight = true;
        }
        else if (encounterChance > 30) {
            findSomething = true;
        }
        while (!input.equalsIgnoreCase("L") && !input.equalsIgnoreCase("R") && !input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("B") && !input.equalsIgnoreCase("C") && !input.equalsIgnoreCase("Q")) {
            System.out.println("You can only go (L)eft, (R)ight, (A)head or (B)ehind, or you can (C)heck your inventory or (Q)uit");
            input = move.nextLine();
        }
        if (input.equalsIgnoreCase("L")) {
            System.out.println("You enter into the room to your left.\n");
            if (fight) {
                fight();
            }
            if (findSomething) {
                find();
            }
        }
        else if (input.equalsIgnoreCase("R")) {
            System.out.println("You enter into the room to your right.\n");
            if (fight) {
                fight();
            }
            if (findSomething) {
                find();
            }
        }
        else if (input.equalsIgnoreCase("A")) {
            System.out.println("You enter into the room ahead of you.\n");
            if (fight) {
                fight();
            }
            if (findSomething) {
                find();
            }
        }
        else if (input.equalsIgnoreCase("B")) {
            System.out.println("You enter into the room behind you.\n");
            if (fight) {
                fight();
            }
            if (findSomething) {
                find();
            }
        }
        else if (input.equalsIgnoreCase("C")) {
            System.out.println(player.getInventoryInfo());
        }
        else if (input.equalsIgnoreCase("Q")) {
            System.out.println("Saving your data. Goodbye.");
            player.setRoomCount(player.getRoomCount());
            player.save();
            System.exit(1);
        }
    }

    public void fight() {
        Scanner choice = new Scanner(System.in);
        Monster foe = new Monster();
        System.out.println(foe.monsterAppears());
        int attack = player.getAttack();
        int baseAttack = player.getAttack();
        int energy = player.getEnergy();
        int baseEnergy = player.getEnergy();
        int monsterAttackBase = foe.getMonsterAttack();
        int monsterArmourBase = foe.getMonsterArmour();
        int monsterArmour = foe.getMonsterArmour();
        int monsterHealth = foe.getMonsterHealth();
        while (player.getHealth() != 0 && foe.getMonsterHealth() != 0) {
            while (energy > 0) {
                System.out.print("You can (A)ttack or (B)lock: ");
                String move = choice.nextLine();
                while (!move.equalsIgnoreCase("A") && !move.equalsIgnoreCase("B")) {
                    System.out.println("Please enter A or B.");
                    move = choice.nextLine();
                }
                if (move.equalsIgnoreCase("A")) {
                    attack = baseAttack;
                    System.out.println("You attack for " + attack + " damage!");
                    if (foe.getMonsterArmour() > 0) {
                        foe.setMonsterArmour(monsterArmour - attack);
                        attack = monsterArmour - attack;
                        if (attack > 0) {
                            foe.setMonsterHealth(monsterHealth - attack);
                            System.out.println(foe.getMonsterHealth());
                        }
                    }
                    else {
                        foe.setMonsterHealth(monsterHealth - attack);
                        System.out.println(foe.getMonsterHealth());
                    }
                }
                else {
                    System.out.println("You block for " + player.getArmour() + "!");
                }
                energy--;
            }
            foe.makeMove(player);
            energy = baseEnergy;
        }
        if (player.getHealth() <= 0) {
            System.out.println("You've lost. How unfortunate.");
        }
        else if (foe.getMonsterHealth() <= 0) {
            System.out.println("You've beat the monster! Congratulations!");
        }
    }

    public void find() {
        Scanner choice = new Scanner(System.in);
        PlayerItem found = new PlayerItem();
        int determineFind = (int) (Math.random() * 2) + 1;
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
    }
}
