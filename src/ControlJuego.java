import java.util.ArrayList;
import java.util.Random;

/**
 * Clase gestora del tablero de juego. Guarda una matriz de enteros representado
 * el tablero. Si hay una mina en una posición guarda el número -1 Si no hay
 * una mina, se guarda cuántas minas hay alrededor. Almacena la puntuación de
 * la partida
 * 
 * @author jesusredondogarcia
 *
 */
public class ControlJuego {

	private final static int MINA = -1;
	final int MINAS_INICIALES = 20;
	final int LADO_TABLERO = 10;

	private int[][] tablero;
	private int puntuacion;

	public ControlJuego() {
		// Creamos el tablero:
		tablero = new int[LADO_TABLERO][LADO_TABLERO];

		// Inicializamos una nueva partida
		inicializarPartida();
	}

	/**
	 * Método para generar un nuevo tablero de partida:
	 * 
	 * @pre: La estructura tablero debe existir.wwwwwwwww
	 * @post: Al final el tablero se habrá inicializado con tantas minas como
	 *        marque la variable MINAS_INICIALES. El resto de posiciones que no son
	 *        minas guardan en el entero cuántas minas hay alrededor de la celda
	 */
	public void inicializarPartida() {

		Random rd = new Random();
		int filas = rd.nextInt(LADO_TABLERO);
		int columnas = rd.nextInt(LADO_TABLERO);

		for (int i = 0; i < MINAS_INICIALES; i++) {// Mete las 20 minas en el tablero
			if (tablero[filas][columnas] == 0) {
				tablero[filas][columnas] = MINA;
			} else {
				filas = rd.nextInt(LADO_TABLERO);
				columnas = rd.nextInt(LADO_TABLERO);
				i--;
			}
		}

		for (int i = 0; i < tablero.length; i++) {// Recorre el tablero, si hay una mina, suma uno a los huecos
													// adyacentes.
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] == MINA) {
					calculoMinasAdjuntas(i, j);
				}
			}
		}

		depurarTablero();// Muestro el tablero

	}

	/**
	 * Cálculo de las minas adjuntas: Para calcular el número de minas tenemos que
	 * tener en cuenta que no nos salimos nunca del tablero. Por lo tanto, como
	 * mucho la i y la j valdrán LADO_TABLERO-1. Por lo tanto, como mucho la i y la
	 * j valdrán como poco 0.
	 * 
	 * @param i:
	 *            posición verticalmente de la casilla a rellenar
	 * @param j:
	 *            posición horizontalmente de la casilla a rellenar
	 * @return : El número de minas que hay alrededor de la casilla [i][j]
	 **/
	private int calculoMinasAdjuntas(int i, int j) {
		int minas = 0;
		int minimoPosible = 0;
		
		for (int filas = i - 1; filas <= i + 1; filas++) {
			for (int columnas = j - 1; columnas <=i + 1; columnas++) {
				if (tablero[filas][columnas] == MINA) {
					//Si es una mina no hace nada
				} else {
					//Si no es una mina le suma uno.
					tablero[filas][columnas]++;
				}
			}
		}

//		for (int filas = Math.max(minimoPosible, (i - 1)); filas <= Math.min((LADO_TABLERO-1), (i + 1)); filas++) {
//			for (int columnas = Math.max(minimoPosible, (j - 1)); columnas <= Math.min((LADO_TABLERO-1), (i + 1)); columnas++) {
//				if (tablero[filas][columnas] == MINA) {
//					//Si es una mina no hace nada
//				} else {
//					//Si no es una mina le suma uno.
//					tablero[filas][columnas]++;
//				}
//			}
//		}

		return minas;
	}

	/**
	 * Método que nos permite
	 * 
	 * @pre : La casilla nunca debe haber sido abierta antes, no es controlado por
	 *      el GestorJuego. Por lo tanto siempre sumaremos puntos
	 * @param i:
	 *            posición verticalmente de la casilla a abrir
	 * @param j:
	 *            posición horizontalmente de la casilla a abrir
	 * @return : Verdadero si no ha explotado una mina. Falso en caso contrario.
	 */
	public boolean abrirCasilla(int i, int j) {

	}

	/**
	 * Método que checkea si se ha terminado el juego porque se han abierto todas
	 * las casillas.
	 * 
	 * @return Devuelve verdadero si se han abierto todas las celdas que no son
	 *         minas.
	 **/
	public boolean esFinJuego() {
	}

	/**
	 * Método que pinta por pantalla toda la información del tablero, se utiliza
	 * para depurar
	 */
	public void depurarTablero() {
		System.out.println("---------TABLERO--------------");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("\nPuntuación: " + puntuacion);
	}

	/**
	 * Método que se utiliza para obtener las minas que hay alrededor de una celda
	 * 
	 * @pre : El tablero tiene que estar ya inicializado, por lo tanto no hace falta
	 *      calcularlo, símplemente consultarlo
	 * @param i
	 *            : posición vertical de la celda.
	 * @param j
	 *            : posición horizontal de la cela.
	 * @return Un entero que representa el número de minas alrededor de la celda
	 */
	public int getMinasAlrededor(int i, int j) {
	}

	/**
	 * Método que devuelve la puntuación actual
	 * 
	 * @return Un entero con la puntuación actual
	 */
	public int getPuntuacion() {
	}

}
