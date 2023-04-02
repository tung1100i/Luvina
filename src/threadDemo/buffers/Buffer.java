/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadDemo.buffers;

/**
 *
 * @author ManhHung
 */
class Buffer { 
    private int buffer = -1; // Kho chỉ chứa được 1 đơn vị sản phẩm
    public void set(int value) {
        buffer = value;
    }

    public int get() {
        return buffer;
    }
}
