package Domain;

import Services.iComplex;

public class Complex implements iComplex{
    private int real;
    private int image;

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public Complex(int real) {
        this(real, 0);
    }

    public Complex() {
        this(0, 0);
    }

    @Override
    public int[] get() {
        return new int[]{this.real, this.image};
    }

    @Override
    public int getReal() {
        return this.real;
    }

    @Override
    public int getImage() {
        return this.image;
    }

    @Override
    public void setReal(int real) {
        this.real = real;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public void set(int real, int image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public iComplex copy() {
        return new Complex(this.real, this.image);
    }

    @Override
    public String toString() {
        String symbol = this.image >= 0 ? "+" : "";
        return String.format("%d%s%di",this.real, symbol, this.image);
    }
}
