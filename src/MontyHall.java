public class MontyHall {
    // instance variables
    private String firstDoor;
    private String secondDoor;
    private String thirdDoor;
    private int user_choice;


    // constructors
    public MontyHall(String firstDoor, String secondDoor, String thirdDoor, int user_choice) {
        this.firstDoor = firstDoor;
        this.secondDoor = secondDoor;
        this.thirdDoor = thirdDoor;
        this.user_choice = user_choice;
    }


    public int getUser_Choice() {
        return user_choice;
    }


    // find door with car
    public String doorWithCar(String firstDoor, String secondDoor, String thirdDoor) {
        if (firstDoor.equals("car")) {
            return "firstDoor";
        } else if (secondDoor.equals("car")) {
            return "secondDoor";
        } else {
            return "thirdDoor";
        }
    }


    // align user_choice as an int to the door as a string
    public String numToDoor(int user_choice) {
        if (user_choice == 1) {
            return "firstDoor";
        } else if (user_choice == 2) {
            return "secondDoor";
        } else {
            return "thirdDoor";
        }
    }


    // reveals one of the goat doors
    public int revealDoor() {
        // choose the door with goat and not chosen by the player
        if (firstDoor.equals("goat") && user_choice != 1) {
            return 1;
        } else if (secondDoor.equals("goat") && user_choice != 2) {
            return 2;
        } else {
            return 3;
        }
    }


    // all the possibilities when player changed their choice
    public void switchDoor() {
        if (user_choice == 1 && revealDoor() == 2) {
            user_choice = 3;
        } else if (user_choice == 1 && revealDoor() == 3) {
            user_choice = 2;
        } else if (user_choice == 2 && revealDoor() == 1) {
            user_choice = 3;
        } else if (user_choice == 2 && revealDoor() == 3) {
            user_choice = 1;
        } else if (user_choice == 3 && revealDoor() == 1) {
            user_choice = 2;
        } else if (user_choice == 3 && revealDoor() == 2) {
            user_choice = 1;
        }
    }


    // if the user's choice is equal to the door with the car, return true
    public boolean winOrLose() {
        return numToDoor(user_choice).equals(doorWithCar(firstDoor, secondDoor, thirdDoor));
    }

}
