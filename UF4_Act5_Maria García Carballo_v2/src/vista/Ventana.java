package vista;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import controlador.Eventos;

public class Ventana extends JFrame{
	
	//DECLARACION DE COMPONENTES - ATRIBUTOS DE LA CLASE (PRIVADAS)	
	private JLabel etiquetaNum1,etiquetaNum2,etiquetaResul,etiquetaResulFinal,etiquetaImagen, nombreApp;
	private JTextField cajaNumero1, cajaNumero2;
	private JButton botonSuma, botonResta, botonMultiplica, botonDivide, botonRaizCuadrada, botonRaizCubica;
	
	//CONSTRUCTOR
	public Ventana() {
		setSize(290,450); //Tamaño de la Ventana
		setLocationRelativeTo(null); //Eliminamos la autolocalización
		setTitle("Mi Calculadora"); //Titulo
		setLayout(null); // Lo colocamos nosotros
		setIconImage(Toolkit.getDefaultToolkit().getImage("calculadora.jpg")); //Imagen de la App
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Para programa cuendo cerramos
		incializarComponentes(); //Método que inicializa los componentes
		setVisible(true); //Visible
	}
	
	//FUNCION QUE INICIALIZA LOS COMPONENTES
	private void incializarComponentes() {
		
		getContentPane().setBackground(new Color(102,0,204)); //Damos un color de fondo a la calculadora
		
		//Creamos una imagen nueva y la escalamos al tamaño de la caja
		Image img = new ImageIcon("halloween.jpg").getImage();
		etiquetaImagen = new JLabel (new ImageIcon(img.getScaledInstance(80,80, Image.SCALE_SMOOTH)));
		etiquetaImagen.setBounds(20,20,80,80);
		add(etiquetaImagen);	
		
		//He importado un tipo de letra y la utilizamos para el nombre de la App.
		//Para realizarlo es necesario un Try/Catch
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("Halloween.ttf"));
			
			nombreApp = new JLabel("CALCULADORA");
			nombreApp.setHorizontalAlignment(SwingConstants.CENTER); //Centramos
			nombreApp.setFont(font.deriveFont(Font.BOLD, 25f)); //Tamaño
			nombreApp.setBounds(100,50,150,30); //Colocamos
			nombreApp.setForeground(Color.orange); //Damos color a la letra
			add(nombreApp); //añadimos
			
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		etiquetaNum1 = new JLabel("Número 1:");//Creamos el componente
		etiquetaNum1.setBounds(50,120,80,25);//Posicionamos
		etiquetaNum1.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		etiquetaNum1.setForeground(Color.WHITE);//Color del texto
		add(etiquetaNum1);//Añadimos
		
		etiquetaNum2 = new JLabel("Número 2:");//Creamos el componente
		etiquetaNum2.setBounds(50,150,80,25);
		etiquetaNum2.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		etiquetaNum2.setForeground(Color.WHITE);//Color del texto
		add(etiquetaNum2);//Añadimos
		
		cajaNumero1 = new JTextField();//Creamos el componente
		cajaNumero1.setBounds(135,120,80,25);//Posicionamos
		cajaNumero1.setBorder(null); //Eliminamos el borde
		cajaNumero1.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		cajaNumero1.setBackground(Color.WHITE); //Color de fondo
		cajaNumero1.setForeground(new Color(0,0,128));//Color del número
		cajaNumero1.setHorizontalAlignment(JTextField.CENTER); //Centramos en la caja
		add(cajaNumero1);//Añadimos
		
		cajaNumero2 = new JTextField();//Creamos el componente
		cajaNumero2.setBounds(135,150,80,25);//Posicionamos
		cajaNumero2.setBorder(null); //Eliminamos el borde
		cajaNumero2.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		cajaNumero2.setBackground(Color.WHITE); //Color de fondo
		cajaNumero2.setForeground(new Color(0,0,128));//Color del número
		cajaNumero2.setHorizontalAlignment(JTextField.CENTER); //Centramos en la caja
		add(cajaNumero2);//Añadimos
		
		botonSuma = new JButton("+");//Creamos el componente
		botonSuma.setBounds(20,200,50,35);
		botonSuma.setBorder(null); //Eliminamos el borde
		botonSuma.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		botonSuma.setBackground(new Color(0,0,102)); //Color de fondo
		botonSuma.setForeground(Color.WHITE);//Color del número
		add(botonSuma);//Añadimos
		
		botonResta = new JButton("-");//Creamos el componente
		botonResta.setBounds(80,200,50,35);
		botonResta.setBorder(null); //Eliminamos el borde
		botonResta.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		botonResta.setBackground(new Color(0,0,102)); //Color de fondo
		botonResta.setForeground(Color.WHITE);//Color del número
		add(botonResta);//Añadimos
		
		botonMultiplica = new JButton("x");//Creamos el componente
		botonMultiplica.setBounds(140,200,50,35);
		botonMultiplica.setBorder(null); //Eliminamos el borde
		botonMultiplica.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		botonMultiplica.setBackground(new Color(0,0,102)); //Color de fondo
		botonMultiplica.setForeground(Color.WHITE);//Color del número
		add(botonMultiplica);//Añadimos
		
		botonDivide = new JButton("/");//Creamos el componente
		botonDivide.setBounds(200,200,50,35);
		botonDivide.setBorder(null); //Eliminamos el borde
		botonDivide.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		botonDivide.setBackground(new Color(0,0,102)); //Color de fondo
		botonDivide.setForeground(Color.WHITE);//Color del número
		add(botonDivide);//Añadimos
		
		botonRaizCuadrada = new JButton("Raiz 2");//Creamos el componente
		botonRaizCuadrada.setBounds(20,245,110,35);
		botonRaizCuadrada.setBorder(null); //Eliminamos el borde
		botonRaizCuadrada.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		botonRaizCuadrada.setBackground(new Color(0,0,102)); //Color de fondo
		botonRaizCuadrada.setForeground(Color.WHITE);//Color del número
		add(botonRaizCuadrada);//Añadimos
		
		botonRaizCubica = new JButton("Raiz 3");//Creamos el componente
		botonRaizCubica.setBounds(140,245,110,35);
		botonRaizCubica.setBorder(null); //Eliminamos el borde
		botonRaizCubica.setFont(new Font("Garamond",Font.BOLD,16));//Damos formato al contenido
		botonRaizCubica.setBackground(new Color(0,0,102)); //Color de fondo
		botonRaizCubica.setForeground(Color.WHITE);//Color del número
		add(botonRaizCubica);//Añadimos
		
		etiquetaResul = new JLabel("Resultado:");//Creamos el componente
		etiquetaResul.setBounds(90,300,230,20);//Posicionamos
		etiquetaResul.setFont(new Font("Garamond",Font.BOLD,20));//Damos formato al contenido
		etiquetaResul.setForeground(Color.WHITE);//Color del número
		add(etiquetaResul);
		
		etiquetaResulFinal = new JLabel();//Creamos el componente
		etiquetaResulFinal.setBounds(20,340,230,40);
		etiquetaResulFinal.setBackground(new Color(211,211,211)); //Color de fondo
		etiquetaResulFinal.setOpaque(true);//Para que aparezca el color de fondo
		etiquetaResulFinal.setFont(new Font("Garamond",Font.BOLD,18));//Damos formato al contenido
		etiquetaResulFinal.setForeground(new Color(34,139,34));//Color del texto
		etiquetaResulFinal.setHorizontalAlignment(JTextField.CENTER); //Centramos en la caja
		add(etiquetaResulFinal);
	}

	//METODO PARA PONER A LA ESCUCHA LOS EVENTOS	
	public void Eventos (Eventos manejador) {
		botonSuma.addActionListener(manejador);
		botonResta.addActionListener(manejador);
		botonMultiplica.addActionListener(manejador);
		botonDivide.addActionListener(manejador);
		botonRaizCuadrada.addActionListener(manejador);
		botonRaizCubica.addActionListener(manejador);
	}

	//GETTER y SETTER
	public JLabel getEtiquetaNum1() {
		return etiquetaNum1;
	}
	public JLabel getEtiquetaNum2() {
		return etiquetaNum2;
	}
	public JLabel getEtiquetaResul() {
		return etiquetaResul;
	}
	public void setEtiquetaResul(JLabel etiquetaResul) {
		this.etiquetaResul = etiquetaResul;	}

	public JLabel getEtiquetaResulFinal() {
		return etiquetaResulFinal;
	}
	public void setEtiquetaResulFinal(JLabel etiquetaResulFinal) {
		this.etiquetaResulFinal = etiquetaResulFinal;
	}
	public JTextField getCajaNumero1() {
		return cajaNumero1;
	}
	public JTextField getCajaNumero2() {
		return cajaNumero2;
	}
	public void setCajaNumero2(JTextField cajaNumero2) {
		this.cajaNumero2 = cajaNumero2;
	}
	public JButton getBotonSuma() {
		return botonSuma;
	}
	public JButton getBotonResta() {
		return botonResta;
	}
	public JButton getBotonMultiplica() {
		return botonMultiplica;
	}
	public JButton getBotonDivide() {
		return botonDivide;
	}
	public JButton getBotonRaizCuadrada() {
		return botonRaizCuadrada;
	}
	public void setBotonRaizCuadrada(JButton botonRaizCuadrada) {
		this.botonRaizCuadrada = botonRaizCuadrada;
	}
	public JButton getBotonRaizCubica() {
		return botonRaizCubica;
	}
	public void setBotonRaizCubica(JButton botonRaizCubica) {
		this.botonRaizCubica = botonRaizCubica;
	}		
}
