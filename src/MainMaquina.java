import java.util.Scanner;

public class MainMaquina {
	private static final double PRECIO_LECHE = 0.8;
	private static final int PRECIO_CAFE = 1;
	private static final double PRECIO_CAFE_LECHE = 1.5;
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// variables
		double monedero;
		try {
			System.out.println("Introduzca el monedero inicial");
			monedero = Double.parseDouble(teclado.nextLine());

			Maquina maquina1 = new Maquina(monedero);
			llamarMenu(maquina1);

		} catch (MaquinaException em) {
			System.out.println(em.getMessage());
		}

	}

	public static void llamarMenu(Maquina maquina1) {
		int respuesta;
		boolean salir = false;
		double dinero;

		do {
			do {
				System.out.println("¿Qué opción quiere elegir? ");
				System.out.println(
						" 1. Servir café solo (1 euro) \n 2. Servir leche (0,80 euros) \n 3. Servir café con leche (1,50 euros) "
								+ "\n 4. Consultar estado máquina. Aparecen datos de los depósitos y el monedero \n 5. Apagar máquina y salir");
				respuesta = Integer.parseInt(teclado.nextLine());
			} while (respuesta < 1 || respuesta > 5);
			
			try {
				switch (respuesta) {
				case 1:
					System.out.println("Introduzca " + PRECIO_CAFE + " euros");
					dinero = Double.parseDouble(teclado.nextLine());
					maquina1.servirCafe(dinero);
					break;
				case 2:
					System.out.println("Introduzca " + PRECIO_LECHE + " euros");
					dinero = Double.parseDouble(teclado.nextLine());
					maquina1.servirLeche(dinero);
					break;

				case 3:
					System.out.println("Introduzca " + PRECIO_CAFE_LECHE + " euros");
					dinero = Double.parseDouble(teclado.nextLine());
					maquina1.servirCafeLeche(dinero);
					break;

				case 4:
					System.out.println(maquina1);
					break;

				case 5:
					salir = true;
					System.out.println("Gracias por usar nuestro servicio");
					break;

				default:
					System.out.println("Valor incorrecto");
				}
			} catch (MaquinaException em) {
				System.out.println(em.getMessage());
			}
		} while (salir == false);
	}

}
