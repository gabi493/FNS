import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Botones extends JFrame{
	//CREAMOS LOS BOTONES
	JButton aceptar = new JButton("Aceptar");
	JButton cancelar = new JButton("Cancelar");

	//CREAMOS UN PANEL PARA COLOCAR LOS BOTONES
	JPanel principal = new JPanel(new BorderLayout());

	public Botones(){
		super("Botones");
		principal.add("North", aceptar);
		principal.add("South", cancelar);

		getContentPane().add(principal);

		//AGREGAMOS TOOL TIPS A LOS BOTONES
		aceptar.setToolTipText("Botón ACEPTAR...");
		cancelar.setToolTipText("Botón CANCELAR...");

		pack();
		setResizable(false); 
		Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();

		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
	}//FIN DEL CONSTRUCTOR DE LA CLASE

	public static void main(String g[]){
		Botones p = new Botones();
		p.show();

		p.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				System.exit(0);
			}
		});
	}//FIN DEL MAIN
}//FIN DE LA CLASE