/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadDemo;

/**
 *
 * @author Hung
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable{

	private List<Integer> myList;
	private Object host;
	public MyThread(List<Integer> list){
		this.myList = list;
	}
	private void updateList(int i){
			myList.add(i);
	}
	@Override
	public void run() {
		for( int i = 0; i < 100;i++){
			updateList(i);
		}
		System.out.println("end: " + myList.size());
	}
}
public class ArrListMultiThread {

	private ArrayList<Integer> taskList = new ArrayList<Integer>();
	private Object object = new Object();
	private void launch(){
		
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        	executorService.execute(new MyThread(taskList));
        	executorService.execute(new MyThread(taskList));
	}
	public static void main(String[] args) {
		ArrListMultiThread test = new ArrListMultiThread();
		test.launch();
	}
}
 
