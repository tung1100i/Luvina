package thread.LTPT_NguyenThanhTung_1851063190_lab3;
import java.util.Random;

public class Test {    
    
    static int b ;
    public static void main(String[] args) throws InterruptedException  {
        
        BoundedBuffer boundedBuffer = new BoundedBuffer();
           
    class Thread1 extends Thread{   
        
        BoundedBuffer T1 = new BoundedBuffer();       
        public Thread1(BoundedBuffer bd) {
            T1=bd;
        }
        @Override
        public void run(){
            for(int i=0;i<20;i++){
            //while (true) {  
                try {
                Random rand = new Random();
                b = rand.nextInt(100)+1;
                System.err.println("----T1: "+b);
                this.sleep(1000);
                T1.deposit(b);         
                } catch (InterruptedException ex) {}     
            }  
        }
    }

    class Thread2 extends Thread{
        
        BoundedBuffer T2 = new BoundedBuffer();
        public Thread2(BoundedBuffer bd) {
            T2=bd;
        }    
        
        boolean check(int a){
            int sum=0;
            for(int i=1;i<a;i++){
                if(a%i==0)sum+=i;
                }
            return(sum==a);
        }
        
        @Override
        public void run(){ 
            for(int i=0;i<20;i++){
           // while(true){
                int x = 0;
                try {
                    x = (int) T2.fetch();
                } catch (InterruptedException ex) {}
                if(check(x)){
                    System.out.println(x + " la so hoan hao");
                }else{
                    System.out.println(x+ " khong phai so hoan hao");
                }
            }
        }
    }
 
        Thread1 T0 = new Thread1(boundedBuffer);
        Thread2 T1 = new Thread2(boundedBuffer);
        
        try {
            T0.start();
            T1.start();
            T0.join();
            T1.join();
        } catch (InterruptedException ex) {}   
   } 
}


