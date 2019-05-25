package usecabeca9;

class Triangule {
    double area;
    int height;
    int length;
    
    public static void main(String[] args){
        int x = 0;
        
        Triangule[] ta = new Triangule[4];
        while (x < 4){
         ta[x] = new Triangule();
         ta[x].height = (x +1 ) * 2;
         ta[x].length = x + 4;
         ta[x].setArea();
         System.out.println("Triangule X, area = " + ta[x].area);
         x++;         
        }
        int y = x;
        x = 27;
        Triangule t5 = ta[2];
        ta[2].area = 343;
        System.out.println(" y = " + y + ", t5 area = " + t5.area);
    }
    void setArea(){
        area = (height * length) /2 ;
    }
}
