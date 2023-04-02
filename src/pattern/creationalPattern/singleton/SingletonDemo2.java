/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern.creationalPattern.singleton;

/**
 *
 * @author Admin
 */
public class SingletonDemo2 {

    private static SingletonDemo2 instance ; //=new SingletonDemo2(); 

    static {
        synchronized (SingletonDemo2.class) {
           instance = new SingletonDemo2(); 
        }       
    }
    public String value;

    private SingletonDemo2() {

    }

    public static SingletonDemo2 getInstance(String value) {
        instance.value = value;
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused " + "\n"
                + "If you see different values, then 2 singletons were created " + "\n\n"
                + "RESULT:" + "\n");
        SingletonDemo2 singleton = SingletonDemo2.getInstance("FOO");
        SingletonDemo2 anotherSingleton = SingletonDemo2.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
