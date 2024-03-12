package Fabric;

import java.util.Scanner;

import Domain.Complex;
import Services.iComplex;
import Services.iGenerateComplexNumber;

public class GenerateComplexNumber implements iGenerateComplexNumber {

    private Scanner scan = new Scanner(System.in);

    @Override
    public iComplex create() {
        int[] number = readConsole();
        return new Complex(number[0], number[1]);
    }

    @Override
    public int[] readConsole() {
        System.out.println("Введите вещественную часть числа:");
        int real = scan.hasNextInt() ? scan.nextInt() : 0;
        System.out.println("Введите мнимую часть числа:");
        int image = scan.hasNextInt() ? scan.nextInt() : 0;
        return new int[]{real, image};
    }
}
