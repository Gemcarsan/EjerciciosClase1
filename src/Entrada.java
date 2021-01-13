import java.util.Scanner;

public class Entrada {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		SolicitarEntero();
		SolicitarEnteroPositivo();
		SolicitarEnteroEnRango(1, 10);
		SolicitarCaracter();
		SolicitarCaracterSN();
		SolicitarCadena();

	}

	public static int SolicitarEntero() {
		int entero = 0;
		boolean error = true;
		do {
			try {
				System.out.println("Introduzca un número entero:");
				entero = Integer.parseInt(teclado.nextLine());
				error = false;

			} catch (NumberFormatException ex) {
				System.out.println("No es un número");
			}
		} while (error == true);
		return entero;
	}

	public static int SolicitarEnteroPositivo() {
		int entero;
		do {
			System.out.println("Introduzca un número entero positivo:");
			entero = Integer.parseInt(teclado.nextLine());
		} while (entero < 0);

		return entero;
	}

	public static int SolicitarEnteroEnRango(int rangoInferior, int rangoSuperior) {
		int entero;
		do {
			System.out.println("Introduzca un número entero del " + rangoInferior + " al " + rangoSuperior);
			entero = Integer.parseInt(teclado.nextLine());
		} while (entero < rangoInferior || entero > rangoSuperior);

		return entero;
	}

	public static char SolicitarCaracter() {
		char caracter;
		do {
			System.out.println("Introduzca un caracter");
			caracter = teclado.nextLine().charAt(0);
		} while (Character.isLetter(caracter) == false);

		return caracter;
	}

	public static char SolicitarCaracterSN() {
		char caracterSN;
		do {
			System.out.println("Introduzca un caracter");
			caracterSN = teclado.nextLine().charAt(0);
			caracterSN = Character.toUpperCase(caracterSN);
		} while (caracterSN != 'S' || caracterSN != 'N');

		return caracterSN;
	}

	public static String SolicitarCadena() {
		String cadena;
		System.out.println("Introduzca una cadena de caracteres");
		cadena = teclado.nextLine();
		return cadena;
	}

}
