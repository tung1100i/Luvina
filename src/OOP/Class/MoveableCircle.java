package OOP.Class;
public class MoveableCircle implements Moveable {

    public int radius;
    public MoveablePoint center;

    public MoveableCircle(int radius, MoveablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    public String toString() {
        String a = "Center: "+this.center+"\nRadius = "+this.radius ;
        return a;
    }
}
