/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.basesdedatoseps;
import java.awt.Image;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Karol
 */
public class GestionAfiliados extends javax.swing.JFrame {

    /**
     * Creates new form GestionAfiliados
     */
    public GestionAfiliados() {
        initComponents();
        setSize(800, 400);
        setLocationRelativeTo(null);
    }
    
    private void guardarAfiliado() {
    try {
        Coneccion conexion = new Coneccion();
        conexion.conectar();
        
        String sql = "INSERT INTO Afiliados (ID, Tipo_ID, Apellidos, Nombres, Fecha_nacimiento, Genero, Direccion, Ciudad_Residencia, Telefono, Estado_Civil, Correo_electronico, Fecha_primera_afiliacion, Estado, salario, rango_salarial) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = conexion.conn.prepareStatement(sql);
        
        pst.setInt(1, Integer.parseInt(txtDocumento.getText()));
        pst.setString(2, txtTipoDocumento.getText());
        pst.setString(3, txtNombreApellido.getText().split(" ")[1]);
        pst.setString(4, txtNombreApellido.getText().split(" ")[0]);
        pst.setDate(5, Date.valueOf(txtFechaNacimiento.getText()));
        pst.setString(6, txtGenero.getText());
        pst.setString(7, txtCorreo.getText());
        pst.setString(8, txtCiudad.getText());
        pst.setString(9, txtTelefono.getText());
        pst.setString(10, txtEstadoCivil.getText());
        pst.setString(11, txtCorreo.getText());
        pst.setDate(12, Date.valueOf(txtFechaAfiliacion.getText()));
        pst.setString(13, "Activo");
        pst.setDouble(14, Double.parseDouble(txtSalario.getText()));
        pst.setString(15, txtRango.getText());

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Afiliado guardado exitosamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar el afiliado: " + e.getMessage());
    }
}

private void editarAfiliado() {
    try {
        Coneccion conexion = new Coneccion();
        conexion.conectar();

        String sql = "UPDATE Afiliados SET Tipo_ID=?, Apellidos=?, Nombres=?, Fecha_nacimiento=?, Genero=?, Direccion=?, Ciudad_Residencia=?, Telefono=?, Estado_Civil=?, Correo_electronico=?, Fecha_primera_afiliacion=?, Estado=?, salario=?, rango_salarial=? WHERE ID=?";
        PreparedStatement pst = conexion.conn.prepareStatement(sql);

        pst.setString(1, txtTipoDocumento.getText());
        pst.setString(2, txtNombreApellido.getText().split(" ")[1]);
        pst.setString(3, txtNombreApellido.getText().split(" ")[0]);
        pst.setDate(4, Date.valueOf(txtFechaNacimiento.getText()));
        pst.setString(5, txtGenero.getText());
        pst.setString(6, txtCorreo.getText());
        pst.setString(7, txtCiudad.getText());
        pst.setString(8, txtTelefono.getText());
        pst.setString(9, txtEstadoCivil.getText());
        pst.setString(10, txtCorreo.getText());
        pst.setDate(11, Date.valueOf(txtFechaAfiliacion.getText()));
        pst.setString(12, "Activo");
        pst.setDouble(13, Double.parseDouble(txtSalario.getText()));
        pst.setString(14, txtRango.getText());
        pst.setInt(15, Integer.parseInt(txtDocumento.getText()));

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Afiliado actualizado exitosamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al editar el afiliado: " + e.getMessage());
    }
}

private void eliminarAfiliado() {
    try {
        Coneccion conexion = new Coneccion();
        conexion.conectar();

        String sql = "DELETE FROM Afiliados WHERE ID=?";
        PreparedStatement pst = conexion.conn.prepareStatement(sql);

        pst.setInt(1, Integer.parseInt(txtDocumento.getText()));
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Afiliado eliminado exitosamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar el afiliado: " + e.getMessage());
    }
}

private void listarAfiliados() {
    try {
        Coneccion conexion = new Coneccion();
        conexion.conectar();

        String sql = "SELECT * FROM Afiliados";
        Statement st = conexion.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("ID"));
            System.out.println("Nombre: " + rs.getString("Nombres") + " " + rs.getString("Apellidos"));
            System.out.println("Teléfono: " + rs.getString("Telefono"));
            System.out.println("Correo: " + rs.getString("Correo_electronico"));
            System.out.println("----------------------");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al listar los afiliados: " + e.getMessage());
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Documento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRango = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTipoDocumento = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDocumento = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNombreApellido = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtFechaNacimiento = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtGenero = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtEstadoCivil = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtFechaAfiliacion = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtTelefono = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtSalario = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtCorreo = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtCiudad = new javax.swing.JTextArea();
        BotonSalir = new javax.swing.JPanel();
        BotonSalirTxt = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BotonGuardar = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BotoneEliminar = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        BotonEditar = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        BotoneEliminar1 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtDireccion1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        Title.setText("GESTION AFILIADOS");
        jPanel1.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        Documento.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Documento.setText("TIPO DOCUMENTO:");
        jPanel1.add(Documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel5.setText("NOMBRE Y APELLIDO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel6.setText("FECHA DE NACIMIENTO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel7.setText("GENERO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel8.setText("CORREO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel9.setText("ESTADO CIVIL:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel12.setText("FECHA DE AFILIACIÓN:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel3.setText("SALARIO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel13.setText("CIUDAD: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel11.setText("RANGO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel14.setText("TELÉFONO: ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtRango.setColumns(20);
        txtRango.setRows(5);
        jScrollPane1.setViewportView(txtRango);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 50, 20));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtTipoDocumento.setColumns(20);
        txtTipoDocumento.setRows(5);
        jScrollPane2.setViewportView(txtTipoDocumento);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 210, 20));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel15.setText("N° DOCUMENTO:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDocumento.setColumns(20);
        txtDocumento.setRows(5);
        jScrollPane3.setViewportView(txtDocumento);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 180, 20));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtNombreApellido.setColumns(20);
        txtNombreApellido.setRows(5);
        jScrollPane4.setViewportView(txtNombreApellido);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 180, 20));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtFechaNacimiento.setColumns(20);
        txtFechaNacimiento.setRows(5);
        jScrollPane5.setViewportView(txtFechaNacimiento);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 170, 20));

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtGenero.setColumns(20);
        txtGenero.setRows(5);
        jScrollPane6.setViewportView(txtGenero);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 170, 20));

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtEstadoCivil.setColumns(20);
        txtEstadoCivil.setRows(5);
        jScrollPane7.setViewportView(txtEstadoCivil);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 170, 20));

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtFechaAfiliacion.setColumns(20);
        txtFechaAfiliacion.setRows(5);
        jScrollPane8.setViewportView(txtFechaAfiliacion);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 170, 20));

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtTelefono.setColumns(20);
        txtTelefono.setRows(5);
        jScrollPane9.setViewportView(txtTelefono);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 170, 20));

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtSalario.setColumns(20);
        txtSalario.setRows(5);
        jScrollPane10.setViewportView(txtSalario);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 110, 20));

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtCorreo.setColumns(20);
        txtCorreo.setRows(5);
        jScrollPane11.setViewportView(txtCorreo);

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 160, 20));

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtCiudad.setColumns(20);
        txtCiudad.setRows(5);
        jScrollPane12.setViewportView(txtCiudad);

        jPanel1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 110, 20));

        BotonSalir.setBackground(new java.awt.Color(45, 98, 138));
        BotonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonSalirMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonSalirMousePressed(evt);
            }
        });

        BotonSalirTxt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BotonSalirTxt.setForeground(new java.awt.Color(255, 255, 255));
        BotonSalirTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonSalirTxt.setText("SALIR");

        javax.swing.GroupLayout BotonSalirLayout = new javax.swing.GroupLayout(BotonSalir);
        BotonSalir.setLayout(BotonSalirLayout);
        BotonSalirLayout.setHorizontalGroup(
            BotonSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonSalirTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        BotonSalirLayout.setVerticalGroup(
            BotonSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonSalirTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(BotonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 90, 30));

        jPanel4.setBackground(new java.awt.Color(45, 98, 138));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        BotonGuardar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BotonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        BotonGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonGuardar.setText("GUARDAR");
        BotonGuardar.setToolTipText("");
        BotonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonGuardarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 160, 30));

        jPanel5.setBackground(new java.awt.Color(45, 98, 138));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        BotoneEliminar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BotoneEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BotoneEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotoneEliminar.setText("LISTAR");
        BotoneEliminar.setToolTipText("");
        BotoneEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotoneEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoneEliminarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotoneEliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotoneEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotoneEliminar)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 140, 30));

        jPanel6.setBackground(new java.awt.Color(45, 98, 138));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        BotonEditar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BotonEditar.setForeground(new java.awt.Color(255, 255, 255));
        BotonEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonEditar.setText("EDITAR");
        BotonEditar.setToolTipText("");
        BotonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEditarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonEditarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 140, 30));

        jPanel7.setBackground(new java.awt.Color(45, 98, 138));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        BotoneEliminar1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BotoneEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        BotoneEliminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotoneEliminar1.setText("ELIMINAR");
        BotoneEliminar1.setToolTipText("");
        BotoneEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotoneEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotoneEliminar1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotoneEliminar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotoneEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotoneEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 140, 30));

        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane13.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDireccion1.setColumns(20);
        txtDireccion1.setRows(5);
        jScrollPane13.setViewportView(txtDireccion1);

        jPanel1.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 160, 20));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel10.setText("DIRECCIÓN: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonSalirMouseClicked
        this.dispose();  // Esto cierra la ventana de Cotizante
        // Crear una nueva instancia de la ventana de inicio de sesión (IniciarSesion)
        VentanaAdministrador Admin = new VentanaAdministrador();

        // Hacer visible la ventana de inicio de sesión
        Admin.setVisible(true);
    }//GEN-LAST:event_BotonSalirMouseClicked

    private void BotonSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonSalirMousePressed
        
    }//GEN-LAST:event_BotonSalirMousePressed

    private void BotoneEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoneEliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BotoneEliminarMouseClicked

    private void BotoneEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoneEliminarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BotoneEliminarMouseExited

    private void BotonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEditarMouseClicked
        
    }//GEN-LAST:event_BotonEditarMouseClicked

    private void BotonEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEditarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEditarMouseExited

    private void BotoneEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoneEliminar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BotoneEliminar1MouseClicked

    private void BotoneEliminar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotoneEliminar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BotoneEliminar1MouseExited

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        editarAfiliado();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        eliminarAfiliado();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        listarAfiliados();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        guardarAfiliado();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void BotonGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGuardarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGuardarMouseExited

    private void BotonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGuardarMouseClicked

    
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
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionAfiliados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonEditar;
    private javax.swing.JLabel BotonGuardar;
    private javax.swing.JPanel BotonSalir;
    private javax.swing.JLabel BotonSalirTxt;
    private javax.swing.JLabel BotoneEliminar;
    private javax.swing.JLabel BotoneEliminar1;
    private javax.swing.JLabel Documento;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea txtCiudad;
    private javax.swing.JTextArea txtCorreo;
    private javax.swing.JTextArea txtDireccion1;
    private javax.swing.JTextArea txtDocumento;
    private javax.swing.JTextArea txtEstadoCivil;
    private javax.swing.JTextArea txtFechaAfiliacion;
    private javax.swing.JTextArea txtFechaNacimiento;
    private javax.swing.JTextArea txtGenero;
    private javax.swing.JTextArea txtNombreApellido;
    private javax.swing.JTextArea txtRango;
    private javax.swing.JTextArea txtSalario;
    private javax.swing.JTextArea txtTelefono;
    private javax.swing.JTextArea txtTipoDocumento;
    // End of variables declaration//GEN-END:variables


}
