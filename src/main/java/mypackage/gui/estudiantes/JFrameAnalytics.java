/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.gui.estudiantes;

import java.awt.Color;
import static java.lang.Float.max;
import static java.lang.Float.min;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mypackage.connector.LocalConnector;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.jdbc.EstudianteRepository;
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

    private I_EstudianteRepository estudianteRepository = new EstudianteRepository(LocalConnector.getLocalConnection());

    /** Creates new form JFrameAnalytics */
    public JFrameAnalytics() {
        initComponents();
        listarEstudiantes();
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
    public void listarEstudiantes() {

        new Table().cargar(jTableListaEstudiantes, estudianteRepository.getAll());


    }
    //=============================================
    //===FIN LISTAMOS LOS EMPLEADOS EN LA TABLA ESCONDIDA==
    //=============================================

    //=============================================
    //===SET VALORES DE LA DB A LOS JTEXTFIELDS=======
    //=============================================
    public void setearTextFields() {
        //-----------------------------------
        //------EDAD(columna 3)-----
        //-----------------------------------
    //CANTIDAD
        //jTextFieldEdadesCantidad.setText(String.valueOf(cantidadValores(3)));
        jTextFieldEdadesCantidad.setText(String.valueOf(cantidadValores(3)));
        //MAXIMO
        jTextFieldEdadMaxima.setText(String.valueOf(maximaValores(3)));

        //MINIMO
        jTextFieldEdadMinima.setText(String.valueOf(minimaValores(3)));

        //GASTADA-MEDIA
        jTextFieldEdadPromedio.setText(String.valueOf(promedioValores(3)));

        //MODA-MEDIANA
        jTextFieldEdadQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(3).get(0)));

        //FRECUENCIA DE VECES MODA-MEDIANA
        jTextFieldFrecuenciaEdadQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(3).get(1)));

        //DISPERSION RESPECTO AL PROMEDIO-MEDIA (VARIANZA)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldVarianzaEdad.setText(String.valueOf(varianzaValores(3, 3)));

        //GRADO DE DISPERSION (DESVIO ESTANDAR)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldDesvioEstandarEdad.setText(String.valueOf(desvioEstandarValores(3, 3, 3)));

        //----------------------------------------
        //------FIN EDAD(columna 3)-----
        //----------------------------------------
        //--------------------------------------------------------------------------------------------
        //-----------CANTIDAD DE HORAS SEMANALES(columna 10)---------------
        //---------------------------------------------------------------------------------------------
                //CANTIDAD
        //jTextFieldHsSemanalesCantidad.setText(String.valueOf(cantidadValores(10)));
        jTextFieldHsSemanalesCantidad.setText(String.valueOf(cantidadValores(11)));
        //MAXIMO
        jTextFieldHsSemanalesMaxima.setText(String.valueOf(maximaValores(11)));

        //MINIMO
        jTextFieldHsSemanalesMinima.setText(String.valueOf(minimaValores(11)));

        //PROMEDIO-MEDIA
        jTextFieldHsSemanalesPromedio.setText(String.valueOf(promedioValores(11)));

        //MODA-MEDIANA
        jTextFieldHsSemanalesQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(11).get(0)));

        //FRECUENCIA DE VECES MODA-MEDIANA
        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(11).get(1)));

        //DISPERSION RESPECTO AL PROMEDIO-MEDIA (VARIANZA)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldVarianzaHsSemanales.setText(String.valueOf(varianzaValores(11, 11)));

        //GRADO DE DISPERSION (DESVIO ESTANDAR)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldDesvioEstandarHsSemanales.setText(String.valueOf(desvioEstandarValores(11, 11, 11)));

        //-------------------------------------------------------------------------------------------------
        //-----------FIN CANTIDAD DE HORAS SEMANALES(columna 10)---------------
        //---------------------------------------------------------------------------------------------------
        
        //---------------------------------------------------------
        //-----------SUELDO(columna 11)---------------
        //----------------------------------------------------------
   //CANTIDAD
        //jTextFieldSueldoCantidad.setText(String.valueOf(cantidadValores(11)));
        jTextFieldSueldoCantidad.setText(String.valueOf(cantidadValores(12)));
        //MAXIMO
        jTextFieldSueldoMaximo.setText(String.valueOf(maximaValoresGastadaDecimal(12)));

        //MINIMO
        jTextFieldSueldoMinimo.setText(String.valueOf(minimaValoresSueldoDecimal(12)));

        //PROMEDIO-MEDIA
        jTextFieldSueldoPromedio.setText(String.valueOf(promedioValoresSueldoDecimal(12)));

        //MODA-MEDIANA
        jTextFieldSueldoQueMasSeRepite.setText(modaFrecuenciaValoresSueldoDecimal(12).get(0));

        //FRECUENCIA DE VECES MODA-MEDIANA
        jTextFieldFrecuenciaSueldoQueMasSeRepite.setText(modaFrecuenciaValoresSueldoDecimal(12).get(1));

        //DISPERSION RESPECTO AL PROMEDIO-MEDIA (VARIANZA)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldVarianzaSueldo.setText(String.valueOf(varianzaValoresSueldoDecimal(12, 11)));

        //GRADO DE DISPERSION (DESVIO ESTANDAR)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldDesvioEstandarSueldo.setText(String.valueOf(desvioEstandarValoresSueldoDecimal(12, 12, 12)));
//        //--------------------------------------------------------------
//        //-----------FIN SUELDO(columna 11)---------------
//        //--------------------------------------------------------------
    }

    //=============================================
    //===FIN SET VALORES DE LA DB A LOS JTEXTFIELDS=======
    //=============================================
    //=============================================
    //==============GRÁFICOS=====================
    //=============================================
    JFreeChart GraficaEdad;
    JFreeChart GraficaHsSemanales;
    JFreeChart GraficaSueldo;

    DefaultCategoryDataset DatosEdad = new DefaultCategoryDataset();
    DefaultCategoryDataset DatosHsSemanales = new DefaultCategoryDataset();
    DefaultCategoryDataset DatosGastada = new DefaultCategoryDataset();

    public void graficarGraficoEdad() {
          DatosEdad.addValue(cantidadValores(3), "EDAD", "CANTIDAD");
        DatosEdad.addValue(promedioValores(3), "EDAD", "PROMEDIO");
        DatosEdad.addValue(maximaValores(3), "EDAD", "MÁXIMA");
        DatosEdad.addValue(minimaValores(3), "EDAD", "MÍNIMA");
        DatosEdad.addValue(Integer.valueOf(modaFrecuenciaValores(3).get(0)), "EDAD", "MODA");
        DatosEdad.addValue(Integer.valueOf(modaFrecuenciaValores(3).get(1)), "EDAD", "FRECUENCIA MODA");
        DatosEdad.addValue(varianzaValores(3, 3), "EDAD", "VARIANZA");
        DatosEdad.addValue(desvioEstandarValores(3, 3, 3), "EDAD", "DESVIO ESTANDAR");

//Creamos un grafico de tipo barras
        GraficaEdad = ChartFactory.createBarChart("GRÁFICA DE ANALYTICS EDAD",
                "ESTADISTICA", "VALORES OBTENIDOS", DatosEdad,
                PlotOrientation.HORIZONTAL, true, true, false);

//Agregamos nuestro grafico a una nueva ventana
        ChartPanel Panel = new ChartPanel(GraficaEdad);
        JFrame Ventana = new JFrame("JFreeChartAnalyticsEdad");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void graficarGraficoHsSemanales() {
        //DatosHsSemanales.addValue(cantidadValores(10), "HORAS SEMANALES", "CANTIDAD");
        DatosHsSemanales.addValue(cantidadValores(10), "HORAS SEMANALES", "CANTIDAD");
        DatosHsSemanales.addValue(promedioValores(10), "HORAS SEMANALES", "PROMEDIO");
        DatosHsSemanales.addValue(maximaValores(10), "HORAS SEMANALES", "MÁXIMA");
         DatosHsSemanales.addValue(minimaValores(10), "HORAS SEMANALES", "MÍNIMA");
        DatosHsSemanales.addValue(Integer.valueOf(modaFrecuenciaValores(10).get(0)), "HORAS SEMANALES", "MODA");
        DatosHsSemanales.addValue(Integer.valueOf(modaFrecuenciaValores(10).get(1)), "HORAS SEMANALES", "FRECUENCIA MODA");
        DatosHsSemanales.addValue(varianzaValores(10, 10), "HORAS SEMANALES", "VARIANZA");
        DatosHsSemanales.addValue(desvioEstandarValores(10, 10, 10), "HORAS SEMANALES", "DESVIO ESTANDAR");

//Creamos un grafico de tipo barras
        GraficaHsSemanales = ChartFactory.createBarChart("GRÁFICA DE ANALYTICS HORAS SEMANALES",
                "ESTADISTICA", "VALORES OBTENIDOS", DatosHsSemanales,
                PlotOrientation.HORIZONTAL, true, true, false);

//Agregamos nuestro grafico a una nueva ventana
        ChartPanel Panel = new ChartPanel(GraficaHsSemanales);
        JFrame Ventana = new JFrame("JFreeChartAnalyticsHsSemanales");
        Ventana.getContentPane().add(Panel).setBackground(Color.yellow);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void graficarGraficoGastada() {
        //DatosSueldo.addValue(cantidadValores(11), "SUELDO", "CANTIDAD");
        DatosGastada.addValue(cantidadValores(11), "Promedio", "CANTIDAD");
        DatosGastada.addValue(promedioValoresSueldoDecimal(11), "Promedio", "PROMEDIO");
        DatosGastada.addValue(maximaValoresGastadaDecimal(11), "Promedio", "MÁXIMA");
        DatosGastada.addValue(minimaValoresSueldoDecimal(11), "GASTADA", "MÍNIMA");
        DatosGastada.addValue(Float.valueOf(modaFrecuenciaValoresSueldoDecimal(11).get(0)), "GASTADA", "MODA");
        DatosGastada.addValue(Float.valueOf(modaFrecuenciaValoresSueldoDecimal(11).get(1)), "GASTADA", "FRECUENCIA MODA");
        DatosGastada.addValue(varianzaValoresSueldoDecimal(11, 11), "GASTADA", "VARIANZA");
        DatosGastada.addValue(desvioEstandarValoresSueldoDecimal(11, 11, 11), "GASTADA", "DESVIO ESTANDAR");

//Creamos un grafico de tipo barras
        GraficaSueldo = ChartFactory.createBarChart("GRÁFICA DE ANALYTICS GASTADA",
                "ESTADISTICA", "VALORES OBTENIDOS", DatosGastada,
                PlotOrientation.HORIZONTAL, true, true, false);

//Agregamos nuestro grafico a una nueva ventana
        ChartPanel Panel = new ChartPanel(GraficaSueldo);
        JFrame Ventana = new JFrame("JFreeChartAnalyticsSueldo");
        Ventana.getContentPane().add(Panel).setBackground(Color.yellow);
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
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                cantidad = jTableListaEstudiantes.getRowCount();

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
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                max = Math.round(max(max, Integer.parseInt(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }
//---------------------------------------------------------------------------------
    public float maximaValoresGastadaDecimal(int columnaTabla) {
        float max = 0;
        try {
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                max = Math.round(max(max, Float.parseFloat(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }
//---------------------------------------------------------------------------------
    public int minimaValores(int columnaTabla) {

        int min = Integer.parseInt(jTableListaEstudiantes.getValueAt(0, columnaTabla).toString());

        try {
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                // min = Math.round(min(min, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
                min = Math.round(min(min, Integer.parseInt(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return min;
    }
//---------------------------------------------------------------------------------
    
     public float minimaValoresSueldoDecimal(int columnaTabla) {

        float min = Float.parseFloat(jTableListaEstudiantes.getValueAt(0, columnaTabla).toString());

        try {
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                // min = Math.round(min(min, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
                min = Math.round(min(min, Float.parseFloat(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString())));
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
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                sum += Integer.parseInt(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promedio = sum / jTableListaEstudiantes.getRowCount();
        return promedio;

    }
//---------------------------------------------------------------------------------
    public float promedioValoresSueldoDecimal(int columnaTabla) {
        float sum = 0;
        float promedio = 0;
        try {
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                sum += Float.parseFloat(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promedio = sum / jTableListaEstudiantes.getRowCount();
        return promedio;

    }
//---------------------------------------------------------------------------------
    public List<String> modaFrecuenciaValores(int columnaTabla) {

        int valores = 0;

        List<Integer> arrayValores = new ArrayList<Integer>();

        try {
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                valores = Integer.valueOf(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString());

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
     public List<String> modaFrecuenciaValoresSueldoDecimal(int columnaTabla) {

        float valores = 0;

        List<Float> arrayValores = new ArrayList<Float>();

        try {
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                valores = Float.valueOf(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Hasta aca guardamos todos los elementos de la jTable en List

        //Ahora realizamos el calculo de la moda
        float moda = 0;

        int frecuenciaDeVecesQueSeRepite = 0;

        for (int i = 0; i < arrayValores.size(); i++) {

            int  vecesQueSeRepite = 0;

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
    //El segundo parametro nos aseguramos de no crear metodos repetidos
    public double varianzaValores(int columnaTabla, int columnaTablaPromedioValores) {

        int valores;
        double varianza = 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("###.##");

        List<Integer> arrayValores = new ArrayList<Integer>();

        try {
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                valores = Integer.valueOf(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);
            }
            for (int j = 0; j < jTableListaEstudiantes.getRowCount(); j++) {
                double rango;
                rango = Math.pow(arrayValores.get(j) - promedioValores(columnaTablaPromedioValores), 2f);
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

       //El segundo parametro nos aseguramos de no crear metodos repetidos
    public float varianzaValoresSueldoDecimal(int columnaTabla, int columnaTablaPromedioValores) {

        float valores;
        float varianza = 0.0f;
        DecimalFormat decimalFormat = new DecimalFormat("###.##");

        List<Float> arrayValores = new ArrayList<Float>();

        try {
            for (int i = 0; i < jTableListaEstudiantes.getRowCount(); i++) {

                valores = Float.valueOf(jTableListaEstudiantes.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);
            }
            for (int j = 0; j < jTableListaEstudiantes.getRowCount(); j++) {
                float rango;
   
                rango =(float)Math.pow(arrayValores.get(j) - promedioValoresSueldoDecimal(columnaTablaPromedioValores), 2f);
               
                varianza = varianza + rango;
            }
            //suma de diferencias sobre "n"
            varianza = varianza /Float.valueOf(arrayValores.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return varianza;
    }
//---------------------------------------------------------------------------------

    
//---------------------------------------------------------------------------------
    public double desvioEstandarValores(int columnaTabla, int columnaTablaVarianza, int columnaTablaPromedioValores) {

        double desviacion = 0.0;

        try {

            //teniendo ya la varinza sólo debemos sacarle raiz cuadrada 
            //tendremos la desviación estandar
            desviacion = Math.sqrt(varianzaValores(columnaTablaVarianza, columnaTablaPromedioValores));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return desviacion;

    }
    //---------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------
    public float desvioEstandarValoresSueldoDecimal(int columnaTabla, int columnaTablaVarianza, int columnaTablaPromedioValores) {

        float   desviacion = 0.0f;

        try {

            //teniendo ya la varinza sólo debemos sacarle raiz cuadrada 
            //tendremos la desviación estandar
            desviacion = (float)Math.sqrt(varianzaValoresSueldoDecimal(columnaTablaVarianza, columnaTablaPromedioValores));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return desviacion;

    }
    //---------------------------------------------------------------------------------


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
        jLabelHsSemanalesMinima = new javax.swing.JLabel();
        jTextFieldEdadMaxima = new javax.swing.JTextField();
        jLabelEdadMinima = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelEdad = new javax.swing.JLabel();
        jLabelTituloCantHsSemanales = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
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
        jLabelSueldo = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jLabelHsSemanalesPromedio = new javax.swing.JLabel();
        jTextFieldSueldoPromedio = new javax.swing.JTextField();
        jLabelDesvioEdad2 = new javax.swing.JLabel();
        jTextFieldSueldoQueMasSeRepite = new javax.swing.JTextField();
        jTextFieldEdadMinima = new javax.swing.JTextField();
        jLabelCantidadHsSemanales = new javax.swing.JLabel();
        jTextFieldEdadesCantidad = new javax.swing.JTextField();
        jTextFieldFrecuenciaSueldoQueMasSeRepite = new javax.swing.JTextField();
        jLabelFrecuenciaEdadMasRepetido3 = new javax.swing.JLabel();
        jLabelVarianzaHsSemanales = new javax.swing.JLabel();
        jTextFieldVarianzaHsSemanales = new javax.swing.JTextField();
        jTextFieldDesvioEstandarSueldo = new javax.swing.JTextField();
        jLabelDesvioEstandar = new javax.swing.JLabel();
        jLabelEdadMasRepetido1 = new javax.swing.JLabel();
        jLabelEdadMasRepetido2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaEstudiantes = new javax.swing.JTable();
        jButtonGraficaSueldo = new javax.swing.JButton();
        jLabelCantidadEdad = new javax.swing.JLabel();
        jTextFieldSueldoCantidad = new javax.swing.JTextField();
        jLabelEdadPromedio1 = new javax.swing.JLabel();
        jTextFieldEdadPromedio = new javax.swing.JTextField();
        jLabelEdadMaxima1 = new javax.swing.JLabel();
        jButtonGrafica = new javax.swing.JButton();
        jLabelHsSemanalesMaxima1 = new javax.swing.JLabel();
        jTextFieldHsSemanalesMinima = new javax.swing.JTextField();
        jTextFieldSueldoMaximo = new javax.swing.JTextField();
        jLabelVarianzaEdad1 = new javax.swing.JLabel();
        jTextFieldVarianzaEdad = new javax.swing.JTextField();
        jLabelDesvioEdad3 = new javax.swing.JLabel();
        jLabelDesvioEstandar1 = new javax.swing.JLabel();
        jTextFieldDesvioEstandarEdad = new javax.swing.JTextField();
        jLabelEdadMasRepetido3 = new javax.swing.JLabel();
        jLabelEdadMasRepetido4 = new javax.swing.JLabel();
        jLabelFrecuenciaEdadMasRepetido4 = new javax.swing.JLabel();
        jTextFieldEdadQueMasSeRepite = new javax.swing.JTextField();
        jTextFieldFrecuenciaEdadQueMasSeRepite = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        jButtonGraficaHsSemanales = new javax.swing.JButton();
        jLabelCantidadHsSemanales1 = new javax.swing.JLabel();
        jLabelHsSemanalesPromedio1 = new javax.swing.JLabel();
        jTextFieldHsSemanalesCantidad = new javax.swing.JTextField();
        jTextFieldHsSemanalesPromedio = new javax.swing.JTextField();
        jLabelVarianzaHsSemanales1 = new javax.swing.JLabel();
        jTextFieldVarianzaSueldo = new javax.swing.JTextField();
        jLabelDesvioEstandar2 = new javax.swing.JLabel();
        jLabelDesvioEdad4 = new javax.swing.JLabel();
        jTextFieldDesvioEstandarHsSemanales = new javax.swing.JTextField();
        jLabelEdadMasRepetido5 = new javax.swing.JLabel();
        jLabelEdadMasRepetido6 = new javax.swing.JLabel();
        jTextFieldHsSemanalesQueMasSeRepite = new javax.swing.JTextField();
        jLabelFrecuenciaEdadMasRepetido5 = new javax.swing.JLabel();
        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite = new javax.swing.JTextField();
        jLabelHsSemanalesMaxima2 = new javax.swing.JLabel();
        jLabelHsSemanalesMinima1 = new javax.swing.JLabel();
        jTextFieldHsSemanalesMaxima = new javax.swing.JTextField();
        jTextFieldSueldoMinimo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("ANALYTICS-ESTUDIANTES");
        jDesktopPane1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, -1));

        jLabelHsSemanalesMinima.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesMinima.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesMinima.setText("Hora Mínima:");
        jDesktopPane1.add(jLabelHsSemanalesMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, -1, 30));

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
        jDesktopPane1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 920, 10));

        jLabelEdad.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdad.setText("EDAD");
        jDesktopPane1.add(jLabelEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, 30));

        jLabelTituloCantHsSemanales.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelTituloCantHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloCantHsSemanales.setText(" HORAS SEMANALES");
        jDesktopPane1.add(jLabelTituloCantHsSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 240, 40));
        jDesktopPane1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 52, 270, 0));
        jDesktopPane1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 350, 10));
        jDesktopPane1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 510, 10));
        jDesktopPane1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 402, 220, 0));
        jDesktopPane1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 92, 240, 0));
        jDesktopPane1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 270, 20));
        jDesktopPane1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 362, 270, 0));
        jDesktopPane1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 330, 10));
        jDesktopPane1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 402, 180, 0));
        jDesktopPane1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 2, -1, 20));
        jDesktopPane1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 760, 10));
        jDesktopPane1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));
        jDesktopPane1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 180, 0));
        jDesktopPane1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 430, 10));
        jDesktopPane1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 930, 10));
        jDesktopPane1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 660, 240, 0));

        jLabelSueldo.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelSueldo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSueldo.setText("SUELDO");
        jDesktopPane1.add(jLabelSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 670, 110, 50));
        jDesktopPane1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 652, 200, 0));
        jDesktopPane1.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 652, 200, 0));
        jDesktopPane1.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 670, 240, 10));

        jLabelHsSemanalesPromedio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesPromedio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesPromedio.setText("Sueldo Promedio (Media) :");
        jDesktopPane1.add(jLabelHsSemanalesPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 230, 30));

        jTextFieldSueldoPromedio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoPromedioActionPerformed(evt);
            }
        });
        jTextFieldSueldoPromedio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoPromedioKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldSueldoPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 790, 100, 30));

        jLabelDesvioEdad2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEdad2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEdad2.setText("Estandar:");
        jDesktopPane1.add(jLabelDesvioEdad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 90, 30));

        jTextFieldSueldoQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldSueldoQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoQueMasSeRepiteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldSueldoQueMasSeRepite, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 730, 100, 30));

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

        jLabelCantidadHsSemanales.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCantidadHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidadHsSemanales.setText("Cantidad de Horas:");
        jDesktopPane1.add(jLabelCantidadHsSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, 30));

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

        jTextFieldFrecuenciaSueldoQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldFrecuenciaSueldoQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFrecuenciaSueldoQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldFrecuenciaSueldoQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFrecuenciaSueldoQueMasSeRepiteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldFrecuenciaSueldoQueMasSeRepite, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 790, 100, 30));

        jLabelFrecuenciaEdadMasRepetido3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelFrecuenciaEdadMasRepetido3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrecuenciaEdadMasRepetido3.setText("Frecuencia de Moda:");
        jDesktopPane1.add(jLabelFrecuenciaEdadMasRepetido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 790, 180, 30));

        jLabelVarianzaHsSemanales.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelVarianzaHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVarianzaHsSemanales.setText("Varianza:");
        jDesktopPane1.add(jLabelVarianzaHsSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 850, 90, 30));

        jTextFieldVarianzaHsSemanales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldVarianzaHsSemanales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVarianzaHsSemanalesActionPerformed(evt);
            }
        });
        jTextFieldVarianzaHsSemanales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVarianzaHsSemanalesKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldVarianzaHsSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 210, 30));

        jTextFieldDesvioEstandarSueldo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldDesvioEstandarSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesvioEstandarSueldoActionPerformed(evt);
            }
        });
        jTextFieldDesvioEstandarSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDesvioEstandarSueldoKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldDesvioEstandarSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 850, 210, 30));

        jLabelDesvioEstandar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEstandar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEstandar.setText("Desvio ");
        jDesktopPane1.add(jLabelDesvioEstandar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 830, 70, 30));

        jLabelEdadMasRepetido1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido1.setText("Sueldo que más ");
        jDesktopPane1.add(jLabelEdadMasRepetido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 710, 150, 30));

        jLabelEdadMasRepetido2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido2.setText("se repite (MonoModa):");
        jDesktopPane1.add(jLabelEdadMasRepetido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 740, 200, 20));

        jTableListaEstudiantes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jTableListaEstudiantes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTableListaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableListaEstudiantes.setToolTipText("");
        jScrollPane1.setViewportView(jTableListaEstudiantes);

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 0, 410));

        jButtonGraficaSueldo.setBackground(new java.awt.Color(0, 34, 103));
        jButtonGraficaSueldo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonGraficaSueldo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGraficaSueldo.setText("GRAFICA SUELDO");
        jButtonGraficaSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficaSueldoActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButtonGraficaSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 900, 270, 40));

        jLabelCantidadEdad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCantidadEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidadEdad.setText("Cantidad de Edades:");
        jDesktopPane1.add(jLabelCantidadEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 30));

        jTextFieldSueldoCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoCantidadActionPerformed(evt);
            }
        });
        jTextFieldSueldoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoCantidadKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldSueldoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 740, 100, 30));

        jLabelEdadPromedio1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadPromedio1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadPromedio1.setText("Edad Promedio (Media) :");
        jDesktopPane1.add(jLabelEdadPromedio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 30));

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

        jLabelEdadMaxima1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMaxima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMaxima1.setText("Edad Máxima:");
        jDesktopPane1.add(jLabelEdadMaxima1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 50));

        jButtonGrafica.setBackground(new java.awt.Color(0, 34, 103));
        jButtonGrafica.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonGrafica.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGrafica.setText("GRAFICA EDAD");
        jButtonGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficaActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButtonGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 180, 40));

        jLabelHsSemanalesMaxima1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesMaxima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesMaxima1.setText("Sueldo Máximo:");
        jDesktopPane1.add(jLabelHsSemanalesMaxima1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 740, -1, 30));

        jTextFieldHsSemanalesMinima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesMinimaActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesMinimaKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldHsSemanalesMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 90, 30));

        jTextFieldSueldoMaximo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoMaximoActionPerformed(evt);
            }
        });
        jTextFieldSueldoMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoMaximoKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldSueldoMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 740, 90, 30));

        jLabelVarianzaEdad1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelVarianzaEdad1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVarianzaEdad1.setText("Varianza:");
        jDesktopPane1.add(jLabelVarianzaEdad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 90, 30));

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
        jDesktopPane1.add(jTextFieldVarianzaEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 210, 30));

        jLabelDesvioEdad3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEdad3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEdad3.setText("Estandar:");
        jDesktopPane1.add(jLabelDesvioEdad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 850, 90, 30));

        jLabelDesvioEstandar1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEstandar1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEstandar1.setText("Desvio ");
        jDesktopPane1.add(jLabelDesvioEstandar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 70, 30));

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
        jDesktopPane1.add(jTextFieldDesvioEstandarEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 210, 30));

        jLabelEdadMasRepetido3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido3.setText("Edad que más ");
        jDesktopPane1.add(jLabelEdadMasRepetido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 130, 30));

        jLabelEdadMasRepetido4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido4.setText("se repite (MonoModa):");
        jDesktopPane1.add(jLabelEdadMasRepetido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 200, 20));

        jLabelFrecuenciaEdadMasRepetido4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelFrecuenciaEdadMasRepetido4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrecuenciaEdadMasRepetido4.setText("Frecuencia de Moda:");
        jDesktopPane1.add(jLabelFrecuenciaEdadMasRepetido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 180, 30));

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
        jDesktopPane1.add(jTextFieldEdadQueMasSeRepite, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 100, 30));

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
        jDesktopPane1.add(jTextFieldFrecuenciaEdadQueMasSeRepite, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 100, 30));
        jDesktopPane1.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 710, 320, 10));

        jButtonGraficaHsSemanales.setBackground(new java.awt.Color(0, 34, 103));
        jButtonGraficaHsSemanales.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonGraficaHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGraficaHsSemanales.setText("GRAFICA HS SEMANALES");
        jButtonGraficaHsSemanales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficaHsSemanalesActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButtonGraficaHsSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 270, 40));

        jLabelCantidadHsSemanales1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCantidadHsSemanales1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidadHsSemanales1.setText("Cantidad de Sueldos:");
        jDesktopPane1.add(jLabelCantidadHsSemanales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 740, 200, 30));

        jLabelHsSemanalesPromedio1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesPromedio1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesPromedio1.setText("Horas Promedio (Media) :");
        jDesktopPane1.add(jLabelHsSemanalesPromedio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 220, 30));

        jTextFieldHsSemanalesCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesCantidadActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesCantidadKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldHsSemanalesCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 100, 30));

        jTextFieldHsSemanalesPromedio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesPromedioActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesPromedio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesPromedioKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldHsSemanalesPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 100, 30));

        jLabelVarianzaHsSemanales1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelVarianzaHsSemanales1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVarianzaHsSemanales1.setText("Varianza:");
        jDesktopPane1.add(jLabelVarianzaHsSemanales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 90, 30));

        jTextFieldVarianzaSueldo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldVarianzaSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVarianzaSueldoActionPerformed(evt);
            }
        });
        jTextFieldVarianzaSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVarianzaSueldoKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldVarianzaSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 850, 210, 30));

        jLabelDesvioEstandar2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEstandar2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEstandar2.setText("Desvio ");
        jDesktopPane1.add(jLabelDesvioEstandar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 70, 30));

        jLabelDesvioEdad4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEdad4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEdad4.setText("Estandar:");
        jDesktopPane1.add(jLabelDesvioEdad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 90, 30));

        jTextFieldDesvioEstandarHsSemanales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldDesvioEstandarHsSemanales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesvioEstandarHsSemanalesActionPerformed(evt);
            }
        });
        jTextFieldDesvioEstandarHsSemanales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDesvioEstandarHsSemanalesKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldDesvioEstandarHsSemanales, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 210, 30));

        jLabelEdadMasRepetido5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido5.setText("Hora que más ");
        jDesktopPane1.add(jLabelEdadMasRepetido5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 130, 30));

        jLabelEdadMasRepetido6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido6.setText("se repite (MonoModa):");
        jDesktopPane1.add(jLabelEdadMasRepetido6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 200, 20));

        jTextFieldHsSemanalesQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesQueMasSeRepiteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldHsSemanalesQueMasSeRepite, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 100, 30));

        jLabelFrecuenciaEdadMasRepetido5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelFrecuenciaEdadMasRepetido5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrecuenciaEdadMasRepetido5.setText("Frecuencia de Moda:");
        jDesktopPane1.add(jLabelFrecuenciaEdadMasRepetido5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 180, 30));

        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldFrecuenciaHsSemanalesQueMasSeRepite, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 100, 30));

        jLabelHsSemanalesMaxima2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesMaxima2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesMaxima2.setText("Hora Máxima:");
        jDesktopPane1.add(jLabelHsSemanalesMaxima2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, 30));

        jLabelHsSemanalesMinima1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesMinima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesMinima1.setText("Sueldo Mínimo:");
        jDesktopPane1.add(jLabelHsSemanalesMinima1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 790, -1, 30));

        jTextFieldHsSemanalesMaxima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesMaximaActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesMaximaKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldHsSemanalesMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 90, 30));

        jTextFieldSueldoMinimo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoMinimoActionPerformed(evt);
            }
        });
        jTextFieldSueldoMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoMinimoKeyTyped(evt);
            }
        });
        jDesktopPane1.add(jTextFieldSueldoMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 790, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEdadMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMaximaActionPerformed

    private void jTextFieldEdadMaximaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadMaximaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMaximaKeyTyped

    private void jTextFieldSueldoPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoPromedioActionPerformed

    private void jTextFieldSueldoPromedioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoPromedioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoPromedioKeyTyped

    private void jTextFieldSueldoQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoQueMasSeRepiteActionPerformed

    private void jTextFieldSueldoQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoQueMasSeRepiteKeyTyped

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

    private void jTextFieldFrecuenciaSueldoQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaSueldoQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaSueldoQueMasSeRepiteActionPerformed

    private void jTextFieldFrecuenciaSueldoQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaSueldoQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaSueldoQueMasSeRepiteKeyTyped

    private void jTextFieldVarianzaHsSemanalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaHsSemanalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaHsSemanalesActionPerformed

    private void jTextFieldVarianzaHsSemanalesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaHsSemanalesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaHsSemanalesKeyTyped

    private void jTextFieldDesvioEstandarSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarSueldoActionPerformed

    private void jTextFieldDesvioEstandarSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarSueldoKeyTyped

    private void jButtonGraficaSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficaSueldoActionPerformed
        graficarGraficoGastada();
    }//GEN-LAST:event_jButtonGraficaSueldoActionPerformed

    private void jTextFieldSueldoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoCantidadActionPerformed

    private void jTextFieldSueldoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoCantidadKeyTyped

    private void jTextFieldEdadPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadPromedioActionPerformed

    private void jTextFieldEdadPromedioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadPromedioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadPromedioKeyTyped

    private void jButtonGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficaActionPerformed
        graficarGraficoEdad();
    }//GEN-LAST:event_jButtonGraficaActionPerformed

    private void jTextFieldHsSemanalesMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesMinimaActionPerformed

    private void jTextFieldHsSemanalesMinimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesMinimaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesMinimaKeyTyped

    private void jTextFieldSueldoMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoMaximoActionPerformed

    private void jTextFieldSueldoMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoMaximoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoMaximoKeyTyped

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

    private void jTextFieldEdadQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadQueMasSeRepiteActionPerformed

    private void jTextFieldEdadQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadQueMasSeRepiteKeyTyped

    private void jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed

    private void jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped

    private void jButtonGraficaHsSemanalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficaHsSemanalesActionPerformed
        graficarGraficoHsSemanales();
    }//GEN-LAST:event_jButtonGraficaHsSemanalesActionPerformed

    private void jTextFieldHsSemanalesCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesCantidadActionPerformed

    private void jTextFieldHsSemanalesCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesCantidadKeyTyped

    private void jTextFieldHsSemanalesPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesPromedioActionPerformed

    private void jTextFieldHsSemanalesPromedioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesPromedioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesPromedioKeyTyped

    private void jTextFieldVarianzaSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaSueldoActionPerformed

    private void jTextFieldVarianzaSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaSueldoKeyTyped

    private void jTextFieldDesvioEstandarHsSemanalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarHsSemanalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarHsSemanalesActionPerformed

    private void jTextFieldDesvioEstandarHsSemanalesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarHsSemanalesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarHsSemanalesKeyTyped

    private void jTextFieldHsSemanalesQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesQueMasSeRepiteActionPerformed

    private void jTextFieldHsSemanalesQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesQueMasSeRepiteKeyTyped

    private void jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteActionPerformed

    private void jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteKeyTyped

    private void jTextFieldHsSemanalesMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesMaximaActionPerformed

    private void jTextFieldHsSemanalesMaximaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesMaximaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesMaximaKeyTyped

    private void jTextFieldSueldoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoMinimoActionPerformed

    private void jTextFieldSueldoMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoMinimoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoMinimoKeyTyped

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
    private javax.swing.JButton jButtonGraficaHsSemanales;
    private javax.swing.JButton jButtonGraficaSueldo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelCantidadEdad;
    private javax.swing.JLabel jLabelCantidadHsSemanales;
    private javax.swing.JLabel jLabelCantidadHsSemanales1;
    private javax.swing.JLabel jLabelDesvioEdad2;
    private javax.swing.JLabel jLabelDesvioEdad3;
    private javax.swing.JLabel jLabelDesvioEdad4;
    private javax.swing.JLabel jLabelDesvioEstandar;
    private javax.swing.JLabel jLabelDesvioEstandar1;
    private javax.swing.JLabel jLabelDesvioEstandar2;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEdadMasRepetido1;
    private javax.swing.JLabel jLabelEdadMasRepetido2;
    private javax.swing.JLabel jLabelEdadMasRepetido3;
    private javax.swing.JLabel jLabelEdadMasRepetido4;
    private javax.swing.JLabel jLabelEdadMasRepetido5;
    private javax.swing.JLabel jLabelEdadMasRepetido6;
    private javax.swing.JLabel jLabelEdadMaxima1;
    private javax.swing.JLabel jLabelEdadMinima;
    private javax.swing.JLabel jLabelEdadPromedio1;
    private javax.swing.JLabel jLabelFrecuenciaEdadMasRepetido3;
    private javax.swing.JLabel jLabelFrecuenciaEdadMasRepetido4;
    private javax.swing.JLabel jLabelFrecuenciaEdadMasRepetido5;
    private javax.swing.JLabel jLabelHsSemanalesMaxima1;
    private javax.swing.JLabel jLabelHsSemanalesMaxima2;
    private javax.swing.JLabel jLabelHsSemanalesMinima;
    private javax.swing.JLabel jLabelHsSemanalesMinima1;
    private javax.swing.JLabel jLabelHsSemanalesPromedio;
    private javax.swing.JLabel jLabelHsSemanalesPromedio1;
    private javax.swing.JLabel jLabelSueldo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloCantHsSemanales;
    private javax.swing.JLabel jLabelVarianzaEdad1;
    private javax.swing.JLabel jLabelVarianzaHsSemanales;
    private javax.swing.JLabel jLabelVarianzaHsSemanales1;
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
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTableListaEstudiantes;
    public static javax.swing.JTextField jTextFieldDesvioEstandarEdad;
    public static javax.swing.JTextField jTextFieldDesvioEstandarHsSemanales;
    public static javax.swing.JTextField jTextFieldDesvioEstandarSueldo;
    public static javax.swing.JTextField jTextFieldEdadMaxima;
    public static javax.swing.JTextField jTextFieldEdadMinima;
    public static javax.swing.JTextField jTextFieldEdadPromedio;
    public static javax.swing.JTextField jTextFieldEdadQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldEdadesCantidad;
    public static javax.swing.JTextField jTextFieldFrecuenciaEdadQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldFrecuenciaHsSemanalesQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldFrecuenciaSueldoQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldHsSemanalesCantidad;
    public static javax.swing.JTextField jTextFieldHsSemanalesMaxima;
    public static javax.swing.JTextField jTextFieldHsSemanalesMinima;
    public static javax.swing.JTextField jTextFieldHsSemanalesPromedio;
    public static javax.swing.JTextField jTextFieldHsSemanalesQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldSueldoCantidad;
    public static javax.swing.JTextField jTextFieldSueldoMaximo;
    public static javax.swing.JTextField jTextFieldSueldoMinimo;
    public static javax.swing.JTextField jTextFieldSueldoPromedio;
    public static javax.swing.JTextField jTextFieldSueldoQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldVarianzaEdad;
    public static javax.swing.JTextField jTextFieldVarianzaHsSemanales;
    public static javax.swing.JTextField jTextFieldVarianzaSueldo;
    // End of variables declaration//GEN-END:variables


}
