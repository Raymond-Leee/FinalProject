import java.util.Scanner;

public class Room {
    public Room() {}

    public void play(Player player) {
        boolean quit = false;
        int roomCount = 1;
        Scanner s = new Scanner(System.in);
        if (player.getCharacter().equals("")) {
            System.out.println("Choose a character (1, 2, 3):");
            System.out.println(player.getCharacters());
            int characterInput = s.nextInt();
            while (characterInput != 1 && characterInput != 2 && characterInput != 3) {
                System.out.println("Please enter 1, 2, or 3.");
                System.out.println(player.getCharacters());
                characterInput = s.nextInt();
            }
            if (characterInput == 1) {
                player.setCharacter("Rogue");
                System.out.println("You are now playing as a " + player.getCharacter());
            }
            else if (characterInput == 2) {
                player.setCharacter("Knight");
                System.out.println("You are now playing as a " + player.getCharacter());
            }
            else if (characterInput == 3) {
                player.setCharacter("Traveller");
                System.out.println("You are now playing as a " + player.getCharacter());
            }
        }
        while (!quit) {
            if (roomCount == 1) {
                System.out.println("You awaken in a dark room. You see entrances on all 4 sides.");
            }
        }
    }

    public void fight() {

    }
}
