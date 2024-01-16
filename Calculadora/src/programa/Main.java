package programa;

import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.jtattoo.plaf.noire.NoireLookAndFeel;

import ventanas.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		try {
            JFrame.setDefaultLookAndFeelDecorated(true); //Decoracion
            Properties props = new Properties();
            props.put("logoString", "Calculadora");
            props.put("textAntiAliasingMode", "grey");
            props.put("dynamicLayout", "on");
            NoireLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel"); //Inserta el tema en la interfaz de usuario del proyecto
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		VentanaPrincipal frame = new VentanaPrincipal();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Calculator");
	}
}

