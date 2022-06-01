public class Floor {
    private String[] DESCRIPTIONS = new String[]{"The humble beginnings of a new adventure. The luscious woodland's silence broken only by the call of monsters.",
                                                 "The eternal howl of the winds deafen those who dare to traverse it.",
                                                 "The remains of a city once gleaming with life, its history now hidden away in the sand.",
                                                 "Tucked away in the deepest of caves, a monument of the past still standing.",
                                                 "The only refuge untouched by the Scourge. Those who remain fight to see the next day."};
    private String floorName;
    private String description;

    public Floor() {
        int num = (int) (Math.random() * 5);
        if (num == 0) {
            floorName = "The Silver Forest";
            description = DESCRIPTIONS[num];
        }
        if (num == 1) {
            floorName = "The Howling Peak";
            description = DESCRIPTIONS[num];
        }
        if (num == 2) {
            floorName = "The Sunken City";
            description = DESCRIPTIONS[num];
        }
        if (num == 3) {
            floorName = "The Endless Tower";
            description = DESCRIPTIONS[num];
        }
        if (num == 4) {
            floorName = "The Reservoir";
            description = DESCRIPTIONS[num];
        }
    }

    public Floor(String floor) {
        floorName = floor;
        description =
    }

    public String getFloorName() {
        return floorName;
    }


    public String getFloorInfo() {
        return "You've reached " + floorName +
               "\n" + description;
    }
}
