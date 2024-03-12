package Services;

public interface iComplex {
    public int[] get();
    public int getReal();
    public int getImage();
    public void setReal(int real);
    public void setImage(int image);
    public void set(int real, int image);
    public iComplex copy();
}
