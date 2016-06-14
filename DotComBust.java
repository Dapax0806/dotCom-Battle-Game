package com.company;


import java.util.ArrayList;


public class DotComBust {

    //Declare Variables
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;


    private void setUpGame(){

        //Make dot coms and give them locations
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        DotCom four = new DotCom();
        four.setName("Dpaxton.com");
        DotCom five = new DotCom();
        five.setName("Battleship.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        dotComsList.add(four);
        dotComsList.add(five);

        //Print Instructions
        System.out.println("Your goal is to sink five dot Websites");
        System.out.println("Pets.com, eToys.com, Go2.com, Dpaxton.com, Battleship.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        //Ask helper for dotcom location for each dotcom in the list
        for (DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation); //Call the setter method
        }

    }
   //Get user input while cell is not empty
    private void startPlaying(){
        while (!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);

        }

        //Call finish game method
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "miss";

        //Repeat with all dot coms in the list
        for (int x = 0; x < dotComsList.size(); x++){
            result = dotComsList.get(x).checkYourself(userGuess);
            if (result.equals("hit")){
                break;
            }

            //Remove from Array list if dead
            if (result.equals("kill")){
                dotComsList.remove(x);
            }
        }

        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if(numOfGuesses <=18){
            System.out.println("It onle took you " + numOfGuesses + " guesses.");
            System.out.println("YOu got out before your options sank. ");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }


}
