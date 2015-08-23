//***********************************
// Oracle.Class
// By Jordana Aviva Mael (jam2350) 
// A class calculating bulls and cows
//***********************************

import java.lang.String;

public class Oracle{
    
    //Oracle's randomly generated pattern
    private String pattern;
    //Stores content of first bull
    private String bullOne;
    //Stores content of second bull
    private String bullTwo;
    //Stores content of third bull
    private String bullThree;
    //Stores content of fourth bull
    private String bullFour;

    //Constructs an Oracle, initializes it
    //with a random pattern,
    //and stores the content of bull matches
    public Oracle()
    {
        pattern = makePattern();
        bullOne = "none";
        bullTwo = "none";
        bullThree = "none";
        bullFour = "none";
    }
    
    //Generates a random pattern of non-repeating digits
    //and stores pattern as a String
    public String makePattern()
    {
        int first = (int) (Math.random()*10);
        int second = (int) (Math.random()*10);
        //While loops prevent repeating digits
        while (second == first)
        {
            second = (int) (Math.random()*10);
        }
        int third = (int) (Math.random()*10);
        while (third == first || third == second)
        {
            third = (int) (Math.random()*10);
        }
        int fourth = (int) (Math.random()*10);
        while (fourth == first || fourth == second || fourth == third)
        {
            fourth = (int) (Math.random()*10);
        }
        //Converts pattern of digits to a String
        String randomPattern = "" + first + second + third + fourth;
        return randomPattern;
    }

    public void setPattern(String solution){

        pattern = solution;
    }

    public String getPattern(){

        return pattern;
    }

    //Calculates how many bulls in a user's guess
    public int howManyBulls(String guess)
    {
        int bulls = 0;
        bullOne = "none";
        bullTwo = "none";
        bullThree = "none";
        bullFour = "none";   
        //One digit of user's guess
        String gSub;
        //One digit of Oracle's pattern
        String pSub;
        //Index of guess and pattern
        int i;
        for (i = 0; i < guess.length(); i++)
        {
            gSub = guess.substring(i,i+1);
            pSub = pattern.substring(i,i+1);
            //Count one bull for every matching digit and index
            //and stores the content of that bull
            if (gSub.equals(pSub))
            {
                bulls++;
                setBull(guess, i);
            }
        }
        return bulls;
    }

    //Stores the content of each bull
    public void setBull(String guess, int index)
    {
        if (index == 0)
        {
            bullOne = guess.substring(0,1);
        }
        if (index == 1)
        {
            bullTwo = guess.substring(1,2);
        }
        if (index == 2)
        {
            bullThree = guess.substring(2,3);
        }
        if (index == 3)
        {
            bullFour = guess.substring(3,4);
        }
    }

    //Calculates how many cows in a user's guess
    public int howManyCows(String guess)
    {
        int cows = 0;
        //Index of user's guess
        int i;
        //Index of Oracle's pattern
        int j;
        for(j = 0; j < pattern.length(); j++)
        {
            for(i = 0; i < guess.length(); i++)
            {
                String pSub = pattern.substring(j,j+1);
                String gSub = guess.substring(i,i+1);
                //Increments cow only if there is a match for that
                //digit in a different index value and only counts
                //cows once per digit
                if (pSub.equals(gSub))
                {
                    if (i != j && !(pSub.equals(bullOne)) && !(pSub.equals(bullTwo))
                    && !(pSub.equals(bullThree)) && !(pSub.equals(bullFour)))
                    {
                        cows++;
                    }
                    break;
                }
            }       
        }
        return cows;      
    }                    

}
