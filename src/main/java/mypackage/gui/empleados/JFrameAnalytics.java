/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.gui.empleados;

import static java.lang.Float.max;
import static java.lang.Float.min;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mypackage.connector.LocalConnector;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.jdbc.EmpleadoRepository;
import mypackage.utils.swing.Table;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author andre
 */
public class JFrameAnalytics extends javax.swing.JFrame {

    private I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(LocalConnector.getLocalConnection());

    /** Creates new form JFrameAnalytics */
    public JFrameAnalytics() {
        initComponents();
        listarEmpleados();
        setearTextFields();
    }
    /*
        COLOCO LA LISTA DE EMPLEADOS ENCONDIDA EN EL JFRAME PORQUE ES MAS FACIL, MENOS CODIGO
    Y MAS ENTENDIBLE COLOCAR LOS JTEXTFIELDS Y REALIZAR LOS GRAFICOS DESDE ACA Y NO ANDAR ENVIANDO
    LOS DATOS DESDE OTRO JFRAME
    */
    
      //=============================================
    //===LISTAMOS LOS EMPLEADOS EN LA TABLA ESCONDIDA==
    //=============================================
    public void listarEmpleados() {

        new Table().cargar(jTableListaEmpleados, empleadoRepository.getAll());

    }
    //=============================================
    //===FIN LISTAMOS LOS EMPLEADOS EN LA TABLA ESCONDIDA==
    //=============================================
    
    
    //=============================================
    //===SET VALORES DE LA DB A LOS JTEXTFIELDS=======
    //=============================================
    public void setearTextFields(){
        
            //------EDAD(columna 3)-----
    //CANTIDAD
    jTextFieldEdadesCantidad.setText (String.valueOf
    (cantidadValores(3)));
     //------EDAD(columna 3)-----
        //CANTIDAD
       jTextFieldEdadesCantidad.setText(String.valueOf(cantidadValores(3)));
        //MAXIMO
        jTextFieldEdadMaxima.setText(String.valueOf(maximaValores(3)));

        //MINIMO
        jTextFieldEdadMinima.setText(String.valueOf(minimaValores(3)));

        //PROMEDIO-MEDIA
        jTextFieldEdadPromedio.setText(String.valueOf(promedioValores(3)));

        //MODA-MEDIANA
       jTextFieldEdadQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(3).get(0)));

        //FRECUENCIA DE VECES MODA-MEDIANA
        jTextFieldFrecuenciaEdadQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(3).get(1)));

        //DISPERSION RESPECTO AL PROMEDIO-MEDIA (VARIANZA)
        jTextFieldVarianzaEdad.setText(String.valueOf(varianzaValores(3)));

        //GRADO DE DISPERSION (DESVIO ESTANDAR)
        jTextFieldDesvioEstandarEdad.setText(String.valueOf(desvioEstandarValores(3)));

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
        
        
    }

      //=============================================
    //===FIN SET VALORES DE LA DB A LOS JTEXTFIELDS=======
    //=============================================
    
    
      //=============================================
    //==============GRÁFICOS=====================
    //=============================================
    JFreeChart Grafica;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();

    public void graficarGraficoEdad() {
        Datos.addValue(cantidadValores(3), "EDAD", "CANTIDAD");
        Datos.addValue(promedioValores(3), "EDAD", "PROMEDIO");
        Datos.addValue(maximaValores(3), "EDAD", "MÁXIMA");
        Datos.addValue(minimaValores(3), "EDAD", "MÍNIMA");
        Datos.addValue(Integer.valueOf(modaFrecuenciaValores(3).get(0)), "EDAD", "MODA");
        Datos.addValue(Integer.valueOf(modaFrecuenciaValores(3).get(1)), "EDAD", "FRECUENCIA MODA");
        Datos.addValue(varianzaValores(3), "EDAD", "VARIANZA");
        Datos.addValue(desvioEstandarValores(3), "EDAD", "DESVIO ESTANDAR");

//Creamos un grafico de tipo barras
        Grafica = ChartFactory.createBarChart("GRÁFICA DE ANALYTICS EDAD",
                "ESTADISTICA", "VALORES OBTENIDOS", Datos,
                PlotOrientation.HORIZONTAL, true, true, false);

//Agregamos nuestro grafico a una nueva ventana
        ChartPanel Panel = new ChartPanel(Grafica);
        JFrame Ventana = new JFrame("JFreeChartAnalyticsEdad");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    //=============================================
    //==============FIN GRÁFICOS=====================
    //=============================================

    //=============================================
    //==============ANALYTICS=====================
    //=============================================
    public int cantidadValores(int columnaTabla) {
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
//---------------------------------------------------------------------------------
    public int maximaValores(int columnaTabla) {
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
//---------------------------------------------------------------------------------
    public int minimaValores(int columnaTabla) {

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
//---------------------------------------------------------------------------------
    public int promedioValores(int columnaTabla) {
        int sum = 0;
        int promedio = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                sum += Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promedio = sum / jTableListaEmpleados.getRowCount();
        return promedio;

    }
//---------------------------------------------------------------------------------
    public List<String> modaFrecuenciaValores(int columnaTabla) {

        int valores = 0;

        List<Integer> arrayValores = new ArrayList<Integer>();

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                valores = Integer.valueOf(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Hasta aca guardamos todos los elementos de la jTable en List

        //Ahora realizamos el calculo de la moda
        int moda = 0;

        int frecuenciaDeVecesQueSeRepite = 0;

        for (int i = 0; i < arrayValores.size(); i++) {

            int vecesQueSeRepite = 0;

            for (int j = 0; j < arrayValores.size(); j++) {

                if (arrayValores.get(i) == arrayValores.get(j)) {

                    vecesQueSeRepite++;
                }
            }
            if (vecesQueSeRepite > frecuenciaDeVecesQueSeRepite) {

                moda = arrayValores.get(i);

                frecuenciaDeVecesQueSeRepite = vecesQueSeRepite;
            }
        }
        //  Como no podemos tener un return dos veces devolvemos una List de enteros con ambos valores
        List<String> valoresObtenidos = new ArrayList<String>();

        valoresObtenidos.add(String.valueOf(moda));
        valoresObtenidos.add(String.valueOf(frecuenciaDeVecesQueSeRepite));

        return valoresObtenidos;
    }
//---------------------------------------------------------------------------------
    public double varianzaValores(int columnaTabla) {

        int valores;
        double varianza = 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("###.##");

        List<Integer> arrayValores = new ArrayList<Integer>();

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                valores = Integer.valueOf(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);
            }
            for (int j = 0; j < jTableListaEmpleados.getRowCount(); j++) {
                double rango;
                rango = Math.pow(arrayValores.get(j) - promedioValores(3), 2f);
                varianza = varianza + rango;
            }
            //suma de diferencias sobre "n"
            varianza = varianza / Double.valueOf(arrayValores.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return varianza;
    }
//---------------------------------------------------------------------------------
    public double desvioEstandarValores(int columnaTabla) {

        double desviacion = 0.0;

        try {

            //teniendo ya la varinza sólo debemos sacarle raiz cuadrada 
            //tendremos la desviación estandar
            desviacion = Math.sqrt(varianzaValores(3));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return desviacion;

    }

    //=============================================
    //==============FIN ANALYTICS==================
    //=============================================
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelEdadMaxima = new javax.swing.JLabel();
        jTextFieldEdadMaxima = new javax.swing.JTextField();
        jLabelEdadMinima = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelEdad = new javax.swing.JLabel();
        jLabelTituloCantHsSemanales = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabelTotalTransporte = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jLabelTotalServicios1 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jTextFieldTotalTransporte = new javax.swing.JTextField();
        jLabelPrecioMaximoTransporte = new javax.swing.JLabel();
        jTextFieldPrecioMaxTransporte = new javax.swing.JTextField();
        jTextFieldPrecioMinTransporte = new javax.swing.JTextField();
        jLabelPrecioMinTransporte = new javax.swing.JLabel();
        jLabelEdadPromedio = new javax.swing.JLabel();
        jTextFieldEdadPromedio = new javax.swing.JTextField();
        jLabelDesvioEdad2 = new javax.swing.JLabel();
        jTextFieldEdadQueMasSeRepite = new javax.swing.JTextField();
        jTextFieldEdadMinima = new javax.swing.JTextField();
        jLabelEdadMaxima1 = new javax.swing.JLabel();
        jTextFieldEdadesCantidad = new javax.swing.JTextField();
        jTextFieldFrecuenciaEdadQueMasSeRepite = new javax.swing.JTextField();
        jLabelFrecuenciaEdadMasRepetido3 = new javax.swing.JLabel();
        jLabelVarianzaEdad = new javax.swing.JLabel();
        jTextFieldVarianzaEdad = new javax.swing.JTextField();
        jTextFieldDesvioEstandarEdad = new javax.swing.JTextField();
        jLabelDesvioEstandar = new javax.swing.JLabel();
        jLabelEdadMasRepetido1 = new javax.swing.JLabel();
        jLabelEdadMasRepetido2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaEmpleados = new javax.swing.JTable();
        jButtonGrafica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("ANALYTICS-EMPLEADOS");
        jDesktopPane1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, 50));

        jLabelEdadMaxima.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMaxima.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMaxima.setText("Edad Máxima:");
        jDesktopPane1.add(jLabelEdadMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 50));

        jTextFieldEdadMaxima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadMaximaActionPerformed(evt);
            }
        });
        jTextFieldEdadMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadMaximaKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldEdadMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 90, 30));

        jLabelEdadMinima.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMinima.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMinima.setText("Edad Mínima:");
        jDesktopPane1.add(jLabelEdadMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, 30));
        jDesktopPane1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 670, 10));

        jLabelEdad.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdad.setText("EDAD");
        jDesktopPane1.add(jLabelEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, 50));

        jLabelTituloCantHsSemanales.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelTituloCantHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloCantHsSemanales.setText(" HORAS SEMANALES");
        jDesktopPane1.add(jLabelTituloCantHsSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 240, 40));
        jDesktopPane1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 52, 270, 0));
        jDesktopPane1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 440, 10));
        jDesktopPane1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 42, 420, 10));
        jDesktopPane1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 402, 220, 0));

        jLabelTotalTransporte.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTotalTransporte.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalTransporte.setText("Precio Total: $");
        jDesktopPane1.add(jLabelTotalTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 670, -1, 50));
        jDesktopPane1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 92, 240, 0));
        jDesktopPane1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 280, 10));
        jDesktopPane1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 362, 270, 0));
        jDesktopPane1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 330, 10));
        jDesktopPane1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 402, 180, 0));
        jDesktopPane1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 2, -1, 20));
        jDesktopPane1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 550, -1));
        jDesktopPane1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));
        jDesktopPane1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 180, 0));
        jDesktopPane1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 430, -1));
        jDesktopPane1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 580, -1));
        jDesktopPane1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 610, 240, -1));

        jLabelTotalServicios1.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelTotalServicios1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalServicios1.setText("TRANSPORTE");
        jDesktopPane1.add(jLabelTotalServicios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 160, 50));
        jDesktopPane1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 652, 200, 0));
        jDesktopPane1.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 652, 200, 0));
        jDesktopPane1.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 660, 240, 20));

        jTextFieldTotalTransporte.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldTotalTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalTransporteActionPerformed(evt);
            }
        });
        jTextFieldTotalTransporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTotalTransporteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldTotalTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 680, 150, 30));

        jLabelPrecioMaximoTransporte.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelPrecioMaximoTransporte.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrecioMaximoTransporte.setText("Precio Máximo: $");
        jDesktopPane1.add(jLabelPrecioMaximoTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 720, -1, 50));

        jTextFieldPrecioMaxTransporte.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldPrecioMaxTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioMaxTransporteActionPerformed(evt);
            }
        });
        jTextFieldPrecioMaxTransporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecioMaxTransporteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldPrecioMaxTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 730, 150, 30));

        jTextFieldPrecioMinTransporte.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldPrecioMinTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioMinTransporteActionPerformed(evt);
            }
        });
        jTextFieldPrecioMinTransporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecioMinTransporteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldPrecioMinTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 780, 150, 30));

        jLabelPrecioMinTransporte.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelPrecioMinTransporte.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrecioMinTransporte.setText("Precio Mínimo: $");
        jDesktopPane1.add(jLabelPrecioMinTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 770, -1, 50));

        jLabelEdadPromedio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadPromedio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadPromedio.setText("Edad Promedio (Media) :");
        jDesktopPane1.add(jLabelEdadPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 240, 30));

        jTextFieldEdadPromedio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadPromedioActionPerformed(evt);
            }
        });
        jTextFieldEdadPromedio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadPromedioKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldEdadPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 100, 30));

        jLabelDesvioEdad2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEdad2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEdad2.setText("Estandar:");
        jDesktopPane1.add(jLabelDesvioEdad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 90, 30));

        jTextFieldEdadQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldEdadQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadQueMasSeRepiteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldEdadQueMasSeRepite, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 100, 30));

        jTextFieldEdadMinima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadMinimaActionPerformed(evt);
            }
        });
        jTextFieldEdadMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadMinimaKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldEdadMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 90, 30));

        jLabelEdadMaxima1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMaxima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMaxima1.setText("Cantidad de Edades:");
        jDesktopPane1.add(jLabelEdadMaxima1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 50));

        jTextFieldEdadesCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadesCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadesCantidadActionPerformed(evt);
            }
        });
        jTextFieldEdadesCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadesCantidadKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldEdadesCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 100, 30));

        jTextFieldFrecuenciaEdadQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldFrecuenciaEdadQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldFrecuenciaEdadQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldFrecuenciaEdadQueMasSeRepite, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 100, 30));

        jLabelFrecuenciaEdadMasRepetido3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelFrecuenciaEdadMasRepetido3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrecuenciaEdadMasRepetido3.setText("Frecuencia de Moda:");
        jDesktopPane1.add(jLabelFrecuenciaEdadMasRepetido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 180, 30));

        jLabelVarianzaEdad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelVarianzaEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVarianzaEdad.setText("Varianza:");
        jDesktopPane1.add(jLabelVarianzaEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 90, 30));

        jTextFieldVarianzaEdad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldVarianzaEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVarianzaEdadActionPerformed(evt);
            }
        });
        jTextFieldVarianzaEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVarianzaEdadKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldVarianzaEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 210, 30));

        jTextFieldDesvioEstandarEdad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldDesvioEstandarEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesvioEstandarEdadActionPerformed(evt);
            }
        });
        jTextFieldDesvioEstandarEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDesvioEstandarEdadKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldDesvioEstandarEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 210, 30));

        jLabelDesvioEstandar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEstandar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEstandar.setText("Desvio ");
        jDesktopPane1.add(jLabelDesvioEstandar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 70, 30));

        jLabelEdadMasRepetido1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido1.setText("Edad que más se repite");
        jDesktopPane1.add(jLabelEdadMasRepetido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 210, 30));

        jLabelEdadMasRepetido2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido2.setText("(MonoModa):");
        jDesktopPane1.add(jLabelEdadMasRepetido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 120, 30));

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

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 0, 410));

        jButtonGrafica.setBackground(new java.awt.Color(0, 34, 103));
        jButtonGrafica.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonGrafica.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGrafica.setText("GRAFICA");
        jButtonGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficaActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButtonGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEdadMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMaximaActionPerformed

    private void jTextFieldEdadMaximaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadMaximaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMaximaKeyTyped

    private void jTextFieldTotalTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalTransporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalTransporteActionPerformed

    private void jTextFieldTotalTransporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTotalTransporteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalTransporteKeyTyped

    private void jTextFieldPrecioMaxTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioMaxTransporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecioMaxTransporteActionPerformed

    private void jTextFieldPrecioMaxTransporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecioMaxTransporteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecioMaxTransporteKeyTyped

    private void jTextFieldPrecioMinTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioMinTransporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecioMinTransporteActionPerformed

    private void jTextFieldPrecioMinTransporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecioMinTransporteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecioMinTransporteKeyTyped

    private void jTextFieldEdadPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadPromedioActionPerformed

    private void jTextFieldEdadPromedioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadPromedioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadPromedioKeyTyped

    private void jTextFieldEdadQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadQueMasSeRepiteActionPerformed

    private void jTextFieldEdadQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadQueMasSeRepiteKeyTyped

    private void jTextFieldEdadMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMinimaActionPerformed

    private void jTextFieldEdadMinimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadMinimaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMinimaKeyTyped

    private void jTextFieldEdadesCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadesCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadesCantidadActionPerformed

    private void jTextFieldEdadesCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadesCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadesCantidadKeyTyped

    private void jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed

    private void jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped

    private void jTextFieldVarianzaEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaEdadActionPerformed

    private void jTextFieldVarianzaEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaEdadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaEdadKeyTyped

    private void jTextFieldDesvioEstandarEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarEdadActionPerformed

    private void jTextFieldDesvioEstandarEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarEdadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarEdadKeyTyped

    private void jButtonGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficaActionPerformed
        graficarGraficoEdad();
    }//GEN-LAST:event_jButtonGraficaActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAnalytics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGrafica;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelDesvioEdad2;
    private javax.swing.JLabel jLabelDesvioEstandar;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEdadMasRepetido1;
    private javax.swing.JLabel jLabelEdadMasRepetido2;
    private javax.swing.JLabel jLabelEdadMaxima;
    private javax.swing.JLabel jLabelEdadMaxima1;
    private javax.swing.JLabel jLabelEdadMinima;
    private javax.swing.JLabel jLabelEdadPromedio;
    private javax.swing.JLabel jLabelFrecuenciaEdadMasRepetido3;
    private javax.swing.JLabel jLabelPrecioMaximoTransporte;
    private javax.swing.JLabel jLabelPrecioMinTransporte;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloCantHsSemanales;
    private javax.swing.JLabel jLabelTotalServicios1;
    private javax.swing.JLabel jLabelTotalTransporte;
    private javax.swing.JLabel jLabelVarianzaEdad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTableListaEmpleados;
    public static javax.swing.JTextField jTextFieldDesvioEstandarEdad;
    public static javax.swing.JTextField jTextFieldEdadMaxima;
    public static javax.swing.JTextField jTextFieldEdadMinima;
    public static javax.swing.JTextField jTextFieldEdadPromedio;
    public static javax.swing.JTextField jTextFieldEdadQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldEdadesCantidad;
    public static javax.swing.JTextField jTextFieldFrecuenciaEdadQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldPrecioMaxTransporte;
    public static javax.swing.JTextField jTextFieldPrecioMinTransporte;
    public static javax.swing.JTextField jTextFieldTotalTransporte;
    public static javax.swing.JTextField jTextFieldVarianzaEdad;
    // End of variables declaration//GEN-END:variables
}
