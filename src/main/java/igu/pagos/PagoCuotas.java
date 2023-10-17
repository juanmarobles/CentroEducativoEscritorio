package com.mycompany.lestanitest.igu;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloMovimientos;
import com.mycompany.lestanitest.logica.Movimientos;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.ModeloCliente;
import com.mycompany.lestanitest.logica.ModeloRepresentante;
import com.mycompany.lestanitest.logica.Representantes;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PrinterName;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class PagoCuotas extends javax.swing.JFrame {

    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Controladora control = new Controladora();
    TableRowSorter trs;
    DefaultTableModel tabla = new DefaultTableModel();
    private Cliente cliente;
    private SimpleDateFormat sdf;
    private String montoTotalImpreso;
    private String fleteTotalImpreso;
    //Nuevo
    // private List<Movimientos> listaFiltrada;
    
    private boolean botonMostrarPresionado = false;
   

    public PagoCuotas() {
        initComponents();
        mostrarTablaMovimientos(control.traerMovimientos());
        cargarClientes();
        cargarOrigen();
        cargarDestino();
        cargarRepresentantes();
        
          //FECHA
       // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Mostrar la fecha actual en los campos de texto correspondientes
        txtDiaH.setText(String.valueOf(fechaActual.getDayOfMonth()));
        txtMesH.setText(String.valueOf(fechaActual.getMonthValue()));
        txtAnioH.setText(String.valueOf(fechaActual.getYear()));
        

        // Mostrar la fecha actual en los campos de texto correspondientes
        txtDiaD.setText(String.valueOf(fechaActual.getDayOfMonth()));
        txtMesD.setText(String.valueOf(fechaActual.getMonthValue()));
        txtAnioD.setText(String.valueOf(fechaActual.getYear()));
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Borde al seleccionar TEXFIELD
        SwingUtilities.invokeLater(() -> {
            // Define el borde de enfoque
            Border normalBorder = txtDiaD.getBorder();
            Border focusBorder = new LineBorder(Color.BLUE, 3);

            FocusAdapter focusAdapter = new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    ((JComponent) e.getComponent()).setBorder(focusBorder);
                    if (e.getComponent() instanceof JTextField) {
                        ((JTextField) e.getComponent()).selectAll();
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    ((JComponent) e.getComponent()).setBorder(normalBorder);
                }
            };
            txtDiaD.addFocusListener(focusAdapter);
            txtMesD.addFocusListener(focusAdapter);
            txtAnioD.addFocusListener(focusAdapter);
            txtDiaH.addFocusListener(focusAdapter);
            txtMesH.addFocusListener(focusAdapter);
            txtAnioH.addFocusListener(focusAdapter);
        });
        
        
        
        //Combobox Seleccion
        ComboBoxStyle(cbClientes);
        ComboBoxStyle(cbRepresentantes);
        ComboBoxStyle(cbOrigen);
        ComboBoxStyle(cbDestinos);
        
        
        txtTotalMonto.setEditable(false);
        txtTotalFlete.setEditable(false);
        txtCantBultos.setEditable(false);
        
        // Listener al mause para editar con doble click el movimiento.
        tablaConsultas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // Acción a realizar cuando se haga doble clic en un elemento de la tabla
                    int filaSeleccionada = tablaConsultas.getSelectedRow();
                    int id = (int) tablaConsultas.getValueAt(filaSeleccionada, 0);
                    // Realizar la acción deseada con el ID obtenido
                    System.out.println("ID seleccionado: " + id);
                    EditarMovimientos editar = new EditarMovimientos(id);
                    editar.setVisible(true);
                    editar.setLocationRelativeTo(null);

                }
            }
        });
        
        //Listener para evitar que pongan letras en Fletes
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                char c = e.getKeyChar();

                // Verificar si el carácter no es un número o un punto
                if (!Character.isDigit(c) && c != '.') {
                    // Mostrar una alerta solo si la cadena no contiene solo números y puntos

                    if (!textField.getText().matches("[\\d.]*")) {
                        JOptionPane.showMessageDialog(null, "Solo se permiten números y puntos decimales.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Consumir el evento para evitar que el carácter se ingrese en el JTextField
                    e.consume();
                }
            }
        };

        txtFleteCambio.addKeyListener(keyListener);

        // Agregar evento de selección a la tabla
        tablaConsultas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtener los índices de las filas seleccionadas
                    int[] selectedRows = tablaConsultas.getSelectedRows();
                    List<Movimientos> movimientosFiltrados = control.traerMovimientos();

                    // Calcular y actualizar el total de montos de los elementos seleccionados
                    calcularTotalMonto(movimientosFiltrados, selectedRows);
                    calcularTotalFlete(movimientosFiltrados, selectedRows);
                    calcularTotalBultos(movimientosFiltrados, selectedRows);

                }
            }
        });

    }

    ModeloCliente modClientes = new ModeloCliente();
    ArrayList<Cliente> listaClientes = modClientes.getClientes();

   private static void mostrarResultadosBusqueda(JComboBox<String> combobox, String textoBusqueda) {
    // Limpiar selección previa
    combobox.setSelectedIndex(-1);

    // Buscar resultados de búsqueda exacta
    boolean encontradoExacta = false;

    for (int i = 0; i < combobox.getItemCount(); i++) {
        String item = combobox.getItemAt(i).toString();
        if (item.equalsIgnoreCase(textoBusqueda)) {
            combobox.setSelectedItem(item);
            combobox.getEditor().setItem(item);
            encontradoExacta = true;
            break; // Terminar la búsqueda cuando se encuentra una coincidencia exacta
        }
    }

    // Si no se encontró una coincidencia exacta, buscar coincidencias parciales
    if (!encontradoExacta) {
        boolean encontradoParcial = false;
        for (int i = 0; i < combobox.getItemCount(); i++) {
            String item = combobox.getItemAt(i).toString();
            if (item.toLowerCase().contains(textoBusqueda.toLowerCase())) {
                combobox.setSelectedIndex(i);
                combobox.getEditor().setItem(item);
                encontradoParcial = true;
                break; // Terminar la búsqueda cuando se encuentra una coincidencia parcial
            }
        }

        // Si no se encontró ninguna coincidencia parcial, mostrar el desplegable
        if (!encontradoParcial) {
            combobox.setPopupVisible(true);
            combobox.getEditor().setItem(textoBusqueda); // Deja el ComboBox con el texto de búsqueda
        }
    }
}

    private void cargarClientes() {
         ModeloCliente modClientes = new ModeloCliente();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();

        cbClientes.setEditable(true);

        // Ordenar la lista de clientes alfabéticamente por el nombre
        listaClientes.sort((cliente1, cliente2) -> cliente1.getNombre().compareToIgnoreCase(cliente2.getNombre()));

        // Agregar los clientes al combobox
        for (Cliente cliente : listaClientes) {
            cbClientes.addItem(cliente.getNombre());
        }

        // Eliminar la opción en blanco después de configurar el decorador
        cbClientes.removeItem("");

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbClientes.setSelectedIndex(-1);

        cbClientes.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    String textoBusqueda = cbClientes.getEditor().getItem().toString();

                    // Normaliza el texto de búsqueda a mayúsculas y elimina caracteres no deseados excepto espacios en blanco
                    textoBusqueda = textoBusqueda.toUpperCase().replaceAll("[^A-ZÑñ.\\s]", "");

                    mostrarResultadosBusqueda(cbClientes, textoBusqueda);

                    // Busca el cliente seleccionado en la lista de clientes
                    cliente = null; // Restablece el destinatario seleccionado

                    for (Cliente clientes : listaClientes) {
                        // Normaliza el nombre del cliente a mayúsculas y elimina caracteres no deseados excepto espacios en blanco
                        String nombreCliente = clientes.getNombre().toUpperCase().replaceAll("[^A-ZÑñ.\\s]", "");

                        if (nombreCliente.contains(textoBusqueda)) {
                            cliente = clientes;
                            System.out.println("Destinatario seleccionado: " + cliente);
                            break;
                        }
                    }

                    if (cliente == null) {
                        System.out.println("No se encontró Cliente.");
                    }
                }
            }
        });
    }

    private void cargarDestino() {
         ModeloCliente modClientes = new ModeloCliente();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();

        cbDestinos.setEditable(true);

         // Ordenar la lista de clientes alfabéticamente por el nombre
        listaClientes.sort((cliente1, cliente2) -> cliente1.getNombre().compareToIgnoreCase(cliente2.getNombre()));

        // Agregar los clientes al combobox
        for (Cliente cliente : listaClientes) {
            cbDestinos.addItem(cliente.getNombre());
        }

        // Eliminar la opción en blanco después de configurar el decorador
        cbDestinos.removeItem("");

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbDestinos.setSelectedIndex(-1);

        cbDestinos.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    String textoBusqueda = cbDestinos.getEditor().getItem().toString();

                    // Normaliza el texto de búsqueda a mayúsculas y elimina caracteres no deseados excepto espacios en blanco
                    textoBusqueda = textoBusqueda.toUpperCase().replaceAll("[^A-ZÑñ.\\s]", "");

                    mostrarResultadosBusqueda(cbDestinos, textoBusqueda);                  
                }
            }
        });
    }

    private void cargarOrigen() {
        cbOrigen.setEditable(true);
        // Ordenar la lista de clientes alfabéticamente por el nombre
        listaClientes.sort((cliente1, cliente2) -> cliente1.getNombre().compareToIgnoreCase(cliente2.getNombre()));

        // Agregar los clientes al combobox
        for (Cliente cliente : listaClientes) {
            cbOrigen.addItem(cliente.getNombre());
        }

        // Eliminar la opción en blanco después de configurar el decorador
        cbOrigen.removeItem("");

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbOrigen.setSelectedIndex(-1);

        cbOrigen.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    String textoBusqueda = cbOrigen.getEditor().getItem().toString();

                    // Normaliza el texto de búsqueda a mayúsculas y elimina caracteres no deseados excepto espacios en blanco
                    textoBusqueda = textoBusqueda.toUpperCase().replaceAll("[^A-ZÑñ.\\s]", "");

                    mostrarResultadosBusqueda(cbOrigen, textoBusqueda);                  
                }
            }
        });
    }

    private void cargarRepresentantes() {
        ModeloRepresentante modRepre = new ModeloRepresentante();
        ArrayList<Representantes> listaRepresentantes = modRepre.getRepresentantes();
        
        cbRepresentantes.setEditable(true);
        
         // Ordenar la lista de clientes alfabéticamente por el nombre
        listaRepresentantes.sort((representante1, representante2) -> representante1.getNombre().compareToIgnoreCase(representante2.getNombre()));
        
        
        // Agregar los clientes al combobox
        for (Representantes Repre : listaRepresentantes) {
            cbRepresentantes.addItem(Repre.getNombre());
        }
        

// Eliminar la opción en blanco después de configurar el decorador
        cbRepresentantes.removeItem("");

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbRepresentantes.setSelectedIndex(-1);

        // Agregar ActionListener para capturar el evento "Enter"
        cbRepresentantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = cbRepresentantes.getEditor().getItem().toString();
                mostrarResultadosBusqueda(cbRepresentantes, textoBusqueda);
            }
        });

        // Agregar KeyListener para capturar el evento "Enter"
        cbRepresentantes.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String textoBusqueda = cbRepresentantes.getEditor().getItem().toString();
                    mostrarResultadosBusqueda(cbRepresentantes, textoBusqueda);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo2 = new javax.swing.ButtonGroup();
        Grupo1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        Grupo3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtCantBultos = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBusquedaRemito = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiaD = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMesD = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtAnioD = new javax.swing.JTextField();
        txtDiaH = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtMesH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtAnioH = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        btnImprimirConsulta = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        ccSi = new javax.swing.JRadioButton();
        ccNo = new javax.swing.JRadioButton();
        ccTodos = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTotalMonto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotalFlete = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbPagados = new javax.swing.JRadioButton();
        cbNoPagados = new javax.swing.JRadioButton();
        cbmTodos = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        btnImprimir1 = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso Lestani S.R.L - Consultas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(66, 66, 66));

        jLabel1.setBackground(new java.awt.Color(66, 66, 66));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 80, 166));
        jLabel1.setText("Tutor");

        btnMostrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(15, 80, 166));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Mostrar_24px.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.setBorder(new javax.swing.border.MatteBorder(null));
        btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        tablaConsultas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaConsultas.setForeground(new java.awt.Color(236, 240, 241));
        tablaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaConsultas.setOpaque(false);
        jScrollPane1.setViewportView(tablaConsultas);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(15, 80, 166));

        txtCantBultos.setEditable(false);
        txtCantBultos.setBackground(new java.awt.Color(255, 255, 255));
        txtCantBultos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtCantBultos.setForeground(new java.awt.Color(0, 153, 51));
        txtCantBultos.setText("0");

        jLabel13.setForeground(new java.awt.Color(15, 80, 166));
        jLabel13.setText("Cant. Cuotas");

        txtBusquedaRemito.setForeground(new java.awt.Color(15, 80, 166));
        txtBusquedaRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaRemitoActionPerformed(evt);
            }
        });
        txtBusquedaRemito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaRemitoKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(15, 80, 166));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Busqueda x  N° Remito");
        jLabel22.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(149, Short.MAX_VALUE)
                        .addComponent(txtCantBultos, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(168, 168, 168)
                        .addComponent(txtBusquedaRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaRemito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantBultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(15, 80, 166));
        jLabel2.setText("Fecha:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(15, 80, 166));
        jLabel9.setText("Desde");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(15, 80, 166));
        jLabel8.setText("Hasta");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("/");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("/");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("/");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("/");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaH)
                            .addComponent(txtDiaD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMesH)
                            .addComponent(txtMesD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnioD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnioH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtDiaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(txtMesH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(txtAnioH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDiaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtMesD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtAnioD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)))
                .addGap(16, 16, 16))
        );

        btnImprimir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(15, 80, 166));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf_24px-pdf.png"))); // NOI18N
        btnImprimir.setText("Generar PDF");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnImprimirConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnImprimirConsulta.setForeground(new java.awt.Color(15, 80, 166));
        btnImprimirConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir_24px.png"))); // NOI18N
        btnImprimirConsulta.setText("Imprimir");
        btnImprimirConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirConsultaActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(15, 80, 166));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(15, 80, 166));
        jLabel7.setText("Alumno");

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(15, 80, 166));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/X_24px.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setForeground(new java.awt.Color(15, 80, 166));
        jLabel21.setText("Cuenta Corriente");

        ccSi.setBackground(new java.awt.Color(255, 255, 255));
        Grupo3.add(ccSi);
        ccSi.setForeground(new java.awt.Color(15, 80, 166));
        ccSi.setText("Si");

        ccNo.setBackground(new java.awt.Color(255, 255, 255));
        Grupo3.add(ccNo);
        ccNo.setForeground(new java.awt.Color(15, 80, 166));
        ccNo.setText("No");

        ccTodos.setBackground(new java.awt.Color(255, 255, 255));
        Grupo3.add(ccTodos);
        ccTodos.setForeground(new java.awt.Color(15, 80, 166));
        ccTodos.setSelected(true);
        ccTodos.setText("Todos");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ccTodos)
                            .addComponent(ccSi)
                            .addComponent(ccNo)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ccSi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ccNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ccTodos)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(15, 80, 166));

        jLabel4.setFont(new java.awt.Font("Noto Sans Kannada", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("<html>\n\n<p>Centro</p>\n<p>Educativo</p>\n</html>");
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setForeground(new java.awt.Color(236, 240, 241));

        txtTotalMonto.setEditable(false);
        txtTotalMonto.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalMonto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotalMonto.setForeground(new java.awt.Color(0, 153, 51));
        txtTotalMonto.setText("0");
        txtTotalMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalMontoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(15, 80, 166));
        jLabel11.setText("Total Monto   $:");

        txtTotalFlete.setEditable(false);
        txtTotalFlete.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalFlete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotalFlete.setForeground(new java.awt.Color(0, 153, 51));
        txtTotalFlete.setText("0");
        txtTotalFlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalFleteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(15, 80, 166));
        jLabel12.setText("Total Flete     $:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(txtTotalFlete))
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setBackground(new java.awt.Color(66, 66, 66));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(15, 80, 166));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dinero_24px.png"))); // NOI18N
        jLabel3.setText("Monto");

        cbPagados.setBackground(new java.awt.Color(255, 255, 255));
        Grupo1.add(cbPagados);
        cbPagados.setForeground(new java.awt.Color(15, 80, 166));
        cbPagados.setText("Pagados");
        cbPagados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagadosActionPerformed(evt);
            }
        });

        cbNoPagados.setBackground(new java.awt.Color(255, 255, 255));
        Grupo1.add(cbNoPagados);
        cbNoPagados.setForeground(new java.awt.Color(15, 80, 166));
        cbNoPagados.setText("No Pagados");
        cbNoPagados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNoPagadosActionPerformed(evt);
            }
        });

        cbmTodos.setBackground(new java.awt.Color(255, 255, 255));
        Grupo1.add(cbmTodos);
        cbmTodos.setForeground(new java.awt.Color(15, 80, 166));
        cbmTodos.setSelected(true);
        cbmTodos.setText("Todos");
        cbmTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbNoPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPagados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbNoPagados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbmTodos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnImprimir1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnImprimir1.setForeground(new java.awt.Color(15, 80, 166));
        btnImprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/factura.png"))); // NOI18N
        btnImprimir1.setText("Pagado");
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(174, 174, 174)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(92, 92, 92))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(10, 10, 10)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimirConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimirConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed

        botonMostrarPresionado = true;
        aplicarFiltros();
        


    }//GEN-LAST:event_btnMostrarActionPerformed

     private void aplicarFiltros() {
        // Verificar si se ha presionado el botón "Mostrar"
        if (!botonMostrarPresionado) {
            return;
        }
        List<Movimientos> movimientosFiltrados = control.traerMovimientos();

        // Obtener el cliente seleccionado
        Object clienteSeleccionado = cbClientes.getSelectedItem();
        String clienteFiltrado = clienteSeleccionado != null ? clienteSeleccionado.toString() : "";

        // Filtrar por cliente (solo si se ha seleccionado un cliente)
        if (!clienteFiltrado.isEmpty()) {
            movimientosFiltrados = movimientosFiltrados.stream()
                    .filter(mov -> {
                        String cliente = mov.getCliente();
                        String destino = mov.getDestino();

                        // Realizar una búsqueda exacta (insensible a mayúsculas/minúsculas) cuando el texto es igual
                        if (cliente.equalsIgnoreCase(clienteFiltrado) || destino.equalsIgnoreCase(clienteFiltrado)) {
                            return true;
                        }

                        // Realizar una búsqueda parcial (insensible a mayúsculas/minúsculas) cuando el texto no es igual
                        return cliente.toLowerCase().contains(clienteFiltrado.toLowerCase()) || destino.toLowerCase().contains(clienteFiltrado.toLowerCase());
                    })
                    .collect(Collectors.toList());

        }

        // Obtener el cliente seleccionado en el ComboBox cbOrigen
        Object origenSeleccionado = cbOrigen.getSelectedItem();
        String origenFiltrado = origenSeleccionado != null ? origenSeleccionado.toString() : "";

        // Obtener el cliente seleccionado en el ComboBox cbDestino
        Object destinoSeleccionado = cbDestinos.getSelectedItem();
        String destinoFiltrado = destinoSeleccionado != null ? destinoSeleccionado.toString() : "";

        // Filtrar por origen (solo si se ha seleccionado un cliente)
        if (!origenFiltrado.isEmpty()) {
            movimientosFiltrados = movimientosFiltrados.stream()
                    .filter(mov -> mov.getCliente().equals(origenFiltrado))
                    .collect(Collectors.toList());
        }

        // Filtrar por destino (solo si se ha seleccionado un cliente)
        if (!destinoFiltrado.isEmpty()) {
            movimientosFiltrados = movimientosFiltrados.stream()
                    .filter(mov -> mov.getDestino().equals(destinoFiltrado))
                    .collect(Collectors.toList());
        }
        
        
        //Fecha
        // Obtener los valores de los campos de texto para la fecha desde
        int diaD = Integer.parseInt(txtDiaD.getText());
        int mesD = Integer.parseInt(txtMesD.getText());
        int anioD = Integer.parseInt(txtAnioD.getText());

// Crear una instancia de LocalDate si la fecha es válida
        LocalDate fechaDesde = LocalDate.of(anioD, mesD, diaD);

// Obtener los valores de los campos de texto para la fecha hasta
        int diaH = Integer.parseInt(txtDiaH.getText());
        int mesH = Integer.parseInt(txtMesH.getText());
        int anioH = Integer.parseInt(txtAnioH.getText());

// Crear una instancia de LocalDate si la fecha es válida
        LocalDate fechaHasta = LocalDate.of(anioH, mesH, diaH);

        if (fechaDesde != null && fechaHasta != null) {
            movimientosFiltrados = movimientosFiltrados.stream()
                    .filter(mov -> {
                        Date fechaMovimiento = mov.getFecha();
                        if (fechaMovimiento != null) {
                            LocalDate fechaMovimientoLocalDate = fechaMovimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            return !fechaMovimientoLocalDate.isBefore(fechaDesde) && !fechaMovimientoLocalDate.isAfter(fechaHasta);
                        }
                        return false; // Manejar casos donde fechaMovimiento es null
                    })
                    .collect(Collectors.toList());
        }
    
        
        
                 // Obtener el representante seleccionado
         Object representanteSeleccionado = cbRepresentantes.getSelectedItem();
         String representanteFiltrado = representanteSeleccionado != null ? representanteSeleccionado.toString() : "";

         // Obtener el estado de la cuenta corriente seleccionado
         String radioButtonSeleccionado = "Todos"; // Inicialmente, se selecciona "Todos"

         if (ccSi.isSelected()) {
             radioButtonSeleccionado = "Si";
         } else if (ccNo.isSelected()) {
             radioButtonSeleccionado = "No";
         }

         final String finalRadioButtonSeleccionado = radioButtonSeleccionado; // Hacer que la variable sea final
         
         //filtro de Cuenta Corriente 
         
         // cuenta corriente
          if (representanteFiltrado.isEmpty() && clienteFiltrado.isEmpty()) {
         movimientosFiltrados = movimientosFiltrados.stream()
                 .filter(mov -> {
                     String cuentaCorriente = mov.getCuentaCorriente();
                     // Filtrar por cuenta corriente
                     if (finalRadioButtonSeleccionado.equals("Todos")) {
                         // Si es ccTodos, mostrar todos los movimientos independientemente de su cuenta corriente
                         return true;
                     } else {
                         // Mostrar solo movimientos que coincidan con la cuenta corriente seleccionada
                         return cuentaCorriente.equals(finalRadioButtonSeleccionado);
                     }
                 })
                 .collect(Collectors.toList());    
          }


         // Filtrar por representantes si se ha seleccionado un representante
         if (!representanteFiltrado.isEmpty()) {
             movimientosFiltrados = movimientosFiltrados.stream()
                     .filter(mov -> {
                         String cuentaCorriente = mov.getCuentaCorriente();
                         String representante = mov.getRepresentante();

                         // Filtrar por cuenta corriente
                         if (finalRadioButtonSeleccionado.equals("Todos")) {
                             // Si es ccTodos, mostrar todos los representantes independientemente de su cuenta corriente
                             return representante.equalsIgnoreCase(representanteFiltrado);
                         } else {
                             // Mostrar solo representantes que coincidan con la cuenta corriente seleccionada
                             return representante.equalsIgnoreCase(representanteFiltrado) && cuentaCorriente.equals(finalRadioButtonSeleccionado);
                         }
                     })
                     .collect(Collectors.toList());
         } 
         
             // Filtrar por clientes y cuentas corrientes si no se selecciona un representante
         if (!clienteFiltrado.isEmpty() && !finalRadioButtonSeleccionado.equals("Todos")) {
             movimientosFiltrados = movimientosFiltrados.stream()
                     .filter(mov -> {
                         String cuentaCorriente = mov.getCuentaCorriente();
                         String cliente = mov.getCliente();
                         String destino = mov.getDestino();
                         String fleteDestinoOrigen = mov.getFleteDestinoOrigen();

                         boolean esClienteFiltrado = cliente.equalsIgnoreCase(clienteFiltrado);

                         // Si el tipo de flete es "Origen", el cliente debe ser responsable
                         boolean esFleteOrigen = fleteDestinoOrigen.equals("Origen") && esClienteFiltrado;

                         // Si el tipo de flete es "Destino", el destino debe ser responsable
                         boolean esFleteDestino = fleteDestinoOrigen.equals("Destino") && destino.equalsIgnoreCase(clienteFiltrado);

                         // Mostrar solo registros que coincidan con el cliente y la cuenta corriente seleccionados
                         return cuentaCorriente.equals(finalRadioButtonSeleccionado) && (esFleteOrigen || esFleteDestino);
                     })
                     .collect(Collectors.toList());
         }



         
         
        //Chechbox
        boolean mostrarPagados = cbPagados.isSelected();
        boolean mostrarNoPagados = cbNoPagados.isSelected();
        boolean mostrarFPagados = cbFletePagado.isSelected();
        boolean mostrarFNoPagados = cbFleteNoPagado.isSelected();
        
        //Filtrado de Fletes y Montos
        movimientosFiltrados = movimientosFiltrados.stream()
                .filter(mov -> {
                    boolean estadoPagoCumple = true;
                    boolean fletesCumple = true;

                    // Filtrar por estado de pago
                    if (mostrarPagados && !mov.getTipoMontoP().equals("Si")) {
                        estadoPagoCumple = false;
                    } else if (mostrarNoPagados && !mov.getTipoMontoP().equals("No")) {
                        estadoPagoCumple = false;
                    }

                    // Filtrar por fletes
                    if (mostrarFPagados && !mov.getTipoFleteP().equals("Si")) {
                        fletesCumple = false;
                    } else if (mostrarFNoPagados && !mov.getTipoFleteP().equals("No")) {
                        fletesCumple = false;
                    }

                    return estadoPagoCumple && fletesCumple;
                })
                .collect(Collectors.toList());

        

        mostrarTablaMovimientos(movimientosFiltrados);
        //Total Monto
        int[] selectedRows = tablaConsultas.getSelectedRows();
        calcularTotalMonto(movimientosFiltrados, selectedRows);
        calcularTotalFlete(movimientosFiltrados, selectedRows);
        calcularTotalBultos(movimientosFiltrados, selectedRows);

    }

    // Método para calcular el total de montos de los elementos seleccionados en la tabla
    private void calcularTotalMonto(List<Movimientos> movimientosFiltrados, int[] selectedRows) {

        if (selectedRows.length > 0) {
            // Si hay elementos seleccionados, calcular y mostrar el total de montos seleccionados
            double totalMonto = 0.0;

            // Supongamos que "Movimientos" tiene un método "getMonto()" para obtener el monto de cada movimiento.
            for (int rowIndex : selectedRows) {
                String monto = tablaConsultas.getValueAt(rowIndex, 7).toString();
                monto = monto.replace("$", "").replace(".", "").replace(",", "."); // Eliminar símbolos y reemplazar la coma por el punto decimal
                try {
                    totalMonto += Double.parseDouble(monto);
                } catch (NumberFormatException e) {
                    // Manejar la excepción en caso de que no se pueda convertir el monto a número
                    e.printStackTrace();
                }
            }

            //Formato de Monto
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
            String totalFormateado = decimalFormat.format(totalMonto);

            txtTotalMonto.setText(totalFormateado);
        } else {
            // Calcular el total de los montos
            double totalMonto = movimientosFiltrados.stream()
                    .mapToDouble(mov -> {
                        String monto = mov.getMonto().replace(".", ""); // Eliminar el separador de miles (punto)
                        monto = monto.replace(",", "."); // Reemplazar la coma por punto decimal
                        monto = monto.replace("$", ""); // Eliminar el signo de dólar
                        try {
                            return Double.parseDouble(monto);
                        } catch (NumberFormatException e) {
                            return 0.0;
                        }
                    })
                    .sum();

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
            String totalFormateado = decimalFormat.format(totalMonto);

            txtTotalMonto.setText(totalFormateado);
        }
    }

    // Método para calcular el total de montos de los elementos seleccionados en la tabla
    private void calcularTotalFlete(List<Movimientos> movimientosFiltrados, int[] selectedRows) {

        if (selectedRows.length > 0) {
            // Si hay elementos seleccionados, calcular y mostrar el total de montos seleccionados
            double totalFlete = 0.0;

            // Supongamos que "Movimientos" tiene un método "getFlete()" para obtener el monto de cada movimiento.
            for (int rowIndex : selectedRows) {
                String flete = tablaConsultas.getValueAt(rowIndex, 10).toString();
                flete = flete.replace("$", "").replace(".", "").replace(",", "."); // Eliminar símbolos y reemplazar la coma por el punto decimal
                try {
                    totalFlete += Double.parseDouble(flete);
                } catch (NumberFormatException e) {
                    // Manejar la excepción en caso de que no se pueda convertir el monto a número
                    e.printStackTrace();
                }
            }

            //Formato de Monto
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
            String totalFormateado = decimalFormat.format(totalFlete);

            txtTotalFlete.setText(totalFormateado);
        } else {
            // Calcular el total de los Fletes
            double totalflete = movimientosFiltrados.stream()
                    .mapToDouble(mov -> {
                        String flete = mov.getFlete().replace(".", ""); // Eliminar el separador de miles (punto)
                        flete = flete.replace(",", "."); // Reemplazar la coma por punto decimal
                        flete = flete.replace("$", ""); // Eliminar el signo de dólar
                        try {
                            return Double.parseDouble(flete);
                        } catch (NumberFormatException e) {
                            return 0.0;
                        }
                    })
                    .sum();

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
            String totalFormateado = decimalFormat.format(totalflete);

            txtTotalFlete.setText(totalFormateado);
        }
    }
    

        private static void ComboBoxStyle(JComboBox<String> comboBox) {
        comboBox.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                SwingUtilities.invokeLater(() -> {
                    JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();
                    editor.selectAll();
                });
            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();
                    editor.selectAll();
                });
            }
        });
    }
    

    private void calcularTotalBultos(List<Movimientos> movimientosFiltrados, int[] selectedRows) {

        if (selectedRows.length > 0) {

            // Si hay elementos seleccionados, calcular y mostrar el total de montos seleccionados
            int totalbulto = 0;

            // Supongamos que "Movimientos" tiene un método "getFlete()" para obtener el monto de cada movimiento.
            for (int rowIndex : selectedRows) {
                String bulto = tablaConsultas.getValueAt(rowIndex, 6).toString();
                try {
                    totalbulto += Double.parseDouble(bulto);
                } catch (NumberFormatException e) {
                    // Manejar la excepción en caso de que no se pueda convertir el monto a número
                    e.printStackTrace();
                }
                txtCantBultos.setText(String.format("%,d", totalbulto));
            }
        } else {

            int sumaBultos = movimientosFiltrados.stream()
                    .mapToInt(Movimientos::getBultos)
                    .sum();

            txtCantBultos.setText(String.format("%,d", sumaBultos));

        }
    }


    private void mostrarTablaMovimientos(List<Movimientos> listaMovimientos) {
        //filas y columnas no editables
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        //nombres de columnas
        String titulos[] = {"ID", "HORA", "FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "RENDIDO", "FLETE", "PAGADO", "RENDIDO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        // Centrar los títulos en el encabezado de la tabla
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tablaConsultas.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tablaConsultas.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));

        // Ordenar los datos por el ID en forma descendente
        Collections.sort(listaMovimientos, Comparator.comparingInt(Movimientos::getId_movimientos).reversed());
        //carga de los datos desde la lista filtrada
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};
                tabla.addRow(objeto);
            }
        }
        tablaConsultas.setModel(tabla);

        // Personalizar el ancho de las columnas
        // "ID","HORA","FECHA","CLIENTE","DESTINO","REMITO","BULTOS","MONTO","PAGADO","RENDIDO","FLETE","PAGADO","RENDIDO","A_CARGO_DE","REPRESENTANTE","CC","OBS"
        int[] columnWidths = {15, 50, 50, 120, 120, 40, 25, 80, 30, 30, 80, 30, 30, 50, 100, 30, 120}; // Ancho de las columnas en píxeles

        for (int i = 0; i < tablaConsultas.getColumnCount(); i++) {
            TableColumn column = tablaConsultas.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Personalizar el tamaño de las celdas
        int cellHeight = 25; // Altura de las celdas
        tablaConsultas.setRowHeight(cellHeight);

        // Personalizar la alineación del contenido en las celdas (opcional)
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablaConsultas.setDefaultRenderer(Object.class, centerRenderer);

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


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened
    /**
     * CHECK BOX PAGADOS
     *
     */

    private void cbPagadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagadosActionPerformed
       
    }//GEN-LAST:event_cbPagadosActionPerformed

    private void cbNoPagadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNoPagadosActionPerformed
        
    }//GEN-LAST:event_cbNoPagadosActionPerformed

    private void cbmTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmTodosActionPerformed
        
    }//GEN-LAST:event_cbmTodosActionPerformed

    private void txtTotalFleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalFleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFleteActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        generarPDF();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        /*  txtFechaDesde.setText("");
       // txtFechaHasta.setText("");
        txtCliente.setText("");
        txtTotalMonto.setText("");
        txtTotalFlete.setText("");
        txtCantBultos.setText("");*/
        dispose();
        PagoCuotas con = new PagoCuotas();
        con.setVisible(true);

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtTotalMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalMontoActionPerformed

    }//GEN-LAST:event_txtTotalMontoActionPerformed

    private void btnImprimirConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirConsultaActionPerformed
        imprimirPDF();
    }//GEN-LAST:event_btnImprimirConsultaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Eliminar
        // Control para verificar que la tabla no esté vacía
        if (tablaConsultas.getRowCount() > 0) {
            // Validar que se hayan seleccionado registros
            int[] selectedRows = tablaConsultas.getSelectedRows();
            if (selectedRows.length > 0) {
                int confirmResult = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas borrar los registros seleccionados?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    for (int selectedRow : selectedRows) {
                        int idMovimiento = Integer.parseInt(String.valueOf(tablaConsultas.getValueAt(selectedRow, 0)));
                        control.borrarMovimiento(idMovimiento);
                    }
                    mostrarMensaje("Movimientos borrados correctamente", "Info", "Borrados con éxito");
                    mostrarTablaMovimientos();
                }
            } else {
                mostrarMensaje("No seleccionaste registros para eliminar", "Error", "Error al eliminar");
            }
        } else {
            mostrarMensaje("La tabla está vacía, no se puede eliminar", "Error", "Error al eliminar");
        }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBusquedaRemitoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaRemitoKeyTyped
       txtBusquedaRemito.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBusquedaRemito.getText(), 5));
            }

        });
        trs = new TableRowSorter(tablaConsultas.getModel());
        tablaConsultas.setRowSorter(trs);
    }//GEN-LAST:event_txtBusquedaRemitoKeyTyped

    private void txtBusquedaRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaRemitoActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimir1ActionPerformed
    private void cambiarValorFlete(double nuevoMontoFlete) {
        int[] filasSeleccionadas = tablaConsultas.getSelectedRows(); // Obtener índices de las filas seleccionadas
        String nuevoValorFleteTexto = txtFleteCambio.getText().trim(); // Obtener el nuevo valor del campo de texto
        double nuevoValorFlete = Double.parseDouble(nuevoValorFleteTexto); // Convertir a tipo numérico

        DefaultTableModel modeloTabla = (DefaultTableModel) tablaConsultas.getModel();
        int columnaFlete = 10; // Índice de la columna "Flete" en el modelo de tabla
        int totalFilas = modeloTabla.getRowCount();

        if (filasSeleccionadas.length > 0) {
            for (int filaSeleccionada : filasSeleccionadas) {
                int fila = filaSeleccionada; // Declarar y asignar el valor de filaSeleccionada a fila
                modeloTabla.setValueAt(nuevoMontoFlete, fila, columnaFlete);

                int idMovimientos = (int) modeloTabla.getValueAt(fila, 0);
                Movimientos movimiento = control.traerMovimiento(idMovimientos);

                if (movimiento != null) {
                    movimiento.setFlete(nuevoValorFleteTexto); // Guardar el valor sin el signo "$"
                    control.actualizarPrecioFlete(movimiento, nuevoValorFleteTexto); // Utilizar el método actualizarPrecioFlete() de la controladora
                    String nuevoValorFleteConSigno = "$" + nuevoValorFleteTexto; // Agregar el signo "$"
                    modeloTabla.setValueAt(nuevoValorFleteConSigno, fila, columnaFlete); // Actualizar el valor en la columna "FLETE"
                }
            }

            modeloTabla.fireTableDataChanged();
            JOptionPane.showMessageDialog(null, "Se cambió el monto de los fletes seleccionados con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si no hay filas seleccionadas, recorrer todas las filas
            for (int fila = 0; fila < totalFilas; fila++) {
                modeloTabla.setValueAt(nuevoMontoFlete, fila, columnaFlete);

                int idMovimientos = (int) modeloTabla.getValueAt(fila, 0);
                Movimientos movimiento = control.traerMovimiento(idMovimientos);

                if (movimiento != null) {
                    movimiento.setFlete(nuevoValorFleteTexto); // Guardar el valor sin el signo "$"
                    control.actualizarPrecioFlete(movimiento, nuevoValorFleteTexto); // Utilizar el método actualizarPrecioFlete() de la controladora
                    String nuevoValorFleteConSigno = "$" + nuevoValorFleteTexto; // Agregar el signo "$"
                    modeloTabla.setValueAt(nuevoValorFleteConSigno, fila, columnaFlete); // Actualizar el valor en la columna "FLETE"
                }
            }

            modeloTabla.fireTableDataChanged();
            JOptionPane.showMessageDialog(null, "Se cambió el monto de todos los fletes con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void mostrarTablaMovimientos() {
        //filas y columnas no editables
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        //nombres de columnas
        String titulos[] = {"ID", "HORA", "FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "RENDIDO", "FLETE", "PAGADO", "RENDIDO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        tablaConsultas.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
        //carga de los datos desde la bd
        List<Movimientos> listaMovimientos = control.traerMovimientos();
        // Ordenar los datos por el ID en forma descendente
        Collections.sort(listaMovimientos, Comparator.comparingInt(Movimientos::getId_movimientos).reversed());

        //recorrer lista y mostrar elementos en la tabla
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

                tabla.addRow(objeto);

            }
        }
        tablaConsultas.setModel(tabla);

        // Personalizar el tamaño de las celdas
        int cellHeight = 25; // Altura de las celdas
        tablaConsultas.setRowHeight(cellHeight);

        // Personalizar la alineación del contenido en las celdas (opcional)
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablaConsultas.setDefaultRenderer(Object.class, centerRenderer);

        // Establecer el ancho específico de las columnas
        int[] anchos = {15, 50, 50, 120, 120, 40, 25, 80, 30, 30, 80, 30, 30, 50, 100, 30, 120}; // Anchos deseados para cada columna en píxeles

        if (anchos.length == tabla.getColumnCount()) {
            TableColumnModel columnModel = tablaConsultas.getColumnModel();
            for (int i = 0; i < anchos.length; i++) {
                TableColumn columna = columnModel.getColumn(i);
                columna.setPreferredWidth(anchos[i]);
                // Renderizador personalizado para centrar el contenido de las celdas
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                columna.setCellRenderer(renderer);
                // Renderizador personalizado para centrar el título de las columnas
                DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tablaConsultas.getTableHeader().getDefaultRenderer();
                headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(PagoCuotas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoCuotas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoCuotas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoCuotas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagoCuotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.ButtonGroup Grupo2;
    private javax.swing.ButtonGroup Grupo3;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JButton btnImprimirConsulta;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JRadioButton cbNoPagados;
    private javax.swing.JRadioButton cbPagados;
    private javax.swing.JRadioButton cbmTodos;
    private javax.swing.JRadioButton ccNo;
    private javax.swing.JRadioButton ccSi;
    private javax.swing.JRadioButton ccTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tablaConsultas;
    private javax.swing.JTextField txtAnioD;
    private javax.swing.JTextField txtAnioH;
    private javax.swing.JTextField txtBusquedaRemito;
    private javax.swing.JTextField txtCantBultos;
    private javax.swing.JTextField txtDiaD;
    private javax.swing.JTextField txtDiaH;
    private javax.swing.JTextField txtMesD;
    private javax.swing.JTextField txtMesH;
    private javax.swing.JTextField txtTotalFlete;
    private javax.swing.JTextField txtTotalMonto;
    // End of variables declaration//GEN-END:variables

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);

    }

    //Nueva funcion de marcar como pagados Monto
    private void cambiarTipoMonto() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaConsultas.getModel();
        int totalFilas = modeloTabla.getRowCount();
        int[] filasSeleccionadas = tablaConsultas.getSelectedRows();

        // Si hay filas seleccionadas, recorrer solo las filas seleccionadas
        if (filasSeleccionadas.length > 0) {
            for (int filaSeleccionada : filasSeleccionadas) {
                int idMovimientos = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
                Movimientos movimiento = control.traerMovimiento(idMovimientos);

                if (movimiento != null) {
                    String tipoMonto = (String) modeloTabla.getValueAt(filaSeleccionada, 8);
                    if (tipoMonto.equals("No")) {
                        control.actualizarMonto(movimiento, "Si");
                        modeloTabla.setValueAt("Si", filaSeleccionada, 8);
                    }
                }
            }
        } else {
            // Si no hay filas seleccionadas, recorrer todas las filas
            for (int fila = 0; fila < totalFilas; fila++) {
                int idMovimientos = (int) modeloTabla.getValueAt(fila, 0);
                Movimientos movimiento = control.traerMovimiento(idMovimientos);

                if (movimiento != null) {
                    String tipoMonto = (String) modeloTabla.getValueAt(fila, 8);
                    if (tipoMonto.equals("No")) {
                        control.actualizarMonto(movimiento, "Si");
                        modeloTabla.setValueAt("Si", fila, 8);
                    }
                }
            }
        }

        modeloTabla.fireTableDataChanged();
    }

    //Nuevo metodo para marcar como pagados fletes
    private void cambiarTipoFlete() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaConsultas.getModel();
        int totalFilas = modeloTabla.getRowCount();
        int[] filasSeleccionadas = tablaConsultas.getSelectedRows();

        // Si hay filas seleccionadas, recorrer solo las filas seleccionadas
        if (filasSeleccionadas.length > 0) {
            for (int filaSeleccionada : filasSeleccionadas) {
                int idMovimientos = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
                Movimientos movimiento = control.traerMovimiento(idMovimientos);

                if (movimiento != null) {
                    String tipoFlete = (String) modeloTabla.getValueAt(filaSeleccionada, 11);
                    if (tipoFlete.equals("No")) {
                        control.actualizarFlete(movimiento, "Si");
                        modeloTabla.setValueAt("Si", filaSeleccionada, 11);
                    }
                }
            }
        } else {
            // Si no hay filas seleccionadas, recorrer todas las filas
            for (int fila = 0; fila < totalFilas; fila++) {
                int idMovimientos = (int) modeloTabla.getValueAt(fila, 0);
                Movimientos movimiento = control.traerMovimiento(idMovimientos);

                if (movimiento != null) {
                    String tipoFlete = (String) modeloTabla.getValueAt(fila, 11);
                    if (tipoFlete.equals("No")) {
                        control.actualizarFlete(movimiento, "Si");
                        modeloTabla.setValueAt("Si", fila, 11);
                    }
                }
            }
        }

        modeloTabla.fireTableDataChanged();
    }

    //Nuevo metodo para marcar como rendidos fletes
    private void cambiarTipoFleteRendido() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaConsultas.getModel();
        int totalFilas = modeloTabla.getRowCount();
        int[] filasSeleccionadas = tablaConsultas.getSelectedRows();

        // Si hay filas seleccionadas, recorrer solo las filas seleccionadas
        if (filasSeleccionadas.length > 0) {
            for (int filaSeleccionada : filasSeleccionadas) {
                int idMovimientos = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
                Movimientos movimiento = control.traerMovimiento(idMovimientos);

                if (movimiento != null) {
                    String tipoFleteRendido = (String) modeloTabla.getValueAt(filaSeleccionada, 12);
                    if (tipoFleteRendido.equals("No")) {
                        control.actualizarFleteR(movimiento, "Si");
                        modeloTabla.setValueAt("Si", filaSeleccionada, 12);
                    }
                }
            }
        } else {
            // Si no hay filas seleccionadas, recorrer todas las filas
            for (int fila = 0; fila < totalFilas; fila++) {
                int idMovimientos = (int) modeloTabla.getValueAt(fila, 0);
                Movimientos movimiento = control.traerMovimiento(idMovimientos);

                if (movimiento != null) {
                    String tipoFleteRendido = (String) modeloTabla.getValueAt(fila, 12);
                    if (tipoFleteRendido.equals("No")) {
                        control.actualizarFleteR(movimiento, "Si");
                        modeloTabla.setValueAt("Si", fila, 12);
                    }
                }
            }
        }

        modeloTabla.fireTableDataChanged();
    }

    //IMPRIMIR CONSULTAS
    private void generarPDF() {
        Document document = new Document();
        try {
            // Crear un diálogo de selección de archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            // Mostrar el diálogo de selección de archivo
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Obtener el archivo seleccionado por el usuario
                File selectedFile = fileChooser.getSelectedFile();
                String outputPath = selectedFile.getAbsolutePath();

                // Agregar la extensión ".pdf" al nombre del archivo si no está presente
                if (!outputPath.toLowerCase().endsWith(".pdf")) {
                    outputPath += ".pdf";
                }

                // Crear el archivo de salida
                File outputFile = new File(outputPath);
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
                document.open();

                //FUENTES
                Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.BOLD);
                Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD);

                // LOGO
                InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logo.jpg");
                Image logo = Image.getInstance(ImageIO.read(logoStream), null);
                logo.scaleToFit(450, 800);
                logo.setAlignment(Element.ALIGN_CENTER);
                document.add(logo);
                // TITULO
                Paragraph titulo = new Paragraph("DETALLE DE MOVIMIENTOS", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

                // FECHAS
                 //Fecha
        // Obtener los valores de los campos de texto
        int diaD = Integer.parseInt(txtDiaD.getText());
        int mesD = Integer.parseInt(txtMesD.getText());
        int anioD = Integer.parseInt(txtAnioD.getText());
        
        // Crear una instancia de LocalDate si la fecha es válida
            LocalDate fechaArmadaD = LocalDate.of(anioD, mesD, diaD);
            
            // Formatear la fecha en el formato deseado
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fechaDesde = fechaArmadaD.format(formatter);
                    
                    // Obtener los valores de los campos de texto
        int diaH = Integer.parseInt(txtDiaH.getText());
        int mesH = Integer.parseInt(txtMesH.getText());
        int anioH = Integer.parseInt(txtAnioH.getText());
        
        // Crear una instancia de LocalDate si la fecha es válida
            LocalDate fechaArmadaH = LocalDate.of(anioH, mesH, diaH);
            
            // Formatear la fecha en el formato deseado
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fechaHasta = fechaArmadaH.format(formatter2);

                // Agregar fechas desde y hasta al título
                Chunk chunkFechas = new Chunk("Desde " + fechaDesde + " \nHasta " + fechaHasta, fontFecha);
                Paragraph fechas = new Paragraph(chunkFechas);
                fechas.setAlignment(Element.ALIGN_CENTER);
                fechas.setSpacingAfter(5f); // Espacio después de las fechas (en puntos)

                document.add(titulo);
                document.add(fechas);

                // Obtener las filas seleccionadas o todas las filas si no hay ninguna seleccionada
                int[] filasSeleccionadas = tablaConsultas.getSelectedRows();
                if (filasSeleccionadas.length == 0) {
                    filasSeleccionadas = new int[tablaConsultas.getRowCount()];
                    for (int i = 0; i < tablaConsultas.getRowCount(); i++) {
                        filasSeleccionadas[i] = i;
                    }
                }

                //creacion de la TABLA
                PdfPTable table = new PdfPTable(tablaConsultas.getColumnCount() - 7); // Excluir las 6 columnas A_CARGO_DE, CC, OBS, MOVIMIENTO, RENDIDO_1 y RENDIDO_2
                table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
                table.setSpacingAfter(10f);

                // Ajustar espacio horizontal
                float[] columnWidths = {1f, 1.9f, 1.9f, 0.8f, 0.8f, 1f, 0.8f, 1f, 0.8f, 1.5f}; // Anchos de las columnas (proporciones)
                table.setWidths(columnWidths);
                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                table.setWidths(columnWidths);

                // Agregar las celdas a la tabla
                for (int i = 0; i < tablaConsultas.getColumnCount(); i++) {
                    String col = tablaConsultas.getColumnName(i);
                    if (!col.equals("A_CARGO_DE") && !col.equals("CC") && !col.equals("OBS") && !col.equals("ID")
                            && !col.equals("RENDIDO") && !col.equals("RENDIDO") && !col.equals("HORA")) {
                        PdfPCell cell = new PdfPCell(new Phrase(col, font));
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                        table.addCell(cell);
                    }
                }
                for (int row : filasSeleccionadas) {
                    for (int col = 0; col < tablaConsultas.getColumnCount(); col++) {
                        String colName = tablaConsultas.getColumnName(col);
                        if (!colName.equals("A_CARGO_DE") && !colName.equals("CC") && !colName.equals("OBS") && !colName.equals("ID")
                                && !colName.equals("RENDIDO") && !colName.equals("RENDIDO") && !colName.equals("HORA")) {
                            Object value = tablaConsultas.getValueAt(row, col);
                            if (value != null) {
                                PdfPCell cell = new PdfPCell(new Phrase(value.toString(), fontFilas));
                                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                                cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                                if (colName.equals("CLIENTE") || colName.equals("DESTINO") || colName.equals("FECHA")) {
                                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                                }
                                table.addCell(cell);
                            }
                        }
                    }
                }

                document.add(table);

                // Crear una tabla para los montos totales
                PdfPTable totalsTable = new PdfPTable(2);
                totalsTable.setWidthPercentage(100);

                // Monto total
                // Establecer la fuente deseada
                Phrase montoTotalPhrase = new Phrase("Monto total: $" + txtTotalMonto.getText(), fontTotales);
                PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
                montoTotalCell.setBorder(Rectangle.NO_BORDER);
                montoTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear la celda al centro
                totalsTable.addCell(montoTotalCell);

                // Flete total
                Phrase fleteTotalPhrase = new Phrase("Flete total: $" + txtTotalFlete.getText(), fontTotales);
                PdfPCell fleteTotalCell = new PdfPCell(fleteTotalPhrase);
                fleteTotalCell.setBorder(Rectangle.NO_BORDER);
                fleteTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear la celda al centro
                totalsTable.addCell(fleteTotalCell);

                totalsTable.setSpacingBefore(10f);
                document.add(totalsTable);
                document.close();
                writer.close();

                JOptionPane.showMessageDialog(null, "El archivo se generó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(PagoCuotas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void imprimirPDF() {
        Document document = new Document();
        try {
            String userHome = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
            String outputPath = userHome + File.separator + "archivo.pdf";
            // Crear el archivo de salida
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.BOLD);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD);
            // LOGO
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logo.jpg");
            Image logo = Image.getInstance(ImageIO.read(logoStream), null);
            logo.scaleToFit(450, 800);
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);
            // TITULO
            Paragraph titulo = new Paragraph("DETALLE DE MOVIMIENTOS", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            // FECHAS
                 //Fecha
        // Obtener los valores de los campos de texto
        int diaD = Integer.parseInt(txtDiaD.getText());
        int mesD = Integer.parseInt(txtMesD.getText());
        int anioD = Integer.parseInt(txtAnioD.getText());
        
        // Crear una instancia de LocalDate si la fecha es válida
            LocalDate fechaArmadaD = LocalDate.of(anioD, mesD, diaD);
            
            // Formatear la fecha en el formato deseado
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fechaDesde = fechaArmadaD.format(formatter);
                    
                    // Obtener los valores de los campos de texto
        int diaH = Integer.parseInt(txtDiaH.getText());
        int mesH = Integer.parseInt(txtMesH.getText());
        int anioH = Integer.parseInt(txtAnioH.getText());
        
        // Crear una instancia de LocalDate si la fecha es válida
            LocalDate fechaArmadaH = LocalDate.of(anioH, mesH, diaH);
            
            // Formatear la fecha en el formato deseado
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fechaHasta = fechaArmadaH.format(formatter2);
                    
            // Agregar fechas desde y hasta al título
            Chunk chunkFechas = new Chunk("Desde " + fechaDesde + " \nHasta " + fechaHasta, fontFecha);
            Paragraph fechas = new Paragraph(chunkFechas);
            fechas.setAlignment(Element.ALIGN_CENTER);
            fechas.setSpacingAfter(5f); // Espacio después de las fechas (en puntos)

            document.add(titulo);
            document.add(fechas);

            // Obtener las filas seleccionadas o todas las filas si no hay ninguna seleccionada
            int[] filasSeleccionadas = tablaConsultas.getSelectedRows();
            if (filasSeleccionadas.length == 0) {
                filasSeleccionadas = new int[tablaConsultas.getRowCount()];
                for (int i = 0; i < tablaConsultas.getRowCount(); i++) {
                    filasSeleccionadas[i] = i;
                }
            }

            //creacion de la TABLA
            PdfPTable table = new PdfPTable(tablaConsultas.getColumnCount() - 7); // Excluir las 6 columnas A_CARGO_DE, CC, OBS, MOVIMIENTO, RENDIDO_1 y RENDIDO_2
            table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
            table.setSpacingAfter(10f);

            // Ajustar espacio horizontal
            float[] columnWidths = {1f, 1.9f, 1.9f, 0.8f, 0.8f, 1f, 0.8f, 1f, 0.8f, 1.5f}; // Anchos de las columnas (proporciones)
            table.setWidths(columnWidths);
            table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

            table.setWidths(columnWidths);

            // Agregar las celdas a la tabla
            for (int i = 0; i < tablaConsultas.getColumnCount(); i++) {
                String col = tablaConsultas.getColumnName(i);
                if (!col.equals("A_CARGO_DE") && !col.equals("CC") && !col.equals("OBS") && !col.equals("ID")
                        && !col.equals("RENDIDO") && !col.equals("RENDIDO") && !col.equals("HORA")) {
                    PdfPCell cell = new PdfPCell(new Phrase(col, font));
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                    table.addCell(cell);
                }
            }
            for (int row : filasSeleccionadas) {
                for (int col = 0; col < tablaConsultas.getColumnCount(); col++) {
                    String colName = tablaConsultas.getColumnName(col);
                    if (!colName.equals("A_CARGO_DE") && !colName.equals("CC") && !colName.equals("OBS") && !colName.equals("ID")
                            && !colName.equals("RENDIDO") && !colName.equals("RENDIDO") && !colName.equals("HORA")) {
                        Object value = tablaConsultas.getValueAt(row, col);
                        if (value != null) {
                            PdfPCell cell = new PdfPCell(new Phrase(value.toString(), fontFilas));
                            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                            cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                            table.addCell(cell);
                        }
                    }
                }
            }

            document.add(table);
            // Crear una tabla para los montos totales
            PdfPTable totalsTable = new PdfPTable(2);
            totalsTable.setWidthPercentage(100);

            // Monto total
            // Establecer la fuente deseada
            Phrase montoTotalPhrase = new Phrase("Monto total: $" + txtTotalMonto.getText(), fontTotales);
            PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
            montoTotalCell.setBorder(Rectangle.NO_BORDER);
            montoTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear la celda al centro
            totalsTable.addCell(montoTotalCell);

            // Flete total
            Phrase fleteTotalPhrase = new Phrase("Flete total: $" + txtTotalFlete.getText(), fontTotales);
            PdfPCell fleteTotalCell = new PdfPCell(fleteTotalPhrase);
            fleteTotalCell.setBorder(Rectangle.NO_BORDER);
            fleteTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear la celda al centro
            totalsTable.addCell(fleteTotalCell);

            totalsTable.setSpacingBefore(10f);
            document.add(totalsTable);
            document.close();
            writer.close();
            // Imprimir el archivo PDF automáticamente
            try {
                // Cargar el archivo PDF generado previamente
                PDDocument pdfDocument = PDDocument.load(new File(outputPath));

                // Obtener la impresora predeterminada y crear un objeto PDFPageable
                PrinterJob printerJob = PrinterJob.getPrinterJob();
                PDFPageable pageable = new PDFPageable(pdfDocument);

                // Establecer el objeto PDFPageable en el trabajo de impresión
                printerJob.setPageable(pageable);

                // Imprimir el documento
                printerJob.print();

                // Cerrar el documento PDF después de imprimir
                pdfDocument.close();

                JOptionPane.showMessageDialog(null, "La consulta se generó e imprimió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al generar o imprimir la consulta.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(PagoCuotas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void imprimir(String filePath) {
        try {
            // Crear un flujo de entrada para el archivo PDF
            FileInputStream fis = new FileInputStream(filePath);

            // Obtener la impresora por defecto del sistema
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();

            // Crear un trabajo de impresión
            DocPrintJob printJob = printService.createPrintJob();
            Doc doc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);

            // Establecer las opciones de impresión
            PrintRequestAttributeSet printAttributes = new HashPrintRequestAttributeSet();
            printAttributes.add(new PrinterName(printService.getName(), null));

            // Enviar el trabajo de impresión a la impresora
            printJob.print(doc, printAttributes);

            fis.close();
        } catch (IOException | PrintException e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
