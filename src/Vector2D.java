public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0,0);
    }
    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D addThis(float x, float y) {
        this.x += x;
        this.y += y;
        return this; // in order to use as series . Eg: v.addThis(1,1).scaleThis(2)
    }
    public Vector2D subtractThis(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }
    public Vector2D scaleThis(float rate) {
        this.x *= rate;
        this.y *= rate;
        return this;
    }

    public float getLength() {
        return (float)Math.sqrt(x*x + y*y);
    }

    public Vector2D setLength(float length) {
        float old_length = this.getLength();
        this.x = (x*length)/old_length;
        this.y = (y*length)/old_length;
        return this;
    }
    public float getAngle() {
        return (float)Math.atan(this.y/this.x);
    }

    public Vector2D setAngle(float angle) {
        float length = this.getLength();
        this.x = length*(float)Math.cos(angle);
        this.y = length*(float)Math.sin(angle);
        return this;
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1,1);
        System.out.println(v1.getAngle()-Math.PI/4);
        System.out.println(v1.setAngle((float)Math.PI/2));
        System.out.println(v1.setAngle((float)-Math.PI/4));

    }
}
