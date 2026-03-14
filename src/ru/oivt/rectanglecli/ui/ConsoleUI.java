package ru.oivt.rectanglecli.ui;

import ru.oivt.rectanglecli.util.InputUtils;
import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        printHeader();

        double a = InputUtils.readPositiveDouble(scanner, "Введите сторону a: ");
        double b = InputUtils.readPositiveDouble(scanner, "Введите сторону b: ");

        System.out.println("Создан прямоугольник со сторонами " + a + " и " + b);
        showMenu();
    }

    private void printHeader() {
        System.out.println("=== Программа расчета прямоугольника ===");
    }

    private void showMenu() {
        System.out.println("Меню (заглушка):");
        System.out.println("1. Опции пока недоступны");
        System.out.println("0. Выход");
    }
}