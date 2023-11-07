import java.util.Scanner;
public class MontyHallRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Monty Hall Game!");
        System.out.println();
        System.out.println("There are two goats and a car randomly placed behind doors 1, 2, and 3");
        System.out.print("Where do you think the car is? Enter 1, 2, or 3: ");
        int user_choice = scan.nextInt();

        int randomNum = (int) (Math.random() * 3) + 1;
        String firstDoor = "";
        String secondDoor = "";
        String thirdDoor = "";

        // assigning car to a random door
        if (randomNum == 1) { // if the randomNum is 1, the first door has the car
            firstDoor = "car";
            secondDoor = "goat";
            thirdDoor = "goat";
        } else if (randomNum == 2) { // if the randomNum is 2, the second door has the car
            firstDoor = "goat";
            secondDoor = "car";
            thirdDoor = "goat";
        } else { // if the randomNum is 3, the third door has the car
            firstDoor = "goat";
            secondDoor = "goat";
            thirdDoor = "car";
        }


        // create a MontyHall object
        MontyHall game = new MontyHall(firstDoor, secondDoor, thirdDoor, user_choice);
        System.out.println("One of the goats is behind Door Number " + game.revealDoor());
        scan.nextLine();

        System.out.print("Do you want to switch your guess (Yes or No)? ");
        String changeDoor = scan.nextLine();
        changeDoor = changeDoor.toLowerCase();


        // if player wants to switch the door, switch it
        if (changeDoor.equals("yes")) {
            game.switchDoor();
            System.out.println("Guessed switched from " + user_choice + " to " + game.getUser_Choice());
        }


        // determine if the player wins or loses. If lost, reveal the door with the car
        if (game.winOrLose()) {
            System.out.println("You won the car!");
        } else {
            int doorNumWithCar;
            if (game.doorWithCar(firstDoor, secondDoor, thirdDoor).equals("firstDoor")) {
                doorNumWithCar = 1;
            } else if (game.doorWithCar(firstDoor, secondDoor, thirdDoor).equals("secondDoor")) {
                doorNumWithCar = 2;
            } else {
                doorNumWithCar = 3;
            }

            System.out.println("The car is behind door " + doorNumWithCar + ". You lost! (Or you could say you won a goat!)");
        }
    }
}