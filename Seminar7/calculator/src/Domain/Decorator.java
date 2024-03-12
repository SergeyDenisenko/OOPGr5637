package Domain;

import Services.iCalculator;
import Services.iComplex;

public class Decorator implements iCalculator {

    private iCalculator calc;
    private Logger logger;

    public Decorator (iCalculator calc, Logger logger) {
        this.calc = calc;
        this.logger = logger;
        logger.add("init", calc.answer(), calc.answer());
    }

    @Override
    public void addition(iComplex complex) {
        logger.add("addition", calc.answer(), complex);
        calc.addition(complex);
    }

    @Override
    public void subtraction(iComplex complex) {
        logger.add("subtraction", calc.answer(), complex);
        calc.subtraction(complex);
    }

    @Override
    public void multiplication(iComplex complex) {
        logger.add("multiplication", calc.answer(), complex);
        calc.multiplication(complex);
    }

    @Override
    public void division(iComplex complex) {
        logger.add("division", calc.answer(), complex);
        calc.division(complex);
    }

    @Override
    public iComplex answer() {
        iComplex answer = calc.answer();;
        logger.add("answer", answer, answer);
        return answer;
    }
}
