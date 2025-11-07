import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaAhorcado extends JFrame {

	private JLabel LblPalabra;
	private JLabel LblIntentos;
	private JTextArea TxtAscii;
	private JLabel LblMensaje;

	private JPanel PanelLetras;
	private ArrayList<JButton> BtnLetras;

	private JButton BtnIniciar;

	public VentanaAhorcado() {
		super("Interfaz Ahorcado");
		setLocationRelativeTo(null);
