package usecabeca2;

class Movie {
    String title, genre;
    int rating;
    
    void playIt(){
        System.out.println("Playing the movie");
    }

}
public class useCabeca2 {
   public static void main(String[] args){
       Movie one = new Movie();
       one.title = "Sharks";
       one.genre = "Suspense";
       one.rating = 3;
       
       Movie two = new Movie();
       two.title = "The phantom of the opera";
       two.genre = " ";
       two.rating = 1000;
       two.playIt();
       
       Movie three = new Movie();
       three.title = " ";
       three.genre = "Comedy";
       three.rating = 50;
   }
}