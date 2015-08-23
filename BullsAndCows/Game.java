//**********************************************
//Game.java
//By Jordana Aviva Mael (jam2350)
//A class that plays the game Bulls and Cows
//**********************************************

import java.util.Scanner;

public class Game
{
    //Stores how many turns user has
    private int turns;
    //The computer player with a secret pattern
    private Oracle computer;
    //Stores the user's guess
    private Scanner input;
    //Whether or not the user won
    private boolean win;

    //Constructs a game beginning with no turns,
    //playing against an Oracle object,
    //and a user who has not won yet
    public Game()
    {
        turns = 0;
        computer = new Oracle();
        win = false;
    }

    //Plays one turn of the game continuously until
    //the user wins
    public void playGame()
    {
        while (win != true)
        {
            playOneTurn();
            turns++;
        }
        System.out.println("You won in " + turns + " turns!");
    }

    //Plays one turn of the game
    public void playOneTurn()
    {
        //Prompts user for a guess
        System.out.print("Enter a 4-digit integer ");
        input = new Scanner(System.in);
        //Accepts user's guess as a String
        String guess = input.next();
        //Calculates how many bulls in a user's guess
        int bulls = computer.howManyBulls(guess);
        //Calculates how many cows in a user's guess
        int cows = computer.howManyCows(guess);
        //User wins game when they have 4 bulls
        if (bulls == 4)
        {
            win = true;
        }
        else
        {
           System.out.println("Bulls: " + bulls);
           System.out.println("Cows: " + cows);  
        }     

    }

    public void setPattern(String solution){

        computer.setPattern(solution);
    }

    public String getPattern(){

        return computer.getPattern();
    }



}
