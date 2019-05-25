package usecabeca3;

class Player{
    int number = 0;
    public void guess(){
        number = (int) (Math.random() *10);
        System.out.println("Estou pensando em: " + number);
    }
}

class GuessGame{
    Player p1;
    Player p2;
    Player p3;
    
public void startGame() {
    p1 = new Player();    
    p2 = new Player();
    p3 = new Player();
    
    int guessp1 = 0, guessp2 = 0,guessp3 = 0;
    boolean p1isRight = false, p2isRight = false, p3isRight = false;
    int targetNumber = (int) (Math.random() *10);
    System.out.println("Tente adivinhar o número!");
    
    while (true) {
      
      p1.guess();
      p2.guess();
      p3.guess();
      
      guessp1 = p1.number;
      guessp2 = p2.number;
      guessp3 = p3.number;
      System.out.println("Palpite jogador 1: " + guessp1 + "Palpite jogador 2: " + guessp2 + "Palpite jogador 3:" + guessp3);
     
      if (guessp1 == targetNumber) 
        p1isRight  = true; 
      
      if (guessp2 == targetNumber) 
        p2isRight  = true;
      
      if (guessp3 == targetNumber) 
        p3isRight  = true;
      
      if (p1isRight || p2isRight || p3isRight){
        System.out.println("Temos um vencedor! "); 
        System.out.println("Jogador um acertou? " + p1isRight);
        System.out.println("Jogador dois acertou? " + p2isRight);
        System.out.println("Jogador três acertou? " + p3isRight);
        break;
      } else{
          System.out.println("Ninguem acertou!! tentem novamente");
      }
    }
    }
}

public class useCabe3 {
    public static void main(String[] args){
        GuessGame game = new GuessGame();
        game.startGame();
    }
}
