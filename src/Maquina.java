
public class Maquina {

	// CONSTANTES

	private static final int MAX_VASOS = 80;
	private static final int MAX_CAFE = 50;
	private static final int MAX_LECHE = 50;
	private static final double PRECIO_LECHE = 0.8;
	private static final int PRECIO_CAFE = 1;
	private static final double PRECIO_CAFE_LECHE = 1.5;

	// ATRIBUTOS
	private int cafe;
	private int leche;
	private int vasos;
	private double monedero;

	// CONSTRUCTOR

	// VALORES INICIALES
	public Maquina() {
		leche = MAX_LECHE;
		cafe = MAX_CAFE;
		vasos = MAX_VASOS;
		monedero = 0;
	}

	public Maquina(double monedero) throws MaquinaException {

		setRellenar();

		if (monedero < 0) {
			throw new MaquinaException("Cantidad incorrecta: No puede ingresar una cantidad negativa");
		}
		this.monedero = monedero;
	}

	// METODOS GET

	public double getMonedero() {
		return monedero;
	}

	public int getLeche() {
		return leche;
	}

	public int getCafe() {
		return cafe;
	}

	public int getVasos() {
		return vasos;
	}

	// METODOS VOID
	public void vaciarMonedero() {
		monedero = 0;
	}

	private void setRellenar() {
		leche = MAX_LECHE;
		cafe = MAX_CAFE;
		vasos = MAX_VASOS;
	}

	public void setRellenarMonedero(double rellenarMonedero) throws MaquinaException {

		if (rellenarMonedero < 0) {
			throw new MaquinaException("No puede introducir una cantidad negativa");
		}
		monedero = monedero + rellenarMonedero;
	}

	public void servirCafeLeche(double dinero) throws MaquinaException {

		if (leche == 0 || vasos == 0 || cafe == 0) {
			throw new MaquinaException("No hay depositos");
		}
		if (dinero < PRECIO_CAFE_LECHE) {
			throw new MaquinaException("Dinero insuficiente");
		}
	
		if (dinero == PRECIO_CAFE_LECHE) {
			introducirDinero(dinero);
			System.out.println("Producto servido");
			cafe--;
			leche--;
			vasos--;
		} else {
			System.out.println("Producto servido");
			System.out.println("Su vuelta es " + devolverDinero(dinero, PRECIO_CAFE_LECHE));
			introducirDinero((dinero - devolverDinero(dinero, PRECIO_CAFE_LECHE)));
			cafe--;
			leche--;
			vasos--;
		}
	}

	public void servirCafe(double dinero) throws MaquinaException {

		if (cafe == 0 || vasos == 0) {
			throw new MaquinaException("No hay depositos");
		}
		if (dinero < PRECIO_CAFE) {
			throw new MaquinaException("Dinero insuficiente");
		}
		if (dinero == PRECIO_CAFE) {
			introducirDinero(dinero);
			System.out.println("Producto servido");
			cafe--;
			vasos--;
		} else {
			System.out.println("Producto servido");
			System.out.println("Su vuelta es " + devolverDinero(dinero, PRECIO_CAFE));
			introducirDinero((dinero - devolverDinero(dinero, PRECIO_CAFE)));
			cafe--;
			vasos--;
		}

	}

	public void servirLeche(double dinero) throws MaquinaException {

		if (leche == 0 || vasos == 0) {
			throw new MaquinaException("No hay depositos");
		}
		if (dinero < PRECIO_LECHE) {
			throw new MaquinaException("Dinero insuficiente");
		}
		if (dinero == PRECIO_LECHE) {
			introducirDinero(dinero);
			System.out.println("Producto servido");
			leche--;
			vasos--;
		} else {
			System.out.println("Producto servido");
			System.out.println("Su vuelta es " + devolverDinero(dinero, PRECIO_LECHE));
			introducirDinero((dinero - devolverDinero(dinero, PRECIO_LECHE)));
			leche--;
			vasos--;
		}

	}

	public void introducirDinero(double dinero) {
		monedero = monedero + dinero;
	}

	public double devolverDinero(double dinero, double precio) {
		double vuelta;
		vuelta = dinero - precio;

		return vuelta;
	}

	// Mensaje por pantalla
	public String toString() {
		String info;
		info = "La máquina tiene " + vasos + " vasos, " + cafe + " de café, " + leche
				+ " de leche, con un monedero de " + monedero + " euros";
		return info;
	}

}
