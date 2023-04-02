/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.LTPT_NguyenThanhTung_1851063190_lab3;

class BoundedBuffer {
    final int size = 10;
    double[] buffer = new double[size];
    int inBuf = 0, outBuf = 0;
    BinarySemaphore mutex = new BinarySemaphore(true);
    CountingSemaphore isEmpty = new CountingSemaphore(0);
    CountingSemaphore isFull = new CountingSemaphore(size);

    public void deposit(double value) throws InterruptedException {
        isFull.P();
        mutex.P(); 
        buffer[inBuf] = value; 
        inBuf = (inBuf + 1) % size;
        mutex.V();
        isEmpty.V();  
    }
    public double fetch() throws InterruptedException {
        double value;
        isEmpty.P(); 
        mutex.P();  
        value = buffer[outBuf]; 
        outBuf = (outBuf + 1) % size;
        mutex.V();
        isFull.V(); 
        return value;
    }
}
