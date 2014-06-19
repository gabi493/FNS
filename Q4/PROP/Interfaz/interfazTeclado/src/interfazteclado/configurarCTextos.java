/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazteclado;

import java.io.File;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author josep
 */
public class configurarCTextos extends javax.swing.JFrame {
    alfabeto alfabetoElegido = new alfabeto();
    DefaultListModel modeloIzquierda = new DefaultListModel();
    DefaultListModel modeloDerecha = new DefaultListModel();
    //configurarAlfabeto cAlf = new configurarAlfabeto();
        

    
    Vector<String> ficheros = new Vector<String> ();
    
    Initialize ini = new Initialize();
    texto tSeleccionadoLista1 = new texto();
    texto tSeleccionadoLista2 = new texto();
    int index;
    int index2;

    
    public configurarCTextos() {
        initComponents();
    }
    
    public configurarCTextos(Initialize ini, alfabeto alfabetoElegido) {
        this.alfabetoElegido = alfabetoElegido;
        this.ini = ini;
        refreshLista();
        initComponents();
        repaint();
        validate();
    }
    
    public void setNewTexto(texto nuevo) {
        modeloIzquierda.addElement(nuevo);

    }
    
    public void vaciarLista() {
       modeloIzquierda.removeAllElements();
    }
    
    public void inicializarLista() {
        File f = new File("Textos");
        if (f.exists()) {
            File [] archivos = f.listFiles();
            for (int i = 0; i < archivos.length; i++) {
                ficheros.add(archivos[i].getName());
                texto t = new texto(alfabetoElegido.getNombreAlfabeto(), archivos[i].getName(), archivos[i].getAbsolutePath());
                setNewTexto(t);
            }
            repaint();
            validate();           
        }
    }
    
    public void refreshLista() {
        vaciarLista();
        inicializarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lConfigurar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        try {
            listaIzquierda =(javax.swing.JList)java.beans.Beans.instantiate(getClass().getClassLoader(), "interfazteclado.configurarCTextos_listaIzquierda");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        listaIzquierda = new JList(modeloIzquierda);
        jScrollPane2 = new javax.swing.JScrollPane();
        try {
            listaDerecha =(javax.swing.JList)java.beans.Beans.instantiate(getClass().getClassLoader(), "interfazteclado.configurarCTextos_listaDerecha");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        listaDerecha = new JList(modeloDerecha);
        bAnadir = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();
        bNuevoTexto = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lConfigurar.setText("Configurar Conjunto de Textos");

        jLabel1.setText("Lista");

        jLabel2.setText("Textos seleccionados");

        listaIzquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaIzquierdaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaIzquierda);

        listaDerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaDerechaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaDerecha);

        bAnadir.setText("Añadir");
        bAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnadirActionPerformed(evt);
            }
        });

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bAtras.setText("Atrás");
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        bNuevoTexto.setText("Nuevo Texto");
        bNuevoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoTextoActionPerformed(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bNuevoTexto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bAnadir)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bAceptar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(bEliminar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lConfigurar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(94, 94, 94))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lConfigurar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAnadir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bAceptar)
                            .addComponent(bAtras)
                            .addComponent(bNuevoTexto)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        // TODO add your handling code here:
        //formaTeclado formaT = new formaTeclado(configurarCTextos.this);
        //formaT.setVisible(true);
        configurarCTextos.this.setVisible(false);
        ini.setVisible(true);
        
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bNuevoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoTextoActionPerformed
        configurarCTextos.this.setVisible(false);
        nuevoTexto nTexto = new nuevoTexto(configurarCTextos.this);
        nTexto.setVisible(true);
    }//GEN-LAST:event_bNuevoTextoActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        // TODO add your handling code here:
        configurarCTextos.this.setVisible(false);
        ini.setVisible(true);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void listaIzquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaIzquierdaMouseClicked
        // TODO add your handling code here:
        index = listaIzquierda.getSelectedIndex();
        tSeleccionadoLista1 = (texto)modeloIzquierda.getElementAt(index);
        //lAlfabetoElegido.setText(alfabetoElegido.getNombreAlfabeto());   
    }//GEN-LAST:event_listaIzquierdaMouseClicked

    private void listaDerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaDerechaMouseClicked
        // TODO add your handling code here:
        index2 = listaDerecha.getSelectedIndex();
        tSeleccionadoLista2 = (texto)modeloDerecha.getElementAt(index2);
    }//GEN-LAST:event_listaDerechaMouseClicked

    private void bAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirActionPerformed
        // TODO add your handling code here:
        modeloDerecha.addElement(tSeleccionadoLista1);
        modeloIzquierda.removeElementAt(index);
    }//GEN-LAST:event_bAnadirActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        modeloIzquierda.addElement(tSeleccionadoLista2);
        modeloDerecha.removeElementAt(index2);
    }//GEN-LAST:event_bEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(configurarCTextos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(configurarCTextos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(configurarCTextos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(configurarCTextos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new configurarCTextos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAnadir;
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bNuevoTexto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lConfigurar;
    private javax.swing.JList listaDerecha;
    private javax.swing.JList listaIzquierda;
    // End of variables declaration//GEN-END:variables
}
