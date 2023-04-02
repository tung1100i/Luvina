package IOstream;

import java.util.Random;

public class Ran {
    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            Random generator = new Random();
            int value = generator.nextInt(50);
            System.out.print(value+" ");
        }
    }
}
