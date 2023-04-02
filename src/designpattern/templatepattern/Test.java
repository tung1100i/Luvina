package designpattern.templatepattern;

import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("designpattern.templatepattern.Chess");
        game g= (game) c.getConstructor().newInstance() ;
        g.play();
    }
}
