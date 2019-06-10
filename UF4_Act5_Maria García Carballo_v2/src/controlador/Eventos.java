package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import vista.Ventana;
import java.awt.*;

public class Eventos implements ActionListener {

	private Ventana ventana;

	public Eventos(Ventana ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		DecimalFormat formatea = new DecimalFormat("###,###.##");// Declaramos el formato de los números
		
		//Refactor de variables para limpiar código
		JLabel resulFinal = ventana.getEtiquetaResulFinal();
		boolean emptyCaja1 = ventana.getCajaNumero1().getText().isEmpty();
		boolean emptyCaja2 = ventana.getCajaNumero2().getText().isEmpty();
		
		//Evento Raiz Cuadrada
		if (e.getSource() == ventana.getBotonRaizCuadrada()) {
			JOptionPane.showMessageDialog(
					new JFrame(), 
					"Funcionalidad no disponible",
					"Raiz Cuadrada",
					JOptionPane.INFORMATION_MESSAGE);
			resulFinal.setText("");// Limpiamos el resultado final si lo hubiera
			return;
		}
		
		//Evento Raiz Cúbica
		if (e.getSource() == ventana.getBotonRaizCubica()) {

			String contrasena = JOptionPane.showInputDialog(
					null, 
					"Introduzca contraseña", 
					"Raiz Cubica",
					JOptionPane.QUESTION_MESSAGE);
			
			if (contrasena != null) {
				if (contrasena.equals("calculadora")) {
					try {	
						
						color(); //Resultado alineado con el color
						
						if (emptyCaja1) {
							if (emptyCaja2) {
								sinNumeros(resulFinal);
								color_error();
							} else { //Operación de la caja 2 por estar vacía la 1
								float cubica2 = (float) Math.pow(numero2(), 1.0 / 3.0);
								resulFinal.setText(String.valueOf(formatea.format(cubica2)));
							}
						} else {//Operación de la caja 1 por estar vacía la 2
							float cubica1 = (float) Math.pow(numero1(), 1.0 / 3.0);
							resulFinal.setText(String.valueOf(formatea.format(cubica1)));
						}
						
						if(!emptyCaja1&&!emptyCaja2) { //Si están los dos números hacemos la operación de la Caja 1
							float cubica1 = (float) Math.pow(numero1(), 1.0 / 3.0);
							resulFinal.setText(String.valueOf("Num 1: "+ formatea.format(cubica1)));
						}
					} catch (NumberFormatException o) { // Capturamos la excepción si la caja contiene texto.
						color_error();
						error_texto();
					}
				} else { //Si no coincide la contraseña
					resulFinal.setText("Error en contraseña");
					color_error();
				}
			} else { //Si no ha introducido nada
				resulFinal.setText("Necesaria contraseña");
				color_error();
			}
			return;
		}
		
		//Comprobamos si alguna de las cajas está vacía o ambas
		if (emptyCaja1) {
			if (emptyCaja2) {
				color_error();
				sinNumeros(resulFinal);
			} else {
				color_error();
				resulFinal.setText("Falta el número 1");
			}
		} else if(emptyCaja2) {
			color_error();
			resulFinal.setText("Falta el número 2");			
		} else {
	
			try {

				color();

				// OPERACIONES
				float suma = numero1() + numero2();
				float resta = numero1() - numero2();
				float multiplica = numero1() * numero2();
				float divide = numero1() / numero2();

				// dependiendo del botón que se pulse, se obtendrá el resultado de la operacion
				if (e.getSource() == ventana.getBotonSuma()) {
					resulFinal.setText(String.valueOf(formatea.format(suma)));
				} else if (e.getSource() == ventana.getBotonResta()) {
					resulFinal.setText(String.valueOf(formatea.format(resta)));
				} else if (e.getSource() == ventana.getBotonMultiplica()) {
					resulFinal.setText(String.valueOf(formatea.format(multiplica)));
				} else if (e.getSource() == ventana.getBotonDivide()) {
					if (numero2() == 0) {
						color_error();
						resulFinal.setText("No divisible por 0");//Controlamos la división por 0
					} else {
						resulFinal.setText(String.valueOf(formatea.format(divide)));
					}
				} else {
					ventana.getCajaNumero1().requestFocus();// Ponemos foco en la Caja 1
				}
				
			} catch (NumberFormatException o) { // Capturamos la excepción si la caja contiene texto.
				color_error();
				error_texto();
			}
		}
	}
	
	//Extraemos método si no hay números
	private void sinNumeros(JLabel resulFinal) {
		resulFinal.setText("Escribe un número");
	}
	
	//Extraemos el numero 1
	private float numero1() {
		float numero1 = Float.parseFloat(ventana.getCajaNumero1().getText());
		return numero1;
	}
	
	//Extraemos el numero 2
	private float numero2() {
		float numero2 = Float.parseFloat(ventana.getCajaNumero2().getText());
		return numero2;
	}

	//Extremos método para indicar error en formato
	private void error_texto() {
		ventana.getEtiquetaResulFinal().setText("Sólo son válidos números");
	}

	// Extraemos un método para cambiar el color al texto del error
	private void color_error() {
		ventana.getEtiquetaResulFinal().setForeground(Color.RED);
		ventana.getEtiquetaResulFinal().setFont(new Font("Garamond", Font.BOLD, 18));
	}

	// Extraemos un método para cambiar el color si no hay errores.
	private void color() {
		ventana.getEtiquetaResulFinal().setForeground(new Color(0, 51, 25));
		ventana.getEtiquetaResulFinal().setFont(new Font("Garamond", Font.BOLD, 25));
	}
}
