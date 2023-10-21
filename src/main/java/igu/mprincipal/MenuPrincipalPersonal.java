
package igu.mprincipal;

//import com.mycompany.lestanitest.igu.PagoCuotas;
import igu.alumnos.VerDatosAlumno;
import igu.asignacion.AsignarMateriaAlumno;
import igu.asignacion.AsignarMateriasDocente;
import igu.docentes.VerDatosDocentes;
import igu.login.Login;
import igu.notas.BoletinNotas;
//import igu.notas.CargarNotas;
import igu.personal.VerDatosPersonal;
import igu.tutores.VerDatosTutor;
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
public class MenuPrincipalPersonal extends javax.swing.JFrame {
    
    
    private static MenuPrincipalPersonal instancia;
  
 public MenuPrincipalPersonal(String rol) {
        initComponents();
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        instancia = this;
        
        lblRol.setText("Ingreso como: " + rol);
        //labelRol.setText("Rol del usuario: " + rolUsuario);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Entidades1 = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        AsignarMateriaAlumno = new javax.swing.JMenuItem();
        Entidades3 = new javax.swing.JMenu();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        AsignarMaterias2 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        Entidades4 = new javax.swing.JMenu();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        Salir = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Centro Educativo - Menu Principal");
        setBackground(new java.awt.Color(51, 102, 255));
        setIconImages(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAutoscrolls(true);
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1080));

        labelRol.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl.setText("Bienvenido");

        lblRol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(772, 772, 772)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(343, 343, 343)
                        .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(620, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(148, 148, 148)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(15, 80, 166));
        jMenuBar1.setBorder(null);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(505, 38));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(505, 40));

        Entidades1.setForeground(new java.awt.Color(255, 255, 255));
        Entidades1.setText("Asignar Materias");
        Entidades1.add(jSeparator5);
        Entidades1.add(jSeparator6);
        Entidades1.add(jSeparator7);

        AsignarMateriaAlumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AsignarMateriaAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        AsignarMateriaAlumno.setText("Alumno");
        AsignarMateriaAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AsignarMateriaAlumno.setPreferredSize(new java.awt.Dimension(142, 36));
        AsignarMateriaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMateriaAlumnoActionPerformed(evt);
            }
        });
        Entidades1.add(AsignarMateriaAlumno);

        jMenuBar1.add(Entidades1);

        Entidades3.setForeground(new java.awt.Color(255, 255, 255));
        Entidades3.setText("Pagos");
        Entidades3.add(jSeparator11);

        AsignarMaterias2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AsignarMaterias2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        AsignarMaterias2.setText("Asignar pago");
        AsignarMaterias2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AsignarMaterias2.setPreferredSize(new java.awt.Dimension(142, 36));
        AsignarMaterias2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMaterias2ActionPerformed(evt);
            }
        });
        Entidades3.add(AsignarMaterias2);
        Entidades3.add(jSeparator12);
        Entidades3.add(jSeparator13);

        jMenuBar1.add(Entidades3);

        Entidades4.setForeground(new java.awt.Color(255, 255, 255));
        Entidades4.setText("Salir");
        Entidades4.add(jSeparator14);

        Salir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        Salir.setText("Deslogear");
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.setPreferredSize(new java.awt.Dimension(142, 36));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Entidades4.add(Salir);
        Entidades4.add(jSeparator15);
        Entidades4.add(jSeparator16);

        jMenuBar1.add(Entidades4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private VerDatosAlumno ventanaAlumnos;
    private VerDatosDocentes ventanaDocentes;
    private VerDatosPersonal ventanaPersonal;
     private Login ventanaLogin;
   // private PagoCuotas ventanaCuotas;
    private AsignarMateriaAlumno ventanaMaterias;
    //private CargarNotas ventanaCarga_Notas;
    private BoletinNotas ventanaVer_Notas;
        private VerDatosTutor ventanaTutor;
    private void AsignarMaterias2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMaterias2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AsignarMaterias2ActionPerformed

    private void AsignarMateriaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMateriaAlumnoActionPerformed
          if (ventanaMaterias == null || !ventanaMaterias.isVisible()) {
            ventanaMaterias = new AsignarMateriaAlumno();
        }

        ventanaMaterias.setVisible(true);
        ventanaMaterias.toFront();
    }//GEN-LAST:event_AsignarMateriaAlumnoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        if (ventanaLogin == null || !ventanaLogin.isVisible()) {
            ventanaLogin = new Login();
        }

        ventanaLogin.setVisible(true);
        ventanaLogin.toFront();
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                    String rol = "personal";
                // Crear la instancia de VentanaPrincipal y mostrarla
                MenuPrincipalPersonal ventanaPrincipal = new MenuPrincipalPersonal(rol);
                ventanaPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AsignarMateriaAlumno;
    private javax.swing.JMenuItem AsignarMaterias2;
    private javax.swing.JMenu Entidades1;
    private javax.swing.JMenu Entidades3;
    private javax.swing.JMenu Entidades4;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblRol;
    // End of variables declaration//GEN-END:variables
}
