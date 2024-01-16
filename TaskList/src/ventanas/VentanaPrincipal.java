package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private DefaultListModel model = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("Lista de Tareas");
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
		setBounds(100, 100, 316, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(10, 75, 280, 269);
		list.setModel(model);
		contentPane.add(list);
		
		JLabel lb_titulo = new JLabel("TAREAS");
		lb_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_titulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lb_titulo.setBounds(71, 0, 167, 39);
		contentPane.add(lb_titulo);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER && !textField.getText().equalsIgnoreCase("")){
					String texto = textField.getText();
					model.addElement(texto);
					textField.setText("");
				}
					
			}
		});
		textField.setBounds(10, 44, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton bt_añadir = new JButton("Añadir");
		bt_añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				model.addElement(texto);
				textField.setText("");
			}
		});
	
		bt_añadir.setBounds(199, 43, 91, 23);
		contentPane.add(bt_añadir);
		
		JButton bt_completado = new JButton("Completar");
		bt_completado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int item = list.getSelectedIndex();
				if(item != -1) {
					String texto = (String) model.getElementAt(item);
					texto = "<html><strike><i>" + texto + "</i></strike></html>";
					model.setElementAt(texto, item);
				}
			}
		});
		bt_completado.setBounds(10, 355, 128, 23);
		contentPane.add(bt_completado);
		
		JButton bt_borrar = new JButton("Borrar");
		bt_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int item = list.getSelectedIndex();
					if(item != -1) {
						model.remove(item);
					}
			}
		});
		bt_borrar.setBounds(162, 355, 128, 23);
		contentPane.add(bt_borrar);
	}
}
