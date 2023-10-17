
package igu.mprincipal;

import com.mycompany.lestanitest.igu.PagoCuotas;
import igu.alumnos.VerDatosAlumno;
import igu.asignacionAulas.Aulas_Materias;
import igu.docentes.VerDatosDocentes;
import igu.notas.BoletinNotas;
import igu.notas.CargarNotas;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Entidades = new javax.swing.JMenu();
        MenuAlumnos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuTutores = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuDocentes = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MenuPersonal = new javax.swing.JMenuItem();
        Cuotas = new javax.swing.JMenu();
        Horarios_Aulas = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        CargarNotas = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        BoletinNotas = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Centro Educativo - Menu Principal");
        setBackground(new java.awt.Color(51, 102, 255));
        setIconImages(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAutoscrolls(true);
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\lucia\\Descargas\\zyro-image-removebg-preview.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(676, 676, 676)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(716, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(273, 273, 273)
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
        Entidades.setText("Entidades");

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
        Entidades.add(menuTutores);
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

        jMenuBar1.add(Entidades);

        Cuotas.setForeground(new java.awt.Color(255, 255, 255));
        Cuotas.setText("Cuotas");
        Cuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuotasActionPerformed(evt);
            }
        });
        jMenuBar1.add(Cuotas);

        Horarios_Aulas.setForeground(new java.awt.Color(255, 255, 255));
        Horarios_Aulas.setText("Clases y Aulas");
        Horarios_Aulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Horarios_AulasActionPerformed(evt);
            }
        });
        jMenuBar1.add(Horarios_Aulas);

        jMenu6.setForeground(new java.awt.Color(255, 255, 255));
        jMenu6.setText("Notas");

        CargarNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CargarNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cliente.png"))); // NOI18N
        CargarNotas.setText("Cargar Notas");
        CargarNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CargarNotas.setPreferredSize(new java.awt.Dimension(96, 36));
        CargarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarNotasActionPerformed(evt);
            }
        });
        jMenu6.add(CargarNotas);
        jMenu6.add(jSeparator7);

        BoletinNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BoletinNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        BoletinNotas.setText("Boletin");
        BoletinNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BoletinNotas.setPreferredSize(new java.awt.Dimension(142, 36));
        BoletinNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoletinNotasActionPerformed(evt);
            }
        });
        jMenu6.add(BoletinNotas);

        jMenuBar1.add(jMenu6);

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
    private VerDatosTutor ventanaTutor;
    private VerDatosDocentes ventanaDocentes;
    private VerDatosPersonal ventanaPersonal;
    private PagoCuotas ventanaCuotas;
    private Aulas_Materias ventanaHorarios;
    private CargarNotas ventanaCarga_Notas;
    private BoletinNotas ventanaVer_Notas;
    
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
        // Verificar si la ventana ya está abierta
        if (ventanaTutor == null || !ventanaTutor.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaTutor = new VerDatosTutor();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaTutor.setVisible(true);
        ventanaTutor.toFront();
    }//GEN-LAST:event_menuTutoresActionPerformed
    private void MenuPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPersonalActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaPersonal == null || !ventanaPersonal.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaPersonal = new VerDatosPersonal();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaPersonal.setVisible(true);
        ventanaPersonal.toFront();
    }//GEN-LAST:event_MenuPersonalActionPerformed
    private void MenuDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDocentesActionPerformed
       // Verificar si la ventana ya está abierta
        if (ventanaDocentes == null || !ventanaDocentes.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaDocentes = new VerDatosDocentes();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaDocentes.setVisible(true);
        ventanaDocentes.toFront();
    }//GEN-LAST:event_MenuDocentesActionPerformed

    private void CargarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarNotasActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaCarga_Notas == null || !ventanaCarga_Notas.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaCarga_Notas = new CargarNotas();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaCarga_Notas.setVisible(true);
        ventanaCarga_Notas.toFront();
    }//GEN-LAST:event_CargarNotasActionPerformed

    private void BoletinNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoletinNotasActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaVer_Notas == null || !ventanaVer_Notas.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaVer_Notas = new BoletinNotas();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaVer_Notas.setVisible(true);
        ventanaVer_Notas.toFront();
    }//GEN-LAST:event_BoletinNotasActionPerformed

    private void Horarios_AulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Horarios_AulasActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaHorarios == null || !ventanaHorarios.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaHorarios = new Aulas_Materias();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaHorarios.setVisible(true);
        ventanaHorarios.toFront();
    }//GEN-LAST:event_Horarios_AulasActionPerformed

    private void CuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuotasActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaCuotas == null || !ventanaCuotas.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaCuotas = new PagoCuotas();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaCuotas.setVisible(true);
        ventanaCuotas.toFront();
    }//GEN-LAST:event_CuotasActionPerformed

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
    private javax.swing.JMenuItem BoletinNotas;
    private javax.swing.JMenuItem CargarNotas;
    private javax.swing.JMenu Cuotas;
    private javax.swing.JMenu Entidades;
    private javax.swing.JMenu Horarios_Aulas;
    private javax.swing.JMenuItem MenuAlumnos;
    private javax.swing.JMenuItem MenuDocentes;
    private javax.swing.JMenuItem MenuPersonal;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JMenuItem menuTutores;
    // End of variables declaration//GEN-END:variables
}
