/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.gui.empleados;

import static java.lang.Float.max;
import static java.lang.Float.min;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import mypackage.connector.LocalConnector;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.jdbc.EmpleadoRepository;
import mypackage.utils.swing.Table;

/**
 *
 * @author andre
 */
public class JFrameVerEmpleado extends javax.swing.JFrame {

    private I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(LocalConnector.getLocalConnection());

    /** Creates new form JFrameVerEmpleados */
    public JFrameVerEmpleado() {
        initComponents();
        listarEmpleados();
    }

    public void listarEmpleados() {

        new Table().cargar(jTableListaEmpleados, empleadoRepository.getAll());
    }

    //------------ANALYTICS------------------
    //-----------Valores-------------------------
    public double valorTotal(int columnaTabla) {

        float sum = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                sum += Math.round(Float.parseFloat(jTableListaEmpleados.getValueAt(i, columnaTabla).toString()));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sum;
    }

    public double valorPromedio(int columnaTabla) {
        float sum = 0;
        float promedio = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                sum += Math.round(Float.parseFloat(jTableListaEmpleados.getValueAt(i, columnaTabla).toString()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promedio = sum / jTableListaEmpleados.getRowCount();
        return promedio;

    }

    public double valorMaximo(int columnaTabla) {
        float max = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                max = Math.round(max(max, Float.parseFloat(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return max;
    }

    public double valorMinimo(int columnaTabla) {
        float min = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                min = Math.round(min(min, Float.parseFloat(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return min;
    }

    //----------------Fin Valores----------------
    //-----------------Edad----------------------
    public int edadCantidad(int columnaTabla) {
        int cantidad = 0;

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                cantidad = jTableListaEmpleados.getRowCount();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cantidad;

    }

    public int edadPromedio(int columnaTabla) {
        int sum = 0;
        int promedio = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                sum += Math.round(Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promedio = sum / jTableListaEmpleados.getRowCount();
        return promedio;

    }
    
    
    
    
    
    
        public  List<Integer> edadModa(int columnaTabla) {

            int edad=0;
            
            List<Integer> arrayEdades=new ArrayList<Integer>();
            
            
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {
                
               edad=Integer.valueOf(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());
               
               arrayEdades.add(edad);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Hasta aca guardamos todos los elementos de la jTable en List
        int auxiliar=0;
        int contador=0;
            try {
                for(int j=0; j < arrayEdades.size(); j++){
                    
                    auxiliar=arrayEdades.get(j);
                    
                    if(auxiliar == (arrayEdades.get(j)) ){
                        contador ++;
                        
                    }
                }
            } catch (Exception e) {
            }
            
        return arrayEdades;
           
    }
        
//        //EJEMPLO
//        public int masUsado ( ) {
//int num_mas_usado = 0;
//int veces [ ] = new int [arreglo.length];
//int posicion = 0;
//for(int i = 0; i < arreglo.length; i++){
//num_mas_usado = arreglo[i];
//for(int j = i; j < arreglo.length; j++){
//if(arreglo[j] == num_mas_usado){
//veces[i]++;
//}
//}
//}
//num_mas_usado = 0;
//for(int k = 0; k < veces.length; k++){
//if(num_mas_usado < veces [k]){
//num_mas_usado = veces [k];
//posicion = k;
//}
//}
//System.out.println("El numero " + arreglo[posicion] + " aparecio " + veces[posicion] + " veces.");
//return arreglo[posicion];
//}
    
        
        

    public int edadMaxima(int columnaTabla) {
        int max = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                max = Math.round(max(max, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;

    }

    public int edadMinima(int columnaTabla) {

        int min = Integer.parseInt(jTableListaEmpleados.getValueAt(0, columnaTabla).toString());

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                // min = Math.round(min(min, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
                min = Math.round(min(min, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return min;
    }

    //--------------FinEdad-----------------------
//    public double valorQueMasSeRepite(int columnaTabla) {
//        int[] numeros = { 1, 2, 3, 1, 1, 2, 3, 4, 2, 4, 412, 3, 12, 321, 12, 3, 213, 13, 213121, 1, 345, 12, 312, 3, 5424,
//				314 };
//        int valorQueMasSeRepite = 0;
//        try {
//            HashMap<Integer, Integer> mapa = new HashMap<>();
//            for (int x = 0; x < jTableListaEmpleados.getRowCount(); x++) {
//                int numero = jTableListaEmpleados[x];
//                if (mapa.containsKey(numero)) {
//                    mapa.put(numero, mapa.get(numero) + 1);
//                } else {
//                    mapa.put(numero, 1);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    //------------FIN ANALYTICS------------------
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaEmpleados = new javax.swing.JTable();
        jButtonEliminar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jLabelBusqueda = new javax.swing.JLabel();
        jTextFieldBusquedaEmpleados = new javax.swing.JTextField();
        jComboBoxBusquedaEmpleados = new javax.swing.JComboBox<>();
        jButtonRefrescarLista = new javax.swing.JButton();
        jButtonAnalytics = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("LISTA DE EMPLEADOS");

        jTableListaEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jTableListaEmpleados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTableListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableListaEmpleados.setToolTipText("");
        jScrollPane1.setViewportView(jTableListaEmpleados);

        jButtonEliminar.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButtonEliminar.setText("ELIMINAR");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonActualizar.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButtonActualizar.setText("ACTUALIZAR");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jLabelBusqueda.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBusqueda.setText("Buscar por :");

        jTextFieldBusquedaEmpleados.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextFieldBusquedaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBusquedaEmpleadosActionPerformed(evt);
            }
        });
        jTextFieldBusquedaEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBusquedaEmpleadosKeyReleased(evt);
            }
        });

        jComboBoxBusquedaEmpleados.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBoxBusquedaEmpleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "ID", "NOMBRE", "APELLIDO", "EDAD", "GÉNERO", "TIPO DE DOCUMENTO", "NÚMERO DE DOCUMENTO", "CORREO ELECTRÓNICO", "NÚMERO DE TELÉFONO", "FECHA DE INICIO", "CANTIDAD DE HS SEMANALES", "SUELDO" }));

        jButtonRefrescarLista.setBackground(new java.awt.Color(0, 34, 103));
        jButtonRefrescarLista.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonRefrescarLista.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefrescarLista.setText("REFRESCAR LISTA");
        jButtonRefrescarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefrescarListaActionPerformed(evt);
            }
        });

        jButtonAnalytics.setBackground(new java.awt.Color(0, 34, 103));
        jButtonAnalytics.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonAnalytics.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAnalytics.setText("ANALYTICS");
        jButtonAnalytics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalyticsActionPerformed(evt);
            }
        });

        jDesktopPane2.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButtonEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButtonActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabelBusqueda, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jTextFieldBusquedaEmpleados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jComboBoxBusquedaEmpleados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButtonRefrescarLista, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButtonAnalytics, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addGap(66, 258, Short.MAX_VALUE)
                .addComponent(jLabelBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxBusquedaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jTextFieldBusquedaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelTitulo)
                        .addGap(361, 361, 361))))
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonAnalytics, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonActualizar)
                .addGap(58, 58, 58)
                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(jButtonRefrescarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBusqueda, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxBusquedaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldBusquedaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRefrescarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAnalytics, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jDesktopPane1.setLayer(jDesktopPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int filaTablaEmpleado = jTableListaEmpleados.getSelectedRow();

        if (filaTablaEmpleado == -1) {

            JOptionPane.showMessageDialog(this, "SELECCIONE ALGUN EMPLEADO QUE DESEE ELIMINAR DE LA LISTA!");

            return;
        }

        int idEmpleado = (int) jTableListaEmpleados.getValueAt(filaTablaEmpleado, 0);

        if (JOptionPane.showConfirmDialog(this, "ESTA POR ELIMINAR EL EMPLEADO CON EL ID " + idEmpleado + "!!") != 0) {

            return;

        }

        empleadoRepository.remove(empleadoRepository.getById(idEmpleado));

        listarEmpleados();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        new JFrameActualizarEmpleado().setVisible(true);
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jTextFieldBusquedaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBusquedaEmpleadosActionPerformed

    private void jTextFieldBusquedaEmpleadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaEmpleadosKeyReleased

        if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("ID")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeId(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("NOMBRE")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeNombre(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("APELLIDO")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeApellido(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("EDAD")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeEdad(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("GÉNERO")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeGenero(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("TIPO DE DOCUMENTO")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeTipoDocumento(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("NÚMERO DE DOCUMENTO")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeNumeroDocumento(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("CORREO ELECTRÓNICO")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeCorreoElectronico(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("NÚMERO DE TELÉFONO")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeNumeroTelefono(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("FECHA DE INICIO")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeFechaInicio(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("CANTIDAD DE HS SEMANALES")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeCantidadHsSemanales(jTextFieldBusquedaEmpleados.getText()));

        } else if (jComboBoxBusquedaEmpleados.getSelectedItem().equals("SUELDO")) {

            new Table().cargar(jTableListaEmpleados, empleadoRepository.getLikeSueldo(jTextFieldBusquedaEmpleados.getText()));

        }

    }//GEN-LAST:event_jTextFieldBusquedaEmpleadosKeyReleased

    private void jButtonRefrescarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefrescarListaActionPerformed

        new Table().cargar(jTableListaEmpleados, empleadoRepository.getAll());
    }//GEN-LAST:event_jButtonRefrescarListaActionPerformed

    private void jButtonAnalyticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalyticsActionPerformed
        new JFrameAnalytics().setVisible(true);

        //Enviamos lso datos al jframe de analytics
        //IMPORTANTE-->EL JTEXTFIELD DEL OTRO JFRAME DEBERA ESTAR EN PUBLIC Y STATIC
        //------EDAD(columna 3)-----
        //CANTIDAD
        JFrameAnalytics.jTextFieldEdadesCantidad.setText(String.valueOf(edadCantidad(3)));
        //MAXIMO
        JFrameAnalytics.jTextFieldEdadMaxima.setText(String.valueOf(edadMaxima(3)));

        //MINIMO
        JFrameAnalytics.jTextFieldEdadMinima.setText(String.valueOf(edadMinima(3)));

        //PROMEDIO-MEDIA
        JFrameAnalytics.jTextFieldEdadPromedio.setText(String.valueOf(edadPromedio(3)));
        
        //MEDIANA
        JFrameAnalytics.jTextFieldEdadQueMasSeRepite.setText(String.valueOf(edadModa(3)));

        //----------FIN EDAD------------
//        //-----------NUMERO DE DOCUMENTO(columna 6)-----------------
//        //MAXIMO
//        JFrameAnalytics.jTextFieldPrecioMaxServicios.setText(String.valueOf(maximoPrecio(3)));
//
//        //MINIMO
//        JFrameAnalytics.jTextFieldPrecioMinServicios.setText(String.valueOf(minimoPrecio(3)));
//
//        //-----------FIN NUMERO DE DOCUMENTO------------
//        //---------TRANSPORTE(columna 5)--------------
//        //TOTAL
//        JFrameAnalytics.jTextFieldTotalTransporte.setText(String.valueOf(totalPrecio(5)));
//
//        //MAXIMO
//        JFrameAnalytics.jTextFieldPrecioMaxTransporte.setText(String.valueOf(maximoPrecio(5)));
//
//        //MINIMO
//        JFrameAnalytics.jTextFieldPrecioMinTransporte.setText(String.valueOf(minimoPrecio(5)));
//
//        //---------FIN TRANSPORTE--------

    }//GEN-LAST:event_jButtonAnalyticsActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameVerEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVerEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVerEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVerEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameVerEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAnalytics;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonRefrescarLista;
    private javax.swing.JComboBox<String> jComboBoxBusquedaEmpleados;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabelBusqueda;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaEmpleados;
    private javax.swing.JTextField jTextFieldBusquedaEmpleados;
    // End of variables declaration//GEN-END:variables
}
