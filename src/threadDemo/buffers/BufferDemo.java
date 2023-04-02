/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadDemo.buffers;

/**
 *
 * @author ManhHung
 */
public class BufferDemo {

    public static void main(String[] args) {
        //create shared object used by threads
        // Buffer sharedBuffer = new Buffer();
        Buffer sharedBuffer = new Buffer();
        //create producer and consumer objects
        ProducerBuffer producer = new ProducerBuffer(sharedBuffer);
        ConsumerBuffer consumer = new ConsumerBuffer(sharedBuffer);
        producer.start(); 	// start producer thread
        consumer.start();   // start consumer thread
    }
}
