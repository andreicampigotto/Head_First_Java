package usecabeca8;

class TestArrays {

    public static void main(String[] args){
        
        int [] index = new int[4];
        index[0] = 1;        
        index[1] = 3;
        index[2] = 0;
        index[3] = 2;
        
        String[] islands = new String[4];
        islands[0] = "Bermuda";
        islands[1] = "Fiji";
        islands[2] = "Azores";
        islands[3] = "Cozumel";
        
        int ref;
        for (int i = 0; i <= index.length; i++) {
            ref = index[i];
            System.out.println("Island = " + islands[ref]);
        }
    }
            
    
}
