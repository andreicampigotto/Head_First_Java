package usecabeca4;

class DrumKit {
    boolean topHat = true;
    boolean snare = true;
    void playTopHat(){
        System.out.println("ding ding d-ding");
    }
    void playSnare(){
        System.out.println("bang bang ba-bang");
    }
}
 class useCabeca4 {
    public static void main(String[] args){
      DrumKit d = new DrumKit();
      d.playSnare();
      d.snare = false;
      d.playTopHat();
      if (d.snare == true){
        d.playSnare();
      }
    }
}  

