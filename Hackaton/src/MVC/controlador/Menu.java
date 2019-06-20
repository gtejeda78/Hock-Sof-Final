/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.controlador;

import MVC.Usuario;
import static MVC.controlador.jfAlta.jlVersion;
import MVC.modelo.Bd;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

/**
 *
 * @author gftej
 */
public final class Menu extends javax.swing.JFrame {

    
    /**
     * Creates new form menu
     *
     * @param user
     */
    public Menu(Usuario user) {
        initComponents();
		
      //Crear un objeto de la clase Controller
        Bd bd= new Bd("hacksof");        
        ControllerMenu controlador;
		controlador = new ControllerMenu(this,bd,user);
        //Vincular la vista y el controlador
        this.conectaControlador(controlador);

        this.jbNuevoPregunta.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jbVerPreguntaU.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());		
		this.jbResponderPregunta.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());		
		this.jbVisualizarPreguntaA.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());		
		this.jbFinalizar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
		this.jbAsignarRespuesta.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
		
        
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaMensaje = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        PanelCliente = new javax.swing.JPanel();
        jbNuevoPregunta = new javax.swing.JButton();
        jbVerPreguntaU = new javax.swing.JButton();
        jbAsignarRespuesta = new javax.swing.JButton();
        PanelTarjeta = new javax.swing.JPanel();
        jbResponderPregunta = new javax.swing.JButton();
        jbVisualizarPreguntaA = new javax.swing.JButton();
        jbFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Hack-sof (\"Menu\")");

        etiquetaMensaje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        PanelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        PanelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones Usuario"));
        PanelCliente.setToolTipText("Acciones Usuario");

        jbNuevoPregunta.setText("Nueva pregunta");
        jbNuevoPregunta.setActionCommand("");
        jbNuevoPregunta.setPreferredSize(new java.awt.Dimension(119, 23));
        jbNuevoPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoPreguntaActionPerformed(evt);
            }
        });

        jbVerPreguntaU.setText("Visualizar preguntas");
        jbVerPreguntaU.setActionCommand("");
        jbVerPreguntaU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerPreguntaUActionPerformed(evt);
            }
        });

        jbAsignarRespuesta.setText("Valorar respuesta");
        jbAsignarRespuesta.setActionCommand("");
        jbAsignarRespuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAsignarRespuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelClienteLayout = new javax.swing.GroupLayout(PanelCliente);
        PanelCliente.setLayout(PanelClienteLayout);
        PanelClienteLayout.setHorizontalGroup(
            PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClienteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbNuevoPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbVerPreguntaU, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAsignarRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        PanelClienteLayout.setVerticalGroup(
            PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClienteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jbNuevoPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbVerPreguntaU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbAsignarRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelTarjeta.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones Asesores"));

        jbResponderPregunta.setText("Responder preguntas");
        jbResponderPregunta.setActionCommand("");

        jbVisualizarPreguntaA.setText("Visualizar preguntas");
        jbVisualizarPreguntaA.setActionCommand("");

        javax.swing.GroupLayout PanelTarjetaLayout = new javax.swing.GroupLayout(PanelTarjeta);
        PanelTarjeta.setLayout(PanelTarjetaLayout);
        PanelTarjetaLayout.setHorizontalGroup(
            PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTarjetaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbVisualizarPreguntaA, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbResponderPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PanelTarjetaLayout.setVerticalGroup(
            PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTarjetaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jbResponderPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbVisualizarPreguntaA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbFinalizar.setText("Finalizar");
        jbFinalizar.setActionCommand("");
        jbFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(PanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(PanelTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jbFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jbFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_splash/splash.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(etiquetaMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	    public void conectaControlador(ControllerMenu c) {

        jbNuevoPregunta.addActionListener(c);
        jbNuevoPregunta.setActionCommand("Nueva");

        jbVerPreguntaU.addActionListener(c);
        jbVerPreguntaU.setActionCommand("Visualizar");
		
		jbResponderPregunta.addActionListener(c);
        jbResponderPregunta.setActionCommand("Respuesta");
		
		jbVisualizarPreguntaA.addActionListener(c);
        jbVisualizarPreguntaA.setActionCommand("VisualizarR");
		
		jbAsignarRespuesta.addActionListener(c);
        jbAsignarRespuesta.setActionCommand("Asignar");
		

    }
		
    private void jbNuevoPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoPreguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbNuevoPreguntaActionPerformed

    private void jbFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarActionPerformed
        // TODO add your handling code here:
		System.gc();
        System.exit(0);
    }//GEN-LAST:event_jbFinalizarActionPerformed

    private void jbVerPreguntaUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerPreguntaUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbVerPreguntaUActionPerformed

    private void jbAsignarRespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAsignarRespuestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAsignarRespuestaActionPerformed


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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCliente;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTarjeta;
    public javax.swing.JLabel etiquetaMensaje;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JButton jbAsignarRespuesta;
    private javax.swing.JButton jbFinalizar;
    public javax.swing.JButton jbNuevoPregunta;
    public javax.swing.JButton jbResponderPregunta;
    public javax.swing.JButton jbVerPreguntaU;
    public javax.swing.JButton jbVisualizarPreguntaA;
    // End of variables declaration//GEN-END:variables
}