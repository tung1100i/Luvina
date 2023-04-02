package OOP.Class;
public class MoveablePoint implements Moveable {

    public int x;
    public int y;
    public int xSpeed;
    public int ySpeed;

    public MoveablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        this.y += this.ySpeed;
    }

    @Override
    public void moveDown() {
        this.y -= this.ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x -= this.xSpeed;
    }

    @Override
    public void moveRight() {
        this.x += this.xSpeed;
    }

    public String toString() {
        String a = "(X,Y)=" + "(" + this.x + "," + this.y + ")";
        return a;
    }
}
