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
        pause();
        showMenu(rectangle);
    }

    private void printHeader() {
        System.out.println("=== Программа расчета прямоугольника ===");
        System.out.println();
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
                    System.out.println("Периметр: " + String.format("%.2f", rect.perimeter()));
                    pause();
                    break;
                case 2:
                    System.out.println("Площадь: " + String.format("%.2f", rect.area()));
                    pause();
                    break;
                case 3:
                    System.out.println("Диагональ: " + String.format("%.2f", rect.diagonal()));
                    pause();
                    break;
                case 4:
                    System.out.println("Длина описанной окружности: " + String.format("%.2f", rect.getCircumference()));
                    pause();
                    break;
                case 5:
                    if (Math.abs(rect.getA() - rect.getB()) < EPS) {
                        System.out.println("Радиус вписанной окружности: " + String.format("%.2f", rect.inscribedCircleRadius()));
                    } else {
                        System.out.println("Вписанная окружность существует только для квадрата");
                    }
                    pause();
                    break;
                case 6:
                    double aNew = InputUtils.readPositiveDouble(scanner, "Введите новую сторону a: ");
                    double bNew = InputUtils.readPositiveDouble(scanner, "Введите новую сторону b: ");
                    rect.setA(aNew);
                    rect.setB(bNew);
                    System.out.println("Параметры обновлены.");
                    pause();
                    break;
                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Некорректный выбор, попробуйте снова.");
                    pause();
            }
        }
    }

    private void pause() {
        System.out.println("Нажмите Enter, чтобы продолжить...");
        scanner.nextLine();
    }
}