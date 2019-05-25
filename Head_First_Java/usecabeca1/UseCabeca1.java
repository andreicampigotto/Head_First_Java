package usecabeca1;

class Dog {
  int size;
  String breed;
  String name;
  
  void bark() {
      System.out.println("Reff! Ruff!");
  }
}
public class UseCabeca1 {

    public static void main(String[] args) {
     Dog d = new Dog();
     
     d.size = 40;
     
     d.bark();
    }
    
}
