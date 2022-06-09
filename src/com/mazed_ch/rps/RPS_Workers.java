package com.mazed_ch.rps;
import java.util.Arrays;

public class RPS_Workers {
    private final int ROCK = 1;
    private final int PAPER = 2;
    private final int SCISSOR = 3;

    // method to get the users choice, and in case an invalid input it repeats until a valid input entered.
    public int playersChoice() {
        UserInput input = new UserInput();
        int choice;
        boolean isBad;
        do {
            isBad = false;
            choice = input.inputInteger("# ");// waits for user input
            //checks if the choice is valid, if it's not it will prompt the user for valid input
            if ((choice < 1) || (choice > 3)) {
                System.out.print("Invalid input, Please enter a number from 1 to 3\n");
                isBad = true;
            }
        } while (isBad);
        return choice;
    }

    // Method for displaying a welcome message and options menu
    public void selectionMenu(){
		System.out.printf("%s%nDraw your weapon%n%d: Rock  %d: Paper  %d: Scissor %n",
				"===================================\n", ROCK, PAPER, SCISSOR);
    }

    // This method uses the passed argument to display the selection from the menu (Rock or Paper or Scissor)
    public String choiceDisplay(int selection) {
        String value;

        switch (selection){
            case ROCK:
                value = "Rock";
                break;
            case PAPER:
                value = "Paper";
                break;
            case SCISSOR:
                value = "Scissor";
                break;
            default:
                value = "Invalid input. Please enter a number from 1 to 3";
        }
        return value;
    }

    /**
     * This method declares the result (Win, Lose, Draw) of the game
     * for the user by comparing the values of user and cpu choices, the choices are passed as integers
     * corresponding to 1=Rock or 2=Paper or 3=Scissors
     * 
     * @param user the choice of the user
     * @param cpu the choice of the CPU
     * @return a string array containing the result and a count for the win.
     */
    //#TO-DO
    // change return type to array
    // add count variable to count the wins and loses
    // return the decision and the count as a String array
    public String[] whoWins(int user, int cpu){
        String[] value = new String[2];
        if (user == cpu){
            value[0] = "Draw !";
            value[1] = "";
        }
        // usr==1 and cpu==3 or usr==2 and cpu==1 or usr==3 and cpu==2
        else if ((user==ROCK && cpu==SCISSOR) || (user==PAPER && cpu==ROCK) ||
                  (user==SCISSOR && cpu==PAPER)) {
            value[0] = "You Win";
            value[1] = "1";
        }
        else {
            value[0] = "You Lost !";
            value[1] = "0";
        }
        return value;
    }
}


