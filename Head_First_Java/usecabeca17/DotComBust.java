package usecabeca17;

import java.util.*;
//import usecaceca17.GameHelper;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        //Cria DotCom e fornece locais
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Seu objetivo é eliminar três dot coms."
                + "\nPets.com, eToys.com and Go2.com"
                + "\nTente eliminar com o menor número de tentativas!!");

        for (DotCom dotComToSet : dotComList) {
            
            ArrayList<String> newLocations = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocations);
        } //end for
    }//end setUpGame

    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Insira um palpite: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        for (DotCom dotComToTest : dotComList) {
            result = dotComToTest.CheckYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComList.remove(dotComToTest);
                break;
            }
            System.out.println(result);
        }
    }
    private void finishGame(){
        System.out.println("Todas as dots afundadas!");
        if(numOfGuesses <= 18){
            System.out.println("Você usou " + numOfGuesses + " palpites." + 
                            "\nVocê antes de eliminar suas opções!");            
        }
        else{
            System.out.println("Demorou de mais." + numOfGuesses + " palpites." + 
                            "\nNão haverá pesca com essas opções!");
        }
    }
    public static void main(String[] Args){
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}

