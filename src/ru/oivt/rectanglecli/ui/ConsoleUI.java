package ru.oivt.rectanglecli.ui;

import ru.oivt.rectanglecli.util.InputUtils;
import ru.oivt.rectanglecli.model.Rectangle;
import java.util.Scanner;

public class ConsoleUI {

    private static final double EPS = 1e-9;

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
            System.out.println("3. Вычислить диагональ");
            System.out.println("4. Вычислить длину описанной окружности");
            System.out.println("5. Вычислить радиус вписанной окружности (только для квадрата)");
            System.out.println("6. Ввести новые параметры");
            System.out.println("0. Выход");
            int choice = InputUtils.readInt(scanner, "Ваш выбор: ");

            switch (choice) {
                case 1:
                    System.out.println("Периметр: " + rect.perimeter());
                    break;
                case 2:
                    System.out.println("Площадь: " + rect.area());
                    break;
                case 3:
                    System.out.println("Диагональ: " + rect.diagonal());
                    break;
                case 4:
                    System.out.println("Длина описанной окружности: " + rect.getCircumference());
                    break;
                case 5:
                    if (Math.abs(rect.getA() - rect.getB()) < EPS) {
                        System.out.println("Радиус вписанной окружности: " + rect.inscribedCircleRadius());
                    } else {
                        System.out.println("Радиус вписанной окружности доступен только для квадрата.");
                    }
                    break;
                case 6:
                    double aNew = InputUtils.readPositiveDouble(scanner, "Введите новую сторону a: ");
                    double bNew = InputUtils.readPositiveDouble(scanner, "Введите новую сторону b: ");
                    rect.setA(aNew);
                    rect.setB(bNew);
                    System.out.println("Параметры обновлены.");
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