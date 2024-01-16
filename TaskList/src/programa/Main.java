package programa;

import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

import ventanas.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            Properties props = new Properties();
            props.put("logoString", "Lista de Tareas");
            props.put("textAntiAliasingMode", "grey");
            props.put("dynamicLayout", "on");
            McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		VentanaPrincipal frame = new VentanaPrincipal();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Lista de Tareas");
	}
}