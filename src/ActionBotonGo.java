import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBotonGo implements ActionListener {

	ControlJuego controlJuego;
	VentanaPrincipal ventanaPrincipal;

	public ActionBotonGo(ControlJuego controlJuego, VentanaPrincipal ventanaPrincipal) {

		this.controlJuego = new ControlJuego();// Creo un nuevo tablero con sus minas y sus historias
		this.ventanaPrincipal = ventanaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ventanaPrincipal.setControlJuego(new ControlJuego());
		ventanaPrincipal.inicializar();
		ventanaPrincipal.refrescarPantalla();

	}

}
