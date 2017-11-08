import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.ActionMapUIResource;

/**
 * Clase que implementa el listener de los botones del Buscaminas. De alguna
 * manera tendrá que poder acceder a la ventana principal. Se puede lograr
 * pasando en el constructor la referencia a la ventana. Recuerda que desde la
 * ventana, se puede acceder a la variable de tipo ControlJuego
 * 
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener {
	VentanaPrincipal ventana;
	int i;
	int j;

	public ActionBoton(VentanaPrincipal ventana, int i, int j) {
		this.ventana = ventana;
		this.i = i;
		this.j = j;

	}

	/**
	 * Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (ventana.getJuego().abrirCasilla(i, j)) {// Si la casilla no es una mina...
			ventana.mostrarNumMinasAlrededor(i, j);// Quita el boton y muestra el numero de minas alrededor.
			ventana.actualizarPuntuacion();// Suma uno a la puntuacion.
			ventana.refrescarPantalla();// Refresca la pantalla para mostrarlo al usuario.

			if (ventana.getJuego().esFinJuego()==true) {// Si se han alcanzado los 80 puntos,
				ventana.mostrarFinJuego(false);// Muestro el fin del juego con el mensaje de que ha ganado.
				
				for (int i = 0; i < ventana.botonesJuego.length; i++) {
					for (int j = 0; j < ventana.botonesJuego[i].length; j++) {
						ventana.botonesJuego[i][j].setEnabled(false);//Desactivo todas los botones que quedan.
					}
				}
			}

		} else {
			ventana.mostrarFinJuego(true);// Muestro el fin del juego con el mensaje de que le ha explotado una mina.
		}

	}

}
