package ru.oivt.rectanglecli.ui;

import ru.oivt.rectanglecli.util.InputUtils;
import ru.oivt.rectanglecli.model.Rectangle;
import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        printHeader();

        double a = InputUtils.readPositiveDouble(scanner, "Введите сторону a: ");
        double b = InputUtils.readPositiveDouble(scanner, "Введите сторону b: ");

        Rectangle rectangle = new Rectangle(a, b);
        System.out.println("Создан прямоугольник со сторонами " + a + " и " + b);
        showMenu(rectangle);
    }

    private void printHeader() {
        System.out.println("=== Программа расчета прямоугольника ===");
    }

    private void showMenu(Rectangle rect) {
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Вычислить периметр");
            System.out.println("2. Вычислить площадь");
            System.out.println("0. Выход");
            int choice = InputUtils.readInt(scanner, "Ваш выбор: "); // вызов с подсказкой

            switch (choice) {
                case 1:
                    System.out.println("Периметр: " + rect.perimeter());
                    break;
                case 2:
                    System.out.println("Площадь: " + rect.area());
                    break;
                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Некорректный выбор, попробуйте снова.");
            }
        }
    }
}