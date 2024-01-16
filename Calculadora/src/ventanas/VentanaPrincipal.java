package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//DEFINIMOS VARIABLES GLOBALES
	
	private JPanel contentPane;
	private JLabel label1;
	private double firstNumber = 0.0;
	private double secondNumber = 0.0;
	private String operation = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{340, 0};
		gbl_contentPane.rowHeights = new int[]{25, 325, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		//-----------------------------------------------------------------
		
		label1 = new JLabel("0");
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setFont(new Font("Tahoma", Font.BOLD, 23));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.fill = GridBagConstraints.BOTH;
		gbc_label1.insets = new Insets(0, 0, 5, 0);
		gbc_label1.gridx = 0;
		gbc_label1.gridy = 0;
		contentPane.add(label1, gbc_label1);
		
		//-----------------------------------------------------------------
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{73, 73, 73, 73, 0};
		gbl_panel.rowHeights = new int[]{65, 65, 65, 65, 65, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		contentPane.getBorder().getBorderInsets(panel).set(0, 0, 0, 0);
		
		//-----------------------------------------------------------------
		//BOTONES
		//-----------------------------------------------------------------
		
		JButton bt_0 = new JButton("0");
		bt_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("0");//RENDERIZAMOS EL TEXTO DEL LABEL
				checkOperation(); //CHEKEAMOS SI HAY ALGUNA OPERACION DE POR MEDIO
			}
		});
		bt_0.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_0 = new GridBagConstraints();
		gbc_bt_0.fill = GridBagConstraints.BOTH;
		gbc_bt_0.insets = new Insets(0, 0, 0, 5);
		gbc_bt_0.gridx = 1;
		gbc_bt_0.gridy = 4;
		panel.add(bt_0, gbc_bt_0);
		
		//-----------------------------------------------------------------
		
		JButton bt_1 = new JButton("1");
		bt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("1");
				checkOperation();
			}
		});
		bt_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_1 = new GridBagConstraints();
		gbc_bt_1.fill = GridBagConstraints.BOTH;
		gbc_bt_1.insets = new Insets(0, 0, 5, 5);
		gbc_bt_1.gridx = 0;
		gbc_bt_1.gridy = 3;
		panel.add(bt_1, gbc_bt_1);
		
		//-----------------------------------------------------------------
		
		JButton bt_2 = new JButton("2");
		bt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("2");
				checkOperation();
			}
		});
		bt_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_2 = new GridBagConstraints();
		gbc_bt_2.fill = GridBagConstraints.BOTH;
		gbc_bt_2.insets = new Insets(0, 0, 5, 5);
		gbc_bt_2.gridx = 1;
		gbc_bt_2.gridy = 3;
		panel.add(bt_2, gbc_bt_2);
		
		//-----------------------------------------------------------------
		
		JButton bt_3 = new JButton("3");
		bt_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("3");
				checkOperation();
			}
		});
		bt_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_3 = new GridBagConstraints();
		gbc_bt_3.fill = GridBagConstraints.BOTH;
		gbc_bt_3.insets = new Insets(0, 0, 5, 5);
		gbc_bt_3.gridx = 2;
		gbc_bt_3.gridy = 3;
		panel.add(bt_3, gbc_bt_3);
		
		//-----------------------------------------------------------------
		
		JButton bt_4 = new JButton("4");
		bt_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("4");
				checkOperation();
			}
		});
		bt_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_4 = new GridBagConstraints();
		gbc_bt_4.fill = GridBagConstraints.BOTH;
		gbc_bt_4.insets = new Insets(0, 0, 5, 5);
		gbc_bt_4.gridx = 0;
		gbc_bt_4.gridy = 2;
		panel.add(bt_4, gbc_bt_4);
		
		//-----------------------------------------------------------------
		
		JButton bt_5 = new JButton("5");
		bt_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("5");
				checkOperation();
			}
		});
		bt_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_5 = new GridBagConstraints();
		gbc_bt_5.fill = GridBagConstraints.BOTH;
		gbc_bt_5.insets = new Insets(0, 0, 5, 5);
		gbc_bt_5.gridx = 1;
		gbc_bt_5.gridy = 2;
		panel.add(bt_5, gbc_bt_5);
		
		//-----------------------------------------------------------------
		
		JButton bt_6 = new JButton("6");
		bt_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("6");
				checkOperation();
			}
		});
		bt_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_6 = new GridBagConstraints();
		gbc_bt_6.fill = GridBagConstraints.BOTH;
		gbc_bt_6.insets = new Insets(0, 0, 5, 5);
		gbc_bt_6.gridx = 2;
		gbc_bt_6.gridy = 2;
		panel.add(bt_6, gbc_bt_6);
		
		//-----------------------------------------------------------------
		
		JButton bt_7 = new JButton("7");
		bt_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("7");
				checkOperation();
			}
		});
		bt_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_7 = new GridBagConstraints();
		gbc_bt_7.fill = GridBagConstraints.BOTH;
		gbc_bt_7.insets = new Insets(0, 0, 5, 5);
		gbc_bt_7.gridx = 0;
		gbc_bt_7.gridy = 1;
		panel.add(bt_7, gbc_bt_7);
		
		//-----------------------------------------------------------------
		
		JButton bt_8 = new JButton("8");
		bt_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("8");
				checkOperation();
			}
		});
		bt_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_8 = new GridBagConstraints();
		gbc_bt_8.fill = GridBagConstraints.BOTH;
		gbc_bt_8.insets = new Insets(0, 0, 5, 5);
		gbc_bt_8.gridx = 1;
		gbc_bt_8.gridy = 1;
		panel.add(bt_8, gbc_bt_8);
		
		//-----------------------------------------------------------------
		
		JButton bt_9 = new JButton("9");
		bt_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderText("9");
				checkOperation();
			}
		});
		bt_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_9 = new GridBagConstraints();
		gbc_bt_9.fill = GridBagConstraints.BOTH;
		gbc_bt_9.insets = new Insets(0, 0, 5, 5);
		gbc_bt_9.gridx = 2;
		gbc_bt_9.gridy = 1;
		panel.add(bt_9, gbc_bt_9);
		
		//-----------------------------------------------------------------
		
		JButton bt_Comma = new JButton(".");
		bt_Comma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!label1.getText().contains(".")){ //Si no hay punto, deja poner el punto
					renderText(".");
					checkOperation();
				}
			}
		});
		bt_Comma.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_Comma = new GridBagConstraints();
		gbc_bt_Comma.fill = GridBagConstraints.BOTH;
		gbc_bt_Comma.insets = new Insets(0, 0, 0, 5);
		gbc_bt_Comma.gridx = 0;
		gbc_bt_Comma.gridy = 4;
		panel.add(bt_Comma, gbc_bt_Comma);
		
		//-----------------------------------------------------------------
		
		JButton bt_CLEAR = new JButton("C");
		bt_CLEAR.setForeground(new Color(0, 0, 0));
		bt_CLEAR.setBackground(new Color(236, 165, 2));
		bt_CLEAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear(); //LLAMAMOS AL METODO QUE RESTAURA TODAS LAS VARIABLES
			}
		});
		bt_CLEAR.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_CLEAR = new GridBagConstraints();
		gbc_bt_CLEAR.gridwidth = 2;
		gbc_bt_CLEAR.fill = GridBagConstraints.BOTH;
		gbc_bt_CLEAR.insets = new Insets(0, 0, 5, 5);
		gbc_bt_CLEAR.gridx = 0;
		gbc_bt_CLEAR.gridy = 0;
		panel.add(bt_CLEAR, gbc_bt_CLEAR);
		
		//-----------------------------------------------------------------
		
		JButton bt_DEL = new JButton("DEL");
		bt_DEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = label1.getText(); //VARIABLE CON TEXTO DEL LABEL
				int longitud = texto.length(); //VARIABLE CON LONGITUD DEL TEXTO
				String textoNuevo = texto.substring(0, longitud - 1); //LE QUITAMOS EL ULTIMO CARACTER DEL TEXTO CON EL SUBSTRING
				label1.setText(textoNuevo); //IMPRIMIMOS EN EL LABEL EL TEXTO YA RESTADO
				if(label1.getText().isEmpty()) {
				    label1.setText("0"); //SI EL TEXTO ESTA VACIA IMPRIMIR UN 0
				}
			}
		});
		bt_DEL.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_DEL = new GridBagConstraints();
		gbc_bt_DEL.fill = GridBagConstraints.BOTH;
		gbc_bt_DEL.insets = new Insets(0, 0, 5, 5);
		gbc_bt_DEL.gridx = 2;
		gbc_bt_DEL.gridy = 0;
		panel.add(bt_DEL, gbc_bt_DEL);
		
		//-----------------------------------------------------------------
		
		JButton bt_Div = new JButton("÷");
		bt_Div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOperationPressed("÷"); //LLAMAMOS EN CADA BOTON DE OPERACION AL METODO
			}
		});
		bt_Div.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_Div = new GridBagConstraints();
		gbc_bt_Div.fill = GridBagConstraints.BOTH;
		gbc_bt_Div.insets = new Insets(0, 0, 5, 0);
		gbc_bt_Div.gridx = 3;
		gbc_bt_Div.gridy = 0;
		panel.add(bt_Div, gbc_bt_Div);
		
		//-----------------------------------------------------------------
		
		JButton bt_Mul = new JButton("×");
		bt_Mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOperationPressed("×");
			}
		});
		bt_Mul.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_Mul = new GridBagConstraints();
		gbc_bt_Mul.fill = GridBagConstraints.BOTH;
		gbc_bt_Mul.insets = new Insets(0, 0, 5, 0);
		gbc_bt_Mul.gridx = 3;
		gbc_bt_Mul.gridy = 1;
		panel.add(bt_Mul, gbc_bt_Mul);
		
		//-----------------------------------------------------------------
		
		JButton bt_Minus = new JButton("-");
		bt_Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOperationPressed("-");
			}
		});
		bt_Minus.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_Minus = new GridBagConstraints();
		gbc_bt_Minus.fill = GridBagConstraints.BOTH;
		gbc_bt_Minus.insets = new Insets(0, 0, 5, 0);
		gbc_bt_Minus.gridx = 3;
		gbc_bt_Minus.gridy = 2;
		panel.add(bt_Minus, gbc_bt_Minus);
		
		//-----------------------------------------------------------------
		
		JButton bt_Plus = new JButton("+");
		bt_Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOperationPressed("+");
			}
		});
		bt_Plus.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_Plus = new GridBagConstraints();
		gbc_bt_Plus.fill = GridBagConstraints.BOTH;
		gbc_bt_Plus.insets = new Insets(0, 0, 5, 0);
		gbc_bt_Plus.gridx = 3;
		gbc_bt_Plus.gridy = 3;
		panel.add(bt_Plus, gbc_bt_Plus);
		
		//-----------------------------------------------------------------
		
		JButton bt_Equal = new JButton("=");
		bt_Equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = 0.0;
				if(operation != null) { //SI LA OPERACION ES NULA, NO HARA NADA EL BOTON IGUAL
					switch(operation){ //DEPENDIENDO QUE OPERACION LE DEMOS DEFINIRA UN RESULTADO U OTRO
					case "+":
						result = firstNumber + secondNumber;
						break;
					case "-":
						result = firstNumber - secondNumber;
						break;
					case "×":
						result = firstNumber * secondNumber;
						break;
					case "÷":
						result = firstNumber / secondNumber;
						break;
					}
				
					operation = null; //RESETEAMOS OPERACION UNA VEZ HECHO UNA
					firstNumber= Double.valueOf(result); //PRIMER NUMERO AHORA SERA EL RESULTADO OBTENIDO
					label1.setText(String.valueOf(result)); //IMPRIMIMOS EN EL LABEL EL RESULTADO
					try {
					 if(label1.getText().endsWith(".0")){ //SI TERMINA EN .0 LO QUITAMOS
						 label1.setText(label1.getText().replace(".0", ""));
					 }/*else { 
						 "%.2f".format(label1.setText(label1.getText())); 
					 }*/
					}catch(Exception e1) {
						e1.printStackTrace();
					 
					}
				}

			}
		});
		bt_Equal.setBackground(new Color(236, 165, 0));
		bt_Equal.setForeground(new Color(0, 0, 0));
		bt_Equal.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_bt_Equal = new GridBagConstraints();
		gbc_bt_Equal.gridwidth = 2;
		gbc_bt_Equal.fill = GridBagConstraints.BOTH;
		gbc_bt_Equal.gridx = 2;
		gbc_bt_Equal.gridy = 4;
		panel.add(bt_Equal, gbc_bt_Equal);
	}
	
	//-----------------------------------------------------------------
	
	public void clear(){ //METODO PARA REINICIAR VARIABLES CON EL BOTON C
	    label1.setText("0");
	    firstNumber = 0.0;
	    secondNumber = 0.0;
	}
	
	//-----------------------------------------------------------------
	
	public void onOperationPressed(String operation) { //METODO PARA CUANDO TECLEAMOS UNA OPERACION
		this.operation = operation; // LA OPERACION GLOBAL SERA LA OPERACION QUE LE PASEMOS A ESTE METODO
		firstNumber = Double.valueOf(label1.getText()); //PRIMER NUMERO EL QUE ESTA PUESTO AL TECLEAR LA OPERACION
		
		label1.setText("0"); //PONEMOS LABEL A 0
	}
	
	//-----------------------------------------------------------------
	
	public void renderText(String number) { //METODO PARA REFRESCAR O ACTUALIZAR EL LABEL
		String result = null;
		if(label1.getText() == "0" && number != ".") { //SI EL TEXTO ES 0 Y EL PARAMETRO QUE LE PASAMOS NO ES EL PUNTO
			result = number; //CAMBIAMOS EL 0 POR EL NUMERO
		}else {
			result = label1.getText() + number; //SI LE PASAMOS EL PUNTO Y HAY UN 0, ESTE SE PONDRA AL LADO DEL 0 
		}							// SI HAY NUMEROS QUE NO SEA EL 0 Y LE PASAMOS OTRO NUMERO, ESTE SE AÑADIRA A LA DERECHA DEL QUE YA HAY
		
		
		label1.setText(result); //IMPRIMIMOS EN EL LABEL
	}
	
	//-----------------------------------------------------------------
	
	public void checkOperation() { //METODO PARA SABER SI HAY UNA OPERACION O NO
		if(operation == null) { 
			firstNumber = Double.valueOf(label1.getText()); //EL PRIMER NUMERO SERA EL QUE ESTA EN EL LABEL
		}else { //SI NO ES NULA
			secondNumber = Double.valueOf(label1.getText()); // EL TEXTO ESCRITO EN EL LABEL SERA EL SEGUNDO NUMERO
		}
	}
	
}
