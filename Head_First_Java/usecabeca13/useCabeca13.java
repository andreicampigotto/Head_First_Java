package usecabeca13;

class useCabeca13 {}

class Clock{
    private String time;
    
    void setTime(String t) {
        time = t;
    }
    String getTime() {
        return time;
    }
}    
    class ClockTest{
        public static void main(String[] args) {
            
            Clock c = new Clock();
            
            c.setTime("12345");
            
            String tod = c.getTime();
            System.out.println("time: " + tod);
        }
    }
    
