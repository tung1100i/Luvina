/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.LTPT_NguyenThanhTung_1851063190_lab3;

public class CountingSemaphore {
    int value;
    public CountingSemaphore(int initValue) {
        value = initValue;
    }
    public synchronized void P() throws InterruptedException {
        value--;
        if (value < 0) this.wait();
    }
    public synchronized void V() {
        value++;
        if (value <= 0) notify();
    }
}