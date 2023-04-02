/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern.creationalPattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    private static SerializableSingleton instance = new SerializableSingleton();

    private SerializableSingleton() {
        System.out.println("Constructor is being called");
    }

    public static SerializableSingleton getInstance() {
        return instance;
    }

//    protected Object readResolve() {
//        return getInstance();
//    }
    public static void main(String args[]) {

        try {
            SerializableSingleton instance1 = SerializableSingleton.getInstance();
            ObjectOutput out = null;

            // Serialize object state to file
            out = new ObjectOutputStream(new FileOutputStream("codePumpkin.ser"));
            out.writeObject(instance1);
            out.close();

            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("codePumpkin.ser"));
            SerializableSingleton instance2 = (SerializableSingleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode = " + instance1.hashCode());
            System.out.println("instance2 hashCode = " + instance2.hashCode());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
        We can see that the hash code of both the instances are different in above example. 
        That clearly violates singleton principle. 
        The problem with above serialized singleton class is that whenever we deserialize it,
        it will create a new instance of the class. 
        We can prevent this by providing implementation readResolve() method as shown below. 
         */
    }
}
