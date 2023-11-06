package igu.mprincipal;

//import com.mycompany.lestanitest.igu.PagoCuotas;
import igu.alumnos.VerDatosAlumno;
import igu.alumnos.VerNotas;
import igu.asignacion.AsignarMateriaAlumno;
import igu.asignacion.AsignarMateriasDocente;
import igu.asignacion.AsignarNotaAlumno;
import igu.docentes.VerDatosDocentes;
import igu.login.Login;
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

    public MenuPrincipalAutoridad(String rol) {
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
        Entidades = new javax.swing.JMenu();
        MenuAlumnos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenuTutores = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuDocentes = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MenuPersonal = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        MenuPersonal1 = new javax.swing.JMenuItem();
        Entidades1 = new javax.swing.JMenu();
        asignarMateriaDocente = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        AsignarMateriaAlumno = new javax.swing.JMenuItem();
        Entidades2 = new javax.swing.JMenu();
        CargarNotas = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        VerNotas = new javax.swing.JMenuItem();
        Entidades3 = new javax.swing.JMenu();
        AsignarMaterias2 = new javax.swing.JMenuItem();
        Entidades5 = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();

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
                        .addGap(510, 510, 510)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(620, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173)
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
        Entidades.add(jSeparator14);

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

        CargarNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CargarNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        CargarNotas.setText("Cargar nota");
        CargarNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CargarNotas.setPreferredSize(new java.awt.Dimension(142, 36));
        CargarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarNotasActionPerformed(evt);
            }
        });
        Entidades2.add(CargarNotas);
        Entidades2.add(jSeparator10);

        VerNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VerNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        VerNotas.setText("Ver Notas");
        VerNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerNotas.setPreferredSize(new java.awt.Dimension(142, 36));
        VerNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerNotasActionPerformed(evt);
            }
        });
        Entidades2.add(VerNotas);

        jMenuBar1.add(Entidades2);

        Entidades3.setForeground(new java.awt.Color(255, 255, 255));
        Entidades3.setText("Pagos");

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

        jMenuBar1.add(Entidades3);

        Entidades5.setForeground(new java.awt.Color(255, 255, 255));
        Entidades5.setText("Salir");

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
    private AsignarMateriaAlumno ventanaAsignarMatAlumno;
    private AsignarNotaAlumno ventanaCarga_Notas;
    private VerNotas ventanaVer_Notas;
    private Login ventanaLogin;
    private VerDatosTutor ventanaTutor;
    
    private void MenuAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAlumnosActionPerformed
        if (ventanaAlumnos == null || !ventanaAlumnos.isVisible()) {
            ventanaAlumnos = new VerDatosAlumno();
        }

        ventanaAlumnos.setVisible(true);
        ventanaAlumnos.toFront();
    }//GEN-LAST:event_MenuAlumnosActionPerformed
    
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

    private void CargarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarNotasActionPerformed
        /*if (ventanaCarga_Notas == null || !ventanaCarga_Notas.isVisible()) {
            ventanaCarga_Notas = new AsignarNotaAlumno();
        }

        ventanaCarga_Notas.setVisible(true);
        ventanaCarga_Notas.toFront();
        */
    }//GEN-LAST:event_CargarNotasActionPerformed

    private void AsignarMaterias2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMaterias2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AsignarMaterias2ActionPerformed

    private void VerNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerNotasActionPerformed
        if (ventanaVer_Notas == null || !ventanaVer_Notas.isVisible()) {
            ventanaVer_Notas = new VerNotas();
        }

        ventanaVer_Notas.setVisible(true);
        ventanaVer_Notas.toFront();
    }//GEN-LAST:event_VerNotasActionPerformed

    private void AsignarMateriaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMateriaAlumnoActionPerformed
        if (ventanaAsignarMatAlumno == null || !ventanaAsignarMatAlumno.isVisible()) {
            ventanaAsignarMatAlumno = new AsignarMateriaAlumno();
        }

        ventanaAsignarMatAlumno.setVisible(true);
        ventanaAsignarMatAlumno.toFront();
    }//GEN-LAST:event_AsignarMateriaAlumnoActionPerformed

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
                String rol = "autoridad";

                // Crear la instancia de VentanaPrincipal y mostrarla
                MenuPrincipalAutoridad ventanaPrincipal = new MenuPrincipalAutoridad(rol);
                ventanaPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AsignarMateriaAlumno;
    private javax.swing.JMenuItem AsignarMaterias2;
    private javax.swing.JMenuItem CargarNotas;
    private javax.swing.JMenu Entidades;
    private javax.swing.JMenu Entidades1;
    private javax.swing.JMenu Entidades2;
    private javax.swing.JMenu Entidades3;
    private javax.swing.JMenu Entidades5;
    private javax.swing.JMenuItem MenuAlumnos;
    private javax.swing.JMenuItem MenuDocentes;
    private javax.swing.JMenuItem MenuPersonal;
    private javax.swing.JMenuItem MenuPersonal1;
    private javax.swing.JMenuItem MenuTutores;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem VerNotas;
    private javax.swing.JMenuItem asignarMateriaDocente;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblRol;
    // End of variables declaration//GEN-END:variables
}
