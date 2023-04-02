package thread.LTPT_NguyenThanhTung_1851063190_lab2;
/**
 *
 * @author hp
 */
public class kiemTra {
    static int counter=0;
    static boolean wantCS[]= {false,true};
    public static class T0 extends Thread{
        Lock lock;
        int tid;
        
        public T0(Lock lock, int tid){
            this.lock=lock;
            this.tid=tid;
        }
        
        void CS(){
            counter+=2;                
        }
        void nonCS(){
          System.out.println("T" + tid + "-> " + counter);
        }
        
        @Override
        public void run(){
            for (int i = 0; i < 50; i++) {                
                lock.requestCS(tid);
                CS();                   
                lock.releaseCS(tid);
                nonCS();
        }         
    }
}
    
    public static class T1 extends Thread{
        Lock lock;
        int tid;
        
        public T1(Lock lock, int tid){
            this.lock=lock;
            this.tid=tid;
        }
        
        void CS(){          
            counter-=2;                         
        }
        void nonCS(){
            System.out.println("T" + tid + "-> " + counter);
        }
        
        @Override
        public void run(){
            for (int i = 0; i < 50; i++) {           
                lock.requestCS(tid);
                CS();                  
                lock.releaseCS(tid);
                nonCS();          
            }   
        }
    }  
    public static void main(String[] args)  {
        Lock lock = new Dekker();
            T0 t0 = new T0(lock,0);
            T1 a  = new T1(lock,1);
        try {          
            t0.start();           
            a.start();         
            t0.join();
            a.join();
        } catch (InterruptedException e) {}    
        System.out.println("Counter: "+counter);
    }    
}

