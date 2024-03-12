import Domain.Calculator;
import Domain.Decorator;
import Domain.Logger;
import Domain.View;
import Fabric.GenerateComplexNumber;
import Services.iCalculator;
import Services.iGenerateComplexNumber;
import Services.iView;

public class App {
    public static void main(String[] args) throws Exception {
        iView view = new View();
        iGenerateComplexNumber genComplexNumber = new GenerateComplexNumber();
        iCalculator calc = new Decorator(new Calculator(genComplexNumber.create()), new Logger());

        while (true) {
            char command = view.readCommand();
            switch (command) {
                case '+':
                    calc.addition(genComplexNumber.create());
                    break;
                case '-':
                    calc.subtraction(genComplexNumber.create());
                    break;
                case '*':
                    calc.multiplication(genComplexNumber.create());
                    break;
                case '/':
                    calc.division(genComplexNumber.create());
                    break;
                case '=':
                    view.printAnswer(calc.answer());
                    if (view.suggestRepeat()) {
                        calc = new Decorator(new Calculator(genComplexNumber.create()), new Logger());
                    } else {
                        return;
                    }
                    break;
                case 'q':
                    return;
                default:
                    System.out.println("Повторите ввод");
            }
        }
    }
}
