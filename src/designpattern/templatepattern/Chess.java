package designpattern.templatepattern;

public class Chess extends game{
    @Override
    void init() {
        System.out.println("Khoi tao Chess");
    }

    @Override
    void start() {
        System.out.println("Start Chess");
    }

    @Override
    void end() {
        System.out.println("End Chess");
    }
}
