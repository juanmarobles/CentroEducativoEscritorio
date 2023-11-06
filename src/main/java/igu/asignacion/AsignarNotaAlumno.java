/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu.asignacion;

import igu.alumnos.NuevoAlumno;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import logica.EntidadesController;
import logica.TextPrompt;
import logica.entidades.Alumno;
import logica.entidades.Docente;
import logica.entidades.Materia;
import logica.entidades.ModeloAlumno;
import logica.entidades.ModeloDocente;
import logica.entidades.ModeloMateria;
import logica.entidades.Nota;
import logica.entidades.Tutor;

/**
 *
 * @author juanm
 */
public class AsignarNotaAlumno extends javax.swing.JFrame {

    EntidadesController control = new EntidadesController();
    TableRowSorter trs;
    private String nombreUsuario;
    private int idUsuario;

    /**
     * Creates new form AsignarNotaAlumno
     */
    public AsignarNotaAlumno(String nombreUsuario, int idUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        initComponents();
        cargarAlumnos(idUsuario);
        cargarMaterias();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btnAsignar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbAlumno = new javax.swing.JComboBox<>();
        cmbNota = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cmbMateria = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel19.setText("Alumno");

        btnAsignar.setBackground(new java.awt.Color(15, 80, 166));
        btnAsignar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnAsignar.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignar.setText("ASIGNAR");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel9.setText("Nota");

        cmbNota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel10.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel10.setText("Materia:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNota, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Asignar Nota");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(15, 80, 166));

        jLabel2.setFont(new java.awt.Font("Noto Sans Kannada", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html>\n\n<p>Centro</p>\n<p>Educativo</p>\n</html>");
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        Materia materia = (Materia) cmbMateria.getSelectedItem();
        String notaStr = (String) cmbNota.getSelectedItem();
        int nota = Integer.parseInt(notaStr);
        Alumno alumno = (Alumno) cmbAlumno.getSelectedItem();

        // Verifica si algún campo está vacío
        if (materia == null || alumno == null || nota < 1 || nota > 10) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de asignar la materia", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
        } else {
            // Todos los campos están completos, realiza la asignación de la materia
            control.asignarNotaAlumno(materia, alumno, nota);
            JOptionPane.showMessageDialog(this, "La materia se ha asignado correctamente", "Asignación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            // Actualizar la tabla

        }

    }//GEN-LAST:event_btnAsignarActionPerformed

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
            java.util.logging.Logger.getLogger(AsignarNotaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarNotaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarNotaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarNotaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AsignarNotaAlumno(" ").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JComboBox<Alumno> cmbAlumno;
    private javax.swing.JComboBox<Materia> cmbMateria;
    private javax.swing.JComboBox cmbNota;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
    //NOTAS

    private void cargarMaterias() {
        ModeloMateria modMaterias = new ModeloMateria();
        ArrayList<Materia> listaMaterias = modMaterias.getMaterias();

        // Crear una lista de materias únicas
        ArrayList<Materia> materiasUnicas = new ArrayList<>();

        for (Materia materia : listaMaterias) {
            if (!materiasUnicas.contains(materia)) {
                materiasUnicas.add(materia);
            }
        }

        // Ordenar la lista de materias alfabéticamente por nombre
        materiasUnicas.sort((materia1, materia2) -> materia1.getMateria().compareToIgnoreCase(materia2.getMateria()));

        // Limpiar el ComboBox
        cmbMateria.removeAllItems();

        // Agregar las materias únicas al ComboBox de forma ordenada
        for (Materia materia : materiasUnicas) {
            cmbMateria.addItem(materia);
        }

        // Eliminar la opción en blanco después de configurar el decorador
        cmbMateria.removeItem("");
        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cmbMateria.setSelectedIndex(-1);

        // Agregar ActionListener para capturar el evento "Enter"
        cmbMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si hay una materia seleccionada
                if (cmbMateria.getSelectedItem() != null) {
                    // Obtén el objeto Materia seleccionado
                    Materia materiaSeleccionada = materiasUnicas.get(cmbMateria.getSelectedIndex());

                    // Ahora puedes trabajar con la materiaSeleccionada
                } else {
                    mostrarMensaje("Por favor, selecciona una materia válida.", "Error", "Error de selección");
                }
            }
        });
    }

    private void cargarAlumnos(int idDocente) {
        cmbAlumno.setEditable(false);

        // Limpiar el ComboBox
        cmbAlumno.removeAllItems();

        // Obtén la lista de alumnos asignados al docente con el ID proporcionado
        List<Alumno> alumnosAsignados = control.obtenerAlumnosAsignadosPorId(idDocente);

        // Agregar los alumnos asignados al ComboBox
        for (Alumno alumno : alumnosAsignados) {
            cmbAlumno.addItem(alumno);
        }

        // Eliminar la opción en blanco después de configurar el decorador
        cmbAlumno.removeItem("");
        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cmbAlumno.setSelectedIndex(-1);

        // Agregar ActionListener para capturar el evento "Enter"
        cmbAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si hay un alumno seleccionado
                if (cmbAlumno.getSelectedItem() != null) {
                    // Obtén el objeto Alumno seleccionado
                    Alumno alumnoSeleccionado = (Alumno) cmbAlumno.getSelectedItem();

                    // Ahora puedes trabajar con el alumnoSeleccionado
                } else {
                    mostrarMensaje("Por favor, selecciona un alumno válido.", "Error", "Error de selección");
                }
            }
        });
    }

    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

}
