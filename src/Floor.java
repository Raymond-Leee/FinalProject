public class Floor {
    private String floorName;
    private String description;

    public Floor() {
        int num = (int) (Math.random() * 5) + 1;
        if (num == 1) {
            floorName = "The Silver Forest";
            description = "The humble beginnings of a new adventure. The luscious woodland's silence broken only by the call of monsters.";
        }
        if (num == 2) {
            floorName = "The Howling Peak";
            description = "The eternal howl of the winds deafen those who dare to traverse it.";
        }
        if (num == 3) {
            floorName = "The Sunken City";
            description = "The remains of a city once gleaming with life, its history now hidden away in the sand.";
        }
        if (num == 4) {
            floorName = "The Endless Tower";
            description = "Tucked away in the deepest of caves, a monument of the past still standing.";
        }
        if (num == 5) {
            floorName = "The Reservoir";
            description = "The only refuge untouched by the Scourge. Those who remain fight to see the next day.";
        }
    }

    public String getFloorName() {
        return floorName;
    }

    public String getFloorInfo() {
        return "You've reached " + floorName +
               "\n" + description;
    }
}
