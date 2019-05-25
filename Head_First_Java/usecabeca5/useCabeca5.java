package usecabeca5;

class useCabeca5{    
}
class Dog{
String name;    

public static void main(String[] args){
    Dog dog1 = new Dog();
    dog1.bark();
    
    Dog[] myDogs = new Dog[3];
    
    myDogs[0] = new Dog();
    myDogs[1] = new Dog();
    myDogs[2] = dog1;
    
    myDogs[0].name = "Fred";
    myDogs[1].name = "Marge";
    
    System.out.println("O ultimo cão é");
    System.out.println(myDogs[2].name);
    
    int x = 0;
    
    while (x < myDogs.length){
        myDogs[x].bark();
        x++;
    }
}

public void bark() {
    System.out.println(name + " ruff");
}
public void eat(){}
public void chaseCat(){}
}
