package thread.LAB1;
/**
 *
 * @author hp
 */
import static thread.LAB1.LTPT_NguyenThanhTung_1851063190_lab1.random.usingRandomClass;

import java.util.Random;
import java.util.Scanner;

public class LTPT_NguyenThanhTung_1851063190_lab1   {
    
    static int[] b = new int[10000000];
    static int k;
    public class random {
        static void usingRandomClass(int a[]) {  
            for (int i=0; i<k; i++) {
                Random rand = new Random();
                a[i] = rand.nextInt(k)+1;
        }
    }
}
    
    public static class T1 extends Thread{  
        public void run(){
            int count = 0;
            for(int i =0; i<k/4;i++) {
                double sq= Math.sqrt(b[i]);
                if((sq - Math.floor(sq)) == 0)
                    count++;                   
        }
            System.out.println("T1 -> "+count);
    }
}
    
    public static class T2 extends Thread{  
        public void run(){
            int count =0;
            for(int i =k/4+1; i<k/2;i++) {
                double sq= Math.sqrt(b[i]);
                if((sq - Math.floor(sq)) == 0)
                    count++;       
        }
            System.out.println("T2 -> "+count);
    }
}
    
public static class T3 extends Thread{  
        public void run(){
            int count = 0;
            for(int i =k/2+1; i<(k-(k/4));i++) {
                double sq= Math.sqrt(b[i]);
                if((sq - Math.floor(sq)) == 0)
                    count++;                   
        }
           System.out.println("T3 -> "+count);
    }
}

public static class T4 extends Thread{  
        public void run(){
            int count = 0;
            for(int i =(k-(k/4)+1); i<k;i++) {
                double sq= Math.sqrt(b[i]);
                if((sq - Math.floor(sq)) == 0)
                    count++;                   
        }
            System.out.println("T4 -> "+count);
    }
}

public static class T9 extends Thread{  
        public void run(){
            int count = 0;
            for(int i =0; i<k;i++) {
                double sq= Math.sqrt(b[i]);
                if((sq - Math.floor(sq)) == 0)
                    count++;                   
        }
            System.out.println("Single -> "+count);           
    }
}
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        k= sc.nextInt();
        usingRandomClass(b);
      
        T9 I = new T9();
        long startTime2 =  System.nanoTime();
        I.start();
        I.join();
        long stopTime2 = System.nanoTime();
        System.out.println("Total time (single): "+(stopTime2-startTime2));
        
        T1 A = new T1();
        T2 B = new T2();
        T3 C = new T3();
        T4 D = new T4();

        long startTime = System.nanoTime();
        A.start();
        B.start();
        C.start();
        D.start();

  
        A.join();
        B.join();
        C.join();
        D.join();

        long stopTime = System.nanoTime();
        System.out.println("Total time (multi): "+(stopTime-startTime));  
   
    }  
}
