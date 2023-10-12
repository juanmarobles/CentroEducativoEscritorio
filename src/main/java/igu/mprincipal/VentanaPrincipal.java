
package igu.mprincipal;

import igu.alumnos.VerDatosAlumno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author Usuario
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private static VentanaPrincipal instancia;
  
 public VentanaPrincipal() {
        initComponents();
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        instancia = this;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        MenuAlumnos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuTutores = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuVehiculos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MenuServicios = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Centro Educativo - Menu Principal");
        setBackground(new java.awt.Color(51, 102, 255));
        setIconImages(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo de pantalla.png"))); // NOI18N

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(505, 38));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(505, 40));

        jMenu3.setText("Cargar Entidades");

        MenuAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cliente.png"))); // NOI18N
        MenuAlumnos.setText("Alumnos");
        MenuAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAlumnos.setPreferredSize(new java.awt.Dimension(96, 36));
        MenuAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAlumnosActionPerformed(evt);
            }
        });
        jMenu3.add(MenuAlumnos);
        jMenu3.add(jSeparator2);

        menuTutores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuTutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        menuTutores.setText("Tutores");
        menuTutores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuTutores.setPreferredSize(new java.awt.Dimension(142, 36));
        menuTutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTutoresActionPerformed(evt);
            }
        });
        jMenu3.add(menuTutores);
        jMenu3.add(jSeparator3);

        MenuVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cliente.png"))); // NOI18N
        MenuVehiculos.setText("Docentes");
        MenuVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuVehiculos.setPreferredSize(new java.awt.Dimension(112, 36));
        MenuVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVehiculosActionPerformed(evt);
            }
        });
        jMenu3.add(MenuVehiculos);
        jMenu3.add(jSeparator4);

        MenuServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/entrega-de-paquetes.png"))); // NOI18N
        MenuServicios.setText("Personal");
        MenuServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuServicios.setPreferredSize(new java.awt.Dimension(100, 36));
        MenuServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuServiciosActionPerformed(evt);
            }
        });
        jMenu3.add(MenuServicios);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private VerDatosAlumno ventanaAlumnos;
    private void MenuAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAlumnosActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaAlumnos == null || !ventanaAlumnos.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaAlumnos = new VerDatosAlumno();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaAlumnos.setVisible(true);
        ventanaAlumnos.toFront();
    }//GEN-LAST:event_MenuAlumnosActionPerformed
    
    private void menuTutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTutoresActionPerformed
        
    }//GEN-LAST:event_menuTutoresActionPerformed
    private void MenuServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuServiciosActionPerformed
        
    }//GEN-LAST:event_MenuServiciosActionPerformed
    private void MenuVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVehiculosActionPerformed
       

    }//GEN-LAST:event_MenuVehiculosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                // Crear la instancia de VentanaPrincipal y mostrarla
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAlumnos;
    private javax.swing.JMenuItem MenuServicios;
    private javax.swing.JMenuItem MenuVehiculos;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem menuTutores;
    // End of variables declaration//GEN-END:variables
}
