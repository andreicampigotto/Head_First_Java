package usecabeca6;

class useCabeca6 {}


class Books {

    String title;
    String author;
}

class testBooks {
    public static void main(String[] args) {
    Books[] myBooks = new Books[3];
    //int x = 0;
    
    myBooks[0] = new Books();
    myBooks[1] = new Books();
    myBooks[2] = new Books();
    
    myBooks[0].title  = "Java";
    myBooks[1].title  = "Python";
    myBooks[2].title  = "Logica";
    myBooks[0].author  = "Bla";
    myBooks[1].author  = "Bla";
    myBooks[2].author  = "Bla";
    
    for (int x = 0;x< myBooks.length ;x++) {
            System.out.println(myBooks[x].title + " by: " + myBooks[x].author);
    }
}
}