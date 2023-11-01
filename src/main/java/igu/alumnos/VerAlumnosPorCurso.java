/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu.alumnos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import logica.EntidadesController;
import logica.entidades.Alumno;
import logica.entidades.Aula;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import logica.entidades.ModeloAula;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.JTable;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;

/**
 *
 * @author juanm
 */
public class VerAlumnosPorCurso extends javax.swing.JFrame {

    EntidadesController control;

    /**
     * Creates new form VerAlumnosPorCurso
     */
    public VerAlumnosPorCurso() {
        control = new EntidadesController();

        initComponents();
        cargarAulas();
        mostrarTablaAulas();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAulas = new javax.swing.JTable();
        btnGenerarPdf = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cmbAula = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        tablaAulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaAulas);

        btnGenerarPdf.setText("PDF");
        btnGenerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnGenerarPdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(332, 332, 332))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnGenerarPdf)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Ver Alumnos por Curso");

        jLabel22.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel22.setText("Curso");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mostrarTablaAulas();
    }//GEN-LAST:event_formWindowOpened

    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
        generarPdf();
    }//GEN-LAST:event_btnGenerarPdfActionPerformed

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
            java.util.logging.Logger.getLogger(VerAlumnosPorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAlumnosPorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAlumnosPorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAlumnosPorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerAlumnosPorCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JComboBox<Aula> cmbAula;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAulas;
    // End of variables declaration//GEN-END:variables

    private void mostrarTablaAulas() {
        List<Aula> listaAulas = control.traerAulas();
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Aula", "Alumno"};
        tabla.setColumnIdentifiers(titulos);

        if (listaAulas != null) {
            for (Aula a : listaAulas) {
                Object[] objeto = {};
                tabla.addRow(objeto);
            }
        } else {
            System.out.println("El objeto Alumno seleccionado o la lista de notas es nula.");
        }

        tablaAulas.setModel(tabla);
    }

    private void cargarAulas() {

        ModeloAula modAula = new ModeloAula();
        ArrayList<Aula> listaAulas = modAula.getAulas();

        cmbAula.setEditable(false);

        // Limpiar el ComboBox
        cmbAula.removeAllItems();

        ArrayList<Aula> aulasUnicas = new ArrayList<>();

        for (Aula aula : listaAulas) {
            if (!aulasUnicas.contains(aula)) {
                aulasUnicas.add(aula);
            }
        }

        // Limpiar el ComboBox
        cmbAula.removeAllItems();

        // Agregar aulas al ComboBox de forma ordenada
        for (Aula aula : aulasUnicas) {
            cmbAula.addItem(aula);
        }
        // Agregar ActionListener para capturar el evento de selección de alumno
        cmbAula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aula aulaSeleccionado = (Aula) cmbAula.getSelectedItem();
                if (aulaSeleccionado != null) {
                    mostrarTablaAulas(aulaSeleccionado);
                }
            }
        });

    }

    private void mostrarTablaAulas(Aula aulaSeleccionado) {
        //System.out.println("Aula seleccionada: " + aulaSeleccionado); // Verificar que se haya seleccionado el aula correctamente

        List<Alumno> listaAlumnos = control.traerAlumnosPorAula(aulaSeleccionado);
        //System.out.println("Cantidad de alumnos encontrados: " + listaAulas.size()); // Verificar cuántos alumnos se han recuperado

        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Aula", "Alumno", "Legajo"};
        tabla.setColumnIdentifiers(titulos);
        if (listaAlumnos != null) {
            for (Alumno alumno : listaAlumnos) {
                Object[] objeto = {aulaSeleccionado.getAula(), alumno.getNombre() +" "+ alumno.getApellido(), alumno.getId()}; // Ajusta el campo para mostrar el nombre del alumno
                tabla.addRow(objeto);
            }
        } else {
            System.out.println("La lista de alumnos asignados al aula es nula.");
        }

        tablaAulas.setModel(tabla);
    }

    private void generarPdf() {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        JTable tabla = new JTable();

        try {
            String nombreArchivo = "AlumnosPorCurso.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));

            document.open();

            // LOGO
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logoeducativo.jpg");
            Image logo = Image.getInstance(ImageIO.read(logoStream), null);
            logo.scaleToFit(100, 100);
            logo.setAlignment(Element.ALIGN_LEFT);
            document.add(logo);

            // Agregar la división en el extremo superior derecho
            Paragraph division = new Paragraph("División: " + cmbAula.getSelectedItem(), new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD));
            division.setAlignment(Element.ALIGN_RIGHT);
            document.add(division);

            // Crear una tabla para mostrar los datos
            PdfPTable pdfTabla = new PdfPTable(3); // 4 columnas para Aula, Nombre, Apellido, Legajo
            pdfTabla.setWidthPercentage(100);

            // Agregar los encabezados
            pdfTabla.addCell(new Phrase("Aula", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
            pdfTabla.addCell(new Phrase("Alumno", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
            pdfTabla.addCell(new Phrase("Legajo", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));

            // Agregar los datos de la tabla
            for (int i = 0; i < tablaAulas.getRowCount(); i++) {
                for (int j = 0; j < tablaAulas.getColumnCount(); j++) {
                    pdfTabla.addCell(tablaAulas.getModel().getValueAt(i, j).toString());
                }
            }

            document.add(pdfTabla);

            // Obtén la fecha actual en el formato "día/mes/año"
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = "Fecha: " + formatoFecha.format(new Date());

            // Agregar la fecha en el pie de página
            Paragraph fecha = new Paragraph(fechaActual, new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD));
            fecha.setAlignment(Element.ALIGN_RIGHT);
            document.add(fecha);

            // Agregar el total de alumnos al pie de página
            String totalAlumnos = "Total de Alumnos: " + tablaAulas.getRowCount();
            Paragraph total = new Paragraph(totalAlumnos, new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD));
            total.setAlignment(Element.ALIGN_CENTER);
            document.add(total);

            document.close();
            // Abrir el archivo PDF generado
            Desktop.getDesktop().open(new File(nombreArchivo));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
