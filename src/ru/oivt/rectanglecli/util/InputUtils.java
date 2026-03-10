package ru.oivt.rectanglecli.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    public static double readPositiveDouble(Scanner sc, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = sc.nextDouble();
                if (value > 0) {
                    sc.nextLine(); // очистка буфера
                    return value;
                } else {
                    System.out.println("Ошибка: число должно быть больше 0. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число. Попробуйте снова.");
                sc.nextLine(); // сбросить неправильный ввод
            }
        }
    }

    public static int readInt(Scanner sc, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = sc.nextInt();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не целое число. Попробуйте снова.");
                sc.nextLine();
            }
        }
    }

    public static void pause(Scanner sc) {
        System.out.println("Нажмите Enter для продолжения...");
        sc.nextLine();
    }
}