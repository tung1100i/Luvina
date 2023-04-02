package designpattern.templatepattern;

public abstract class game {
    abstract void init();

    abstract void start();

    abstract void end();

    public final void play() {
        init();
        start();
        end();
    }
}
