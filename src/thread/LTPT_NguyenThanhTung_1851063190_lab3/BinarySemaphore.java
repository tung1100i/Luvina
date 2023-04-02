package thread.LTPT_NguyenThanhTung_1851063190_lab3;

public class BinarySemaphore {
    boolean value;
    BinarySemaphore(boolean initValue) {
        value = initValue;
    }
    public synchronized void P() throws InterruptedException {
        while (value == false)
            this.wait();// in queue of blocked processes
        value = false;
    }
    public synchronized void V() {
        value = true;
        notify();
    }
}