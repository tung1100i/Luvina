package designpattern.templatepattern;

public class Soccer extends game{
    @Override
    void init() {
        System.out.println("Khoi tao Soccer");
    }

    @Override
    void start() {
        System.out.println("Start Soccer");
    }

    @Override
    void end() {
        System.out.println("End Soccer");
    }
}
