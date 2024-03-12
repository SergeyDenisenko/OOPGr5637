package Domain;

import Services.iCalculator;
import Services.iComplex;

public class Calculator implements iCalculator {

    private iComplex complexNumber;

    public Calculator(iComplex complex) {
        this.complexNumber = complex;
    }

    @Override
    public void addition(iComplex complex) {
        int[] a = complexNumber.get();
        int[] b = complex.get();
        a[0] += b[0];
        a[1] += b[1];
        complexNumber.set(a[0], a[1]);
    }

    @Override
    public void subtraction(iComplex complex) {
        int[] a = complexNumber.get();
        int[] b = complex.get();

        a[0] -= b[0];
        a[1] -= b[1];
        complexNumber.set(a[0], a[1]);
    }

    @Override
    public void multiplication(iComplex complex) {
        int[] a = complexNumber.get();
        int[] b = complex.get();
        a[0] = a[0] * b[0] - a[1] * b[1];
        a[1] = a[1] * b[0] + a[0] * b[1];
        complexNumber.set(a[0], a[1]);
    }

    @Override
    public void division(iComplex complex) {
        int[] a = complexNumber.get();
        int[] b = complex.get();
        a[0] = (a[0] * b[0] + a[1] * b[1]) / (b[0] * b[0] + b[1] * b[1]);
        a[1] = (a[1] * b[0] - a[0] * b[1]) / (b[0] * b[0] + b[1] * b[1]);
        complexNumber.set(a[0], a[1]);
    }

    @Override
    public iComplex answer() {
        return complexNumber.copy();
    }
}