package usecabeca14;

class useCabeca14 {
}

public class Mix4 {

    int counter = 0;

    public static void main(String[] args) {
        int count = 0;
        Mix4[] m4a = new Mix4[20];
        int x = 0;

        while (x < 20) {
            m4a[x].counter = m4a[x].counter++;
            count = count++;
            count = count + m4a[x].maybeNew(x);
            x++;
        }
        System.out.println(count + " " + m4a[1].counter);
    }

    public int maybeNew(int index) {

        if (index < 5) {
            Mix4 m4 = new Mix4();
            m4.counter = m4.counter++;
            return 1;
        }
        return 0;
    }
}
