package igu.mprincipal;

//import com.mycompany.lestanitest.igu.PagoCuotas;
import igu.alumnos.VerDatosAlumno;
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
public class MenuPrincipalAutoridad extends javax.swing.JFrame {

    private static MenuPrincipalAutoridad instancia;

    public MenuPrincipalAutoridad() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        instancia = this;

        //labelRol.setText("Rol del usuario: " + rolUsuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Entidades = new javax.swing.JMenu();
        MenuAlumnos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenuTutores = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuDocentes = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MenuPersonal = new javax.swing.JMenuItem();
        MenuPersonal1 = new javax.swing.JMenuItem();
        Entidades1 = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        asignarMateriaDocente = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        AsignarMateriaAlumno = new javax.swing.JMenuItem();
        Entidades2 = new javax.swing.JMenu();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        AsignarMaterias1 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        AsignarMaterias3 = new javax.swing.JMenuItem();
        Entidades3 = new javax.swing.JMenu();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        AsignarMaterias2 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        Entidades4 = new javax.swing.JMenu();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        AsignarMaterias4 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        Entidades5 = new javax.swing.JMenu();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        Salir = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();

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
                        .addGap(677, 677, 677)
                        .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(620, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(15, 80, 166));
        jMenuBar1.setBorder(null);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(505, 38));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(505, 40));

        Entidades.setForeground(new java.awt.Color(255, 255, 255));
        Entidades.setText("Crear Entidad");

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
        Entidades.add(MenuAlumnos);
        Entidades.add(jSeparator2);

        MenuTutores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuTutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        MenuTutores.setText("Tutores");
        MenuTutores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuTutores.setPreferredSize(new java.awt.Dimension(142, 36));
        MenuTutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTutoresActionPerformed(evt);
            }
        });
        Entidades.add(MenuTutores);
        Entidades.add(jSeparator3);

        MenuDocentes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuDocentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cliente.png"))); // NOI18N
        MenuDocentes.setText("Docentes");
        MenuDocentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuDocentes.setName("MenuDocentes"); // NOI18N
        MenuDocentes.setPreferredSize(new java.awt.Dimension(112, 36));
        MenuDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDocentesActionPerformed(evt);
            }
        });
        Entidades.add(MenuDocentes);
        Entidades.add(jSeparator4);

        MenuPersonal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/entrega-de-paquetes.png"))); // NOI18N
        MenuPersonal.setText("Personal");
        MenuPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuPersonal.setPreferredSize(new java.awt.Dimension(100, 36));
        MenuPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPersonalActionPerformed(evt);
            }
        });
        Entidades.add(MenuPersonal);

        MenuPersonal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuPersonal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/entrega-de-paquetes.png"))); // NOI18N
        MenuPersonal1.setText("Materias");
        MenuPersonal1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuPersonal1.setPreferredSize(new java.awt.Dimension(100, 36));
        MenuPersonal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPersonal1ActionPerformed(evt);
            }
        });
        Entidades.add(MenuPersonal1);

        jMenuBar1.add(Entidades);

        Entidades1.setForeground(new java.awt.Color(255, 255, 255));
        Entidades1.setText("Asignar Materias");
        Entidades1.add(jSeparator5);

        asignarMateriaDocente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        asignarMateriaDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        asignarMateriaDocente.setText("A docente");
        asignarMateriaDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignarMateriaDocente.setPreferredSize(new java.awt.Dimension(142, 36));
        asignarMateriaDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarMateriaDocenteActionPerformed(evt);
            }
        });
        Entidades1.add(asignarMateriaDocente);
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

        Entidades2.setForeground(new java.awt.Color(255, 255, 255));
        Entidades2.setText("Notas");
        Entidades2.add(jSeparator8);

        AsignarMaterias1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AsignarMaterias1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        AsignarMaterias1.setText("Cargar nota");
        AsignarMaterias1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AsignarMaterias1.setPreferredSize(new java.awt.Dimension(142, 36));
        AsignarMaterias1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMaterias1ActionPerformed(evt);
            }
        });
        Entidades2.add(AsignarMaterias1);
        Entidades2.add(jSeparator9);
        Entidades2.add(jSeparator10);

        AsignarMaterias3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AsignarMaterias3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        AsignarMaterias3.setText("Ver Notas");
        AsignarMaterias3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AsignarMaterias3.setPreferredSize(new java.awt.Dimension(142, 36));
        AsignarMaterias3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMaterias3ActionPerformed(evt);
            }
        });
        Entidades2.add(AsignarMaterias3);

        jMenuBar1.add(Entidades2);

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
        Entidades4.setText("Lista");
        Entidades4.add(jSeparator14);

        AsignarMaterias4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AsignarMaterias4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        AsignarMaterias4.setText("Alumnos");
        AsignarMaterias4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AsignarMaterias4.setPreferredSize(new java.awt.Dimension(142, 36));
        AsignarMaterias4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMaterias4ActionPerformed(evt);
            }
        });
        Entidades4.add(AsignarMaterias4);
        Entidades4.add(jSeparator15);
        Entidades4.add(jSeparator16);

        jMenuBar1.add(Entidades4);

        Entidades5.setForeground(new java.awt.Color(255, 255, 255));
        Entidades5.setText("Salir");
        Entidades5.add(jSeparator17);

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
        Entidades5.add(Salir);
        Entidades5.add(jSeparator18);
        Entidades5.add(jSeparator19);

        jMenuBar1.add(Entidades5);

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
    // private PagoCuotas ventanaCuotas;
    private AsignarMateriasDocente ventanaHorarios;
    //private CargarNotas ventanaCarga_Notas;
    private BoletinNotas ventanaVer_Notas;
    private Login ventanaLogin;

    private void MenuAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAlumnosActionPerformed
        if (ventanaAlumnos == null || !ventanaAlumnos.isVisible()) {
            ventanaAlumnos = new VerDatosAlumno();
        }

        ventanaAlumnos.setVisible(true);
        ventanaAlumnos.toFront();
    }//GEN-LAST:event_MenuAlumnosActionPerformed
    private VerDatosTutor ventanaTutor;
    private void MenuTutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTutoresActionPerformed
        if (ventanaTutor == null || !ventanaTutor.isVisible()) {
            ventanaTutor = new VerDatosTutor();
        }

        ventanaTutor.setVisible(true);
        ventanaTutor.toFront();
    }//GEN-LAST:event_MenuTutoresActionPerformed
    private void MenuPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPersonalActionPerformed

        ventanaPersonal = new VerDatosPersonal();

        ventanaPersonal.setVisible(true);
        ventanaPersonal.toFront();
    }//GEN-LAST:event_MenuPersonalActionPerformed
    private void MenuDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDocentesActionPerformed
        if (ventanaDocentes == null || !ventanaDocentes.isVisible()) {
            ventanaDocentes = new VerDatosDocentes();
        }

        ventanaDocentes.setVisible(true);
        ventanaDocentes.toFront();
    }//GEN-LAST:event_MenuDocentesActionPerformed

    private void asignarMateriaDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarMateriaDocenteActionPerformed
        if (ventanaHorarios == null || !ventanaHorarios.isVisible()) {
            ventanaHorarios = new AsignarMateriasDocente();
        }

        ventanaHorarios.setVisible(true);
        ventanaHorarios.toFront();
    }//GEN-LAST:event_asignarMateriaDocenteActionPerformed

    private void AsignarMaterias1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMaterias1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AsignarMaterias1ActionPerformed

    private void AsignarMaterias2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMaterias2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AsignarMaterias2ActionPerformed

    private void AsignarMaterias3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMaterias3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AsignarMaterias3ActionPerformed

    private void AsignarMateriaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMateriaAlumnoActionPerformed

    }//GEN-LAST:event_AsignarMateriaAlumnoActionPerformed

    private void AsignarMaterias4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMaterias4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AsignarMaterias4ActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        if (ventanaLogin == null || !ventanaLogin.isVisible()) {
            ventanaLogin = new Login();
        }

        ventanaLogin.setVisible(true);
        ventanaLogin.toFront();
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void MenuPersonal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPersonal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuPersonal1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // Crear la instancia de VentanaPrincipal y mostrarla
                MenuPrincipalAutoridad ventanaPrincipal = new MenuPrincipalAutoridad();
                ventanaPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AsignarMateriaAlumno;
    private javax.swing.JMenuItem AsignarMaterias1;
    private javax.swing.JMenuItem AsignarMaterias2;
    private javax.swing.JMenuItem AsignarMaterias3;
    private javax.swing.JMenuItem AsignarMaterias4;
    private javax.swing.JMenu Entidades;
    private javax.swing.JMenu Entidades1;
    private javax.swing.JMenu Entidades2;
    private javax.swing.JMenu Entidades3;
    private javax.swing.JMenu Entidades4;
    private javax.swing.JMenu Entidades5;
    private javax.swing.JMenuItem MenuAlumnos;
    private javax.swing.JMenuItem MenuDocentes;
    private javax.swing.JMenuItem MenuPersonal;
    private javax.swing.JMenuItem MenuPersonal1;
    private javax.swing.JMenuItem MenuTutores;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem asignarMateriaDocente;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel labelRol;
    // End of variables declaration//GEN-END:variables
}
