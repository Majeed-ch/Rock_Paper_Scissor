package com.mazed_ch.rps;
import java.util.Random;

/*
this class represent the game of Rock Paper Scissor and contains the main method
 */
public class RPS_Game {
    /*
     this method is the entry point of the application
     it displays a welcome message and a list of options for the user to select from (rock, paper, or scissor)
     it assigns a number randomly as a computer chose that corresponds to a (rock or paper or scissor)
     then it asks the player to select one as well, then it will make a decision of (win, lose, or daw) and display it,
     lastly it will ask to play again and restart if answered yes.
     */
    public static void main(String[] args) {
        int userChoice;
        int cpuChoice;
        int userScore = 0;
        int cpuScore = 0;
        final int GAME_WINNER = 3;
        boolean shouldContinue = true;
        String[] result = new String[2];
        RPS_Workers rps = new RPS_Workers();
        Random random = new Random();
        UserInput input = new UserInput();
        
        
        System.out.println("===================================");
        System.out.println("Welcome to Rock Paper Scissor Game ");
        
        while (shouldContinue){
            rps.selectionMenu(); //prints the menu

            userChoice = rps.playersChoice();// gets user input
            System.out.printf("\tPlayer: %s%n", rps.choiceDisplay(userChoice)); //prints the players choice
            
            // cpus' choice is selected randomly from 1 to 3
            cpuChoice = random.nextInt(3) + 1; // [0...2] + 1 = [1...3]
            System.out.printf("\tCPU:    %s%n", rps.choiceDisplay(cpuChoice)); //prints the cpus' choice

            result = rps.whoWins(userChoice, cpuChoice); //returns the result of the game (win, lose, draw)

            if (result[1].equals("1")){ //counts number of wins for the player
                userScore++;
            }
            else if (result[1].equals("0")){ //counts number of wins for cpu
                cpuScore++;
            }

            System.out.printf("%s %nPlayer  %d:%d  CPU%n", result[0], userScore, cpuScore); //prints total number of wins

            if (userScore == GAME_WINNER || cpuScore == GAME_WINNER){ // force exits the loop if set number of rounds won
                shouldContinue = false;
            }
            if (userScore == GAME_WINNER){
                System.out.println("\n*** YOU WIN THE GAME ***");
            }
            else if (cpuScore == GAME_WINNER){
                System.out.println("\nxxx YOU LOST THE GAME xxx");
            }
        }
        System.out.println("\n Thank you for playing...");
    }
}
