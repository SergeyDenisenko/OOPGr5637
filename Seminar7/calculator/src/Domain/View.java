package Domain;

import java.util.Scanner;

import Services.iComplex;
import Services.iView;

public class View implements iView {

    private Scanner scan = new Scanner(System.in);

    @Override
    public char readCommand() {
        System.out.println("Введите команду ('+','-','*','/','q'):");
        String str = scan.nextLine();
        char command;
        try {
            command = str.charAt(0);
        } catch (Exception e) {
            command = '?';
        }
        return command;
    }

    @Override
    public void printAnswer(iComplex complexNumber) {
        System.out.printf("Answer: %s\n-\n", complexNumber);
    }

    public boolean suggestRepeat() {
        System.out.println("Начать новые вычисления (Y/N)?");
        char simbol = (scan.nextLine()).toUpperCase().charAt(0);
        return simbol == 'Y' ? true : false;
    }
}
