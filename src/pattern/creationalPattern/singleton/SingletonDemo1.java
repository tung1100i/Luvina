/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern.creationalPattern.singleton;

/**
 *
 * @author Admin
 */
public class SingletonDemo1 {

    private static SingletonDemo1 instance;
    public String value;

    private SingletonDemo1(String value) {

        this.value = value;
    }

    public static SingletonDemo1 getInstance(String value) {
        synchronized (SingletonDemo1.class) {
            if (instance == null) {
                instance = new SingletonDemo1(value);
            }
            return instance;
        }

    }

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused " + "\n"
                + "If you see different values, then 2 singletons were created " + "\n\n"
                + "RESULT:" + "\n");
        SingletonDemo1 singleton = SingletonDemo1.getInstance("FOO");
        SingletonDemo1 anotherSingleton = SingletonDemo1.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
