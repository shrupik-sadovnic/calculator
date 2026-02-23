package ru.oivt.rectanglecli;
import ru.oivt.rectanglecli.model.Rectangle;

public class App {

	public App() {
		
	}

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(4, 6);

		System.out.println("Рассчёты для прямоугольника 4x6:");
		System.out.println("Площадь: " + rect.area());
	    System.out.println("Периметр: " + rect.perimeter());
	    System.out.println("Диагональ: " + rect.diagonal());
	    System.out.println("Радиус вписанной окружности: " + rect.inscribedCircleRadius());

	}

}
