/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threadDemo.buffers;

/**
 *
 * @author ManhHung
 */
class ConsumerBuffer extends Thread
{
    private Buffer sharedBuffer; 
 //  public Consumer( Buffer shared )	
    public ConsumerBuffer( Buffer shared )
	{
		super( "Consumer" );
		sharedBuffer = shared;
	}
        public void run(){
		for ( int count = 1; count <= 10; count++ ){ //
		    try{
		    	Thread.sleep((int)(Math.random() *3000));
		    	System.out.println( "Consumer reads " +
						sharedBuffer.get());
		    }catch (InterruptedException e){
		    	e.printStackTrace();
		    }
		}
		System.out.println( getName() + " finished.");
	}
}
