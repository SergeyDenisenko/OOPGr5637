package Services;

public interface iCalculator {
    public void addition(iComplex complex);
    public void subtraction(iComplex complex);
    public void multiplication(iComplex complex);
    public void division(iComplex complex);
    public iComplex answer();
}
