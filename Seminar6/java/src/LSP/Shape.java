package LSP;

public abstract class Shape {
    protected int width;
    protected int height;

    public abstract void setWidth(int width);

    public abstract void setHeight(int height);

    public int area() {
        return this.width * this.height;
    }
}
