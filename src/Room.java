import java.util.Scanner;

public class Room {
    private Player player;
    private Floor flo;

    public Room() {}

    public Room(Player player) {
        this.player = player;
        flo = new Floor();
    }

    public Room(Player player, String floor) {
        this.player = player;
        flo = new Floor(floor);
    }

    public void play() {
        boolean quit = false;
        int roomCount = player.getRoomCount();
        Scanner choice = new Scanner(System.in);
        setWeaponStats();
        setArmourStats();

        if (player.getCharacter().equals("")) {
            System.out.println("Choose a character (1, 2, 3):");
            System.out.println(player.getCharacters());
            String characterInput = choice.nextLine();
            try {
                Integer.parseInt(characterInput);
                while (Integer.parseInt(characterInput) != 1 && Integer.parseInt(characterInput) != 2 && Integer.parseInt(characterInput) != 3) {
                    System.out.println("Please enter 1, 2 or 3:");
                    System.out.println(player.getCharacters());
                    characterInput = choice.nextLine();
                }
                if (Integer.parseInt(characterInput) == 1) {
                    player.setCharacter("Rogue");
                    System.out.println("You are now playing as a " + player.getCharacter() + "\n");
                    player.setEnergy(player.getEnergy() + 1);
                } else if (Integer.parseInt(characterInput) == 2) {
                    player.setCharacter("Knight");
                    System.out.println("You are now playing as a " + player.getCharacter() + "\n");
                    player.setAttack(player.getAttack() + 5);
                } else if (Integer.parseInt(characterInput) == 3) {
                    player.setCharacter("Traveller");
                    System.out.println("You are now playing as a " + player.getCharacter() + "\n");
                    player.setHealth(player.getHealth() + 10);
                }
            }
            catch (Exception e) {
                System.out.println("Please enter 1, 2 or 3: ");
            }

        }
        while (!quit) {
            Scanner move = new Scanner(System.in);
            if (roomCount == 1) {
                System.out.println(flo.getFloorInfo());
                System.out.println("You awaken in a dark room. You see entrances on all 4 sides.");
                System.out.print("You can go (L)eft, (R)ight, (A)head or (B)ehind, or you can (C)heck your inventory or (Q)uit: ");
                String characterDecision = move.nextLine();
                if (characterDecision.equalsIgnoreCase("Q")) {
                    quit = true;
                }
                else if (characterDecision.equalsIgnoreCase("C")) {
                    System.out.println("\n" + player.getInventoryInfo());
                }
                else {
                    move(characterDecision);
                    roomCount++;
                    player.setRoomCount(roomCount);
                }
            }
            else {
                System.out.print("You can go (L)eft, (R)ight or (A)head, or you can (C)heck your inventory or (Q)uit: ");
                String characterDecision = move.nextLine();
                if (characterDecision.equalsIgnoreCase("Q")) {
                    quit = true;
                }
                else if (characterDecision.equalsIgnoreCase("C")) {
                    System.out.println("\n" + player.getInventoryInfo());
                }
                else {
                    move(characterDecision);
                    roomCount++;
                    player.setRoomCount(roomCount);
                }
            }
        }
        System.out.println("\nSaving your data. Goodbye.");
        setWeaponStats();
        setArmourStats();
        player.getFloor(flo);
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
        if (player.getRoomCount() == 1) {
            while (!input.equalsIgnoreCase("L") && !input.equalsIgnoreCase("R") && !input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("B") && !input.equalsIgnoreCase("C") && !input.equalsIgnoreCase("Q")) {
                System.out.print("\nYou can only go (L)eft, (R)ight, (A)head or (B)ehind, or you can (C)heck your inventory or (Q)uit: ");
                input = move.nextLine();
            }
            if (input.equalsIgnoreCase("L")) {
                System.out.println("\nYou enter into the room to your left. The entrance closes behind you.\n");
                if (fight) {
                    fight();
                }
                if (findSomething) {
                    find();
                }
            } else if (input.equalsIgnoreCase("R")) {
                System.out.println("\nYou enter into the room to your right. The entrance closes behind you.\n");
                if (fight) {
                    fight();
                }
                if (findSomething) {
                    find();
                }
            } else if (input.equalsIgnoreCase("A")) {
                System.out.println("\nYou enter into the room ahead of you. The entrance closes behind you.\n");
                if (fight) {
                    fight();
                }
                if (findSomething) {
                    find();
                }
            } else if (input.equalsIgnoreCase("B")) {
                System.out.println("\nYou enter into the room behind you. The entrance closes behind you.\n");
                if (fight) {
                    fight();
                }
                if (findSomething) {
                    find();
                }
            } else if (input.equalsIgnoreCase("C")) {
                System.out.println("\n" + player.getInventoryInfo());
            } else if (input.equalsIgnoreCase("Q")) {
                System.out.println("\nSaving your data. Goodbye.");
                player.setRoomCount(player.getRoomCount());
                setWeaponStats();
                setArmourStats();
                player.getFloor(flo);
                player.save();
                System.exit(1);
            }
        }
        else {
            while (!input.equalsIgnoreCase("L") && !input.equalsIgnoreCase("R") && !input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("C") && !input.equalsIgnoreCase("Q")) {
                System.out.print("\nYou can only go (L)eft, (R)ight or (A)head, or you can (C)heck your inventory or (Q)uit: ");
                input = move.nextLine();
            }
            if (input.equalsIgnoreCase("L")) {
                System.out.println("\nYou enter into the room to your left. The entrance behind you closes.\n");
                if (fight) {
                    fight();
                }
                if (findSomething) {
                    find();
                }
            } else if (input.equalsIgnoreCase("R")) {
                System.out.println("\nYou enter into the room to your right. The entrance closes behind you.\n");
                if (fight) {
                    fight();
                }
                if (findSomething) {
                    find();
                }
            } else if (input.equalsIgnoreCase("A")) {
                System.out.println("\nYou enter into the room ahead of you. The entrance closes behind you.\n");
                if (fight) {
                    fight();
                }
                if (findSomething) {
                    find();
                }
            } else if (input.equalsIgnoreCase("C")) {
                System.out.println("\n" + player.getInventoryInfo());
            } else if (input.equalsIgnoreCase("Q")) {
                System.out.println("\nSaving your data. Goodbye.");
                player.setRoomCount(player.getRoomCount());
                setWeaponStats();
                setArmourStats();
                player.getFloor(flo);
                player.save();
                System.exit(1);
            }
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
                    System.out.print("Please enter A or B: ");
                    move = choice.nextLine();
                }
                if (move.equalsIgnoreCase("A")) {
                    attack = baseAttack;
                    System.out.println("You attack for " + attack + " damage!\n");
                    System.out.println(monsterArmour);
                    if (foe.getMonsterArmour() > 0) {
                        foe.removeMonsterArmour(attack);
                        attack = monsterArmour - attack;
                        if (attack > 0) {
                            foe.removeMonsterHealth(attack);
                            System.out.println(foe.getMonsterHealth());
                        }
                    }
                    else {
                        foe.removeMonsterHealth(attack);
                        System.out.println(foe.getMonsterHealth());
                    }
                }
                else {
                    System.out.println("You block for " + player.getArmour() + "!\n");
                }
                energy--;
            }
            if (foe.getMonsterHealth() <= 0) {
                break;
            }
            foe.makeMove(player);
            energy = baseEnergy;
        }
        if (player.getHealth() <= 0) {
            System.out.println("You've lost. How unfortunate.\n");
        }
        else if (foe.getMonsterHealth() <= 0) {
            System.out.println("You've beat the monster! Congratulations!\n");
        }
    }

    public void find() {
        Scanner choice = new Scanner(System.in);
        PlayerItem found = new PlayerItem();
        int determineFind = (int) (Math.random() * 2) + 1;
        if (determineFind == 2) {
            String weaponFound = found.rollWeapon();
            System.out.println("You found " + weaponFound + "!");
            System.out.print("Would you like to pick it up? Y/N: ");
            String pickUp = choice.nextLine();
            while (!pickUp.equalsIgnoreCase("Y") && !pickUp.equalsIgnoreCase("N")) {
                System.out.print("Please enter Y or N: ");
                pickUp = choice.nextLine();
            }
            if (pickUp.equalsIgnoreCase("Y")) {
                player.setWeapon(weaponFound);
                player.setSpecificInventory(0, weaponFound);
                System.out.println("You picked up the " + weaponFound + ".\n");
            }
            else {
                System.out.println("You left it behind and carried on.\n");
            }
        }
        else if (determineFind == 1) {
            String armourFound = found.rollArmour();
            System.out.println("You found " + armourFound + "!");
            System.out.print("Would you like to pick it up? Y/N: ");
            String pickUp = choice.nextLine();
            while (!pickUp.equalsIgnoreCase("Y") && !pickUp.equalsIgnoreCase("N")) {
                System.out.print("Please enter Y or N: ");
                pickUp = choice.nextLine();
            }
            if (pickUp.equalsIgnoreCase("Y")) {
                player.setArmourItem(armourFound);
                player.setSpecificInventory(1, armourFound);
                System.out.println("You picked up the " + armourFound + ".\n");
            }
            else {
                System.out.println("You left it behind and carried on.\n");
            }
        }
    }

    public void setWeaponStats() {
        if (player.getWeapon().equals("Shoddy Sword")) {
            player.setAttack(10);
        } else if (player.getWeapon().equals("Iron Sword")) {
            player.setAttack(15);
        } else if (player.getWeapon().equals("Iron Greatsword")) {
            player.setAttack(20);
        } else if (player.getWeapon().equals("Steel Dagger")) {
            player.setAttack(25);
        } else if (player.getWeapon().equals("VT7 High-Frequency Blade")) {
            player.setAttack(35);
        }
    }

    public void setArmourStats() {
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
    }
}
