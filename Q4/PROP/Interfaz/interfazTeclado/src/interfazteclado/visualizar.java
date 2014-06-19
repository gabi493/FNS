package interfazteclado;

import java.awt.*;
import java.awt.event.*;
import static java.lang.System.exit;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.Container;


public class visualizar extends JPanel implements ActionListener {
    String st;
    JButton buttonList[];
    //String buffer = "";
    //JTextField text;
    JButton backspace, spaceBar; 
    Initialize init = new Initialize();
    int columnas = 4;
    int filas = 2;
    JPanel teclas = new JPanel();
    
public void disposicion() {
    /*text = new JTextField(20);
    text.setActionCommand(""+ buffer);
    add(text);*/
    int n = st.length();
    buttonList = new JButton[n];    
    for (int i = 0; i < n; i++) {
        buttonList[i] = new JButton( "" + st.charAt(i) );
        teclas.add(buttonList[i]);
        buttonList[i].addActionListener(this);
    }
    spaceBar = new JButton("       ");
    teclas.add(spaceBar);
    spaceBar.addActionListener(this);

    backspace = new JButton("<------");
    teclas.add(backspace);
    backspace.addActionListener(this);
}
public void actionPerformed(ActionEvent e) {
    /*int n = st.length();
    if (e.getSource() == backspace) {
        buffer = buffer.substring(0,buffer.length()-1);
        text.setText("" + buffer);
    }
    else if (e.getSource() == spaceBar){
        buffer += " ";
    }
    else{
        for (int i = 0; i < n; i++){
            if (e.getSource() == buttonList[i]){
               buffer += st.toLowerCase().charAt(i);
              text.setText(""+ buffer);
             break;
            }
        }
    }*/
}

public visualizar(Initialize init, String disp, JPanel tec){
        this.st = disp;
        this.teclas = tec;
        this.init = init;   
  }
}
   